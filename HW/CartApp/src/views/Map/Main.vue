<template>
  <div class="mapbox">
    <div id="title-size">
      <BackMain id="back-button" type="button" class="btn btn-danger">GoBack</BackMain>
      <h1 id="title-name">Map</h1>
      <b-button @click="showModal" ref="add-cart" id="back-button2">물건 담기</b-button>
    </div>
    <transition appear appear-active-class="animated fadeInUp">
    <div id="map-container">
      <div id = "map-image-container">
          <img src="@/assets/map.png" alt="" style="width: 100%;height: 100%;margin: 0;position:relative">
          <img id = "cart-icon" src="@/assets/cart_icon.png" alt="" style="position:absolute; top:-10%; left:-10%">
      </div>

    </div>
    </transition>
    
    <div id="buttons">
      <GoCart style="width:50%; height: 100%;" id="button-font"></GoCart>
      <b-button v-b-toggle.sidebar-right style="width:50%; height: 100%;" id="button-font">Wish List</b-button>
    </div>
    <b-sidebar id="sidebar-right" title="Sidebar" width="40%" right shadow backdrop style="background-color: bisque;">
      <div class="px-3 py-2" style="height: 80%;">
        {{ $store.state.list.cart_name }}
        <ShoppingBox :list="this.$store.state.list" style="height: 100%;"></ShoppingBox>
        <b-button @click="gotolist" id="button-font" style="height: 10%; width: 90%;">리스트 수정하기</b-button>
      </div>
    </b-sidebar>
    <OpenBarcodeModal :showBarcode="showBarcode" @hideB="showBarcode = false" @showitem="show = true"></OpenBarcodeModal>
    <BarcodeModal :show="show" @hide="show = false"></BarcodeModal>
  </div>
</template>

<script>
import MartMap from "@/components/MartMap.vue"
import ShoppingBox from '@/components/ShoppingBox.vue'
import GoCart from '@/components/Buttons/GoCart.vue'
import BackMain from "@/components/Buttons/BackMain.vue"
import BarcodeInput from '@/components/BarcodeInput.vue'
import BarcodeModal from "@/components/Modals/BarcodeModal.vue"
import OpenBarcodeModal from '@/components/Modals/OpenBarcodeModal.vue'
export default {
  data(){
    return{
      showBarcode:false,
      show:false
    }
  },
  components:{
    MartMap,
    BackMain,
    ShoppingBox,
    GoCart,
    BarcodeInput,
    OpenBarcodeModal,
    BarcodeModal
},
  methods:{
    gotolist(){
      this.$router.push(`/list/detail/${this.$store.state.list.cart_name}`)
    },
    showModal() {
      this.showBarcode = true
    }
  },
  mounted(){
    // console.log(this.$store.state.cart_x + this.$store.state.cart_y );
    var movingtarget = document.getElementById("cart-icon");

    setInterval(() => {
      movingtarget.style.top = `${7.5*this.$store.state.cart_x+8}%`
      movingtarget.style.left = `${6.4*this.$store.state.cart_y-4}%`
    }, 1000);
  },

}
</script>

<style>
.mapbox{
  position: relative;
  background-color: aliceblue;
  height: 100%;
  
}
#map-container{
  display: flex;
  height: 75%;
  width: 100%;
  /* justify-content: space-between; */
}


#map-image-container{
  height: 100%;
  width: 100%
}


#buttons{
  display: flex;
  height: 11%;
}
#map-shop-list{
  width: 50%;
  height: 95%;
  font-size: 40px;
}

#button-font{
  font-size: 30px;
}
</style>