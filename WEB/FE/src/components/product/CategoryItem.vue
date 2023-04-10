<template>
  <div class="category">
    <!-- <img src="https://picsum.photos/250/250/?image=25" alt="카테고리 이미지" class="cateimage">   -->
    <span class="textcate">{{ area?.area_name }}</span>
  </div>
</template>

<script>
export default {
  name:"CategoryItem",
  data(){
    return{

    }
  },
  props:['area',]

}
</script>

<style scoped>
.category{
    display: flex;
    justify-content: center;
    align-items: center;
    border: 0px solid black;
    padding: 0px;
    width: 250px;
    height: 250px;
    margin: 10px;
    /* background-image: url("https://picsum.photos/250/250/?image=25"); */
    filter: drop-shadow(5px 5px 5px rgb(197,197,197));
    object-fit: contain;
}
/* .category .textcate{
  visibility: hidden;
} */
.category .textcate:hover{
  visibility: visible;
}
/* .category:hover{
  opacity: 0.5;
    
} */
</style>