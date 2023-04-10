<template>
  <div>
    <b-container id="mypage" class="bv-example-row">
      <b-row>
        <!-- <b-col cols="2">
          <SidebarComp v-bind:user="user"/>
        </b-col> -->
        <b-col style="margin-left:90px" cols="10">
          
          <b-container class="aboutuser">
            <b-row>
              <b-col cols="6">
              <div class="userinfo">
                <b-row>
                  <b-col cols="5">
                  <img 
                  :src="`https://i8a102.p.ssafy.io/api/image/user/${user.user_seq}`" 
                  alt="img"
                  style="
                  height:100px;
                  width:100px;">
                  </b-col>
                    <b-col cols="5">
                    <p>{{ user?.user_name }}님</p>
                    <!-- <p><b>50,000원</b></p> -->
                    <b-button v-on:click="goMyDetail">
                      <b-icon icon="person-lines-fill"></b-icon>회원상세
                    </b-button>
                    </b-col>
                </b-row>
                  </div>
              </b-col>
                  
              <b-col cols="6">  
              <div class="createinfo">
                <div><p>후기</p><p>{{ reviews.length }}</p></div>
                <div><p>레시피</p><p>{{ recipes.length }}</p></div>
                <div><p>좋아요</p><p>2</p></div>
            </div>
            </b-col>
            </b-row>
          </b-container>

          <p>{{ user?.user_name }}님이 작성한 레시피</p><hr>
          <UserRecipeListItem v-bind:recipes="recipes"/>
          <p>{{ user?.user_name }}님이 작성한 후기</p><hr>
          <UserReviewList v-bind:reviews="reviews"/>  
        </b-col>
      </b-row>
    </b-container>  
  </div>
</template>

<script>
import axios from 'axios'
import UserRecipeListItem from '@/components/user/UserRecipeListItem.vue'
import UserReviewList from '@/components/user/UserReviewList.vue'
// import SidebarComp from '@/SidebarComp.vue'


const SERVER_URL = 'https://i8a102.p.ssafy.io/api'

export default {
  name: "MypageView",
  data(){
    return{
      user:null, 
      recipes:[],
      reviews:[],
      
    }
  },
  created(){
    this.getUser()
  },
  methods:{
    getUser(){
      axios({
        method: "get",
        url: `${SERVER_URL}/user/${this.$store.state.login_user}`
      })
      .then((res)=>{
        this.user = res.data
        this.getRecipe()
        this.getReview()
      })
      .catch((err)=>{
        console.log(err)
      })
    },
    getRecipe(){
      axios({
        method:"get",
        url:`${SERVER_URL}/recipe/user/${this.user.user_seq}`
      })
      .then((res)=>{
        this.recipes = res.data
      })
      .catch((err)=>{
        console.log(err)
      })
    },
    getReview(){
      axios({
        method:"get",
        url:`${SERVER_URL}/productcomment/list/user/${this.user.user_seq}`
      })
      .then((res)=>{
        this.reviews = res.data
      })
      .catch((err)=>{
        console.log(err)
      })
    },
    goMyDetail(){
        this.$router.push({ name: 'MypageDetail', params:{ uid: this.$store.state.login_user }})
      },

  },
  computed:{
  },
  components:{
    UserRecipeListItem,
    UserReviewList,
    // SidebarComp,


  }
}
</script>

<style scoped>
#mypage{
  margin-top: 30px;
  margin-left: 150px;
  margin-right: 150px;
  font-family:'Hahmlet', 'serif';
}

.aboutuser{
  background-color: rgb(240, 240, 240);
  box-shadow: 3px 3px 3px rgb(197, 197, 197);
  margin-bottom: 30px;
  padding: 20px;
  border: 0px solid black;
  border-radius: 10px;
}
.userinfo{
  border-right: 1px solid rgb(163, 162, 162);
  height: 100px;

}
.createinfo{
  display: flex;
  justify-content: space-evenly;
  border: 0px solid black;

}
</style>