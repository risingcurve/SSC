<template>
  <div style="height: 100%;">
    <div id="title-size">
      <BackMain id="back-button"></BackMain>
      <h1 id="title-name">Select Dish</h1>
    </div>
    <div class="bb2">
      <div class="box3">
        <div v-for="(list,index) in $store.state.recipe" :key="index" id="inner-s-box">
          <div @click="gotorecipe(list)" style="height: 20%;"><p class="mainfont"> {{ list.recipe_name }}</p></div>
          <Detail @click="gotorecipe(list)" :rseq="list.recipe_seq"></Detail>
        </div>
      </div>
    </div>
  </div>

</template>

<script>
import BackMain from '@/components/Buttons/BackMain.vue'
import Detail from '@/components/RecipeBox_detail.vue'
import { api } from '@/utils/axios'
export default {
  data(){
    return{
      lists:[]
    }
  },
  components:{
    BackMain,Detail

  },
  methods:{
    gotorecipe(data){
      this.$store.commit('SET_RECIPE_SEQ',data.recipe_seq)
      this.$router.push(`/recipe/list/${data.recipe_name}`)
    }
  },
  async created(){
  }

}
</script>

<style>
#inner-s-box{
  height: 90%;
  min-width: 33%;
  background-color: aliceblue;
  border-radius: 3%;
  margin-right: 2%;
  margin-top: 2%;
}
.box3{
  display: flex;
  margin-left:30px;
  overflow-x: scroll;
  height: 100%;
}
.bb2{
  background-color: rgb(92 83 29 / 46%);
  height: 86%;
}
.mainfont{
  font-size: 40px;
  font-family: 'Staatliches', cursive;
  letter-spacing: 5px;
}
</style>