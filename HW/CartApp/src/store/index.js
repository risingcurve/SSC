import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    loginUser:{},
    userId:"",
    list: {},
    carts: [],cart_x:-2,cart_y:-2,
    wishs:[],
    recipe:{},selected_recipe:0,recipe_price:0,
    barcodeItem: {},
    full_name:"",
    purchase_list:{
    //   purchase_seq:0,
    //     user_seq:0,
    //     purchase_date:"",
    //     total_price:0,
    //     purchase_list:[{
    //       purchase_detail_seq:0,
    //       purchase_seq:0,
    //       product_seq:0,
    //       stock:0,
    //       price:0,
    //       sale_price:0
    // }]
    },
    total_price:0,
    total_stock:0
  },
  getters: {
  },
  mutations: {
    SET_LOGIN_USER(state,data){
      state.loginUser = data
    },
    SET_USER_NAME(state,data){
      state.userId = data
    },
    SET_LIST(state, data) {
      state.list = data
    },
    ADD_WISH_MENU(state, data) {
      state.wishs.push(data)
    },
    CHANGE_BARCODE_ID(state, data) {
      state.barcodeItem = data
    },
    SET_COMPANY_NAME(state,data){
      state.full_name = data
    },
    ADD_ITEM(state, data) {
      state.carts.push(data)
    },
    ADD_PRICE(state,data){
      state.total_price += data
    },
    ADD_STOCK(state,data){
      state.total_stock+=data
    },
    SET_POS(state,data){
      state.cart_x = data.x;
      state.cart_y = data.y;
    },
    SET_RECIPE(state,data){
      state.recipe = data
    },
    SET_RECIPE_SEQ(state,data){
      state.selected_recipe = data
    },
    ADD_RECIPE(state,data){
      state.recipe_price += data
    }

  },
  actions: {
  },
  modules: {
  }
})
