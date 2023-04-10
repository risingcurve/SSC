<template>
  <b-container>


    <b-row>
      <b-form-rating v-model="value" style="border:0px solid black; background-color:white;" variant="warning" class="reviewstar" disabled></b-form-rating>
    </b-row>
    <b-row>
      <b-col class="reviewtitle">
        {{ review?.title }}
      </b-col>
    </b-row>
    <b-row>
      <b-col class="reviewdetail">
        {{ review?.detail }}
      </b-col>
    </b-row>
    <b-row>
      <b-col class="reviewwritter">
        {{ name }}
      </b-col>
      <b-col class="reviewcreateddate">
        {{ review?.created_date }}
      </b-col>
    </b-row>
    <div class="reviewbuttondiv">
      <!-- 로그인 유저만 보이게 v-if 추가예정 -->
      <b-button variant="dark" v-on:click="putReview">
        수정
      </b-button>
      <b-button variant="outline-dark" v-on:click="deleteReview">
        X
      </b-button>
    </div>
    <br>
    <b-row></b-row>
</b-container>

</template>

<script>
import axios from '@/service/axios'

const SERVER_URL = 'https://i8a102.p.ssafy.io/api'

export default {
    name:"ReviewListItem",
    props:['review'],
    data(){
      return{
        name:"",
        value:this.review.star_point,
      }
    },
    methods:{
      putReview(){
        this.$router.push({name:"Review", query:{ rid:this.review.product_comment_seq }})
      },
      deleteReview(){
        axios({
          method:"delete",
          url:``
        })
        .then((res)=>{
          console.log(res)
          this.$router.push({ name:'ProductDetail', params:{ pid:`${this.$route.params.pid}` }})  // 나중에 검토하기 
        })
        .catch((err)=>{
          console.log(err)
        })
      },
      getUserName(){
            axios({
                method:"get",
                url:`${SERVER_URL}/user/all/${this.review.user_seq}`
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
.reviewstar {
  width: 20px;
  
}
.reviewtitle {
  font-size: 19px;
}
.reviewdetail {
  font-size: 16px;
}
.reviewwritter {
  font-weight : bold;
}

.reviewcreateddate{
  font-size: 16px;
  color: gray;
}

.reviewbuttondiv {
  display: flex;
  justify-content: right;
  margin-right: 33px;
}
</style>