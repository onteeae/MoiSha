import Vue from 'vue'
import Router from 'vue-router'
// import List from '@/components/Article/List'
import Main from '@/components/Main/Main'
import SignIn from '@/components/SignIn/SignIn'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Main',
      component: Main
    },
    {
      path: '/signIn',
      name: 'SignIn',
      component: SignIn
    }
  ]
})
