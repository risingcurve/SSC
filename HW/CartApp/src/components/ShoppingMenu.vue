<template>
  <b-list-group-item id="menu-box">
    <div id="menu-name" :class="{ 'in-cart': list === true && compMenu === true }">
      No.{{ menuId }}
    </div>
    <div id="menu-name" :class="{ 'in-cart': list === true && compMenu === true }">
      {{ menuName }}
    </div>
    <div id="menu-name" :class="{ 'in-cart': list === true && compMenu === true }">
      {{ menuPrice }}원
    </div>
    <div id="menu-name" :class="{ 'in-cart': list === true && compMenu === true }">
      {{ menuStock }}개
    </div>
    <DeleteMenu 
    v-if="showDel" 
    :menuId="menuId" 
    @showModal="$emit('showModal',true)"
    id="del-btn">
    </DeleteMenu>
  </b-list-group-item>
</template>

<script>
import {api} from '@/utils/axios'
import DeleteMenu from '@/components/Buttons/DeleteMenu.vue';
export default {
  data() {
    return {
      list: false,
      menuName:""

    }
  },
  props:[
    "menuId",
    "menuStock",
    "menuPrice",
    "showDel",
    "compMenu",
    ],
  components: {
    DeleteMenu
  },
  methods:{

  }, 
  async created() {
    const naming = await api.cartdata.getItembyId(this.menuId);
    this.menuName=naming.data.product_name
    var cartArr = this.$store.state.carts
    for(var i in cartArr){
      if(this.menuName === cartArr[i].title)
        this.list = true
  
    }
    
  },

}

</script>

<style scoped>
#menu-box {
  width: 100%;
  display: flex;
  justify-content: space-around;
  height: 100%;
}

#menu-name {
  text-align: center;
  width: 100%;
  height: fit-content;
  margin: auto;
}

.in-cart {
  background-color: blueviolet;
}
</style>