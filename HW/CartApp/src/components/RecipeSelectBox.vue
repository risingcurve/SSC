<template>
      <b-form-select id="select-item" v-model="selected" select-size=1>
        <b-form-select-option :value=null style="font-size: 40px;">{{ options[0].product_info }} {{ options[0].price }}원 </b-form-select-option>
        <b-form-select-option v-for="(option,index) in options" 
        style="font-size: 40px;"
        :key="index" 
        :value="option.price">
          {{ option.product_info }} {{ option.price }}원
        </b-form-select-option>
      </b-form-select>
  </template>
  
  <script>
import { api } from '@/utils/axios'
    export default {
      data() {
        return {
          selected: null,
          options: [
          ],
        }
      },
      props:["item"],
      async created(){
        var name = await api.cartdata.getItembyId(this.item.product_seq)
        var rr = await api.cartdata.getItem(name.data.product_name)
        this.options = rr.data
        console.log()
      },
      watch:{
        selected(newSelect){
          this.$emit('selection',newSelect)
        }
      }
    }
  </script>

  <style>
  #select-item{
    height: 100%;
    font-size:30px;
    margin: 2%;
  }
</style>