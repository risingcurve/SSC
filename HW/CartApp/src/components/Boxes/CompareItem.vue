<template>
    <b-card-body
        id="nav-scroller"
        ref="content"
      >
      <div v-for="(item,index) in comps" :key="index" id="compare-cards">
        <CompareCards :item="item"></CompareCards>
      </div>
    </b-card-body>
</template>

<script>
import CompareCards from '../Cards/CompareCards.vue'
import { api } from '@/utils/axios'
export default {
  components: { CompareCards },
  data(){
    return{
      comps:[]
    }
  },
  async created(){
    var arr = await api.cartdata.getItem(this.$store.state.barcodeItem.product_name)
    console.log(arr.data)
    this.comps = arr.data
  }
}
</script>

<style scoped>
#nav-scroller{
  display: flex;
  flex-direction: column;
  /* justify-content: space-between; */
  overflow-y: scroll;
  align-items: center;
  height: 80%;
  border: 1px solid grey;
  border-radius: 5px;
  background-color: white;
  opacity: 0.9;
  margin: 3%;
}
#compare-cards{
  /* height: 100%; */
  width: 80%;
  display: flex;
  justify-content: space-between;
  height: 30%;
  margin: 1%;
}
.card{
  width: 100%;
}
</style>