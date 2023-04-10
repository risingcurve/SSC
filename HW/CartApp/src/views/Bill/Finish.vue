<template>
  <div style="height: 100vh;background-color: rgb(209 200 132);">
    <div id="container">
      <div id="card" style="justify-content: space-around; width: 100%; height: 90%;" >
        <b-button variant="outline-secondary" @click="gotomain()" style="width:100%;background-color: gray;border-radius: 3%;margin: 4% 2% 4% 6%;">
          <b-icon icon="cart4" aria-hidden="true" scale="20px"></b-icon>
          <h1 style="font-size:150;color: black;">다시 장보기</h1>
        </b-button>
        <b-button variant="outline-secondary" @click="gotofirst()" style="width: 100%;padding: 0%;;margin: 4% 6% 4% 2%; border-radius: 3%;background-color: gray;">
          <b-icon icon="person-circle" aria-hidden="true" scale="20px"></b-icon>
          <h1 style="font-size:150;color: black;">로그 아웃</h1>
          
        </b-button>
    </div>
    </div>
  </div>
</template>

<script>
export default {
  methods:{
    gotocart(){
      this.$router.push('/shopcart')
    },
    gotodetail(){
      this.$router.push('/bill/detail')
    },
    gotofirst(){
      this.$router.push('/')
    },
    gotomain(){
      this.$router.push('/main')
    }
  }
}
</script>

<style scoped>
/* #app {
  display: flex;
  border: 10px solid black;
  flex-direction: column;
  justify-content: center;
} */
#card{
  display: flex;
  justify-content: center;
}

#container{
  text-align: center;
  height: 96%;
}
</style>