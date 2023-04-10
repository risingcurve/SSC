<template>
    <div class="recipecard">
        <b-card
        v-bind:title="recipe?.title"
        :img-src="`https://i8a102.p.ssafy.io/api/image/recipe/${recipe.recipe_seq}`"
        img-alt="Image"
        img-top
        img-height="298px"
        tag="article"
        style="max-width: 20rem;"
        class="mb-2"
        >
        <b-card-text class="recipecardtitle">
            <h3>{{ recipe?.recipe_name }}</h3>
        </b-card-text>
        <!-- <b-card-text class="recipecardcontent"> -->
            <!-- {{ recipe?.user_name }} -->
            <!-- {{ recipe?.detail }} -->
        <!-- </b-card-text> -->
        

        </b-card>    
     
    </div>
</template>

<script>
export default {
    props:[
      "recipe",
    ],
    data() {
        return {
          image:`https://i8a102.p.ssafy.io/api/image/recipe/${this.recipe.recipe_seq}`,
        };
    },
    computed() {
        
    },
    methods: {
        
    },
};
</script>

<style scoped>
@font-face {
    font-family: 'nanumsquare_acEB';
    src: url('../../../public/fonts/NanumSquare_acEB.ttf');
  }

@font-face {
    font-family: 'nanumsquareL';
    src: url('../../../public/fonts/NanumSquareL.ttf');
  }
div{

    padding: 10px;
    margin: 5px;
}
  .recipecardtitle{
    font-family: 'nanumsquare_acEB';
  }
  .recipecardcontent{
    font-family: 'nanumsquareL';
  }
</style>