<template>
    <div id="app">
        <div id="title-size">
            <BackMain id="back-button"></BackMain>
            <h1 id="title-name">Parking</h1>
        </div>
        <div id="parking-box">
            <div id="parking-img-box">
                <img src="@/assets/park.png" alt="" height="90%" width="90%" style="margin:2%">
            </div>
            <div id="parking-pay">
                <div style="width:50%; height: 100%;">
                    주차요금
                </div>
                <b-button style="width:50%;height: 100%;">결제하기</b-button>
            </div>
        </div>
    </div>
</template>

<script>
import BackMain from '@/components/Buttons/BackMain.vue'
export default {
    components: { BackMain },

}
</script>

<style>
#parking-box{
    display: flex;
    justify-content: space-around;
    flex-direction: column;
    height: 86%;
}
#parking-pay{
    display: flex;
    justify-content: space-around;
    height: 10%;
}
#parking-img-box{
    height: 80%;
    width: 100%;
}
</style>