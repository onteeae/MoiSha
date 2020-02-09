import Vue from 'vue'
import Router from 'vue-router'
import List from '@/components/Article/List'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/List',
      name: 'List',
      component: List
    }
  ]
})
