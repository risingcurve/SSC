<template>
    <b-button @click="gotoCart">Cart</b-button>
</template>

<script>
export default {
    methods:{
        gotoCart(){
            this.$router.push('/shopcart')
        }
    }

}
</script>

<style>

</style>