<template>
  <div class="Main_vue_box1">
    <div class="Main_vue_box2">
      <div class="Main_vue_AD1">
        <AD></AD>
      </div>
      <div class="Main_vue_parking" @click="gopark()">
        <p style="font-size:50px;color:black"></p>
      </div>
      <div class="Main_vue_user">
        <div class="Main_vue_info" @click="showB">
          <p style="font-size:30px;color:white;height: fit-content;margin: auto;">물건 담기</p>
        </div>
        <div class="Main_vue_logout" @click="logout">
          <p style="font-size:30px;color:white;height: fit-content;margin: auto;">Log Out</p>
        </div>
        <div class="Main_vue_list" @click="gotoList">
          <p style="font-size:30px;color:white;height: fit-content;margin: auto;">장바구니 선택</p>

        </div>
      </div>
    </div>
    <div class="Main_vue_box3">
      <div class="Main_vue_kita">
        <div class="Main_vue_man">
          <img :src="userImg" alt="" style="height: 100%;width: 100%;">
        </div>
        <div class="Main_vue_clock">
          <Clock></Clock>
        </div>
      </div>
      <div class="Main_vue_shopping" @click="gotoMap">
        <p></p>
      </div>
      <div class="Main_vue_jang" @click="gotoListdetail">
        <p style="position:absolute;left:9%;top:9%; font-size:30px;color:white">장바구니</p>
      </div>
    </div>
    <OpenBarcodeModal :showBarcode="showBarcode" @hideB="showBarcode = false" @showitem="show = true"></OpenBarcodeModal>
    <BarcodeModal :show="show" @hide="show = false"></BarcodeModal>
</div>
</template>

<script>


import Clock from '@/components/Clock.vue'
import BarcodeModal from '@/components/Modals/BarcodeModal.vue'
import BarcodeInput from '@/components/BarcodeInput.vue'
import AD from '@/components/AD.vue'
import OpenBarcodeModal from '@/components/Modals/OpenBarcodeModal.vue'
export default {
  data() {
    return {
      show: false,
      showBarcode: false,
      userImg:`http://i8a102.p.ssafy.io/api/image/user/${this.$store.state.loginUser.user_seq}`
    }
  },
  components: { Clock, BarcodeInput, AD, BarcodeModal, OpenBarcodeModal },
  methods: {
    gopark() {
      this.$router.push("/park")
    },
    gotoMap() {
      this.$router.push("/map")
    },
    gotoList() {
      this.$router.push('/list')
    },
    gotoListdetail() {
      this.$router.push(`/list/compare/${this.$store.state.list}`)
    },
    logout() {
      this.$router.push('/')
    },
    gotocart() {
      this.$router.push('/shopcart')
    },
    showThis() {
      this.show = true
    },
    showB() {
      this.showBarcode = true
    }

  }
}
</script>

<style scoped>
.Main_vue_box1 {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-content: center;
  height: 100%;
}

.Main_vue_box2 {
  border-top: 5px solid #5482ad;
  border-left: 5px solid #5482ad;
  border-right: 5px solid #5482ad;
  height: 50%;
  display: flex;
}

.Main_vue_AD1 {
  width: 40%;
  border: 5px solid #5482ad;

}

.Main_vue_parking {
  flex-grow: 3;
  border: 5px solid #5482ad;
  background-image: url('@/assets/carr.png');
  background-size: cover;
  justify-content: center;
  align-content: center;
}

.Main_vue_user {
  flex-grow: 1;
  border: 5px solid #5482ad;

}

.Main_vue_box3 {
  border-right: 5px solid #5482ad;
  border-left: 5px solid #5482ad;
  border-bottom: 5px solid #5482ad;
  display: flex;
  height: 50%;

}

.Main_vue_kita {
  width: 20%;
  height: 100%;
  border: 5px solid #5482ad;

}

.Main_vue_shopping {
  border: 5px solid #5482ad;
  width: 50%;
  background-image: url('@/assets/shopping2.jpg');
  background-size: cover;
  position: relative;
}

.Main_vue_jang {
  position: relative;
  width: 30%;
  border: 5px solid #5482ad;
  background-image: url('@/assets/shopbag.jpg');
  display: flex;
  justify-content: center;
  align-items: center;
}

.Main_vue_info {
  height: 34%;
  border-bottom: 10px solid #5482ad;
  background-color: gray;
  display: flex;
  justify-content: center;
  align-items: center;
}

.Main_vue_logout {
  height: 34%;
  background-color: black;
  border-bottom: 10px solid #5482ad;
  display: flex;
  justify-content: center;
  align-items: center;
}

.Main_vue_list {
  height: 34%;
  background-color: rgb(216, 99, 99);
  border-bottom: 10px solid #5482ad;
  display: flex;
  justify-content: center;
  align-items: center;
}

.Main_vue_man {
  height: 80%;
  border-bottom: 10px solid #5482ad;
  background-size: cover;
}

.Main_vue_clock {
  height: 20%;
  background-color: #5482ad;
}


</style>