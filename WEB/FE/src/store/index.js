import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

import router from '@/router'
import VueCookies from 'vue-cookies'
import jwtDecode from 'jwt-decode'
// import createPersistedState from "vuex-persistedstate";
// import VueSession from 'vue-session'

// 나중에 변경 예정
const SERVER_URL = 'https://i8a102.p.ssafy.io/api'




// var options={
//   persist: true,
// }

Vue.use(Vuex)

const now = new Date();

export default new Vuex.Store({
  // plugins:[createPersistedState()],
  state: {
    login_user:null,
    user:null,
    areas:[],
    reviews:[],
    images:[],
    wishes:[],
    themes:[],
    products:[],
    accessToken: null, 
    refreshToken: null, 
  },
  
  getters: {
    getToken(){
      let ac = VueCookies.get('accessToken');
      let rf = VueCookies.get('refreshToken');
      return{
        access: ac,
        refresh: rf
      };
    },
    getUserSeq(){
      let user_seq = this.state.user.user_seq
      return{
        user_seq
      }
    }

  },

  mutations: {
    // SAVE_TOKEN(state,token){
    //   state.token = token;
    // },
    LOGIN_TOKEN(state, payload){
      VueCookies.set(
        'accessToken', 
        payload["access-token"], 
        jwtDecode(payload["access-token"]).exp-Number(now.getTime().toString().substring(0,10)));
        VueCookies.set(
          'refreshToken', 
          payload["refresh-token"], 
          jwtDecode(payload["refresh-token"]).exp-Number(now.getTime().toString().substring(0,10)));
      state.accessToken = payload["access-token"];  
      state.refreshToken = payload["refresh-token"];
      state.login_user = jwtDecode(payload["refresh-token"]).user_id
      console.log(state.login_user)
    },
    REFRESH_TOKEN(state, payload){
      VueCookies.set(
        'accessToken', 
        payload["access-token"],
        jwtDecode(payload["access-token"]).exp-Number(now.getTime().toString().substring(0,10)));
      // VueCookies.set(
      //   'refreshToken', 
      //   payload["refresh-token"], 
      //   jwtDecode(payload["refresh-token"]).exp-Number(now.getTime().toString().substring(0,10)));
      state.accessToken =  payload["access-token"];
    },
    REMOVE_TOKEN(state){
      VueCookies.remove('accessToken');
      VueCookies.remove('refreshToken');
      state.login_user = "";
      state.user = [];
    },
    GET_USER_BY_ID(state, user){
      state.user = user
      console.log(state.user.user_seq)
    },
    GET_AREAS(state, areas){
      state.areas = areas;
    },
    GET_PRODUCTS(state, products){
      state.products = products;
    },
    GET_THEMES(state, themes){
      state.themes = themes;
    },
    GET_REVIEWS(state, reviews){
      state.reviews = reviews
    },
    GET_WISHES(state, wishes){
      state.wishes = wishes
    },
    PUT_USER_DATA(state, user){
      state.user.user_seq = user.user_seq
      state.user.user_name = user.user_name
      state.user.user_id = user.user_id
      state.user.user_pwd = user.user_pwd
      state.user.email_id = user.email_id
      state.user.email_domain = user.email_domain
      state.user.phone = user.phone
      state.user.birth = user.birth
      state.user.gender = user.gender
    }
  },

  actions: {
    // 회원가입, 로그인, 로그아웃
    signUp(context, payload){       // 회원가입 함수
      axios({
        method: "post",
        url: `${SERVER_URL}/user`,
        data: {
          user_id:payload.user_id,
          user_pwd:payload.user_pwd,
          user_name:payload.user_name,
          email_id:payload.email_id,
          email_domain: payload.email_domain,
          phone:payload.phone,
          birth:payload.birth,
          gender:payload.gender,
        },
      })
        .then((res) => {
          console.log(res.data)
          router.push({ name: "Home"});
        })
        .catch(err =>{
          console.log(err)
        })
    },
    logIn(context, payload) {   
      axios({
        method:"post",
        url: `${SERVER_URL}/user/login`,
        //토큰뿐만아니라 활성유저인지도 체크할 필요 있음
        data: {
          user_id:payload.user_id,
          user_pwd:payload.user_pwd,
        },
        headers:{
          "Content-Type":'application/json',
        }
      })
        .then((res) => {
          if (res.data.message==='fail'){
            alert("로그인오류")
            router.push({name:"Login"})
          } else {
            context.commit("LOGIN_TOKEN", res.data);
            router.push({name:"Home"})
          }
        })
        .catch((err)=>{
          console.log(err);
        })
    },
    refreshToken({commit}){
      return new Promise((resolve, reject)=>{
        axios({
          method:"get",
          url:`${SERVER_URL}/user/refresh`,
          data:{
            user_id:this.state.login_user,
          },
          headers:{
            Authorization: `Bearer ${ VueCookies.get('refreshToken')}`,
            'Content-Type':"application/json"
          }
        
        })
        .then(res=>{
          console.log("refresh실행")
          commit('REFRESH_TOKEN', res.data);
          resolve(res.data)
        }).catch(err=>{
          console.log(commit)
          console.log(err.config)
          console.log('refreshToken error:',err.config.data);
          reject(err.config.data);
        })
      })
    },
    logOut(context) {
      axios({
        method:"post",    
        url: `${SERVER_URL}/user/logout`,
        data:{
          user_id:this.state.login_user
        }
      })
        .then((res) => {
          console.log(res)
          context.commit("REMOVE_TOKEN");
          router.go()
          router.push({name:"Home"})
        })
        .catch((err)=>{
          console.log(err);
        })
    },
    getUserById(context){
      axios({
        method:"get",
        url:`${SERVER_URL}/user/${this.state.login_user}`
      })
      .then((res)=>{
        context.commit("GET_USER_BY_ID", res.data)
      })
      .catch((err)=>{
        console.log(err)
      })
    },
    putUserData(context, payload){
      axios({
          method:"put",
          url:`${SERVER_URL}/user`,
          data:{
              user_seq:payload.user_seq,
              user_id:payload.user_id,
              user_name:payload.user_name,                        
              user_pwd:payload.user_pwd,
              email_id:payload.email_id,
              email_domain:payload.email_domain,
              phone:payload.phone,
              birth:payload.birth,
              gender:payload.gender,
          },
      })
      .then((res)=>{
          context.commit("PUT_USER_DATA", res.data)
          console.log(res)
          console.log("수정완료")
      })
      .catch((err)=>{
          console.log(context)
          console.log(err)
      })
  },
    
    // 상품 페이지 관련
    getAreas(context){ 
      axios({
        method:"get",
        url:`${SERVER_URL}/area`
      })
      .then((res)=>{
        context.commit("GET_AREAS", res.data)
      })
      .catch((err)=>{
        console.log(err)
      })
    },
    getProducts(context){
      axios({
        method:"get",
        url:`${SERVER_URL}/product`
      })
      .then((res)=>{
        context.commit("GET_PRODUCTS", res.data)
      })
      .catch((err)=>{
        console.log(err)
      })
    },
    getReview(context){
      axios({
        method:"get",
        url:`${SERVER_URL}/reviews`
      })
        .then((res)=>{
          context.commit("GET_REVIEW", res.data)
        })
        .catch((err)=>{
          console.log(err)
        })
      },
  
    

    // 레시피 페이지
    getThemes(context){
      axios({
        method:"get",
        url:`${SERVER_URL}/theme`
      })
      .then((res)=>{
        context.commit("GET_THEMES", res.data)
      })
      .catch((err)=>{
        console.log(err)
      })
    },
    postRecipe(context, payload) {   
      axios({
        method:"post",
        url: `${SERVER_URL}/recipecreate`,
        data: {
          photo:payload.photo,
          recipetitle:payload.recipetitle,
          recipecontent:payload.recipecontent,
        },
      })
        .then((res) => {
          context.commit("SAVE_TOKEN", res.data.key);
          router.push({name:"Recipe"})
        })
        .catch((err)=>{
          console.log(err);
        })
    },
    
    // 장바구니 페이지
    
    // 장바구니 여러개를 만드는 기능을 구현할 경우?
    // createWish(context, payload) {
    //   axios({
    //     method:"post",
    //     url: `${SERVER_URL}/createwish`,
    //     data: {
    //       wishtitle:payload.wishtitle,
    //       wishproduct:payload.wishproduct,
    //     },
    //   })
    //     .then((res) => {
    //       context.commit("SAVE_TOKEN", res.data.key);
    //       router.push({name:"Wish"})
    //     })
    //     .catch((err) => {
    //       console.log(err);
    //     })
    // },
    // 
    
    getWishes(context){
      axios({
        method:"get",
        url: `${SERVER_URL}/cartlist/${this.state.login_user}`
      })
        .then((res) =>{
          context.commit("GET_WISHES", res.data)
        })
        .catch((err) => {
          console.log(err)
        })
      },

  },
})
