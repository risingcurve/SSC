<template>
  <div class="product-list">
      <!--실제로 돌릴 때 주석을 풀어주고 컴포넌트 삭제  -->
      <b-container>
        <b-row>
            <b-col cols="4" class="product-card" v-for="product in products" v-bind:key="product.product_seq">
              <router-link 
              :to="{name:'ProductDetail',params:{ pid:product.product_seq }}"
              style="
              color:black;
              text-decoration: none;">
              <ProductListItemCard v-bind:product="product"/>
              </router-link>
            </b-col>
        </b-row>
      </b-container>
  </div>
</template>

<script>
import ProductListItemCard from './ProductListItemCard.vue'
export default {
    name: "ProductListItem",
    data(){
        return{

        }
    },
    components:{
      ProductListItemCard,  
    },
    props:[
      "products",
    ],
    computed:{
     
      
    },
    methods:{
      
    }
}
</script>

<style scoped>
.product-list{
  display: flex;
  flex-wrap: wrap;
  border: 0px solid black;
  padding: 1px;
}

.product-card {
  display: flex;
  justify-content: center;
}
</style>