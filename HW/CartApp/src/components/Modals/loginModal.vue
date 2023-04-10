<template>
  <b-modal id="modal-prevent-closing" ref="login_modal" title="Sign in" @shown="focusHere" @show="resetModal" @hidden="resetModal"
    @ok="handleOk" size="xl" button-size="lg">
    <p style="text-align: center;">
      <img src="@/assets/favicon.png" alt="">
    </p>
    <form ref="ID" @submit.stop.prevent="handleSubmit">
      <b-form-group id="group-container" label="Name" label-for="inputNum" invalid-feedback="Name is required" :state="nameState" style="font-size: 30px;">
        <b-form-input id="inputNum" ref="inputId" value="" @focus="onInputFocus" @input="onInputChange" v-model="name"
          :state="nameState" required style="font-size: 30px;"></b-form-input>
      </b-form-group>
    </form>
    <form ref="PW" @submit.stop.prevent="handleSubmit">
      <b-form-group label="Password" label-for="inputPass" invalid-feedback="password is required" :state="passState" style="font-size: 30px;">
        <b-form-input id="inputPass" type="password" value="" @focus="onInputFocus" @input="onInputChange"
          v-model="password" :state="passState" required style="font-size: 30px;"></b-form-input>
      </b-form-group>
    </form>
    <!-- {{ name }}
    {{ password }} -->
   
  </b-modal>
</template>

<script>
import { api } from '@/utils/axios'
import SimpleKeyboard from "@/components/Keyboard/SimpleKeyboard.vue";
export default {
  data() {
    return {
      name: '',//입력한 id 저장되는 곳
      password: '',//입력한 pw 저장되는 곳
      nameState: null,
      passState: null,
      //state로 이동
      submittedNames: [],
      submittedPass: [],
      inputName: ""
    }
  },
  components: {
    SimpleKeyboard
  },
  props: [
    "show"
  ],
  methods: {
    showModal() {
      this.$refs['login_modal'].show()

      this.$emit('hide', false)
    },
    hideModal() {
      this.$refs['login_modal'].hide()
      this.$emit('hide', false)
    },
    checkFormValidity_ID() {
      const valid = this.$refs.ID.checkValidity()
      this.nameState = valid
      return valid
    },
    checkFormValidity_PW() {
      const valid = this.$refs.PW.checkValidity()
      this.passState = valid
      return valid
    },
    resetModal() {
      this.name = ''
      this.nameState = null
      this.password = ''
      this.passState = null
    },
    handleOk(bvModalEvent) {
      // Prevent modal from closing
      bvModalEvent.preventDefault() //둘다 비어있는거 방지
      // Trigger submit handler
      this.handleSubmit()
    },
    handleSubmit() {
      // Exit when the form isn't valid
      if (!this.checkFormValidity_ID() || !this.checkFormValidity_PW()) {
        return
      }
      // console.log(this.checkFormValidity_ID);
      // console.log(this.checkFormValidity_PW);
      // Push the name to submitted names
      this.submittedNames.push(this.name);
      this.submittedPass.push(this.password);

      console.log(this.name)
      console.log(this.password)

      this.$store.commit('SET_USER_NAME', this.name)

      // Hide the modal manually
      this.$nextTick(() => {
        this.$bvModal.hide('modal-prevent-closing')
        this.$router.push('/list')
      })
    },
    onChange(input, inputName) {
      // console.log("change", inputName, input);
      document.getElementById(inputName).value = input;
    },
    onKeyPress(button) { },
    onInputChange(input) { },
    onInputFocus(input) {
      this.inputName = input.target.id;
    },
    focusHere(){
      this.$refs.inputId.focus()
    }
  },
  watch: {
    show(newShow) {
      if (newShow === true) {
        this.showModal()
      }
    }
  }
}
</script>
<style>
#modal-prevent-closing>div{
  max-width: 90%;
    height: 80%;
}
#inputNum{
  height: 100%;
}

</style>