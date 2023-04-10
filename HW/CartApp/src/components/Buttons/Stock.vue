<template>
  <div class="stock_container">
    <button @click="down">-</button>
    <button>{{ this.num }}</button>
    <button @click="up">+</button>
  </div>
</template>

<script>
export default {
    data(){ 
        return{
            num:1
        }
    },
    methods:{
        down(){
            if(this.num!=1){
            this.num-=1
            }
            this.$store.state.barcodeItem.stock=this.num

        },
        up(){
            this.num+=1
            this.$store.state.barcodeItem.stock=this.num

        }
    },
    mounted(){
        this.$store.state.barcodeItem.stock=this.num
    }
}
</script>

<style>
.stock_cotainer{
    display: flex;
}
</style>