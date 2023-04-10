<template>
  <div>
    <b-carousel
    id="carousel"
      v-model="slide"
      :interval="4000"
      controls
      indicators
      background="rgb(40, 40, 40)"
      style="
      border:1px solid white;
      margin-left:0px;
      margin-right:0px;
      padding:0px;"
      label-next=""
      label-prev=""
      @sliding-start="onSlideStart"
      @sliding-end="onSlideEnd">
     
  <!-- <div v-for="(recipe, recipe_seq) in recipes" v-bind:key="recipe.recipe_seq"> -->
    <b-carousel-slide v-for="(recipe, recipe_seq) in recipes" v-bind:key="recipe.recipe_seq" style="display:flex;">
    <template #img>
      <div>
      <b-card class="cardstyle" style="border:0px solid black;">
        <b-card-title>{{ recipe?.recipe_name }}</b-card-title>
        <b-card-sub-title>{{ recipe_seq }}</b-card-sub-title>
        <b-card-text>
          {{ recipe?.detail }}
        </b-card-text>
      </b-card>
      </div>
    </template>
    </b-carousel-slide>
  <!-- </div> -->
</b-carousel>
  <!-- <carousel :per-page="1" :navigate-to="someLocalProperty" :mouse-drag="false">
    <slide>
      Slide 1 Content
    </slide>
    <slide>
      Slide 2 Content
    </slide>
  </carousel> -->
  </div>
</template>

<script>
import axios from "axios";
// import {Carousel, Slide} from "vue-carousel";

const SERVER_URL = 'https://i8a102.p.ssafy.io/api'


export default {
    name:"HomeRecipeListItem",
       data() {
        return {
            recipes:[],
            slide: 0,
            sliding: null,
        }
    },
    methods: {
      onSlideStart() {
        this.sliding = true
      },
      onSlideEnd() {
        this.sliding = false
      },
      getRecipe(){
        axios({
          method:"get",
          url: `${SERVER_URL}/recipe/theme/2`
        })
        .then((res)=>{
          this.recipes = res.data
        })
        .catch((err)=>{
          console.log(err)
        })
    },
    },
    created(){
      this.getRecipe()
    },
    // components:{
    //   Carousel,
    //   Slide
    // },

}
</script>

<style scoped>
.cardstyle{
  margin: 100px;
  width:300px;
  height:300px;
}


#carousel{
  /* color: blue !important; */
  border: 0px solid red;
  /* background-color: blue !important; */
}

</style>