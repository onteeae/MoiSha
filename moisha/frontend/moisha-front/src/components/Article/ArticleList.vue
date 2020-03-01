<template>
  <div>
    <Article v-for="item in items" v-bind:item="item" :key="item.articleNo"></Article>
  </div>
</template>

<script>
import Article from './Article'
export default {
  name: 'List',
  components: {Article},
  props: {
    items: {
      type: Array,
      default: null
    }
  }
}
</script>

<style scoped>

</style>
