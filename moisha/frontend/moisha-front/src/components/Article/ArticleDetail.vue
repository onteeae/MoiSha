<template>
  <div>
    <table>
      <colgroup>
        <col style="width:30%">
        <col style="width:70%">
      </colgroup>
      <tr>
        <td>title</td>
        <td>{{item.title}}</td>
      </tr>
      <tr>
        <td>author</td>
        <td>{{item.authorId}}</td>
      </tr>
      <tr>
        <td>tag</td>
        <td>태그</td>
      </tr>
      <tr>
        <td>content</td>
        <td style="height:300px">{{item.contents}}</td>
      </tr>
    </table>
    <Comment></Comment>
  </div>
</template>

<script>
import Comment from './Comment'
export default {
  name: 'ArticleDetail',
  components: {Comment},
  props: {
    item: {
      type: Object,
      default: null
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  table{
    border-collapse: collapse;
    margin:5px 2px 3px;
    width:100%;
  }
  td{
    border:1px solid #aaa;
    padding:10px;
  }
</style>
