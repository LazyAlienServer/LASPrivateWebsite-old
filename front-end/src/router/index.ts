import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import userViewMenu from "@/utils/userViewMenu";

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
    children:getuserViews()
    // children:[
    //   {
    //     path:'/main',
    //     name:'main',
    //     component:() => import(/* webpackChunkName: "about" */ '../views/MainPageView.vue'),
    //     meta:{index:1}
    //   },
    //   {
    //     path:'/userinfo',
    //     name:'userinfo',
    //     component:() => import(/* webpackChunkName: "about" */ '../views/UserPageView.vue'),
    //     meta:{index:4}
    //   }
    // ]
  },{
    path: '/:pathMatch(.*)*',
    redirect:'/error/404',
    meta:{hidden:true}
  },{
    path: '/error/:text',
    name: 'error',
    component: () => import(/* webpackChunkName: "about" */ '../views/ErrorView.vue'),
    meta:{hidden:true}
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

function getuserViews():RouteRecordRaw[]{
  let userViews:RouteRecordRaw[]=[];
  for(let item of userViewMenu.value){
    userViews.push({
      path:item.route,
      name:item.name,
      component:item.component,
      meta:{index:item.id}
    })
  }
  return userViews;
}

export default router
