<template v-bind:interests="interests">
 <div>
   <div class="interestScroller" v-if = "interests.length > 0">
     <div class="container" v-for="interest in interests" :key="interest.interestNo">
       <InterestItem v-bind:interest = "interest"></InterestItem>
     </div>
   </div>

   <div v-else>
     <div id="noResults">
       <h1>검색 결과가 없습니다!</h1>
     </div>
   </div>

 </div>
</template>

<script>
import InterestItem from './InterestItem'
export default {
  name: 'InterestList',
  components: {InterestItem},
  data () {
    return {
      interests: []
    }
  },
  methods: {
    initList: function () {
      let vm = this
      vm.$http.get('/api/interests')
        .then(response => {
          vm.interests = response.data.map(r => r)
        })
        .catch(error => {
          console.log(error)
        })
    },
    created () {
      this.initList()
    }
  }
}
</script>

<style scoped>

</style>
