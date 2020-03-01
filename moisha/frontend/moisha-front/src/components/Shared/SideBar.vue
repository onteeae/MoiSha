<template>
  <div class="container" v-show="showSideBar">
    <div class="gap"></div>
    <ul class="interests list-group">
      <li v-for="interest in interests" :key="interest.interestNo" class="list-group-item" >
        <span class="badge">{{interest.name}}</span>
      </li>
    </ul>
  </div>

</template>

<script>

export default {
  name: 'SideBar',
  data () {
    return {
      // eslint-disable-next-line no-unused-expressions,no-labels
      showSideBar: this.$store.state.auth.status.loggedIn,
      interests: []
    }
  },
  mounted () {
    this.$root.$on('loggedIn', data => {
      this.showSideBar = true
    })
    this.$http.get('/api/interests/user/jay')
      .then(response => {
        this.interests = response.data.map(r => r)
      })
      .catch(error => {
        console.log(error)
      })
  }
}
</script>

<style scoped>
  .container{
    position: fixed;
    width: 10%;
    height: 100%;
    background-color: #444444;
    margin-top: 30px;
  }
  .gap{
    height: 20%;
  }
  .list-group{
    overflow-y: scroll;
    max-height: 60%;
  }
  .badge{
    background-color: #333333;
    color: #ffffff;
    text-align: center;
  }
  .list-group-item{
    margin-top: 5px;
    margin-bottom: 5px;
    text-align: center;
    font-size: 18px;
    padding: 10px 0px;
    background-color: #333333;
    border-radius: 10px;
  }
  .list-group::-webkit-scrollbar{
    display: none;
  }
</style>
