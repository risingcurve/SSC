<template>
  <div class="theme">
    <b-container>
        <div class="themetitlediv">
            <h1 class="themetitle">
              <b style="
              margin-right:10px;
              background: linear-gradient(to right, #FFE400, #FF0000, #5F00FF,#0100FF);
              color: transparent;
              -webkit-background-clip: text;">SSC</b>
              <b>Food Trip</b></h1>
        </div>
        <b-row>
            <b-col v-for="theme in themes" v-bind:key="theme.theme_seq">
                <router-link style="text-decoration:none; color:black; font-weight:bold; font-size:24px;" :to="{name:'Recipe', params:{ tid:theme.theme_seq }}">
                    <ThemeItem v-bind:theme="theme" />
                </router-link>
            </b-col>
        </b-row>
    </b-container>
  </div>
</template>

<script>
import ThemeItem from '@/components/recipe/ThemeItem.vue'
export default {
  components: { ThemeItem },
    name: "ThemeView",
    computed:{
        themes(){
            return this.$store.state.themes;
        },
    },
    created(){
        this.$store.dispatch('getThemes')
    }
}
</script>

<style scoped>
.theme{
    margin-top: 30px;
    margin-left: 150px;
    margin-right: 150px;
    }
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
.theme{
    display: flex;
    margin-top: 30px;
    margin-left: 150px;
    margin-right: 150px;
    font-family: 'nanumsquareR';
}

.themetitlediv{ 
    font-family: 'nanumsquare_acEB';
    display: flex;
    justify-content: center;
}

.themetitle {
  padding: 40px;
}
</style>