<template>
  <div class="review-create">
    <h1><b>후기를 남겨주세요!</b></h1>
    <label for="reviewtitle">리뷰제목:</label>
    <b-form-input type="text" v-model="reviewTitleInput"></b-form-input>
    <label for="starpoints">별점:</label>
    <b-form-rating v-model="value" variant="warning" class="mb-2"></b-form-rating>
    <label for="reviewdetail">리뷰내용:</label>
    <b-form-textarea rows="3" max-rows="6" v-model="reviewDetailInput"></b-form-textarea><br>
<!-- 별점 css 포함 추가 필요 -->
    <div v-if="!id">
    <b-button type="submit" v-on:click="submitReview">SUBMIT</b-button>
    </div>
    <div v-else>
        <b-button type="reset">입력초기화</b-button>
        <b-button type="submit" v-on:click="putReview">수정완료</b-button>
    </div>
    <b-button v-on:click="$router.go(-1)">작성 취소</b-button>
  </div>
</template>

<script>
import axios from 'axios';

const SERVER_URL = 'https://i8a102.p.ssafy.io/api'


export default {
    name:"ReviewCreate",
    data(){
        return{     
            value:null,
            reviewTitleInput:"",
            reviewDetailInput:"",
        }
    },

    methods:{
        submitReview(){
            if (!this.reviewTitleInput){
                alert('제목을 입력해주세요.')
            } else if (!this.reviewDetailInput) {
                alert('내용을 입력해주세요.')
            } 
            axios({
                method:'post',
                url: `${SERVER_URL}/productcomment`,
                data:{
                    title: this.reviewTitleInput,
                    detail: this.reviewDetailInput,
                    star_point: this.value,
                    product_seq:this.$route.params.pid,
                    user_seq:1
                },
                // headers:{
                //     Authorization: .$store.state.token}   // 로그인된 사용자만
                // }
            })
            .then((res)=>{
                console.log(res)
                this.$router.push({ name:'ProductDetail', params:{ pid:`${this.$route.params.pid}` }})  // 나중에 검토하기 
                // 상품 상세페이지로 
            })
            .catch(err=>{
                console.log(err)
            })
        },
        getReview(){
            axios({
                method:"get",
                url:`${SERVER_URL}/productcomment/${this.$route.query.rid}`
            })
            .then((res)=>{
                this.reviewTitleInput = res.data.title
                this.reviewDetailInput = res.data.detail
                this.value = res.data.star_point
            })
            .catch((err)=>{
                console.log(err)
            })

        },
        putReview(){
            axios({
                method:"put",
                url:`${SERVER_URL}/productcomment`,
                data:{
                    title:this.reviewTitleInput,
                    detail:this.reviewDetailInput,
                    star_point:this.value
                }
            })
            .then((res)=>{
                console.log(res.data)
                this.$router.push({ name:'ProductDetail', params:{ pid:`${this.$route.params.pid}` }})
            })
            .catch((err)=>{
                console.log(err)
            })
        },
    },
    created(){
        if (this.id){
            this.getReview()
        }
    },
    computed:{
        id(){
            return this.$route.query.rid
        },
    }
}
</script>

<style scoped>
.review-create{
    margin-left: 150px;
    margin-right: 150px;
    margin-top:30px;
    padding-left: 250px;
    padding-right: 250px;

}
</style>