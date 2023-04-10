<template>
    <b-modal size="xl" ref="my-modal" hide-footer title="이 품목을 삭제하시겠습니까?">
        <div class="d-block text-center">
            <ItemBox :delId="delId" :delName="delName"></ItemBox>
        </div>
        <div class="btn-container" style="height:100px">
            <b-button class="mt-3" variant="outline-danger" block @click="hideModal">취소</b-button>
            <b-button class="mt-3" variant="outline-primary" block @click="hideModal">삭제</b-button>
        </div>
    </b-modal>
</template>

<script>
import ItemBox from '../ItemBox.vue'
export default {
    components:{
        ItemBox
    },
    props: [
        "show", "delId", "delName"
    ],
    methods: {
        showModal(){
            this.$refs['my-modal'].show()
            this.$emit('hide',false)
        },
        hideModal() {
            this.$refs['my-modal'].hide()
            this.$emit('hide',false)
        },
    },
    watch:{
        show(newShow){
            if(newShow === true){
                this.showModal()
            }
        }
    }
}
</script>

<style>
.btn-container{
    display: flex;
}
</style>