<template>
  <div>
    <Feed v-for="item in items" v-bind:key="item.interestNo" v-bind:pdata="item"></Feed>
  </div>
</template>

<script>
import Feed from './Feed'
export default {
  name: 'list',
  components: {Feed},
  props: {
    initItems: []
  },
  data () {
    return {
      items: this.initItems
    }
  },
  methods: {
    initList: function () {
      let vm = this
      vm.$http.get('/api/articles/user/jay/interest/1')
        .then(response => {
          vm.items = response.data.map(r => r)
        })
        .catch(error => {
          console.log(error)
        })
    }
  },
  created () {
    this.initList()
  }
}
</script>

<style scoped>

</style>
