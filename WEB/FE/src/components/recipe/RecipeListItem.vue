<template>
  <div class="recipe-list">
    <div class="recipe-card">
      <b-card-group>
      <b-row>
        <b-col cols="4" v-for="recipe in recipes" v-bind:key="recipe.recipe_seq">
        <router-link style="text-decoration:none; color:black;" :to="{ name:'RecipeDetail', params:{ rid:recipe.recipe_seq }}">
          <RecipeListItemCard v-bind:recipe="recipe"/>
        </router-link>
        </b-col>
      </b-row>
      </b-card-group>
    </div>       
  </div>
</template>

<script>
import RecipeListItemCard from './RecipeListItemCard.vue'
export default {
    name: "RecipeListItem",
    data() {
        return {
            
        };
    },
    components:{
      RecipeListItemCard,
    },
    computed:{
    
    },
    props:[
      "recipes",
    ]
}
</script>

<style scoped>
.recipecard {
  width: 320px;

}


</style>
<!-- .recipe-list{
  display: flex;
  flex-wrap: wrap;
  padding: 1px;
  justify-content: center;
}-->
<!-- border: 1px solid black; -->