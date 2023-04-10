<template>
    <b-button variant="primary" @click="gotoCart">Bill</b-button>
</template>

<script>
export default {
    methods:{
        gotoCart(){
            this.$router.push('/bill')
        }
    }

}
</script>

<style>

</style>