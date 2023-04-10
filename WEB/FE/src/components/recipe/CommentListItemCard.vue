<template>
    <div class="commentcard">
        <b-card :title="name">
            <b-card-text>
                {{ comment?.recipe_content }}
            </b-card-text>
        </b-card>
    </div>
</template>


<script>
import axios from "axios"

const SERVER_URL = 'https://i8a102.p.ssafy.io/api'

export default {
    props:[
        "comment"
    ],
    data() {
        return {
            name:"",
        }
    },
    computed:{

    },
    methods: {
        getUserName(){
            axios({
                method:"get",
                url:`${SERVER_URL}/user/all/${this.comment.user_seq}`
            })
            .then((res)=>{
                this.name = res.data.user_id
            })
        }
    },
    created(){
        this.getUserName()
    },

}

</script>


<style scoped>
.commentcard{
    width: 1010px;
    margin-right: 40px;
    
}
</style>