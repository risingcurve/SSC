<template>
  <b-modal id="modal-id" ref="barcode-modal" hide-footer hide-title body-class="">
    <div id="modal-inner-container">
      <div class="d-block text-center">
        <AddItem :addId="$store.state.barcodeItem.product_seq" :addName="$store.state.full_name"></AddItem>
        <div class="btn-container">
          <b-button class="mt-3" variant="outline-danger" block @click="putCart">카트에 담기</b-button>
          <b-button class="mt-3" variant="outline-danger" block @click="gotoRecipe">레시피 보기</b-button>
        </div>
      </div>
      <div id="comp-item-container">
        <p style="font-size: 30px;">함께 비교하기 좋은 상품</p>
        <CompareItem></CompareItem>
      </div>
    </div>
  </b-modal>
</template>

<script>
import AddItem from '@/components/Boxes/AddItem.vue'
import CompareItem from '../Boxes/CompareItem.vue'
export default {
  data(){
    return{
      compare:[]
    }
  },
  components: {
    AddItem,
    CompareItem
  },
  props: ["show"],
  methods: {
    showModal() {
      this.$refs['barcode-modal'].show()
      this.$emit('hide', false)
    },
    hideModal() {
      this.$refs['barcode-modal'].hide()
      this.$emit('hide', false)
    },
    gotoRecipe(){
      this.$router.push('/recipe')
    },
    putCart(){
      var flag=1
      var index = this.$store.state.carts.length
      // console.log(index)
      // console.log(flag)
      for(let i=0;i<index;i++){
        if(this.$store.state.barcodeItem.product_seq==this.$store.state.carts[i].id){
          this.$store.state.carts[i].stock+=this.$store.state.barcodeItem.stock
          this.$store.state.carts[i].price+=(this.$store.state.barcodeItem.price)*(this.$store.state.barcodeItem.stock)
          flag=2
        }
      }
      if(flag==1){
      this.$store.commit('ADD_ITEM',{
        
        id:this.$store.state.barcodeItem.product_seq,
        title:this.$store.state.barcodeItem.product_name,
        price:this.$store.state.barcodeItem.price*this.$store.state.barcodeItem.stock,
        stock:this.$store.state.barcodeItem.stock,
        img:`${this.$store.state.barcodeItem.imageInfos[0].save_folder}/${this.$store.state.barcodeItem.imageInfos[0].save_name}`
      })}
      this.$store.commit('ADD_PRICE',this.$store.state.barcodeItem.price*this.$store.state.barcodeItem.stock)
      this.$store.commit('ADD_STOCK',this.$store.state.barcodeItem.stock)
      // console.log(this.$store.state.carts[0])
      this.$store.state.barcodeItem.stock=1
      this.hideModal()
      if(this.$route.path !== '/shopcart')
        this.$router.push('/shopcart')
    }
  },
  async created(){

  },
  watch: {
    show(isShow) {
      if (isShow === true) {
        this.showModal()
      }
    }
  }
}
</script>

<style scoped>

#modal-inner-container{
  display: flex;
  height: 93%;
}
#comp-item-container{
  height: 100%;
  width: 50%;
}
.btn-container{
  height: 10%;
}
.btn-container>button{
  height: 100%;
}
.text-center{
  height: 100%;
  width: 50%;
}
.modal-header{
  height: 0px;
}
.modal-body{
  max-height: 100%;

}

</style>