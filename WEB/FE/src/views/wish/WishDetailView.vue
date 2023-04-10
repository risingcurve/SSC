<template>
  <div class="wishdetailwrapper">
    <b-container>
      <div class="wishdetailtitlediv">
        <h1>{{ title }}</h1>
      </div>
      <!-- <b-row v-if="searchfinish===true"> -->
        <table class="wishproducts" style="width: 100%;">
          <thead>
            <tr style="font-weight: bolder;">
              <th style="width:15%; font-size: x-lagre; text-align: center; vertical-align: middle;">상품 이미지</th>
              <th style="width:30%; font-size: x-lagre; text-align: center; vertical-align: middle;">상품명</th>
              <th style="width:20%; font-size: x-lagre; text-align: center; vertical-align: middle;">상품 수량</th>
              <!-- <td style="width:10%; font-size: x-lagre;">수정 버튼(삭제예정)</td> -->
              <th style="width:15%; font-size: x-lagre; text-align: center; vertical-align: middle;">가격</th>
              <th style="width:20%; font-size: x-lagre; text-align: center; vertical-align: middle;">삭제</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="inent in product" v-bind:key="inent.id">
              <td><img 
              :src="`https://i8a102.p.ssafy.io/api/image/product/${inent.product_key}`" 
              alt=""
              style="
              border-radius:10px;
              width:100px;
              height:100px;
              margin-left: 35px;"></td>
              <td style="text-align: center; vertical-align: middle;">{{ inent.name }}</td>
              <td style="text-align: center; vertical-align: middle;">{{ inent.cnt }}</td>
              <!-- <td><button>수정</button></td> -->
              <td style="text-align: center; vertical-align: middle;">{{ inent.price }}</td>
              <td style="text-align: center; vertical-align: middle;"><b-button variant="danger" v-on:click="deleteItem(inent.seq)">X</b-button></td>

            </tr>
          </tbody>
        </table>
      <!-- </b-row> -->
    </b-container>
    <hr>


    <b-container>
      <b-row class="price">
        <p>총 상품 금액 : {{ total_price }}원</p>
      </b-row>
      <b-row>
        <div class="wishbuttondiv">
          <b-button variant="danger" v-on:click="deleteCart" class="wishbutton">
            <b-icon icon="trash-fill" aria-hidden="true"></b-icon> 장바구니 전체삭제
          </b-button>
        </div>
      </b-row>
    </b-container>
  </div>

    <!-- <div class="wish_detail">
      <h1>장바구니 상세페이지</h1>
      <p>장바구니명 : {{ title }}</p>
      <p>{{ detail }}</p>
      
    </div> -->

</template>
  
<script>
import axios from "axios";
  
const SERVER_URL = 'https://i8a102.p.ssafy.io/api'
  
  export default {
      name:"WishDetailView",
      components:{

      },
      data() {
        return {
          wish_id: null,
          title: null,
          detail: null,
          image: null,
          total_price:null,
          product:[],
        }
      },
      created(){
        this.getWishDetail()
      },
      methods:{
        getWishDetail() {
          axios({
            method:"get",
            url: `${SERVER_URL}/cartlist/detail/${this.$route.params.wid}`
          })
            .then((res)=>{
              console.log(res)
              this.wish_id = res.data.cart_seq,
              this.title = res.data.cart_name;
              this.detail = res.data.products;
              this.total_price = res.data.total_price
              this.$store.dispatch("getProducts")
              this.changeValue()
            })
            .catch((err) => {
              console.log(err);
            })
        },
        changeValue(){
        const all = this.$store.state.products
        for (let ent of all){
          for (let inent of this.detail){
            if (ent.product_seq === inent.product_seq){
              this.product.push({"name":ent.product_name, "product_key":ent.product_seq, "price":inent.price, "cnt":inent.cnt, "seq":inent.cart_detail_seq} )
            }
          }
        }
      },
        putWish(){
          axios({
            method:"put",
            url:`${SERVER_URL}/cartdetail`
          })
          .then((res)=>{
            console.log(res)
          })
          .catch((err)=>{
            console.log(err)
          })
        },
        deleteCart(){
          axios({
            method:"delete",
            url:`${SERVER_URL}/cartdetail/${this.wish_id}`
          })
          .then((res)=>{
            alert("삭제되었습니다.")
            console.log(res)
            this.$router.push('/wish')
          })
          .catch((err)=>{
            console.log(err)
          })
        },
        deleteItem(id){
          axios({
            method:"delete",
            url:`${SERVER_URL}/cartdetail/${id}`
          })
          .then((res)=>{
            alert("삭제되었습니다.")
            console.log(res.data)
            this.$router.push('/wish')
          })
          .catch((err)=>{
            console.log(err)
          })
        }
      //   price(){
          
      //     })
        
      }
      
  }
  </script>
  
  <style scoped>
  @font-face {
    font-family: 'NanumSquare_acB';
    src: url('../../../public/fonts/NanumSquare_acB.ttf');
  }
  @font-face {
    font-family: 'NanumSquare_acEB';
    src: url('../../../public/fonts/NanumSquare_acEB.ttf');
  }
  @font-face {
    font-family: 'NanumSquare_acL';
    src: url('../../../public/fonts/NanumSquare_acL.ttf');
  }
  @font-face {
    font-family: 'NanumSquare_acR';
    src: url('../../../public/fonts/NanumSquare_acR.ttf');
  }
  @font-face {
    font-family: 'NanumSquareB';
    src: url('../../../public/fonts/NanumSquareB.ttf');
  }
  @font-face {
    font-family: 'NanumSquareEB';
    src: url('../../../public/fonts/NanumSquareEB.ttf');
  }
  @font-face {
    font-family: 'NanumSquareL';
    src: url('../../../public/fonts/NanumSquareL.ttf');
  }
  @font-face {
    font-family: 'NanumSquareR';
    src: url('../../../public/fonts/NanumSquareR.ttf');
  }
  .wishdetailwrapper{
    font-family: 'NanumSquareR';
    font-size: 18px;
    margin-left: 150px;
    margin-right: 150px;
  }
  .wishdetailtitlediv{
    display: flex;
    justify-content: center;
    font-family: 'NanumSquare_acEB';
    padding: 40px;
  }
  .wishbuttondiv{
    display: flex;
    justify-content: right;
  }
  .wishbutton{
    font-family: 'NanumSquareR';
    font-size: 18px;
  }

  
  </style>