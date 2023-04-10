<template>
  <div>
    <b-container>
      <b-row>
          <b-col cols="4" 
          class="reviewlist" 
          v-for="review in reviews" 
          v-bind:key="review.product_comment_seq"
          >
              <UserReviewListItem v-bind:review ="review" />
          </b-col>
     
      </b-row>
    </b-container>
  </div>
</template>

<script>
// import axios from '@/service/axios'
import UserReviewListItem from './UserReviewListItem.vue'

// const SERVER_URL = 'https://i8a102.p.ssafy.io/api'

export default {
    components: { UserReviewListItem },
    props:[
      "user",
      "reviews"
    ],
    name: "ReviewList",
    data(){
      return{
        // user_review:[],
      }
    },
    created(){
      // this.getUserReview()
    },
    methods:{
      // getUserReview(){
      //   axios({
      //     method:"get",
      //     url:`${SERVER_URL}/recipecomment/user_seq/${this.user}`
      //   })
      //   .then((res)=>{
      //     this.user_review = res.data
      //   })
      //   .catch((err)=>{
      //     console.log(err)
      //   })
      // }
    }

}
</script>

<style>

</style>