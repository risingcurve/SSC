<template>
  <div id="loginapp">
    <div>
      <div class="login">
      <div class="logintitlediv">
        <h1 ><b>로그인</b></h1>
      </div>
        <div class="input_id">
          <b-form-input type="text" placeholder="ID" style="width:500px;" v-model="uid">
          </b-form-input>
        </div>
        <div class="input_pwd">
          <b-form-input type="password" placeholder="password" style="width:500px;" v-model="password">
          </b-form-input>
        </div>
        <div style="display:flex; justify-content: right; padding: 14px">
          
          <div class="loginbtn">
            <b-button 
            type="submit" 
            variant="primary" 
            style="
            margin-right:10px; 
            margin-left:9px;" 
            v-on:click="logIn">Login</b-button>
          </div>
          <div class="signupbtn">
            <b-button type="submit" variant="success" v-on:click="signUp">회원가입</b-button>
          </div>
        </div>
        
      </div>
      
    </div>
  </div>
</template>

<script>
export default {
  name: 'LoginView',
  data() {
    return {
      uid: null,
      password: null,
    }
  },
  methods: {
    logIn() {
      const uid = this.uid
      const password = this.password

      const payload = {
        user_id: uid,
        user_pwd: password,
      }
      this.$store.dispatch('logIn', payload)
    },
    signUp(){
      this.$router.push('/signup')
    }
  }
}
</script>

<style scoped>
@font-face {
  font-family: 'NanumSquare_acEB';
  src: url('../../../public/fonts/NanumSquare_acEB.ttf');
}

@font-face {
  font-family: 'NanumSquareR';
  src: url('../../../public/fonts/NanumSquareR.ttf');
}

body {
  display: flex;
  flex-direction: column;
  flex: 1;
  width: 100%;
  height: 100%;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  }
.logintitlediv {
    display: flex;
    justify-content: center;
    padding: 40px;
    font-family: 'NanumSquare_acEB';
    font-size: 20px;
}

.logintitle, .input_id, .input_pwd, .loginbtn .signupbtn{
  margin: 21px;
  
}

.login{
  border: 0px solid black;
  border-radius: 20px;
}
#loginapp{
  padding-left: 150px;
  padding-right: 150px;
  padding-top: 50px;
  /* font-family: 'NanumSquareR'; */
  display: flex;
  justify-content: center;
  align-content: center;

}



</style>
