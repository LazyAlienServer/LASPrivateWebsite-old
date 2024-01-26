import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/home',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },{
    path: '/',
    name: 'login',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/LoginView.vue')
  },{
    path: '/user',
    name: 'user',
    component: () => import(/* webpackChunkName: "about" */ '../views/UserView.vue'),
    children:[
      {
        path:'/userinfo',
        name:'userinfo',
        component:() => import(/* webpackChunkName: "about" */ '../views/UserPageView.vue')
      },{
        path:'/main',
        name:'main',
        component:() => import(/* webpackChunkName: "about" */ '../views/MainPageView.vue')
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
