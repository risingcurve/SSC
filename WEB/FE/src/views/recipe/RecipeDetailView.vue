<template>
  <div>
  <b-container class="recipedetailcon">
    <b-row class="recipedetialtitlerow">
      <h1>{{ recipe_name }}</h1>
    </b-row>
    <b-row class="recipeimagerow">
      <img :src="`https://i8a102.p.ssafy.io/api/image/recipe/${recipe_id}`" alt="img" class="recipeimage">
    </b-row>
    <br>
    <b-row class="recipetitlerow">
      <p class="recipetitle">레시피</p>
    </b-row>
    <b-row class="contentrow">
      <p>{{ explanation }}</p>
    </b-row>
    <br>
    <br>
    
    <b-row class="ingredienttitlerow">
      <p class="ingredienttitle">재료</p>
    </b-row>        
    <b-row class="ingredientboxrow" style="display:flex; justify-content:space-between;">
      <!-- <span v-for="ent in product" v-bind:key="ent.id"> -->
        <b-form-tags 
        input-id = "tags-pills" 
        v-model="tags"        
        tag-pills
        isDuplicate=true
        separator=" "
        placeholder="장바구니에 상품을 담아보세요"
        remove-on-delete
        no-add-on-enter>
      </b-form-tags>
      <b-button v-on:click="postWish" style="margin-left:auto;"><b-icon icon="cart3"></b-icon></b-button>
    </b-row>
    <!-- <p> {{ ent.name }}</p> -->
    <!-- </span> -->
    <br>
    <br>
    
    <b-row class="commenttitlerow">
      <p>댓글</p>
    </b-row>
    <b-row class="commentlistrow">
      <CommentList v-bind:comments="comments"/>
    </b-row>
    <br>
    <b-row class="commentcreaterow">
      <CommentCreate v-bind:recipe_id="recipe_id"/>
    </b-row>

    <div class="commentdiv">
    </div>
  </b-container>
  </div>
</template>

<script>
import axios from "axios";

import CommentCreate from '@/components/recipe/CommentCreate.vue'
import CommentList from '@/components/recipe/CommentList.vue'

const SERVER_URL = 'https://i8a102.p.ssafy.io/api'


export default {
    name:"RecipeDetailView",
    components:{
      CommentCreate,
      CommentList,
    },
    data() {
      return {
        recipe_id:null, 
        recipe_name: null,
        explanation: null,
        comments:null,
        ingredient:null,
        product:[],
        tags:[],
        tags_id:[],
        all:null,
      }
    },
    computed:{

    },
    methods:{
      getRecipeDetail() {
        axios({
          method:"get",
          url: `${SERVER_URL}/recipe/${this.$route.params.rid}`
        })
          .then((res)=>{
            this.recipe_id = res.data.recipe_seq
            this.recipe_name = res.data.recipe_name;
            this.explanation = res.data.detail;
            this.ingredient = res.data.products
            this.$store.dispatch("getProducts")
            this.changeValue()
          })
          .catch((err) => {
            console.log(err);
          })
      },
      changeValue(){
        const all = this.$store.state.products
        for (let ent of all){
          for (let inent of this.ingredient){
            if (ent.product_seq === inent.product_seq){
              this.product.push({"name":ent.product_name, "product_seq":ent.product_seq} )
              this.tags.push(ent.product_name)
            }
          }
        }
      },
      postWish() {
        const user = this.$store.state.user
        if (user == undefined || user==""){
          alert("SSC의 다양한 서비스를 이용하고 싶으시다면 로그인을 해주세요!")
        } else {
          this.check()
          axios({
            method: "post",
            url: `${SERVER_URL}/cartlist`,
            data: {
              cart_name:`[레시피 장바구니]${this.recipe_name} `,
              user_seq:user.user_seq,
              products:this.tags_id,
            },
        })
          .then((res) => {
            console.log(res.data)
            this.$router.push({name: 'Wish'})
          })
          .catch((err) => {
            
            console.log(err);
          })
        }
      },
      check(){
        for (let tent of this.tags){
          for (let pent of this.product){
            if (tent === pent.name){
              this.tags_id.push({"product_seq":pent.product_seq, "cnt":1})
            }
          }
        }
      },
      createComment(){
        this.$router.push({ name: 'CommentCreate'})
      },
      getCommentList(){
        axios({
          method:"get",
          url: `${SERVER_URL}/recipecomment/recipeseq/${this.$route.params.rid}`
        })
          .then((res)=>{
            this.comments = res.data;
            console.log(res)
          })
          .catch((err) => {
            console.log(err);
          })
      },
      },
      props:[
        'recipe'
      ],
      created(){
        this.getRecipeDetail()
        this.getCommentList()
        this.$store.dispatch("getUserById")
      }


}
</script>

<style scoped>
@font-face {
  font-family: 'nanumsquare_acEB';
  src: url('../../../public/fonts/NanumSquare_acEB.ttf');
}
@font-face {
  font-family: 'NanumSquare_acB';
  src: url('../../../public/fonts/NanumSquare_acB.ttf');
}
@font-face {
  font-family: 'nanumsquareL';
  src: url('../../../public/fonts/NanumSquareL.ttf');
}

@font-face {
  font-family: 'nanumsquareR';
  src: url('../../../public/fonts/NanumSquareR.ttf');
}
@font-face {
  font-family: 'nanumsquareEB';
  src: url('../../../public/fonts/NanumSquareR.ttf');
}

.recipedetailcon {
  font-family: 'nanumsquareR';
}
.recipedetialtitlerow {
  display: flex;
  justify-content: center;
  font-family: 'NanumSquareL';
  padding: 40px;
}

.recipeimagerow{
  display: flex;
  justify-content: center;
  max-width: 1000px;
}

.recipeimage{
  display: flex;
  justify-content: center;
  text-align: center;
  margin-left: 130px;
  width: 1000px;
}
.recipetitlerow{
  margin-left: 50px;
  margin-right: 50px;
}
.recipetitle {
  font-family: 'nanumsquareEB';
  font-size: 24px;
}

.ingredienttitle{
}

.ingredienttitlerow{
  margin-left: 50px;
  margin-right: 50px;
  font-family: 'nanumsquareEB';
  font-size: 24px;
}

.ingredientboxrow{
  margin-left: 50px;
  margin-right: 50px;
  
}
.contentrow {
  margin-left: 50px;
  margin-right: 50px;
  font-size: 19px;
}
.ingredientrow {
  margin-left: 50px;
  margin-right: 50px;
  font-size: 19px;
}
.commenttitlerow {
  margin-left: 50px;
  margin-right: 50px;
  font-family: 'nanumsquareEB';
  font-size: 24px;
  
}

.commentlistrow{
  margin-left: 50px;
  margin-right: 50px;
}

.commentcreaterow{
  margin-left: 50px;
  margin-right: 50px;
}
</style>