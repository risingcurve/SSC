<template>
  <div class="wishlistdiv">
    <b-container>

      <!-- <h3 class="wishlisttitle">장바구니 목록</h3> -->
      <div class="wish-card" v-for="wish in wishes" v-bind:key="wish.cart_seq">
        <router-link :to="{name:'WishDetail', params:{wid:wish.cart_seq}}">
          <WishListItemCard v-bind:wish="wish"/>
        </router-link>
      </div>       
    </b-container>
  </div>
</template>
  
<script>
  import WishListItemCard from './WishListItemCard.vue'
  export default {
      name: "WishListItem",
      data() {
          return {
              
          }
      },
      created(){

      },
      props:[
        "wishes",
      ],
      components:{
        WishListItemCard,
      },
      methods:{
  
      },
      computed:{
       
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
  
.wishlistdiv{
    display: flex;
    font-family: NanumSquareEB;
    padding: 0px;
    
}
.wishlisttitle {
  padding-bottom: 20px;
  font-size: 23px;
    
}

</style>