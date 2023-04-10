<template>
    <div class="productcard">
        <img 
        :src="image" 
        alt="img"
        style="
        filter:drop-shadow(5px 5px 5px rgb(197,197,197));
        object-fit:contain">
        <p style="
        padding-top:15px; 
        padding-bottom:0px; 
        font-weight:bold;">
        <!-- {{ product?.product_name }} -->
        {{ product?.product_info }}
        </p>
        <div style="
        display:flex; 
        justify-content:space-between; 
        padding:0px; margin:0px;
        border:0px solid black;">
            <p><b>{{ product?.price }}원</b></p>
            <b-button variant="outline-primary" style="border: 0px solid white;">
                <b-icon icon="cart3"></b-icon>
            </b-button>
        </div>
            <b-form-rating 
            id="rating-lg-no-border" 
            v-model="value" 
            style="
            padding:3px;
            margin:0px;
            width:30px;" 
            variant="warning" 
            no-border size="md"></b-form-rating>

        
    <!-- <b-card
    v-bind:title="product?.title"
    img-src="https://picsum.photos/600/300/?image=25"
    img-alt="Image"
    img-top
    tag="article"
    style="max-width: 20rem; border-radius:0px"
    class="mb-2"
  >
        <b-card-text>
            test {{ product?.detail }}
        </b-card-text>
        <b-button v-bind:href="product?.product_seq" variant="primary">Go Detail</b-button>
    </b-card> -->
        
    </div>
</template>

<script>
// import axios from '@/service/axios';

// const SERVER_URL = 'https://i8a102.p.ssafy.io/api'

export default {
    props:{
        product: Object,
    },
    data() {
        return {
            value:5,
            image:`https://i8a102.p.ssafy.io/api/image/product/${this.product.product_seq}`,
    
        };
    },
    created(){
      
    },
    computed:{
    
        // imageUrl(){
        //     return this.product.imageInfos[0].save_folder+`/`+this.product.imageInfos[0].save_name
        // }
        
    },
    methods: {
            
    },
};
</script>

<style scoped>
  @font-face {
    font-family: 'NanumSquareR';
    src: url('../../../public/fonts/NanumSquareR.ttf');
  }
.productcard{
    display: flex;
    flex-direction: column;
    justify-content: center;
    border: 0px solid black;
    padding: 0px;
    width: 250px;
    height: 400px;
    margin: 30px;
    font-family: 'NanumSquareR';
}
.productcard:hover{
    transform: scale(1.1);
    
}

</style>