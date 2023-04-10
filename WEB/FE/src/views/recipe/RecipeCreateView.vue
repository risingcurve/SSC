<template>
	<div class="recipecreatediv">
		<b-container>
		<div class="recipecreatetitle">
			<h1>레시피 작성</h1>
		</div>
		
		<!-- <b-form v-on:submit="onSubmit" v-on:reset="onReset" v-if="show"> -->
		<b-form>
			<b-form-group
			id="recipe-name"
			label="레시피 이름:"
			label-for="recipe-name-input"
		>
			<b-form-input
				id="recipe-name-input"
				v-model="recipeTitleInput"
				type="text"
				placeholder="레시피 이름을 입력하세요."
				required
			></b-form-input>
		</b-form-group>
		<br>
		<b-form-group id="recipe-content" label="레시피 내용:" label-for="recipe-content-input">
			<b-form-textarea
				id="recipe-content-input"
				type="text"
				v-model="recipeContentInput"
				placeholder="내용을 입력하세요."
				rows="20"
				required
				></b-form-textarea>
			</b-form-group>
			<br>
			
			<b-form-tags 
        input-id = "tags-pills" 
        v-model="tags"
        tag-variant="primary"
        tag-pills
        isDuplicate=true
        separator=" "
        placeholder="재료를 담아보세요"
        remove-on-delete
        no-add-on-enter>
        </b-form-tags>
		<b-form-select >
          <template #first>
          </template>
          <b-form-select-option 
          v-for="product in products" 
          v-bind:key="product.product_seq" 
          :value="product.product_seq">
          {{ product.product_name }}
        </b-form-select-option>
        </b-form-select>
		<b-button v-on:click="pushProduct">+추가</b-button>
			<!-- <b-form-group id="recipe-food" label="재료:" label-for="Food-input">
				<b-form-select
				id="Food-input"
				v-model="form.food"
				:options="foods"
				required
				></b-form-select>
			</b-form-group> -->

			<br>
			<input type="file" ref="fileinput" accept="image/*"/>
			<br>
			<br>
			
			<!-- <b-form-group id="input-group-4" v-slot="{ ariaDescribedby }">
				<b-form-checkbox-group
				v-model="form.checked"
				id="checkboxes-4"
				:aria-describedby="ariaDescribedby"
				>
					<b-form-checkbox value="me">Check me out</b-form-checkbox>
					<b-form-checkbox value="that">Check that out</b-form-checkbox>
				</b-form-checkbox-group>
		</b-form-group> -->
		
		<b-button variant="primary" v-on:click="postRecipe">작성</b-button>
		<!-- <b-button type="reset" variant="danger">Reset</b-button> -->
		</b-form>
		<!-- <b-card class="mt-3" header="Form Data Result">
			<pre class="m-0">{{ form }}</pre>
		</b-card> -->
	</b-container>
	</div>



  <!-- <div>
    <h1>RecipeCreate</h1>
    <form v-on:submit.prevent="recipeCreate">
      <label for="title">제목 : </label>
      <input type="text" id="title" v-model="title" /><br/>
      <label for="content">내용 : </label>
      <textarea id="content" v-model="content"></textarea>
      <br/>
      <input type="submit" id="submit" />
    </form>
  </div> -->
</template>

<script>
import axios from 'axios'

const SERVER_URL = 'https://i8a102.p.ssafy.io/api'

export default {
    data() {
      return {
		recipeTitleInput:"",
		recipeContentInput:"",
		theme_seq:this.theme_id,
		user:this.$store.state.user,
		file:null,
		value:null,
		products:this.$store.state.products,
		input_product:[],
		tags:[],
        form: {
          email: '',
          name: '',
          food: null,
          checked: []
        },
				// 수정 예정
        foods: [{ text: '필요한 재료를 선택하세요.', value: null }, '당근', '닭', '당면', '간장'],
        show: true
      }
    },
	props:[
		'theme_id'
	],
    methods: {
    //   onSubmit(event) {
    //     event.preventDefault()
    //     alert(JSON.stringify(this.form))
	// 		axios({
	// 		method: "post",
	// 		url: `${SERVER_URL}/recipe`,
	// 		data: {
	// 			recipe_name: this.recipeTitleInput,
	// 			detail: this.recipeContentInput,
	// 		},
	// 		headers: {
	// 			// Authorization: `Token ${ this.$store.state.token }`
	// 		},
	// 	})
	// 	.then((res)=>{
	// 		console.log(res)
	// 		// this.$router.push({ name:'RecipeDetail', params:{ rid:`${}` }})
	// 	})
	// 	.catch((err)=>{
	// 		console.log(err)
	// 	})
    // },
	postRecipe(){
		// const file = this.$refs.fileinput;
		const user = this.user
		const formData = new FormData();
		// formData.append('upfile', file);
		console.log(this.theme_seq)
		console.log(user.user_seq)
		formData.append('recipe_name', this.recipeTitleInput)
		formData.append('detail', this.recipeContentInput)
		formData.append('user_seq', user.user_seq)
		formData.append('theme_seq', this.theme_seq)
		axios({
			method:"post",
			url:`${SERVER_URL}/recipe`,
			data:formData,
			headers:{
				'Content-Type':'multipart/form-data',
			}
			// data:{
			// 	recipe_name:this.recipeTitleInput,
			// 	detail:this.recipeContentInput,
			// 	user_seq:this.user_seq,
			// 	theme_seq:this.theme_id,
			// 	products:this.input_product,
			// }
		})
		.then((res)=>{
			console.log(res.data)
			this.$router.push('/home')
		})
		.catch((err)=>{
			console.log(err)
		})
	},
	getProduct(){
		this.$store.dispatch('getProducts')
	},
	getUser(){
		this.$store.dispatch("getUserById")
	},
	pushProduct(){
		this.input_product.push({"product_seq":this.value, "cnt":1})
		for (let ent of this.products){
			if (ent.product_seq===this.value){
				this.tags.push(`${ent.product_name}`)
				
			}
		}
	}
      // onReset(event) {
      //   event.preventDefault()
      //   // Reset our form values
      //   this.form.email = ''
      //   this.form.name = ''
      //   this.form.food = null
      //   this.form.checked = []
      //   // Trick to reset/clear native browser form validation state
      //   this.show = false
      //   this.$nextTick(() => {
      //     this.show = true
      //   })
      // }
    },
	created(){
		this.getUser()
		this.getProduct()
	}
  }


// export default {
//     name: "RecipeCreateView",

//     data() {
//         return {
//             title: null,
//             content: null,
// 			image: null,
//         }
//     },
// 	methods: {
//     recipeCreate() {
// 			if (!this.recipeTitleInput){
//                 alert('제목을 입력해주세요.')
//             } else if (!this.recipeDetailInput) {
//                 alert('내용을 입력해주세요.')
//             }
// 		axios({
// 			method: "post",
// 			url: `${SERVER_URL}/recipe/create`,
// 			// url: `${SERVER_URL}/recipecreate`,
// 			data: {
// 				title: this.recipeTitleInput,
// 				content: this.recipeContentInput,
// 			},
// 			headers: {
// 				Authorization: `Token ${ this.$store.state.token }`
// 			},
// 		})
//         .then((res) => {
// 			console.log(res)
//             this.$router.push({name: 'recipeDetail', params: {recipe_seq: this.recipe_seq}}) // 나중에 검토
//         })
//         .catch((err) => {
//             console.log(err);
//         })

//     }
//   }
// }
</script>


<style scoped>
@font-face {
    font-family: 'nanumsquare_acEB';
    src: url('../../../public/fonts/NanumSquare_acEB.ttf');
  }

@font-face {
    font-family: 'nanumsquareL';
    src: url('../../../public/fonts/NanumSquareL.ttf');
  }

@font-face {
    font-family: 'nanumsquareR';
    src: url('../../../public/fonts/NanumSquareR.ttf');
  }

.recipecreatetitle {
	font-family: 'nanumsquare_acEB';
}
#recipe-name {
	font-family: 'nanumsquare_acEB';
	font-size:25px; 
}
#recipe-name-input {
	font-family: 'nanumsquareR';
	
}
#recipe-content {
	font-family: 'nanumsquare_acEB';
	font-size:25px; 
}
h1{
	display: flex;
	justify-content: center;
}
</style>
<!-- .recipecreatediv{
    display: flex;
    justify-content: center;
} -->
