<template>
  <div id="app">
    <Header></Header>
    <SideBar></SideBar>
    <div class="content">
      <router-view/>
    </div>
  </div>
</template>

<script>
import Header from './components/Shared/Header'
import SideBar from './components/Shared/SideBar'

export default {
  name: 'App',
  components: {SideBar, Header}
}

</script>

<style>
  .content {
    padding: 150px;
  }
</style>
