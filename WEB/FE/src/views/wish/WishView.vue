<template>
    <div class="wishwrapper">
        <b-container class="wishcontainer">
            <div class="wishtitlediv">
                <h1 
                class="wishlisttitle"
                >Shopping Basket</h1>
            </div>
            <div class="wishcreatebuttondiv">
              
              <b-button v-on:click="goMakeWish" variant="success" class="wishcreatebutton">
                <b-icon icon="cart-plus" >
                </b-icon>
                장바구니 만들기
              </b-button>
            </div>

            <div class="wishlistdiv">
                <WishListItem v-bind:wishes="wishes"/>
            </div>

        </b-container>
    </div>
</template>

<script>
import WishListItem from "@/components/wish/WishListItem.vue"

export default {
    name: 'WishView',
    data() {
        return {
  
        }
    },
    components:{
      WishListItem,
    },
    methods: {
      getWish(){
        this.$store.dispatch("getWishes"); 
      },
      goMakeWish(){
        this.$router.push('/wishcreate')
      }
    },
    created() {
      this.getWish()
    },
    computed:{
      wishes(){
        return this.$store.state.wishes
      }
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
  
  .wishwrapper {
    margin-left: 150px;
    margin-right: 150px;

  }
  .wishcontainer {
    font-family: 'NanumSquareR';
  }

  .wishtitlediv{
    display: flex;
    font-family: NanumSquareEB;
    padding: 50px;
    margin-right: 30px !important;
    margin: 10px;
    justify-content: center;
    text-align: center;

}    



.wishcreatebuttondiv {
  display: flex;
  padding: 10px;

}

.wishcreatebutton {
  margin-left: auto;
  font-size: 20px;
  font-family: 'NanumSquareB';

}

.wishlistdiv {
  font-family: 'NanumSquareR';
  font-size: 20px;

}
</style>
