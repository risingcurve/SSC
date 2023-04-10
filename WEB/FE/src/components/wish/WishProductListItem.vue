<template>
  <div>
    <b-container>
        <b-row>
            <b-col cols="4" class="wish-card" v-for="product in products" v-bind:key="product.product_seq">
                <wish-product-list-item-card v-on:click.native="makeWish(product.product_name, product.product_seq)" v-bind:product="product" />
            </b-col>
        </b-row>
    </b-container>
  </div>
</template>

<script>
import WishProductListItemCard from './WishProductListItemCard.vue'
export default {
    name:"WishProductListItem",
  components: { WishProductListItemCard },
  data(){
    return{

    }
  },
  props:[
    "products"
    ],
  methods:{
    makeWish(name, seq){
        return this.$emit('makewish', {name:name, seq:seq })
    },

  }

}
</script>

<style scoped>

</style>