<template>
  <div class="firstpage" @click="gotologin()">
    <login :show="show" @hide="hideThis"></login>
    <div class="login1">Feeling</div>
    <div><img src="@/assets/login.jpg" class="inpage"></div>
    <div class="login2">Different</div>
  </div>
</template>

<script>
import login from '@/components/Modals/loginModal.vue'
export default {
  data(){
    return{
      show:false
    }
  },
  components:{
    login
  },
  methods:{
    hideThis(){
      this.show=false;
    },
    gotologin(){
      this.show=true;
    }
  }
}
</script>

<style>

.firstpage{
  background-color: #7e97ac;
  display: relative;
  justify-content: space-around;
  align-content: center;
  height: 100vh;
  min-width: fit-content;
}
.login1{
  position: absolute;
  font-weight: bold;
  font-size: 70px;
  left: 9%;
  top: 39%;
}
.login2{
  position: absolute;
  font-weight: bold;
  font-size: 70px;
  right: 7%;
  top: 39%;
}
.inpage{
  max-width: 100%; 
  max-height: 100%; 
  left: 0; 
  right: 0; 
  top: 0; 
  bottom: 0; 
  margin: auto; 
  overflow: auto; 
  position: fixed; 
}
</style>