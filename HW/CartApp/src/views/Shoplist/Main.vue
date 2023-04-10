<template>
  <div class="pp">
    <div style="height: 16%;">
      <h3 style="padding-top:3%; font-size: 40px;">안녕하세요 {{ $store.state.loginUser.user_name }}님! 장바구니를 선택해주세요!</h3>
    </div>
    <b-button @click="gotoMain2" style="font-size: 50px; position:absolute;bottom: 5%;width: 60%; left: 20%;">
      >>메인메뉴로>>
    </b-button>
    <transition appear
	appear-active-class="animated fadeInRight">
    <div id="container">
      <div id="s-box">
        <div v-for="(list, index) in lists" :key="index" id="inner-s-box" @click="gotoMain(list)">
          <div style="font-size: 20px;height: 10%;">{{ list.cart_name }}</div>
          <ShopBox id="main-list" :list="list" :showDel="false"></ShopBox>
        </div>
      </div>
    </div>
  </transition>
  </div>
</template>

<script>
import {api} from '@/utils/axios'
import ShopBox from '@/components/ShoppingBox.vue'
import BackMain from '@/components/Buttons/BackMain.vue'
import BarcodeInput from '@/components/BarcodeInput.vue'
import BarcodeModal from '@/components/Modals/BarcodeModal.vue'
export default {
  data() {
    return {
      lists: [],
      show: true
    }
  },
  components: {
    ShopBox, BackMain, BarcodeInput, BarcodeModal
  },
  methods: {
    gotoMain(data) {
      this.$router.push(`/main`)
      this.$store.commit("SET_LIST",data)
    },
    showThis() {
      this.show = true
    },
    gotoMain2(){
      this.$router.push(`/main`)
    }
  },
  async created(){
    var result = await api.cartdata.getList(this.$store.state.userId)
    var user = await api.cartdata.findUserbyId(this.$store.state.userId) 
    this.lists = result.data
    this.$store.commit('SET_LOGIN_USER',user.data)

  },
  mounted(){

  }

}
</script>

<style scoped>
.pp{
  background-image: url('@/assets/background.jpg');
  background-size: cover;
  height: 100%;
}

#s-box {
  display: flex;
  height: 80%;
  padding: auto;
}


#container {
  overflow-x: scroll;
  height: 84%;
  width: 100%;
}

#main-list{
  height: 90%;
}
</style>