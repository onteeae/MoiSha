import Vue from 'vue'
import Router from 'vue-router'
// import List from '@/components/Article/List'
import Main from '@/components/Main/Main'
import SignIn from '@/components/SignIn/SignIn'

Vue.use(Router)

export const router = new Router({
  routes: [
    {
      path: '/Main',
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

router.beforeEach((to, from, next) => {
  const publicPages = ['/signIn']
  const authRequired = !publicPages.includes(to.path)
  const loggedIn = localStorage.getItem('user')
  // trying to access a restricted page + not logged in
  // redirect to login page
  if (authRequired && !loggedIn) {
    next('/signIn')
  } else {
    next()
  }
})
