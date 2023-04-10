<template>
    <div>
    <b-navbar class="navbar navbar-expand-sm navbar-light" variant="dark" style="padding-right:150px;">
        <div class="container-fluid">
            <router-link 
            to="/" 
            style=
            "text-decoration-line:none; 
            font-size:40px; 
            font-weight:bold;  
            padding:10px;
            padding-left:150px;
            color:white;">
                <span style="padding-top:0px">
                    <img class="navbar-logo" src="../public/images/favicon/android-icon-48x48.png" alt="img">
                </span>
                <span style="padding-top:20px">
                    SSC
                </span>
            </router-link>
        <div id="test">
        <b-input-group size="sm" class="mb-2">
            <b-input-group-prepend>
                <b-button variant="outline-warning" style="border-radius:0px;">
                <b-icon icon="search" variant="light"></b-icon>
                </b-button>
            </b-input-group-prepend>
            <b-form-input 
            type="search" 
            placeholder="Search terms"
            style="
            width:300px;
            border: 1px solid transparent;
            border-radius: 1px;
            background-image: linear-gradient(#F6F6F6, #F6F6F6), linear-gradient(to right, #FFE400, #FF0000, #5F00FF,#0100FF);
            background-origin: border-box;
            background-clip: content-box, border-box;
            "></b-form-input>
        </b-input-group>
        </div>

 
        <ul class="navbar-nav">
            <li class="nav-item" v-if="LoginTF">
                <b-button v-on:click="goLogin" variant="outline-light" style="border:0px solid black">
                    <span class="material-symbols-outlined">login</span>login
                </b-button>
            </li>
            <li class="nav-item" v-else>
                <!-- {{ user_id }} 님 환영합니다. -->
                <b-button v-on:click="goLogout" variant="outline-light" style="border:0px solid black">
                    <span class="material-symbols-outlined">logout</span>logout
                </b-button>
            </li>
            <li class="nav-item">
                <b-button v-on:click="goMypage" variant="outline-light" style="border:0px solid black">
                    <span class="material-symbols-outlined">person</span>
                </b-button>

            </li>

        </ul>
        
    </div>
  </b-navbar>
  <b-card 
  no-body
  style="
  height: 50px; 
  border:1px solid white;
  border-radius:0px; 
  background-color:white;
  padding-left:150px;
  padding-right:150px;
  font-family: 'Hahmlet', serif;
 "
  >
  <b-tabs v-model="tabIndex" card>
    <b-tab title="홈" v-on:click="goHome" :title-link-class="'text-dark'" ></b-tab>
    <b-tab title="장바구니" v-on:click="goWish" :title-link-class="'text-dark'"></b-tab>
    <b-tab title="레시피" v-on:click="goTheme" :title-link-class="'text-dark'"></b-tab>
    <b-tab title="상품" v-on:click="goCategory" :title-link-class="'text-dark'"></b-tab>
  </b-tabs>
  </b-card>
</div>
  
</template>
<script>


export default {
    name: 'NavbarComp',
    data(){
        return{
            tabIndex:0,
        }
    },
    created(){
        this.getUser()
        },
    methods:{
        getUser(){
            this.$store.state.dispatch('getUserById')
        },
        goHome(){
            this.$router.push('/')
        },
        goWish(){
            this.$router.push('/wish')
        },
        goTheme(){
            this.$router.push('/theme')
        },
        goCategory(){
            this.$router.push('/category')
        },
        goLogin(){
            this.$router.push('/Login')
        },
        goLogout(){
            this.$store.dispatch('logOut')
        },
        goMypage(){
            this.$router.push({ name:'Mypage', params:{ uid: this.$store.state.login_user }})
            // 추후 수정
        },
        goPurchase(){
            this.$router.push({name:'Purchase', params:{ uid:this.$store.getters.getUserSeq }})
            // this.$router.push({name:"Purchase"})

        },
        goMyDetail(){
            this.$router.push({ name: 'MypageDetail', params:{ uid:this.$store.state.login_user }})
        },
    //     linkClass(idx) {
    //     if (this.tabIndex === idx) {
    //       return ['bg-light', 'text-dark']
    //     } else {
    //       return ['bg-dark', 'text-light']
    //     }
    //   }
    },
    computed:{
       LoginTF(){
            return this.$store.state.accessToken === null ? true : false
        },
    },
    components:{
        
    }
}
</script>



<style scoped>
@font-face {
    font-family: 'NanumSquare_acB';
    src: url('/public/fonts/NanumSquare_acB.ttf');
}
@font-face {
    font-family: 'NanumSquare_acEB';
    src: url('/public/fonts/NanumSquare_acEB.ttf');
}
@font-face {
    font-family: 'NanumSquare_acL';
    src: url('/public/fonts/NanumSquare_acL.ttf');
    }
@font-face {
    font-family: 'NanumSquare_acR';
    src: url('/public/fonts/NanumSquare_acR.ttf');
}
@font-face {
    font-family: 'NanumSquareB';
    src: url('/public/fonts/NanumSquareB.ttf');
}
@font-face {
    font-family: 'NanumSquareEB';
    src: url('/public/fonts/NanumSquareEB.ttf');
}
@font-face {
    font-family: 'NanumSquareL';
    src: url('/public/fonts/NanumSquareL.ttf');
}
@font-face {
    font-family: 'NanumSquareR';
    src: url('/public/fonts/NanumSquareR.ttf');
}
@font-face {
    font-family: 'NEXONLv1GothicBold';
    src: url('/public/fonts/NEXONLv1GothicBold.ttf');
}
@font-face {
    font-family: 'NEXONLv1GothicLight';
    src: url('/public/fonts/NEXONLv1GothicLight.ttf');
}
@font-face {
    font-family: 'NEXONLv1GothicRegular';
    src: url('/public/fonts/NEXONLv1GothicRegular.ttf');
}
.navbar-nav {
    font-family: NanumSquareR;
}
.nav-item{
    border: 0px solid black;
    margin: 5px;
    border-radius: 7px;
 
}
.navbar-logo{
    border: 0px solid black;
    margin-top:0px;
    margin-right: 0px;
    border-radius: 5px;

}
.tabs{
    font-family: NanumSquare_acR;
}



</style>