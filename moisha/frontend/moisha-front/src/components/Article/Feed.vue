<template>
  <div class="card">
    <h5 class="card-header" v-bind:pdata="item.title"></h5>
    <div class="card-body">
      <p class="card-text" v-bind:pdata="item.authorId"></p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Feed'
}
</script>

<style scoped>

</style>
