<template>
  <div style="height:100%">
    <div id="title-size">
      <BackMain id="back-button"></BackMain>
      <h1 id="title-name">Select Theme</h1>
    </div>
    <div class="bb2">
      <div class="box3">
        <div v-for="(th,index) in names" :key="index" id="inner-s-box">
          <div @click="gotoDetail(th)"><p class="mainfont">{{ th }}</p></div>
          <RecipeBox :recipe="theme[index]"></RecipeBox>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import RecipeBox from '@/components/RecipeBox.vue'
import BackMain from '@/components/Buttons/BackMain.vue'
import { api } from '@/utils/axios'
export default {
    data(){
      return{
        theme:[],
        names:[],
        recipe:[]
      }
    },
    
    methods:{
      gotoDetail(data){
        this.$store.commit('SET_RECIPE',this.recipe)
        this.$router.push(`/recipe/detail/${data}`)
        
      },

    },
    components:{
      BackMain,RecipeBox
    },
    async created(){
      var recipe = await api.cartdata.getRecipebyItem(this.$store.state.barcodeItem.product_seq)
      this.recipe = recipe.data
      for(let i in recipe.data){
        var thm = recipe.data[i].theme_seq
        if(!this.theme.includes(thm)){
          var tt = await api.cartdata.getThemebySeq(thm)
          this.theme.push(thm)
          this.names.push(tt.data.theme_name)
        }
      }

    }
}
</script>

<style scoped>

#container{
  /* position: flex;
  flex-direction: column; */
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
#inner-s-box{
  height: 95%;
  min-width: 30%;
  margin-top: 1%;
}
#inner-img{
  height: 80%;
  width: 85%;
}
</style>