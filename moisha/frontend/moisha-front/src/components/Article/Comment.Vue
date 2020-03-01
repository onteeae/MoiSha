<template>
  <div>
    <CommentList v-for="item in items" v-bind:item="item" :key="item.commentNo"></CommentList>
    <CommentForm @onAdd="onAdd"></CommentForm>
  </div>
</template>

<script>
import CommentForm from './CommentForm'
import CommentList from './CommentList'
import authHeader from '../../services/auth-header'
export default {
  name: 'Comment',
  components: {CommentList, CommentForm},
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
      vm.$http.get('/api/comments/article/1', {headers: authHeader()})
        .then(response => {
          vm.items = response.data.map(r => r)
        })
        .catch(error => {
          console.log(error)
        })
    },
    onAdd: function (message) {

    }
  },
  created () {
    this.initList()
  }
}
</script>

<style scoped>

</style>
