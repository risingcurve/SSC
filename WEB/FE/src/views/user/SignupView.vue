<template>
    <div class="signup">
        <div class="signuptitlediv">
          <h1><b>회원 가입</b></h1>
        </div>
        <div class="signupform">
            <b-form  @submit.stop.prevent>
                <label for="feedback-user">ID</label>
                <b-form-input v-model="uid" :state="validation" id="feedback-user"></b-form-input>
                <b-form-invalid-feedback :state="validation">
                  ID 길이는 8-15자 영문입니다.
                </b-form-invalid-feedback>
                <b-form-valid-feedback :state="validation">
                  Looks Good.
                </b-form-valid-feedback>
            </b-form>
            <b-form @submit.stop.prevent>
             <label for="text-password1">비밀번호</label>
             <b-form-input 
             type="password" 
             id="text-password1" 
             aria-describedby="password-help-block"
             v-model="password1" ></b-form-input>
             <b-form-text id="password-help-block">
               비밀번호 길이는 8-15자의 영문과 숫자를 포함합니다.
             </b-form-text>
        </b-form>
        <b-form @submit.stop.prevent>
             <label for="text-password2">비밀번호 확인</label>
             <b-form-input 
             type="password" 
             id="text-password2" 
             aria-describedby="password-help-block"
             v-model="password2" ></b-form-input>
             <b-form-invalid-feedback :state="validationpwd">
                  비밀번호가 일치하지 않습니다. 
                </b-form-invalid-feedback>
                <b-form-valid-feedback :state="validationpwd">
                  비밀번호가 일치합니다.
                </b-form-valid-feedback>
        </b-form>
        <b-form>
    <label>이름</label>
    <b-form-input
      class="mb-2 mr-sm-2 mb-sm-0"
      v-model="username"
    ></b-form-input>
  </b-form>
  <b-form inline>
     <label class="sr-only" for="inline-form-input-name">이메일</label>
    <b-form-input
      id="inline-form-input-name"
      class="mb-2 mr-sm-2 mb-sm-0"
      v-model="email_id"
    ></b-form-input>
   
    <b-input-group prepend="@" class="mb-2 mr-sm-2 mb-sm-0">
      <b-form-input id="inline-form-input-username" v-model="email_domain"></b-form-input>
    </b-input-group>
    <label for="birth">생년월일</label>
    <b-form-datepicker v-model="birth" v-on:context="onContext"></b-form-datepicker>
  </b-form>
  <b-form-group label="성별" v-slot="{ ariaDescribedby }">
      <b-form-radio-group
        v-model="gender"
        :options="options"
        :aria-describedby="ariaDescribedby"
        name="radio-inline"
      ></b-form-radio-group>
    </b-form-group>
    <b-form-group label="휴대폰번호">
        <b-form-input type="tel"></b-form-input>

    </b-form-group>
        <div>
            <b-button v-on:click="signUp" variant="success">SUBMIT</b-button>
        </div>
    <br>
        <div class="signupbuttondiv">
            <b-button v-on:click="signUp" variant="success">회원가입</b-button>
        </div>
        </div>
    <br>
    <br>
    <br>
    </div>  
</template>
<script>


export default {
    name: 'SignupView',
    data(){
        return{
            uid:"",
            password1:"",
            password2:"",
            username: null,
            email_id:null,
            email_domain:null,
            phone:null,
            birth:null,
            gender:null,
            formatted: '',
            selected: '',
            options: [
          { text: '남자', value: 'M' },
          { text: '여자', value: 'F' }
        ]
        }
    },
    computed:{
        validation(){
            return this.uid.length > 7 && this.uid.length < 16
        },
         validationpwd(){
            return this.password1 === this.password2
        }
    },
    methods:{
        signUp(){
            const uid = this.uid;
            const password1 = this.password1;
            // const password2 = this.password2;
            const username = this.username;
            const email_id = this.email_id;
            const email_domain = this.email_domain;
            const phone = this.phone;
            const birth = this.birth;
            const gender = this.gender;

            const payload = {
                user_id:uid,
                user_pwd:password1,
                user_name: username,
                email_id:email_id,
                email_domain:email_domain,
                phone:phone,
                birth:birth,
                gender:gender,
            };
            this.$store.dispatch("signUp", payload);
        },
        onContext(ctx) {
        this.formatted = ctx.selectedFormatted
        this.selected = ctx.selectedYMD
        console.log(this.selected)
      },
    },
};
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

.signup{
    margin-left: 150px;
    margin-right: 150px;
    margin-top: 30px;
    font-family: 'NanumSquareR';
    font-size: 19px;
}

.signuptitlediv{
    padding: 40px;
    font-family: 'NanumSquare_acEB';
    display: flex;
    justify-content: center;
}
.signupform{
    margin-left: 200px;
    margin-right: 200px;
}

.signupbuttondiv {
  display: flex;
  justify-content: right;      
}
</style>