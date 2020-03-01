<template>
  <div class="card" style="cursor:pointer">
    <div class="card-header flex-column">
      <span class="name">{{interest.name}}</span>
      <span class="creator">Manager : {{interest.createUser}}</span>
    </div>
    <div class="card-body">{{interest.createYmdt}}</div>
  </div>
</template>

<script>
export default {
  name: 'InterestItem',
  props: {
    interest: {
      type: Object,
      default: null
    }
  }
}
</script>

<style scoped>

</style>
