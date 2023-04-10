<template>
  <b-list-group-item id="name-box">
    <div id="menu-name">
      {{ $store.state.carts[Cartnum].stock }}개
    </div> 
    <div id="menu-name">
      {{ this.$store.state.carts[Cartnum].title }}
    </div>
    <div id="menu-name">
      {{ this.$store.state.carts[Cartnum].price }}원
    </div>

  </b-list-group-item>
</template>

<script>
export default {
  props:["Cartnum"]
}
</script>

<style>

</style>