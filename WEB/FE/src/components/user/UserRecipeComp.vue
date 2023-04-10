<template>
  <div id="user_recipe">
    <b-container>
        <b-row>
            <b-col cols="2">
                <SidebarComp/>
            </b-col>
            <b-col cols="10">
                <user-recipe-list-item />
            </b-col>
    <h1></h1>
        </b-row>
    </b-container>
  </div>
</template>

<script>
import SidebarComp from '@/SidebarComp.vue'
import UserRecipeListItem from './UserRecipeListItem.vue'

export default {
    components: { UserRecipeListItem, SidebarComp },
   
}
</script>

<style>

</style>