<template>
  <div>
    <p style="color:white">{{ year }}</p>
    <p style="font-size:20px;color:white" >{{ now }}</p>
  </div>
</template>

<script>
export default {
    data(){
        return{
            year:"",
            now:""
        }
    },
    mounted(){
        this.showClock();
    },
    methods:{
        showClock(){
            const date = new Date()

            this.year = `${date.getFullYear()}:${date.getMonth()}:${date.getDay()}`
            this.now = `${date.getHours()}:${date.getMinutes()}:${date.getSeconds()}`
            setTimeout(() => {
               this.showClock() 
            }, 1000);
        }
    }
}
</script>

<style>

</style>