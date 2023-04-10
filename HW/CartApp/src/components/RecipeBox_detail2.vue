<template>
    <div style="height: 100%;">
        <div class="box_inner">
            <img :src=imgdata alt="image" width="100%" height="100%" style="margin: 3%;">
        </div>
        <div class="box_inner">
            <h2>{{rdata.recipe_name}}</h2>
            <div class="like">
                <p id="like2" class="review">좋아요: {{ rdata.recipe_like_cnt }}</p>
            </div>

        </div>
    </div>
</template>

<script>
import { api } from '@/utils/axios'
export default {
    data() {
        return {
            imgdata: `https://i8a102.p.ssafy.io/api/image/recipe/${this.$store.state.selected_recipe}`,
            rdata:[],
        }
    },
    async created(){
        var rd = await api.cartdata.getRecipebySeq(this.$store.state.selected_recipe)
        this.rdata = rd.data
    }
}
</script>

<style>
.info {
    color: white;
}

.like {
    border-bottom: 1px solid white;
    display: flex;
    justify-content: center;

}

#like2 {
    color: red;
    margin-bottom: -2px;
}

.review {
    color: white;
    font-size: 30px;
}

.box_inner {
    height: 50%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
</style>