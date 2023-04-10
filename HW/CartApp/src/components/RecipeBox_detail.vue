<template>
  <div @click="gotorecipe(list)" style="height: 80%;">
    <img :src=imgUrl alt="" width="90%" height="60%">
  </div>
</template>

<script>
export default {
    // 별점넣는 부분 나중에 db로 받을 때 배열로 받아서 넣어야함 https://bootstrap-vue.org/docs/components/form-rating
    data() {
      return {
        imgUrl:`https://i8a102.p.ssafy.io/api/image/recipe/${this.rseq}`
      }
    },
    props:["rseq"],
    methods:{
        gotoDetail2(data){
            this.$router.push(`/recipe/list/${data}`)
        },
        gotorecipe(data){
      this.$store.commit('SET_RECIPE_SEQ',data.recipe_seq)
      this.$router.push(`/recipe/list/${data.recipe_name}`)
    }
    }
}
</script>

<style>

</style>