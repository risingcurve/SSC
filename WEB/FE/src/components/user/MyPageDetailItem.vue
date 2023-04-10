<template>
  <div>
    <b-row>
            <b-col
            class="profileimg"
            cols="8"
            style=
            "border:0px solid black;
            border-radius:10px;">
              <b-avatar 
              :src="`https://i8a102.p.ssafy.io/api/image/user/${user_seq}`"
              style=
              "border:0px solid black;
              background-color:rgb(190,190,190);
              color:white;
              width:250px;
              height:250px;
              box-shadow: 5px 5px 5px rgb(230,230,230);"></b-avatar>
              
               <!-- <b-img 
               v-bind="mainProps" 
               rounded="circle" 
               alt="Circle image"
               style="
               border:1px solid black
               width:250px;
               height:250px;"></b-img> -->
            </b-col>
            <b-col></b-col>
            <b-col></b-col>
            <b-col
            style=
            "border:0px solid black;
            border-radius:10px;
            padding-top:30px;
            padding-left:70px">
            <b-row>
                <b-col cols="3">
                    <h4>ID</h4>
                </b-col>
                <b-col>
                    <b-form-input
                      id="input-id"
                      type="text"
                      style="
                      width:300px"
                      disabled
                      required
                      :value="id"
                    >{{ id }}</b-form-input>
                </b-col>
            </b-row>
            <br>
            <b-row>
                <b-col cols="3">
                    <h4>이름</h4>
                </b-col>
                <b-col>
                    <b-form-input
                      type="text"
                      style="
                      width:300px"
                      required
                      :value="name"
                    ></b-form-input>
                </b-col>
            </b-row>
            <br>
            <b-row>
                <b-col cols="3">
                    <h4>E-mail</h4>
                </b-col>
                <b-col>
                    <b-form-input
                      id="input-mail"
                      type="email"
                      style="
                      width:300px"
                      :value="`${email_id}@${email_domain}`"
                      required
                    ></b-form-input>
                </b-col>
            </b-row>
            <br>
            <b-row>
                <b-col cols="3">
                    <h4>생년월일</h4>
                </b-col>
                <b-col>
                    <b-form-input
                      id="input-birth"
                      type="date"
                      style="
                      width:300px"
                      required
                      :value="birth"
                    ></b-form-input>
                </b-col>
            </b-row>   
            <br>
            <b-row>
                <b-col cols="3">
                    <h4>Phone</h4>
                </b-col>
                <b-col>
                    <b-form-input
                      id="input-phone"
                      type="text"
                      style="
                      width:300px"
                      :value="phone"
                      required
                    ></b-form-input>
                </b-col>
            </b-row>   
            <!-- <br> -->
            <!-- <b-row>
                <b-col cols="3">
                    <h4>결제카드</h4>
                </b-col>
                <b-col>
                    <b-form-input
                      id="input-card"
                      type="text"
                      style="
                      width:300px"
                      
                      required
                    ></b-form-input>
                </b-col>
            </b-row> -->
            <br>
                <b-row>
                <b-col cols="3">
                    <h4>비밀번호입력</h4>
                </b-col>
                <b-col>
                    <b-form-input
                      id="input-password1"
                      type="password"
                      style="
                      width:300px"
                      :value="password1"
                      required
                    ></b-form-input>
                </b-col>
                
            </b-row>
            <br>
            <b-row>
                <b-col cols="3">
                    <h4>비밀번호확인</h4>
                </b-col>
                <b-col>
                    <b-form-input
                      id="input-password2"
                      type="password"
                      style="
                      width:300px"
                      
                      required
                    ></b-form-input>
                </b-col>
                
            </b-row>
            <br>
            <b-row>
                <b-col style="margin-right:0px; padding-right:0px" cols="3">
                    <h4>가입일</h4>
                </b-col>
                <b-col>
                    <b-form-input
                      id="input-date"
                      type="date"
                      style="
                      width:300px"
                      disabled
                      required
                      :value="created_date"
                    ></b-form-input>
                </b-col>
            </b-row>
            <br>
            <!-- <b-row>
                <b-col cols="3">
                    <h4>차량등록</h4>
                </b-col>
                <b-col>
                    <b-form-input
                      id="input-car"
                      type="text"
                      style="
                      width:300px"
            
                      required
                    ></b-form-input>
                </b-col>
            </b-row>     -->
            </b-col>
          </b-row>
          <br>
          <b-row>
            <b-col cols="4"></b-col>
            <b-col cols="2">
                <b-button 
                type="submit" 
                variant="primary"
                v-on:click="putUserData">
                정보수정완료
                </b-button>
            </b-col>
            <b-col ><b-button variant="danger" v-b-modal.modal-1>회 원 탈 퇴</b-button></b-col>
          </b-row>
        <b-modal id="modal-1" title="회원탈퇴" hide-footer>
            
            <h5 class="my-4">정말 탈퇴하시겠습니까?</h5>
            <h5> 앞으로 SSC 서비스를 이용하실 수 없습니다.</h5>
            <hr>
            <b-button>
                취소
            </b-button>
            <b-button v-on:click="withdrawl">
                탈퇴
            </b-button>
        </b-modal>
          
  </div>
</template>

<script>
import axios from 'axios'


const SERVER_URL = 'https://i8a102.p.ssafy.io/api'

export default {
    name:"MyPageDetailItem",
    data(){
        return{
            user_seq:"",
            id:`${this.$route.params.uid}`,
            name:"",
            password1:"",
            password2:"",
            email_id:"",
            email_domain:"",
            phone:"",
            birth:"",
            gender:"",
            created_date:null,

        }
    },
    methods:{
        getUserInfo(){ 
            axios({
                method:"get",
                url:`${SERVER_URL}/user/${this.$route.params.uid}`,
                // headers:{
                //     Authorization: `Token ${this.$store.state.token}`
                // }
            })
            .then((res)=>{
                console.log(res.data)
                this.user_seq = res.data.user_seq
                this.name = res.data.user_name
                this.email_id = res.data.email_id
                this.email_domain = res.data.email_domain
                this.phone = res.data.phone
                const date = new Date(res.data.birth)
                this.birth = date.toISOString().slice(0,10)
                this.gender = res.data.gender
                const createdate = new Date(res.data.created_date)
                // this.created_date = `${createdate.getFullYear()}-${createdate.getMonth()}-${createdate.getDate()}`;
                this.created_date = createdate.toISOString().slice(0,10)
                console.log(this.birth)
                console.log(this.created_date)
            })
            .catch((err)=>{
                console.log(err)
            })

        },
        putUserData(){

            const user_seq = this.user_seq;
            const id = this.id;
            const name = this.name                      
            const password = this.password1
            const email_id = this.email_id
            const email_domain = this.email_domain
            const phone = this.phone
            const birth = this.birth
            const gender = this.gender  

            const payload = {
              user_seq:user_seq,
              user_id:id,
              user_name:name,                        
              user_pwd:password,
              email_id:email_id,
              email_domain:email_domain,
              phone:phone,
              birth:birth,
              gender:gender,
            };
            this.$store.dispatch('putUserData', payload)
          },
        
        withdrawl(){
            axios({
                method:"put",
                url:``,
                date:{
                    is_deleted:true
                }
            })
            .then((res)=>{
                console.log(res)
                this.$store.dispatch("logOut")
                this.$router.push({name:'Home'})
            })
            .catch((err)=>{
                console.log(err)
            })
        },
        
    },
    created(){
        this.getUserInfo()
    }

}
</script>

<style scoped>
.profileimg{
  display: flex;
  align-content: center;
  justify-content: center;
  padding: 25px;
}

</style>