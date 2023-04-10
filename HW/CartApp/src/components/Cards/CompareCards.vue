<template>
  <b-card
    :title=item.product_name
    :img-src=imgUrl
    img-alt="Image"
    img-left
    tag="article"
    img-height="100%"
    img-width="30%"
    class="mb-2"
  >
  {{ item.price }}원
  </b-card>
</template>

<script>
import { api } from '@/utils/axios'
export default {
  data(){
    return{
      imgUrl:`https://i8a102.p.ssafy.io/api/image/product/${this.item.product_seq}`
    }
  },
  props:["item"],
  async created(){
    console.log(this.item)
  }
}
</script>

<style>

</style>