<template>
  <div>
    <img 
        :src="`https://i8a102.p.ssafy.io/api/image/product/${this.product.product_seq}`" 
        alt="img"
        style="
        width:300px;
        height:300px;
        filter:drop-shadow(5px 5px 5px rgb(197,197,197));
        object-fit:contain">
        <p style="
    
        padding-top:15px; 
        padding-bottom:0px; 
        font-weight:bold;">{{ product?.product_name }}</p>
        <div style="
        display:flex; 
        justify-content:space-between; 
        padding:0px; margin:0px;
        border:0px solid black;">
            <p><b>{{ product?.price }}원</b></p>
        </div>
            <!-- <b-form-rating 
            id="rating-lg-no-border" 
            v-model="value" 
            style="
            width:100px;
            padding:3px;
            margin:0px;" 
            variant="warning" 
            no-border size="md"></b-form-rating> -->

  </div>
</template>

<script>
export default {
  name:"WishProductListItemCard",
  data(){
    return{
      value:5
    }
  },
  props:[
    "product",
  ]

}
</script>

<style>

</style>