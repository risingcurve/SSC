<template>
  <div class="billbox">
    <div id="title-size">
      <BackMain id="back-button"></BackMain>
      <h1 id="title-name">결제 수단을 선택해주세요</h1>
    </div>
    <div id="detailb">
      
      <div id="c-list">
        <CartList></CartList>
      </div>
      <div id="price-box">
        <h2>Total Price</h2>
        <div class="totalprice" v-bind:totalPrice="totalPrice">
          {{ totalPrice }}원
        </div>
        <h2>Discount</h2>
        <div class="totalprice">
          0원
        </div>
        <h2>Final Price</h2>
        <div class="totalprice">
          
          {{ this.$store.state.total_price }}원
        </div>
        <b-button @click="gotologout()" id="pay-button">
          결제하기
        </b-button>
      </div>
    </div>
  </div>
</template>

<script>
import CartList from '@/components/CartList.vue';
import BackMain from '@/components/Buttons/BackMain.vue'
export default {
  components: {
    CartList,
    BackMain,
  },
  data() {
    return {
     
      purchase_list:{
        purchase_seq:0,
        user_seq:0,
        purchase_date:"",
        total_price:0,
        purchase_list:[{
          purchase_detail_seq:0,
          purchase_seq:0,
          product_seq:0,
          stock:0,
          price:0,
          sale_price:0
    }]
    }}
  },
  methods: {
    moveCompare() {
      this.$router.push('/list/compare')
    },
    gotologout() {
      
      this.$router.push('/bill/finish')
    }
  },
  computed:{
    totalPrice(){
      return this.$store.state.total_price
    }
  }
  
}
</script>
<style scoped>
.billbox {
  background-image: url('@/assets/background.jpg');
  background-size: cover;
  object-fit: contain;
  height: 100%;
}

#pppp {
  display: flex;
  position: relative;
}

#detailb {
  display: flex;
  justify-content: space-around;
  height: 86%;
}

#c-list2 {
  display: flex;
  flex-direction: column;
  margin-right: 0%;
}

.totalprice {
  border: 1px solid black;
  border-radius: 1%;
  height: 10vh;
  width: 30vw;
  opacity: 0.8;
  background-color: white;
}
#price-box{
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
  height: 100%;
}

#pay-button{
  height: 10%;
  width: 100%;
}
</style>