<template>
  <!-- <div class="productdetaildiv"> -->
  <b-container class="productdetailcon">
    <b-row style="height:100px;">
<!-- 
    <h3>상품 후기 </h3>
    <ReviewList v-bind:productid="this.$route.params.pid" />
    <b-button v-on:click="createReview">리뷰생성</b-button>
    <b-button v-on:click="$router.push({name:'Product', params:{ cgid:area_seq }})">목록으로</b-button> -->
  <!-- </div> -->
    </b-row>
    <b-row class="productdetailrow">
      <b-col class="productimagecol" cols="5">
        <img 
        :src="`https://i8a102.p.ssafy.io/api/image/product/${product_id}`" 
        alt="상품 이미지" 
        style="
        width:500px;
        height:500px;"
        class="productdetailimage">
      </b-col>
      <!-- <b-col>

      </b-col> -->
      <b-col class="productcontentcol" cols="5">
        <b-row class="productnamerow">
          <!-- <p>양념 LA 꽃갈비 500g</p> -->
          <b-row style="height:20px;">
          </b-row>
          <p class="productnamep">{{ product_info }}</p>
          <!-- <p class="productnamep">{{ product_name }}</p> -->
          <!-- <p class="productnamep">상품 제목</p> -->
        </b-row>
        <b-row>
          <!-- <p>제품에 대한 설명이 들어갑니다. 제품에 대한 설명이 들어갑니다. 제품에 대한 설명이 들어갑니다. 제품에 대한 설명이 들어갑니다. </p> -->
          <!-- <p class="productinfo">{{ product_info }} </p> -->
          <p>재고 : {{ stock }}개</p>
        </b-row>
        <b-row>
          <p>제조사 : {{ company }} </p>
          <!-- <p>상품 카테고리 : {{ area_name }}</p> -->
        </b-row>
        <b-row class="pricerow">
          <p class="pricep">{{ price }}원</p>  
          <!-- <p>29,000원</p>  -->
        </b-row>
        <hr>
        <b-row class="reviewlist">
          <!-- <ReviewList /> -->
          <div>
            <p class="reviewlisttitle">상품 후기</p>
            <div style="position:relative; overflow-y:auto; height:150px;">
              <ReviewList v-bind:productid="this.$route.params.pid" />
            </div>
          </div>
        </b-row>
        <br>
        <b-row >
          <b-col class="buttoncol">
            <b-col>
              
            </b-col>
            <b-col class="gocreatereviewbuttoncol">
              <b-button v-on:click="createReview" variant="success" class="gocreatereviewbutton">후기 작성</b-button>
            </b-col>
            <b-col class="golistbuttoncol">
              <b-button v-on:click="$router.push({name:'Product', params:{ cgid:area_seq }})" class="golistbutton">상품 목록</b-button>
            </b-col>
          </b-col>
        </b-row>
      </b-col>
    </b-row>

  </b-container>
  <!-- </div> -->
</template>

<script>
import axios from "axios";

import ReviewList from '@/components/product/ReviewList.vue'

const SERVER_URL = 'https://i8a102.p.ssafy.io/api'


export default {
    name:"ProductDetailView",
    components:{
      ReviewList,
    },
    data(){
      return {
        product_id:null,
        product_name:null,
        company:null,
        stock:null, 
        price: null, 
        product_info: null, 
        area_seq:null,
        area_name: null,
      }
    },
    created(){
      this.getProductDetail()
    },
    methods:{
      getAreaName(){
        const allarea = this.$store.state.areas
        
        for (let ent of allarea){
          if (ent.area_seq === this.area_seq){
              this.area_name = ent.area_name
          }
        }
      },
      getCompanyName(){
        axios({
          method:"get",
          url:`${SERVER_URL}/company/${this.company}`
        })
        .then((res)=>{
          this.company = res.data.company_name
        })
        .catch((err)=>{
          console.log(err)
        })
      },
      getProductDetail(){
        axios({
          method:"get",
          url: `${SERVER_URL}/product/searchbyseq/${this.$route.params.pid}`
        })
          .then((res)=>{
            // console.log(res.data) 
            this.product_id = res.data.product_seq
            this.product_name = res.data.product_name,
            this.company = res.data.company_seq,
            this.stock = res.data.stock, 
            this.price = res.data.price, 
            this.product_info = res.data.product_info, 
            this.area_seq =  res.data.area_seq,
            this.getAreaName()
            this.getCompanyName()
          })
          .catch((err) =>{
            console.log("에러발생")
            console.log(err);
          })
      },
      createReview(){
        this.$router.push({ name:'Review', params:{ pid:this.$route.params.pid }})
      },
    },
}
</script>

<style scoped>
@font-face {
  font-family: 'nanumsquare_acEB';
  src: url('../../../public/fonts/NanumSquare_acEB.ttf');
}
@font-face {
  font-family: 'NanumSquare_acB';
  src: url('../../../public/fonts/NanumSquare_acB.ttf');
}
@font-face {
  font-family: 'nanumsquareL';
  src: url('../../../public/fonts/NanumSquareL.ttf');
}

@font-face {
  font-family: 'nanumsquareR';
  src: url('../../../public/fonts/NanumSquareR.ttf');
}

.productdetailcon {
  font-family: 'nanumsquareR';
  font-size: 17px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-content: center;
  
}
.productimagecol {
  width: 550px;
  height: 700px;
}

.productcontentcol {
  margin-left: 100px;
  /* width: 550px;
  height: 700px; */
}
.productnamep {
  margin-left: 28px;
  font-size: 40px;
  font-family: 'nanumsquare_acEB';
}
.pricerow {
  display: flex;
  font-size: 25px;
}
.pricep {
  font-family: 'nanumsquare_acEB';
}
.reviewlisttitle {
  font-size: 20px;
  font-family: 'NanumSquare_acB';
}
/* .productinfo{

} */

.buttoncol {
  display: flex;
  justify-content: right;
  font-size: 19px;
}

.gocreatereviewbuttoncol {
  display: flex;
  justify-content: right;
}

.golistbuttoncol {
  display: flex;
  justify-content: right;
}

.gocreatereviewbutton{
  font-size: 19px;
}
.golistbutton {
  font-size: 19px;
}

.product-detail{
  margin-top: 30px;
  margin-left: 150px;
  margin-right: 150px;
  padding-left: 50px;
  padding-right: 50px;
}


</style>