<template>
  <div class="back123">
    <div id="container">
      <div id="title-size">
        <BackMain id="back-button"></BackMain>
        <h1 id="title-name">Shop Compare</h1>
        <b-button @click="showModal" ref="add-cart" id="back-button2">물건 담기</b-button>
      </div>
      <transition appear appear-active-class="animated fadeInUp">
        <div id="com-box">
          <div id="c-list">
            <CartList></CartList>
          </div>
          <div id="s-box1">
            <ShoppingBox id="shop-box-nav" :list="this.$store.state.list" :compMenu="true"></ShoppingBox>
          </div>
        </div>
      </transition>
      <OpenBarcodeModal :showBarcode="showBarcode" @hideB="showBarcode = false" @showitem="show = true"></OpenBarcodeModal>
    <BarcodeModal :show="show" @hide="show = false"></BarcodeModal>
    </div>
  </div>
</template>

<script>
import OpenBarcodeModal from '@/components/Modals/OpenBarcodeModal.vue';
import ShoppingBox from '@/components/ShoppingBox.vue';
import CartList from '@/components/CartList.vue';
import BarcodeInput from '@/components/BarcodeInput.vue'
import BarcodeModal from '@/components/Modals/BarcodeModal.vue';
import BackMain from "@/components/Buttons/BackMain.vue"
export default {
  data() {
    return {
      showBarcode: false,
      show:false
    }
  },
  components: {
    CartList, ShoppingBox, BarcodeInput, BarcodeModal, BackMain,OpenBarcodeModal
  },
  methods: {
    showModal() {
      this.showBarcode = true
    }
  }
}
</script>

<style>
.back123 {
  background-image: url('@/assets/background.jpg');
  position: relative;
  background-size: cover;
}

#container {
  width: 100%;
  height: 100vh;
}

#com-box {
  display: flex;
  width: 100%;
  height: 86%;
}

#s-box1 {
  width: 50%;
  height: 100%;
}

#c-list {
  width: 50%;
}

#title-size {
  height: 14%;
  color: white;
  background-color: #343a40;
  display: flex;
  justify-content: center;
  align-items: center;
}

#title-name {
  height: fit-content;
  margin: auto;
}
#shop-box-nav{
  height: 100%;

}
#shop-box-nav > #nav-scroller{
  display: flex;
  flex-direction: column;
  /* justify-content: space-between; */
  overflow-y: scroll;
  align-items: center;
  height: 80%;
  border: 1px solid grey;
  border-radius: 5px;
  background-color: white;
  opacity: 0.9;
  margin: 3%;
}
</style>