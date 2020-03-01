<template>
  <div class="container col-5">
    <section class="create-app">
      <h2>새 게시글 쓰기</h2>
      <ArticleForm></ArticleForm>
    </section>
  </div>
</template>

<script>
import ArticleForm from './ArticleForm'
export default {
  name: 'ArticleCreate',
  components: {ArticleForm}
}
</script>

<style scoped>
  .container{
    margin-left: 10%;
    padding-top: 100px;
  }
  .create-app{
    margin-left: 20%;
  }

</style>
