<template>
  <b-modal id="modal-id" @shown="focusHere" ref="open-barcode" hide-footer title="바코드를 입력해주세요">
    <div class="d-block-2 text-center">
      <input id="b-input" type="text" style="font-size: 40px;"
  @keyup.enter="pressEnter" 
  ref="barcode" 
  autofocus>
    </div>
    <b-button class="mt-3" variant="outline-danger" block @click="hideModal">Close Me</b-button>
  </b-modal>
</template>

<script>
import BarcodeInput from '../BarcodeInput.vue'
import {api} from '@/utils/axios'
export default {
  components:{
    BarcodeInput,
  },
  props: ["showBarcode"],
  methods: {
    showModal() {
      this.$refs['open-barcode'].show()
      this.$emit('hideB', false)
    },
    hideModal() {
      this.$refs['open-barcode'].hide()
      this.$emit('hideB', false)
    },
    showThis(){
      this.hideModal()
      this.$emit('showitem',true)
    },
    focusHere(){
      this.$refs.barcode.focus()
    },
    async pressEnter(){
            var inputD = this.$refs.barcode.value
            var iteminfo = await api.cartdata.getItembyId(inputD)
            var itemData = iteminfo.data
            var companyinfo = await api.cartdata.getCompbyId(itemData.company_seq)
            this.$store.commit('CHANGE_BARCODE_ID',itemData)
            this.$store.commit('SET_COMPANY_NAME',`${companyinfo.data.company_name} ${itemData.product_info} ${itemData.price} 원`)
            // console.log(this.$store.state.full_name)
            // this.$store.commit('ADD_PRICE',itemData.price)
            this.$refs.barcode.value = ""
            this.showThis()

        },
  },
  mounted(){

  },
  watch: {
    showBarcode(newShow) {
      if (newShow === true) {
        this.showModal()
      }
    }
  }
}
</script>

<style>
#modal-id>div{
  max-width: 90%;
  height: 80%;
}
.modal-content{
  width: 100%;
  height: 100%;
  /* max-height: 100%; */
}
.modal-body{
  height: 100px;
}
#b-input{
  width: 80%;
  height: 30%;
}
.d-block-2{
  height: 80%;
  display: flex;
  align-items: center;
  justify-content: center;
}
.mt-3{
  height: 15%;
  width: 100%;
}

.modal-title{
  font-size: 40px;
}
.modal-body>button{
  font-size: 30px;
}

</style>