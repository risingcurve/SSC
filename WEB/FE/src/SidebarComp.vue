<template>
  <div>
    <div class="sidebar">
      <b-nav vertical
      style="
      background-color:rgb(240, 240, 240); 
      height:400px;
      padding:0px; border-radius:5px; 
      box-shadow: 2px 2px 3px rgb(197,197,197);">
      <b-navbar-nav id="menu" class="ml-auto" style="height:400px; box-shadow: 2px 2px 3px rgb(197,197,197);">
        <b style="padding:10px;">MEMU</b>
        <b-nav-item class="tag" v-on:click="goMyDetail">회원정보</b-nav-item>
        <b-nav-item class="tag" v-on:click="goPurchase">구매내역</b-nav-item>
        <b-nav-item class="tag" v-on:click="goReview">후기</b-nav-item>
        <b-nav-item class="tag" v-on:click="goRecipe">레시피</b-nav-item>
      </b-navbar-nav>

  </b-nav>
    </div>

  </div>
</template>

<script>

export default {
    name:"SidebarComp",
    methods:{
      goMyDetail(){
        this.$router.push({ name: 'MypageDetail', params:{ uid: this.$store.state.login_user }})
      },
      goPurchase(){
        this.$router.push({ name: 'Purchase', params:{uid:this.user.user_seq}})
      },
      goReview(){
        this.$router.push({name: 'UserReview', params:{ uid:this.user.user_seq}})
      },
      goRecipe(){
        this.$router.push({name:'UserRecipe', params:{uid:this.$store.state.login_user}})
      }
    },
    props:[
      "user",
    ]
}
</script>

<style scoped>
.sidebar{
  width: 170px;
  height: 320px;

}
#menu{
  display: flex;
  justify-content: space-around;
}
.tag{
  color: black;
  text-align: center;
  margin: 5px;
}
.tag:hover{
  background-color: rgb(193, 193, 193);
  border-radius:5px ;
  opacity: 0.5 ;
}
</style>