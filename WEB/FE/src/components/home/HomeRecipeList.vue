<template>
  <div>
    <!-- <HomeRecipeListItem /> -->
    <div>
      <h1 id="title">SSC</h1>
      <h3 id="sub">2월의 SSC 추천 레시피-<b>[백종원의 요리비책]</b></h3>
    </div>
    <!-- <div v-else>
      <div v-for="wish in wishes" v-bind:key="wish.cart_seq">
        <HomeWish v-bind:wish="wish"/>
      </div> -->
    <!-- </div> -->
    <hr>
    <b-row>
      <b-col cols="3" v-for="recipe in recipes" v-bind:key="recipe.recipe_seq">
        <router-link style="text-decoration:none; color:black;" :to="{ name:'RecipeDetail', params:{ rid:recipe.recipe_seq }}">
        <HomeRecipeListItemCard v-bind:recipe="recipe" />
        </router-link>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import HomeRecipeListItemCard from '@/components/home/HomeRecipeListItemCard.vue'
import axios from '@/service/axios'
// import HomeWish from './HomeWish.vue'
// import HomeRecipeListItem from './HomeRecipeListItem.vue'

const SERVER_URL = 'https://i8a102.p.ssafy.io/api'

export default {
    name:"HomeRecipeList",
    data(){
        return{
          recipes:[],
          wishes:[],
        }
    },
    components:{
        // HomeRecipeListItem,
        HomeRecipeListItemCard,
        // HomeWish
    },
    methods:{
      getRecipe(){
        axios({
          method:"get",
          url:`${SERVER_URL}/recipe/theme/2`
        })
        .then((res)=>{
          this.recipes = res.data
        })
        .catch((err)=>{
          console.log(err)
        })
      },
      getWishes(){
        if (this.LoginTF===true){
          this.$store.dispatch("getWishes")
        }
      }
    },
    created(){
      this.getRecipe()
      this.getWishes()
    },
    computed:{
      LoginTF(){
        return this.$store.state.refreshToken === null ? true : false
      },
    },

}
</script>

<style scoped>

#title{
  font-size: 100pt ;
  margin-left: 40%;
  font-weight: bolder;
  color: aliceblue;
  animation-duration: 3s;
  animation-name: fadein;
  animation-iteration-count:1;
  width:300px;
  background: linear-gradient(to right, #FFE400, #FF0000, #5F00FF,#0100FF);
  color: transparent;
  -webkit-background-clip: text;
}

@keyframes slidein{
  from{
    margin-left: 100%;
    width: 300%;
  }
  to{
    margin-left: 40%;
    width: 300%;
  }
}

#sub{
  font-size: 20pt ;
  margin-left: 30%;
  /* font-weight: ; */
  color: black;
  animation-duration: 3s;
  animation-name:fadein;
  animation-iteration-count:1;
}

@keyframes fadein {
  from {
        opacity:0;
    }
    to {
        opacity:1;
    }
}
</style>