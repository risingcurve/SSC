<template>
    <div class="recipecard">
        <img 
        :src="`https://i8a102.p.ssafy.io/api/image/recipe/${recipe.recipe_seq}`" 
        alt="img.jpg"
        style="
        width:150px;
        height:150px;">
        <p>{{ recipe.recipe_name }}</p>
        <!-- <p>레시피 내용 : {{ recipe.detail }}</p> -->
    </div>
</template>

<script>
export default {
    props:{
        recipe: Object,
    },
    data() {
        return {
            
        };
    },
    computed() {
        
    },
    methods: {
        
    },
};
</script>

<style scoped>
.recipecard{
    /* box-shadow: 5px 5px 5px rgb(230,230,230); */
    border-radius: 10px;
    border: 0px solid black;
    width: 200px;
    height: 200px;
}

</style>