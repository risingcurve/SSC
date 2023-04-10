<template>
  <div>
  
    <b-table 
    striped 
    v-bind:items="items"
    head-variant="dark"
    fixed
    style="
    box-shadow: 5px 5px 6px rgb(200,200,200);"></b-table>
    <router-link :to="{name:'PurchaseDetail', params:{uid:1, purchaseid:1}}">
      상세보기
    </router-link>
  </div>
</template>

<script>
// get 추가 필요
export default {
    name:"PurchaseListItem",
     data() {
      return {
        items: [],
      }
    },
    props:[
      "purchase",
    ],
    methods:{
      getProduct(){
        this.$store.dispatch('getProducts')
        for (let ent in this.$store.state.products){
          if (this.purchase.product_seq === ent.product_seq){
            let pitem =  { 
              product_name: ent.product_name , 
              cnt: this.purchase.cnt, 
              price: this.purchase.price, 
              total_price:(this.purchase.cnt)*(this.purchase.price) }
            this.items.push(pitem)
          }
        }
      }
    }

}
</script>

<style>


</style>