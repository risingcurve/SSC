<template>
<b-list-group id="menubox" >
    <b-card-body
        id="nav-scroller"
        ref="content"
      >
      <div id="select-box" v-for="(item,index) in ritem" :key="index" style="width:100%;height: 30%;">
        <RecipeSelectBox :item="item" @selection="selection"></RecipeSelectBox>
      </div>
    </b-card-body>
  </b-list-group>
</template>

<script>
import RecipeSelectBox from '../RecipeSelectBox.vue'
export default {
  components: { RecipeSelectBox },
    data(){
        return{
        }
    },
    props:["ritem"],
    methods:{
        selection(data){
          this.$store.commit('CAL_RECIPE',data)
      }
    }
}
</script>

<style scoped>
#select-box{
    display: flex;
    flex-direction: column;
}
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
</style>