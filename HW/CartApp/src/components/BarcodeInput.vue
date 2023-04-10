<template>
  <input id="b-input" type="text" 
  @keyup.enter="pressEnter" 
  ref="barcode" 
  inputmode="none"
  style="">
</template>

<script>
import {api} from '../utils/axios'
export default {
    methods:{
        setCursor(){
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
            this.$emit('showModal',true)
        },
    },
    mounted(){
        this.setCursor()
    }
}
</script>

<style>

</style>