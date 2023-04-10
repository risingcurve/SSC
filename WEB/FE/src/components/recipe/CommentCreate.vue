<template>
	<div>
		<b-container>
            <b-row>
                <b-form-textarea id="content" cols="130" rows="3" v-model="commentDetailInput"></b-form-textarea>
            </b-row>
            <b-row class="recipecommentcreatebuttonrow">
                <b-button type="submit" v-on:click="submitComment" style="font-size:18px; background-color: gray;">댓글 작성</b-button>
            </b-row>
        </b-container>
	</div>
</template>

<script>
import axios from 'axios';

const SERVER_URL = 'https://i8a102.p.ssafy.io/api'

export default {
    name:"CommentCreate",
    data(){
        return{
            commentDetailInput:"",
        }
    },
    props:[
        'recipe_id'
    ],
    methods:{
        submitComment(){
			if (!this.commentDetailInput) {
                alert('내용을 입력해주세요.')
            }else{

                axios({
                    method:'post',
                url: `${SERVER_URL}/recipecomment`,
                data:{
                    user_seq:this.$store.state.user.user_seq,
                    recipe_content: this.commentDetailInput,
                    recipe_seq:this.recipe_id
                },

            })
            .then((res)=>{
                console.log(res)
                this.$router.go(this.$router.currentRoute)
            })
            .catch((err)=>{
                console.log(err)
            })
            } 
        },
        getUser(){
            this.$store.dispatch("getUserById")
        }
    },
    created(){
        this.getUser()
    },
    computed:{
        
    }
}


</script>

<style scoped>
.recipecommentcreatebuttonrow{
    display: flex;
    justify-content: right;
}
</style>