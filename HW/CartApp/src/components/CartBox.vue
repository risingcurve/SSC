<template>
    <div id="cart-box" style="border: 1px solid grey; padding: 10px;">
        <div v-for="(item,index) in this.$store.state.carts" :key="index" id="card">
            <CartMenu :item="item"></CartMenu>
        </div>
    </div>
</template>

<script>
import CartMenu from './CartMenu.vue'
import {api} from '../utils/axios'
export default {
  components: { CartMenu },
  data(){
    return{
      
    }
}
}
</script>

<style>
#cart-box{
    display: flex;
    flex-wrap: wrap;
    overflow-y: scroll;
    background-color: white;
  opacity: 0.7;
  height: 95%;
}
#card{
    width: 25%;
    height: 40%;
}

</style>