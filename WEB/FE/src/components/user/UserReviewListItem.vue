<template>
  <div class="userReview" style="
  width:200px;
  height:200px;
  border-radius:10px;">
    <img 
    :src="`https://i8a102.p.ssafy.io/api/image/product/${review.product_seq}`" 
    alt=""
    style="
    border-radius:10px
    width:100px;
    height:100px;">
    <p><b>{{ review?.title }}</b></p>
    <hr>
    <p>{{ review?.detail }}</p>
  </div>
</template>

<script>
export default {
    name:"UserReviewListItem",
    props:[
      "review"
    ],
    
}
</script>

<style>

</style>