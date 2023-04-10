<template>
  <div>
    <b-container>
        <b-row>
            <b-col cols="2">
                <SidebarComp/>
            </b-col>
            <b-col cols="10">
                <user-review-list v-bind:user="user"/>
            </b-col>
    <h1></h1>
        </b-row>
    </b-container>
  </div>
</template>

<script>
import SidebarComp from '@/SidebarComp.vue'
import UserReviewList from './UserReviewList.vue'

export default {
  components: {
    SidebarComp, 
    UserReviewList 
    },
   
  data(){
    return{
      user: this.$route.params.uid,
    }
  }
}
</script>

<style>

</style>
