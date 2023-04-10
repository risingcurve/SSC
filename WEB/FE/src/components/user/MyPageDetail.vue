<template>
  <div id="mypagedetail">
    <b-container id="mypage" class="bv-example-row">
        <b-button v-on:click="goBack"><b-icon icon="arrow-left"></b-icon>뒤로가기</b-button>
      <b-row style="margin-left:70px;">
        <!-- <b-col cols="2">
          <SidebarComp />
        </b-col> -->
        <b-col cols="12">
          <MyPageDetailItem />
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
// import SidebarComp from '@/SidebarComp.vue'
import MyPageDetailItem from './MyPageDetailItem.vue'
export default {
  components: { 
    // SidebarComp, 
    MyPageDetailItem },
    name:"MypageDetail",
    methods:{
      goBack(){
        this.$router.go(-1)
      }
    }
}
</script>

<style>
#mypage{
  margin-top: 30px;
  margin-left: 150px;
  margin-right: 150px;
  font-family:'Hahmlet', 'serif';
}

</style>