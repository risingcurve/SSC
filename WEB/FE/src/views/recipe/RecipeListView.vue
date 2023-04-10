<template>
  <div class="recipewrapper">
    <b-container class="recipecontainer">
      <div class="recipetitlediv">
        <h1 class="recipetitle"><b style="margin-right:10px;">{{ main_title }}</b>Recipe</h1>
      </div>
      <div class="recipecreatebuttondiv">
        <b-button class="recipecreatebutton" variant="success" v-bind:theme_id="theme_id" v-on:click="goRecipeCreate">
          레시피 작성하기
        </b-button>
        <b-button class="recipethemebutton" v-on:click="goRecipeTheme">
          테마 목록으로
        </b-button>
      </div>

        <RecipeListItem v-bind:recipes="recipes"/>


    </b-container>
  </div>    
</template>
<script>
import RecipeListItem from "@/components/recipe/RecipeListItem.vue"
import axios from "axios";

const SERVER_URL = 'https://i8a102.p.ssafy.io/api'

export default {
  name: 'RecipeListView',
  data(){
    return{
      recipes:[],
      theme_id:this.$route.params.tid,
      main_title:"",
    }
  },
  components:{
    RecipeListItem,
  },
  methods:{
    getRecipe(){
      axios({
        method:"get",
        url: `${SERVER_URL}/recipe/theme/${this.$route.params.tid}`
      })
      .then((res)=>{
        this.recipes = res.data
      })
      .catch((err)=>{
        console.log(err)
      })
    },
    getTheme(){
      axios({
        method:"get",
        url:`${SERVER_URL}/theme`
      })
      .then((res)=>{
        const all = res.data
        for (let ent of all){
          if (ent.theme_seq===this.theme_id){
            this.main_title = ent.theme_name
          }
        }
      })
      .catch((err)=>{
        console.log(err)
      })
    },
    goRecipeCreate(){
      this.$router.push('/recipecreate')
    },
    goRecipeTheme(){
      this.$router.push('/theme')
    },
  },
  created(){
    this.getRecipe()
    this.getTheme()
  },
  computed:{
    // recipes(){
    //   return this.$store.state.recipes
    // },
  }
}
</script>
<style scoped>
@font-face {
  font-family: 'NanumSquare_acB';
  src: url('../../../public/fonts/NanumSquare_acB.ttf');
}
@font-face {
  font-family: 'NanumSquare_acEB';
  src: url('../../../public/fonts/NanumSquare_acEB.ttf');
}
@font-face {
  font-family: 'NanumSquare_acL';
  src: url('../../../public/fonts/NanumSquare_acL.ttf');
}
@font-face {
  font-family: 'NanumSquare_acR';
  src: url('../../../public/fonts/NanumSquare_acR.ttf');
}
@font-face {
  font-family: 'NanumSquareB';
  src: url('../../../public/fonts/NanumSquareB.ttf');
}
@font-face {
  font-family: 'NanumSquareEB';
  src: url('../../../public/fonts/NanumSquareEB.ttf');
}
@font-face {
  font-family: 'NanumSquareL';
  src: url('../../../public/fonts/NanumSquareL.ttf');
}
@font-face {
  font-family: 'NanumSquareR';
  src: url('../../../public/fonts/NanumSquareR.ttf');
}

.recipewrapper {
  display: flex;
  font-family: 'NanumSquareR';
}
.recipetitlediv{
  display: flex;
  justify-content: center;
  padding: 10px;
  margin: 10px; 
  font-family: 'NanumSquare_acEB';
}
.recipetitle {
  padding: 40px;
}
.recipecontainer{
  width: 60%;
}
.recipecreatebuttondiv {
  display: flex;
  
}
.recipecreatebutton {
  margin-left: auto;
  margin-right: 15px;
  font-size: 20px;
  font-family: 'NanumSquareB';
}

.recipethemebutton {
  margin-right: 0px;
  font-size: 20px;
  font-family: 'NanumSquareB';
}




</style>