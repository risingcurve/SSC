<template>
  <div>
    <img :src=urls[delId].url alt="img" style="height: 350px; ">
    <p>{{ delId }}</p>
    <p>{{ delName }}</p>
  </div>
</template>

<script>
import {api} from '../utils/axios'
export default {
  data(){
    return{
      urls:[]
    }
  },
  props:[
    "delId", "delName"
  ],
  async created(){
    var image = await api.jsonplaceholder.findImg()
    this.urls = image.data
  }
}
</script>

<style>

</style>