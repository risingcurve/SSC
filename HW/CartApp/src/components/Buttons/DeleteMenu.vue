<template>
  <div>
    <b-button variant="danger" @click="$emit('showModal',true)">X</b-button>
  </div>
</template>

<script>
export default {
  data() {
      return {
        modalShow: true
      }
    },
    props:["menuId"],

}
</script>

<style>

</style>