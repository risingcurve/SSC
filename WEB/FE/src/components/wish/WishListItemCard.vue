<template>
    <div class="wishcarddiv">
            <b-col cols="2">
                <img :src="`https://i8a102.p.ssafy.io/api/image/product/${wish.products[0].product_seq}`"  
                style="
                border-radius:10px;"
                alt="상품 이미지" 
                class="wishproductimage">
            </b-col>
            <b-col cols="8">
                <b-row class="wishdetailtitle">
                    <b-card-text>
                        {{ wish.cart_name }}
                    </b-card-text>
                </b-row>
                <b-row class="wishdetailproduct">
                    <b-card-text>
                        {{ wish.products.product_seq }}
                    </b-card-text>
                </b-row>
            </b-col>
            <!-- <b-col cols="2">
                <b-button class="wishdetailbutton" pill variant="" v-on:click="goWishDetail">
                    상세 정보
                </b-button>
            </b-col> -->
        </div>

        <!-- <p>{{ wish.title }}</p> -->
        <!-- <p>{{ wish.detail }}</p> -->

</template>

<script>
export default {
    props:[
      'wish',  
    ],
    data() {
        return {
            
        };
    },
    computed() {
        
    },
    methods: {
        goWishDetail(){
        this.$router.push('/wish/:id')
    },
        
    },
};
</script>

<style scoped>
.wishcarddiv{
    display: flex;
    width: auto;
    height: 150px;
    width: 100%;
    text-align: center;
    align-items: center;
    border: 1px solid gray;
    border-radius: 2px;
    border-radius: 10px;
    margin : 5px;
    /* filter: drop-shadow(5px 5px 5px rgb(197,197,197)); */
    box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
    
}
.wishproductimage {
    width: 100px;
    height: 100px;
}

.wishdetailtitle {
    font-size: 25px;
    text-align: left;
    align-items: center;
    filter: none;
    text-decoration: none;
    color: black;
}

.wishdetailproduct {
    text-align: left;
    font-family: 'NanumSquareR';
    
}
.wishdetailbutton {
    filter: none;
}
</style>