<template>
  <table>
    <tr>
      <td>title</td>
      <td>제목</td>
    </tr>
    <tr>
      <td>author</td>
      <td>작성자</td>
    </tr>
    <tr>
      <td>tag</td>
      <td>태그</td>
    </tr>
    <tr>
      <td>content</td>
      <td>내용</td>
    </tr>
  </table>
</template>

<script>
import Comment from './Comment.Vue'
export default {
  name: 'Article',
  components: {Comment}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
