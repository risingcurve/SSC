<template>
    <div class="productlist">
        <b-container>
            <div class="productcatetitlediv">
                <p>{{ area_name }}</p>
            </div>
            <div>
                <ProductsListItem  v-bind:products="products" />   
            </div>
            <div class="backcategorybuttondiv">
                <b-button v-on:click="goCategory" class="backcategorybutton" >카테고리 목록으로</b-button>
            </div>
        </b-container>
    </div>    
</template>
<script>
import ProductsListItem from "@/components/product/ProductListItem.vue"
import axios from 'axios';

const SERVER_URL = 'https://i8a102.p.ssafy.io/api'

export default {
    name: 'ProductsListView',
    data(){
        return{
        
            area_seq: this.$route.params.cgid,
            area_name: null,
            products:[],
        }
    },
    components:{
        ProductsListItem,        
    },
    methods:{
        getProducts(){
            axios({
                method:"get",
                url: `${SERVER_URL}/product`
            })
            .then((res) =>{
                for (let ent of res.data){
                    if (ent.area_seq === this.$route.params.cgid){
                        this.products.push(ent)
                    }
                }
                console.log(this.products)
                console.log(res.data)
            })
            .catch((err) => {
            console.log(err)
            })
        },
        goCategory(){                   
            this.$router.push('/category')
        },
        getAreaName(){
        const allarea = this.$store.state.areas

            for (let ent of allarea){
              if (ent.area_seq === this.area_seq){
                  this.area_name = ent.area_name
              }
            }
        },
    },
  
    created(){
        this.getProducts()
        this.getAreaName()
    },
}
</script>
<style scoped>
@font-face {
    font-family: 'NanumSquare_acB';
    src: url('../../../public/fonts/NanumSquare_acB.ttf');
  }
  @font-face {
    font-family: 'NanumSquare_acEB';
    src: url('../../../public/fonts/NanumSquare_acEB.ttf');
  }
  @font-face {
    font-family: 'NanumSquare_acL';
    src: url('../../../public/fonts/NanumSquare_acL.ttf');
  }
  @font-face {
    font-family: 'NanumSquare_acR';
    src: url('../../../public/fonts/NanumSquare_acR.ttf');
  }
  @font-face {
    font-family: 'NanumSquareB';
    src: url('../../../public/fonts/NanumSquareB.ttf');
  }
  @font-face {
    font-family: 'NanumSquareEB';
    src: url('../../../public/fonts/NanumSquareEB.ttf');
  }
  @font-face {
    font-family: 'NanumSquareL';
    src: url('../../../public/fonts/NanumSquareL.ttf');
  }
  @font-face {
    font-family: 'NanumSquareR';
    src: url('../../../public/fonts/NanumSquareR.ttf');
}

.productlist{
    margin-left: 150px;
    margin-right: 150px;
    font-family: 'NanumSquareR';
}
.productcatetitlediv {
    display: flex;
    justify-content: center;
    font-family: 'NanumSquare_acEB';
    font-size: 40px;
    padding: 40px;
}

.backcategorybuttondiv{
    display: flex;
    justify-content: right;
}

.backcategorybutton{
    font-family: 'NanumSquareR';
    font-size: 19px;
}
</style>