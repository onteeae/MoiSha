<template>
  <div class="text-center">
    <div class="main-template">
      <h1><font-awesome-icon :icon="faGraduationCap" class="fa-lg"/></h1>
      <h1 class="display-4">MoiSha</h1>
      <h3 class="font-weight-light">~ 모이샤 ~</h3>
    </div>
    <br>
    <br>
    <form class="form-signin col-sm-6" name="form" @submit.prevent="handleLogin">
      <div class="form-group">
      <label for="email" class="sr-only">이메일 주소</label>
      <input type="email"
        id="email"
        class="form-control"
        placeholder="이메일 주소"
        v-model="user.email"
        v-validate="'required'"
        name="email"
        autofocus>
      <div
        v-if="errors.has('email')"
        class="alert alert-danger"
        role="alert"
      >Email is required!</div>
      <label for="password" class="sr-only">Password</label>
      <input type="password"
        id="password"
        class="form-control"
        placeholder="비밀번호"
        v-model.lazy="user.password"
        v-validate="'required'"
        name="password"
      >
      <div
        v-if="errors.has('password')"
        class="alert alert-danger"
        role="alert"
      >Password is required!</div>
      <button class="btn btn-lg btn-primary btn-block " type="submit" :disabled="loading">
        <span v-show="loading" class="spinner-border spinner-border-sm"></span>
        <span>Login</span>
      </button>
      <div class="form-group">
        <div v-if="message" class="alert alert-danger" role="alert">{{message}}</div>
      </div>
      </div>
    </form>
  </div>
</template>

<script>
import User from '../../models/user'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faGraduationCap } from '@fortawesome/free-solid-svg-icons'
export default {
  components: {
    FontAwesomeIcon
  },
  props: {
  },
  name: 'SignIn',
  data () {
    return {
      user: new User('', ''),
      loading: false,
      message: '',
      faGraduationCap
    }
  },
  created () {
    if (this.loggedIn) {
      this.$router.push('/Main').catch(e => alert('e1'))
    }
  },
  computed: {
    loggedIn () {
      return this.$store.state.auth.status.loggedIn
    }
  },
  methods: {
    handleLogin () {
      this.loading = true
      this.$validator.validateAll().then(isValid => {
        if (!isValid) {
          this.loading = false
          return
        }
        if (this.user.email && this.user.password) {
          this.$store.dispatch('auth/login', this.user).then(
            () => {
              this.$router.push('/Main').catch(e => alert(e))
            },
            error => {
              this.loading = false
              this.message =
                  (error.response && error.response.data) ||
                  error.message ||
                  error.toString()
            }
          )
        }
      })
    }
  }
}
</script>
<style scoped>
  .form-signin {
    display: inline-block;
  }
</style>
