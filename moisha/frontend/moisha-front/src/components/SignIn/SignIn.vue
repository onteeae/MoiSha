<template>
  <div class="text-center">
    <br>
    <br>
    <form class="form-signin col-sm-6">
      <label for="inputEmail" class="sr-only">이메일 주소</label>
      <input type="email"
        id="inputEmail"
        class="form-control"
        placeholder="이메일 주소"
        v-model.lazy="email"
        autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password"
        id="inputPassword"
        class="form-control"
        placeholder="비밀번호"
        v-model.lazy="password"
      >
      <button class="btn btn-lg btn-primary btn-block " type="submit" v-on:click="signIn">
        로그인
      </button>
    </form>
  </div>
</template>

<script>
export default {
  props: {
  },
  name: 'SignIn',
  data () {
    return {
      email: '',
      password: ''
    }
  },
  methods: {
    signIn: function (event) {
      alert('signIn!')
    }
  }
}
</script>
<style scoped>
  .form-signin {
    display: inline-block;
  }
</style>
