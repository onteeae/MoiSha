<template>
  <nav class="navbar navbar-expand-lg navbar-dark" v-show="showHeader">
    <router-link class="navbar-brand" style="cursor: pointer" tag="a" to="/Main">
      <font-awesome-icon :icon="faGraduationCap" class="fa"/>
      <span class="navbar-brand mb-0 h1 moisha">모이샤</span>
    </router-link>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link home" routerLink="/" routerLinkActive="active">홈</a>
        </li>
        <li>
          <form class="form-inline">
            <input class="form-control" placeholder="Search" aria-label="Search">
            <button class="btn btn-success" type="submit">Search</button>
          </form>
        </li>
      </ul>
    </div>
    <router-link tag="button" class="btn name-button" to="/Profile">
      <b class= "user-name">{{ userName }}님</b>
    </router-link>
    <div ngbDropdown class="d-inline-block">
      <button class="btn btn-outline dropdownButton" id="dropdownBasic1" ngbDropdownToggle></button>
      <div ngbDropdownMenu aria-labelledby="dropdownBasic1">
        <button class="dropdown-item" @click="logout()">로그아웃</button>
      </div>
    </div>
  </nav>
</template>

<script>
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faGraduationCap } from '@fortawesome/free-solid-svg-icons'

export default {
  name: 'Header',
  data () {
    return {
      showHeader: this.$store.state.auth.status.loggedIn,
      userName: this.$store.state.auth.status.loggedIn ? this.$store.state.auth.user.username : 'GUEST',
      faGraduationCap
    }
  },
  components: {FontAwesomeIcon},
  methods: {
    logout () {}
  },
  mounted () {
    this.$root.$on('loggedIn', data => {
      this.userName = this.$store.state.auth.user.username
      this.showHeader = true
    })
  }
}
</script>

<style scoped>
  a{
    text-decoration: none;
    color: #fff;
  }
  .moisha{
    margin-left:18px;
    font-size: 24px;
  }
  .home{
    font-size: 20px
  }
  .navbar{
    background: #444444;
    color: #ffffff;
    z-index: 1;
    position: fixed;
    width: 100%;
  }
  .name-button{
    background-color:#444444;
  }
  .user-name{
    font-size:18px;
    color: #ffffff;
  }
  .d-inline-block{
    margin-left:5px;
    background-color: #343A40;
  }
  .dropdownButton{
    background-color: #343A40;
    color: #ffffff;
  }

</style>
