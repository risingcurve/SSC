<template>
  <div>
    <b-container id="mypage" class="bv-example-row">
      <b-row>
        <b-col cols="2">
          <SidebarComp />
        </b-col>
    
        <b-col cols="7">
          <h1>구매내역</h1>
          <div v-for="purchase in purchaseList" v-bind:key="purchase.purchase_seq">
            <PurchaseListItem v-bind:purchase="purchase"/>
          </div>
     
       
        </b-col>

      </b-row>
    </b-container>
  </div>
</template>

<script>
import SidebarComp from '@/SidebarComp.vue'
import PurchaseListItem from './PurchaseListItem.vue'
import axios from 'axios';

const SERVER_URL = 'https://i8a102.p.ssafy.io/api'

export default {
  name:"PurchaseList",
  data(){
    return{
      purchaseList:[],

    }
  },
  components:{
    PurchaseListItem,
    SidebarComp,
  },
  methods:{
    getPurchase(){
      axios({
        method: "get",
        url: `${SERVER_URL}/purchase/${this.$route.params.uid}`
      })
      .then((res)=>{
        this.purchaseList = res.data
      })
      .catch((err)=>{
        console.log(err)
      })
    }
  }

}
</script>

<style scoped>
#mypage{
  margin-top: 30px;
  margin-left: 150px;
  margin-right: 150px;
  font-family:'Hahmlet', 'serif';
}

</style>