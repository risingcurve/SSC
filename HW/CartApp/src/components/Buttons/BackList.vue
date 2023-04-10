<template>
  <div>
    <b-button variant="danger" @click="gotoList" id="back-button">GoBack</b-button>
  </div>
</template>

<script>
export default {
    methods:{
    gotoList(){
      this.$router.push('/list')
    }
  },
}
</script>

<style>

</style>