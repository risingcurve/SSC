<template>
      <b-button variant="danger" @click="gotoMain">GoBack</b-button>
  </template>
  
  <script>
  export default {
      methods:{
      gotoMain(){
        this.$router.push('/main')
      }
    },
  }
  </script>
  
  <style>
  
  </style>