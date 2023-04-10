import Vue from 'vue'
import VueRouter from 'vue-router'
import VueCookies from 'vue-cookies'


import Home from '@/views/home/HomeView.vue'
//User
import Login from '@/views/user/LoginView.vue'
import Signup from '@/views/user/SignupView.vue'
import Mypage from '@/views/user/MypageView.vue'
import MypageDetail from '@/components/user/MyPageDetail.vue'
import UserReview from '@/components/user/UserReviewComp.vue'
import UserRecipe from '@/components/user/UserRecipeComp.vue'

//UserPurchase
import Purchase from '@/components/user/PurchaseList.vue'
import PurchaseDetail from '@/components/user/PurchaseDetail.vue'
// Product
import Category from '@/views/products/CategoryView.vue'
import Product from '@/views/products/ProductsListView.vue'
import ProductDetail from '@/views/products/ProductDetailView.vue'
import ReviewCreate from '@/components/product/ReviewCreate.vue'

// Recipe
import Theme from '@/views/recipe/ThemeView.vue'
import Recipe from '@/views/recipe/RecipeListView.vue'
import RecipeDetail from '@/views/recipe/RecipeDetailView.vue'
import RecipeCreate from '@/views/recipe/RecipeCreateView.vue'
import CommentCreate from '@/components/recipe/CommentCreate.vue'
// Wish
import Wish from '@/views/wish/WishView.vue'
import WishDetail from '@/views/wish/WishDetailView.vue'
import WishCreate from '@/views/wish/WishCreateView.vue'

import store from '@/store'



Vue.use(VueRouter)


const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/signup',
    name: 'Signup',
    component: Signup
    // 로그인 유저 접근 막기
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
    // 로그인 유저 접근 막기
  },
  {
    path: '/mypage/:uid',
    name: 'Mypage',
    component: Mypage,
    beforeEnter: async (to, from, next)=>{
      if (VueCookies.get('accessToken')==undefined || VueCookies.get('refreshToken')==undefined){
      alert("로그인이 만료되었습니다.")
      return next({name:'Login'});
      }
      if (VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')!==null){
        await store.dispatch('refreshToken');
        
      }
      if (VueCookies.get('accessToken')){
        return next();
      }
      if(VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')===null){
        alert("로그인이 필요합니다.")
        return next({name:'Login'});
      }
    }
  },
  {
    path: '/mypage/:uid/detail',
    name: 'MypageDetail',
    component: MypageDetail,
    beforeEnter: async (to, from, next)=>{
      if (VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')!==null){
        await store.dispatch('refreshToken');
      }
      if (VueCookies.get('accessToken')){
        return next();
      }
      if(VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')===null){
        alert("로그인이 필요합니다.")
        return next({name:'Login'});
      }
      return next();
    }
  },
  {
    path:'/user/:uid/purchase',
    name:'Purchase',
    component:Purchase,
    beforeEnter: async (to, from, next)=>{
      if (VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')!==null){
        await store.dispatch('refreshToken');
      }
      if (VueCookies.get('accessToken')){
        return next();
      }
      if(VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')===null){
        alert("로그인이 필요합니다.")
        return next({name:'Login'});
      }
      return next();
    }
  },
  {
    path:'/user/:uid/purchase/:purchaseid',
    name:'PurchaseDetail',
    component:PurchaseDetail,
    beforeEnter: async (to, from, next)=>{
      if (VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')!==null){
        await store.dispatch('refreshToken');
      }
      if (VueCookies.get('accessToken')){
        return next();
      }
      if(VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')===null){
        alert("로그인이 필요합니다.")
        return next({name:'Login'});
      }
      return next();
    }
  },
  {
    path:'/user/:uid/review',
    name:'UserReview',
    component:UserReview,
    beforeEnter: async (to, from, next)=>{
      if (VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')!==null){
        await store.dispatch('refreshToken');
      }
      if (VueCookies.get('accessToken')){
        return next();
      }
      if(VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')===null){
        alert("로그인이 필요합니다.")
        return next({name:'Login'});
      }
      return next();
    }
  },
  {
    path:'/user/:uid/recipe',
    name:'UserRecipe',
    component:UserRecipe,
    beforeEnter: async (to, from, next)=>{
      if (VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')!==null){
        await store.dispatch('refreshToken');
      }
      if (VueCookies.get('accessToken')){
        return next();
      }
      if(VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')===null){
        alert("로그인이 필요합니다.")
        return next({name:'Login'});
      }
      return next();
    }
  },
  {
    path:'/category',
    name:'Category',
    component: Category
  },
  {
    path: '/:cgid/product',
    name: 'Product',
    component: Product
  },
  {
    path: '/product/:pid',
    name: 'ProductDetail',
    component: ProductDetail
  },
  {
    path: '/product/:pid/create',
    name: 'Review',
    component: ReviewCreate,
    beforeEnter: async (to, from, next)=>{
      if (VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')!==null){
        await store.dispatch('refreshToken');
      }
      if (VueCookies.get('accessToken')){
        return next();
      }
      if(VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')===null){
        alert("로그인이 필요합니다.")
        return next({name:'Login'});
      }
      return next();
    }
  },
  {
    path: '/theme',
    name: 'Theme',
    component: Theme
  },
  {
    path: '/:tid/recipe',
    name: 'Recipe',
    component: Recipe
  },
  {
    path:'/recipe/:rid',
    name:'RecipeDetail',
    component: RecipeDetail
  },
  {
    path:'/recipecreate',
    name:'RecipeCreate',
    component: RecipeCreate,
    beforeEnter: async (to, from, next)=>{
      if (VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')!==null){
        await store.dispatch('refreshToken');
      }
      if (VueCookies.get('accessToken')){
        return next();
      }
      if(VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')===null){
        alert("로그인이 필요합니다.")
        return next({name:'Login'});
      }
      return next();
    }
  },
  {
    path:'/commentcreate',
    name:'CommentCreate',
    component: CommentCreate,
    beforeEnter: async (to, from, next)=>{
      if (VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')!==null){
        await store.dispatch('refreshToken');
      }
      if (VueCookies.get('accessToken')){
        return next();
      }
      if(VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')===null){
        alert("로그인이 필요합니다.")
        return next({name:'Login'});
      }
      return next();
    }
  },
  {
    path:'/wish',
    name:'Wish',
    component: Wish,
    beforeEnter: async (to, from, next)=>{
      if (VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')!==null){
        await store.dispatch('refreshToken');
      }
      if (VueCookies.get('accessToken')){
        return next();
      }
      if(VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')===null){
        alert("로그인이 필요합니다.")
        return next({name:'Login'});
      }
      return next();
    }
  },
  {
    path:'/wish/:wid',
    name:'WishDetail',
    component: WishDetail,
    beforeEnter: async (to, from, next)=>{
      if (VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')!==null){
        await store.dispatch('refreshToken');
      }
      if (VueCookies.get('accessToken')){
        return next();
      }
      if(VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')===null){
        alert("로그인이 필요합니다.")
        return next({name:'Login'});
      }
      return next();
    }
  },
  {
    path:'/wishcreate',
    name:'Wishcreate',
    component: WishCreate,
    beforeEnter: async (to, from, next)=>{
      if (VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')!==null){
        await store.dispatch('refreshToken');
      }
      if (VueCookies.get('accessToken')){
        return next();
      }
      if(VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')===null){
        alert("로그인이 필요합니다.")
        return next({name:'Login'});
      }
      return next();
    }
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})


//jwt 방식 쓸경우

// router.beforeEach( async(to, from, next)=>{
//   if (VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')!==null){
//     await store.dispatch('refreshToken');
//   }
//   if (VueCookies.get('accessToken')){
//     return next();
//   }
//   if(VueCookies.get('accessToken')===null&&VueCookies.get('refreshToken')===null){
//     return next({name:'Login'});
//   }
//   return next();
// })



// 로그인 네비게이션 가드

// router.beforeEach(function (to, from, next){
//   if (to.matched.some(function(routeInfo){
//     return routeInfo.meta.authRequired;
//   })) {
//     alert('로그인이 필요합니다.');
//   } else {
//     console.log("routing sucess:"+to.path+"'");
//     next();
//   }
// });



export default router
