<template>
  <b-list-group id="menubox" >
    <b-card-body
        id="nav-scroller"
        ref="content"
      >
      <div v-for="(menu,index) in list.products" :key="index" id="shop-box">
        <ShoppingMenu 
        :compMenu="compMenu" 
        :menuId="menu.product_seq" 
        :menuPrice="menu.price"
        :menuStock="menu.cnt" 
        :showDel="showDel"
        @showModal="$emit('showModal',[index,menu.title])"
        id="shop-menu">
        </ShoppingMenu>
      </div>
    </b-card-body>
  </b-list-group>
</template>

<script>
import ShoppingMenu from './ShoppingMenu.vue'
import {api} from '../utils/axios'
export default {
  data(){
    return{
      menus:[],
      listnumber:0
    }
  },
  props:
  ["showDel","compMenu","list"],
  components: { ShoppingMenu },
  methods:{

  },
  async created(){
    const result = await api.cartdata.getList(this.$store.state.userId)
    var result_size = result.data[0].products.length
    this.menus = result.data[0]
  },

}
</script>

<style scoped>
#nav-scroller{
  position:relative; 
  height:100%; 
  margin: 20px; 
  overflow-x:auto;
  border-radius: 5px;
  opacity: 0.9;
}

#shop-box{
  width: 100%;
  height: 20%;
}
#shop-menu{
  margin:10px;
  display: flex;
  justify-content: space-between;
  width: 100%;
}
</style>