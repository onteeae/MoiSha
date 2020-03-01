<template>
  <form v-on:submit="onAdd()">
    <textarea ref="message"></textarea>
    <button type="submit">등록</button>
  </form>
</template>

<script>
export default {
  name: 'CommentForm',
  methods: {
    onAdd () {
      const payload = {
        author: this.$store.state.auth.user.username
      }
      this.$http.post('/api/comments/article/1', payload)
        .then(response => {
          console.log(response)
        }, error => {
          console.log(error)
        })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  form{
    display: flex;
  }
  textarea{
    margin:3px;
    flex:9;
  }
  button{
    margin:2px;
    flex:1;
  }
</style>
