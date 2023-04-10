<template>
  <div>
      <div v-for="comment in comments" v-bind:key="comment.recipe_comment_seq">
        <CommentListItem v-bind:comment="comment"/>
      </div>
  </div>
</template>


<script>
import CommentListItem from './CommentListItem.vue'

export default {
  components: { CommentListItem },
  name: "CommentList",
  props:[
    "comments",
  ]
  
}


</script>

<style>

</style>