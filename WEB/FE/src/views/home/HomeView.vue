<template>
    <div id="homeview">
        <HomeRecipeList />
    </div>    
</template>
<script>
import HomeRecipeList from '@/components/home/HomeRecipeList.vue'


export default {
    name: 'HomeView',
    data(){
        return{

        }
    },
    components:{
        HomeRecipeList
        
        
    }
}
</script>
<style scoped>
#homeview{
    padding-left:150px;
    padding-right:150px;
    background-color: white;
}
</style>