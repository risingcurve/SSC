<template>
  <div id="app">
    <Transition name="fade">
      <router-view></router-view>
    </Transition>
  </div>
</template>

<script>
export default {
  methods:{
    getmypos() {
      // making bridge setting
      let bridge = new WebOSServiceBridge();
      let url = 'luna://com.sscart.app.service/mypos';
      let params = '{}';
      //call back func (if get scanned rssi data, it works)
      bridge.url = url;
      bridge.onservicecallback = this.callback2;
      setInterval(() => {
        bridge.call(url, params);
      }, 500);
    },
    callback2(msg) {
      let myx = JSON.parse(msg).x;
      let myy = JSON.parse(msg).y;
      this.$store.commit('SET_POS', {
        x: myx,
        y: myy
      })
    }
  },
  mounted() {
    this.getmypos();
  }
}
</script>

<style scoped>
#app{
  text-align: center;
  height: 100vh;
  width: 100vw;
}
.fade-enter-active, .fade-leave-active {
  transition: opacity .3s;
}

.fade-enter, .fade-leave-to {
  opacity: 0;
}


</style>