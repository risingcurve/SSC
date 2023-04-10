<template>
  <div>
    <div class="reviewlist" v-for="review in reviews" v-bind:key="review.review_seq">
        <ReviewListItem v-bind:review ="review" />
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import ReviewListItem from './ReviewListItem.vue'

const SERVER_URL = 'https://i8a102.p.ssafy.io/api'

export default {
    components: { ReviewListItem },
    name: "ReviewList",
    data(){
      return{
        reviews:[], 
      }
    },
    props:[
      "productid"
    ],
    created(){
      this.getReviews()
  
    },
    methods:{
      getReviews(){
        axios({
          method:"get",
          url: `${SERVER_URL}/productcomment/list/${this.productid}`
        })
        .then((res) =>{
          console.log(res.data)
          for (let ent in res.data){
            if (ent.product_seq === this.productid){
              this.reviews.push(ent)
            }
          }
          this.reviews = res.data
        })
        .catch((err) => {
          console.log(this.productid)
          console.log(err)
        })

      }
    }

}
</script>

<style>
.reviewlist {
  width : 445px;
}
</style>