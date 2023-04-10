<template>
  <div class="recipe-list">
    <div v-if="recipeTF">
      <b-container>
        <b-row>

      <b-col 
      cols="4" 
      class="recipe-card" 
      v-for="recipe in recipes" 
      v-bind:key="recipe.recipe_seq">
      <router-link style="text-decoration:none; color:black;" :to="{ name:'RecipeDetail', params:{ rid:recipe.recipe_seq }}">
        <UserRecipeListItemCard v-bind:recipe="recipe"/>
      </router-link>
      </b-col>       
        </b-row>
      </b-container>
    </div>
    <div v-else>
      <h3> 
        <b-icon icon="exclamation-triangle-fill" scale="2" variant="warning"></b-icon>
        아직 작성한 레시피가 없습니다</h3>
    </div>
  </div>
</template>

<script>
import UserRecipeListItemCard from './UserRecipeListItemCard.vue'

export default {
    name: "UserRecipeListItem",
    data() {
        return {
          
        };
    },
    components:{
      UserRecipeListItemCard,
    },
    props:[
      "recipes",
    ],
    computed:{
      recipeTF(){
        const recipes = this.recipes
        console.log(recipes)
        return recipes.length === 0 ? false:true
      },
    }
}
</script>

<style scoped>

</style>