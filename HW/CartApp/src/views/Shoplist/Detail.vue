<template>
  <div id="app">
    <div id="title-size">
      <BackMain id="back-button" type="button" class="btn btn-danger">GoBack</BackMain>
      <h1 id="title-name">Shop List Detail</h1>
    </div>
    <DeleteModal :show="showDel" :delId="itemId" :delName="itemName" @hide="hideThis">
    </DeleteModal>
    <div id="shop-detail-box">
      <h3>{{ this.$store.state.list.cart_name }}</h3>
      <ShopBox :list="this.$store.state.list" :showDel="true" @showModal="modalData">
      </ShopBox>
    </div>
 </div>
</template>

<script>
import BackMain from '@/components/Buttons/BackMain.vue'
import ShopBox from '@/components/ShoppingBox.vue'
import BarcodeInput from '@/components/BarcodeInput.vue'
import BarcodeModal from '@/components/Modals/BarcodeModal.vue'
import DeleteModal from '@/components/Modals/DeleteModal.vue'
export default {
  data() {
    return {
      showDel: false,
      show:false,
      itemId: 0,
      itemName: "nothing"
    }
  },
  components: {
    BackMain, ShopBox, BarcodeInput,
    DeleteModal,BarcodeModal
  },
  methods: {
    hideThis() {
      this.showDel = this.hideThis
    },
    modalData(event){
      this.showDel = true
      this.itemId = event[0] + 1
      this.itemName = event[1]
    },
    showThis(){
      this.show = true
    }
  }
}
</script>

<style>
#shop-detail-box{
  height: 80%;
}
</style>