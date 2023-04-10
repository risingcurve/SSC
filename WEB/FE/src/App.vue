<template>
  <div id="app">
    <Navbar/>
    <router-view />
  </div>
</template>

<script>
import Navbar from '@/NavbarComp'

export default {
  name: 'App',
  data() {
    return {

    }
  },
  components: {
    Navbar
  },
  computed: {

  },
  methods: {
  },
  created() {
    // let token = this.$store.getters.getToken;
    // if (token.access === null && token.refresh === null){
    //   this.$router.push({name:'Login'}).catch(()=>{});
    // }
  },
}

</script>

<style>


</style>
