<template>
  <div class="wish">
    <b-container>
      <div class="wishcreatetitlediv">
        <h1>장바구니 만들기</h1>
      </div>
      <form v-on:submit.prevent="WishCreate">
        <label for="title">장바구니 이름</label>
        <b-form-input v-model="title"></b-form-input>
        <br>
        <label for="">장바구니에 상품을 담아보세요</label>
        <b-form-tags 
        input-id = "tags-pills" 
        v-model="tags"
        tag-variant="primary"
        tag-pills
        isDuplicate=true
        separator=" "
        placeholder="장바구니에 상품을 담아보세요"
        remove-on-delete
        no-add-on-enter>
        </b-form-tags>

        <b-button type="submit" variant="success" v-on:click="postWish">
          완료
        </b-button>
        <p>상품분류</p>
        <b-form-select v-model="selected">
          <template #first>
          <b-form-select-option :value="null">
            전체
          </b-form-select-option>
          </template>
          <b-form-select-option 
          v-for="area in areas" 
          v-bind:key="area.area_seq" 
          :value="area.area_seq">
          {{ area.area_name }}
        </b-form-select-option>
        </b-form-select>
        <p>상품선택</p>
        <WishProductListItem v-on:makewish="makewish" :name = "name" v-bind:products="products"/>
      </form>
      <br>
      <br>
      <div class="createbuttondiv">
        <b-button type="submit" variant="success" v-on:click="postWish" class="createbutton">
          장바구니 담기
        </b-button>
      </div>
      <br>
      <br>
    </b-container>
    </div>
</template>
  
<script>
import axios from 'axios'
import WishProductListItem from '@/components/wish/WishProductListItem.vue';

  
const SERVER_URL = 'https://i8a102.p.ssafy.io/api'
  
  export default {
  components: { WishProductListItem },
    name: "WishCreateView",
  
    data() {
      return {
        tags:[],
        list:[],
        selected:null,
        name:null,
        title: null,
        image: null,
      };
    },
    methods: {
      postWish() {
        const title = this.title;
        if (!title) {
          alert("내용을 입력해 주세요.");
          return;
        }
  
        axios({
          method: "post",
          url: `${SERVER_URL}/cartlist`,
          data: {
            cart_name:this.title,
            user_seq:this.$store.state.user.user_seq,
            products:this.list,
          },
        })
          .then((res) => {
            console.log(res.data)
            this.$router.push({name: 'Wish'})
          })
          .catch((err) => {
            console.log(err);
          })
  
      },
      getProducts(){
        this.$store.dispatch('getProducts')
      },
      getAreas(){
        this.$store.dispatch('getAreas')
      },
      makewish(name){
        this.name = name.name
        this.list.push({"product_seq":name.seq, "cnt":1})
        this.tags.push(this.name)
      },
      

    },
    created(){
      this.getProducts()
      this.getAreas()
      this.$store.dispatch('getUserById')
    },
    computed:{
      products(){
        const all = this.$store.state.products
        const selectedproducts = []
        if (this.selected !== null){
          for (let ent of all){
            if (ent.area_seq===this.selected){
              selectedproducts.push(ent)
            }
          }
          return selectedproducts
        } else {
          return all
        }
      },
      areas(){
        return this.$store.state.areas
      },
    },
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
  .wish{
    margin-top:30px ;
    margin-left:150px ;
    margin-right:150px ;
    font-family: 'NanumSquareR';

  }
  
  .wishcreatetitlediv{
    display: flex;
    justify-content: center;
    font-family: 'NanumSquare_acEB';
    padding: 40px;
  }

  .createbuttondiv {
    display: flex;
    justify-content: right;
  }
  </style>