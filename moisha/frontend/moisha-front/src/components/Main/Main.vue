<template>
  <div class="Main">
    <ArticleFeed></ArticleFeed>
  </div>
</template>

<script>
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faGraduationCap } from '@fortawesome/free-solid-svg-icons'
import ArticleFeed from '../Article/ArticleFeed'

export default {
  components: {
    FontAwesomeIcon,
    ArticleFeed
  },
  props: {
  },
  name: 'Main',
  data () {
    return {
      faGraduationCap
    }
  }
}
</script>

<style scoped>
</style>
