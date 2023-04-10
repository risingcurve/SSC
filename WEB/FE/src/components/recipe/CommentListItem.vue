<template>
    <div class="comment-list">
        <b-card-group>
            <CommentListItemCard v-bind:comment="comment"/>
        </b-card-group>
    </div>
</template>

<script>
import CommentListItemCard from './CommentListItemCard.vue'
export default {
    name: "CommentListItem",
    data(){
        return{

        }
    },
    components:{
        CommentListItemCard,
    },
    props:[
        "comment"
    ],
    computed:{
      
    }
}
</script>