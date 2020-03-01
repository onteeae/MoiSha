<template>
  <div>
    <div>
      <div>
        <router-link tag="b-button" to="Article/Create" v-bind:interests="interests">새 글 쓰기</router-link>
      </div>
      <br>
      <span v-for="tag in tags" class="badge badge-filter" :key="tag.tagNo">{{tag.name}}</span>
    </div>
    <div class="list">
      <h6>새로운 피드</h6>
      <ArticleList v-bind:items="articles"></ArticleList>
    </div>
    <div class="list">
      <h6>이런 관심사는 어떠세요?</h6>
      <InterestList></InterestList>
    </div>
  </div>
</template>

<script>
import ArticleList from './ArticleList'
import authHeader from '../../services/auth-header'
import InterestList from '../Shared/InterestList'
export default {
  name: 'ArticleFeed',
  components: {
    InterestList,
    ArticleList
  },
  props: {
    interests: {
      type: Array,
      default: null
    }
  },
  data () {
    return {
      articles: [],
      tags: []
    }
  },
  methods: {
    initList: function () {
      let vm = this
      vm.$http.get('/api/articles/interest/1', {headers: authHeader()})
        .then(response => {
          vm.articles = response.data.map(r => r)
        })
        .catch(error => {
          console.log(error)
        })
      vm.$http.get('/api/tags', {headers: authHeader()})
        .then(response => {
          vm.tags = response.data.map(r => r)
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
  .list{
    border: solid 1px #000;
    padding: 10px;
    margin: 10px;
    display:inline-block;
  }
</style>
