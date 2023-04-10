<template>
    <div id="item-container">
      <div id="b-i-image">
        <img :src=imgUrl alt="img" height="70%" width="70%">
      </div>
      <div id="b-i-name">
        <p>{{ addName }}</p>
        <p>수량</p>
        <Stocks></Stocks>
      </div>
    </div>
  </template>
  
  <script>
  import {api} from '@/utils/axios'
  import Stocks from '@/components/Buttons/Stock.vue'
  export default {
    data(){
      return{
        imgUrl:`https://i8a102.p.ssafy.io/api/image/product/${this.addId}`
      }
    },
    components:{
      Stocks
    },
    props:[
      "addId", "addName"
    ],
    async created(){

    }
  }
  </script>
  
  <style scoped>
  #item-container{
    height: 80%;
    display: flex;
  }
  #b-i-image{
    width: 40%;
  }
#b-i-name{
  width: 60%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
#b-i-name>p{
  font-size: 30px;
}
  </style>