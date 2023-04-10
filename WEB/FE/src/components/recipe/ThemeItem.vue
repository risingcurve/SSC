<template>
  <div class="themeitem">
    <span class="texttheme">{{ theme?.theme_name }}</span>

  </div>
</template>

<script>
export default {
    name:"ThemeItem",
    props:['theme',],

}
</script>

<style scoped>
.themeitem{
    display: flex;
    justify-content: center;
    align-items: center;
    border: 1px solid black;
    padding: 0px;
    width: 250px;
    height: 250px;
    margin: 10px;
    color: azure;
    background-color: rgb(47, 47, 47);
    opacity: 70%;
    border-radius: 50%;
    filter: drop-shadow(5px 5px 5px rgb(197,197,197));
    object-fit: contain;
}

</style>