<template>
  <div class="Bill_main">
    <div id="title-size">
      <BackMain id="back-button"></BackMain>
      <h1 id="title-name">결제 수단을 선택해주세요</h1>
    </div>  
    <div id="container">
      <div id="card" style="justify-content: space-around; width: 100%; height: 90%;" @click="gotodetail()">
        <b-button variant="outline-secondary" style="width:100%;opacity:0.9;background-color:white;border-radius: 3%;margin: 4% 2% 4% 6%;">
          <img src="@/assets/credit.png" style="height: 50%;width: 50%;">
          <h1 style="font-size:150;color: white;">신용 카드</h1>
        </b-button>
        <b-button variant="outline-secondary" style="width: 100%;padding: 0%;;margin: 4% 6% 4% 2%;">
            <img src="@/assets/1231.jpg" style="width:100%;height:100%;border-radius: 3%; opacity:0.9;">
        </b-button>
    </div>
    </div>
  </div>
</template>

<script>
import BackMain from '@/components/Buttons/BackMain.vue'
export default {
  components: { BackMain },
  methods:{

    gotodetail(){
      this.$router.push('/bill/detail')
    }
  }
}
</script>

<style scoped>

.Bill_main{
  height: 100vh;
  background-image: url('@/assets/choiceBill.jpg');
  overflow: auto; 
  background-size: cover;
  background-repeat: no-repeat;
}
#card{
  display: flex;
  justify-content: center;
}

#container{
  text-align: center;
  height: 86%;
}
</style>