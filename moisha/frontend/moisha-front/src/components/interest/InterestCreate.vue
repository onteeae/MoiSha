<template>
  <div class="container col-5">
    <section class="create-app">
      <h2>새 관심사 만들기</h2>
      <InterestForm></InterestForm>
    </section>
  </div>
</template>

<script>
import InterestForm from './InterestForm'
export default {
  name: 'InterestCreate',
  components: {InterestForm}
}
</script>

<style scoped>

</style>
