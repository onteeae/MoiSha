package com.moisha.moisha;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableTransactionManagement
@MapperScan(
  basePackages = "com.moisha.repository"
  )
public class DataBaseConfig {
  @Autowired
  private ApplicationContext applicationContext;

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.hikari")
  public HikariConfig hikariConfig() {
    return new HikariConfig();
  }

  @Bean
  public DataSource dataSource() {
    DataSource dataSource = new HikariDataSource(hikariConfig());
    //log.info("datasource : {}", dataSource);
    return dataSource;
  }

  @Bean(name = "transactionManager")
  public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
    DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
    //log.info("transactionManager : {}", transactionManager);
    return transactionManager;
  }

  @Bean
  @Primary
  SqlSessionFactoryBean sqlSessionFactory() throws IOException {
    SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
    sessionFactoryBean.setDataSource(dataSource());
    sessionFactoryBean.setTypeAliasesPackage("com.moisha.model");
    sessionFactoryBean.setTypeHandlersPackage("com.moisha.common.handler");
    sessionFactoryBean.setFailFast(true);
    sessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/mybatis-config.xml"));
    sessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:/mapper/**/*Mapper.xml"));
    return sessionFactoryBean;
  }
}
