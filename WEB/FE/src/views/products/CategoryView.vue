<template>
    <div class="cate">
      <b-container>
          <div class="catetitlediv">
            <h1 class="catetitle"><b>What's in</b>
            <b style="
              margin-left:10px;
              background: linear-gradient(to right, #FFE400, #FF0000, #5F00FF,#0100FF);
              color: transparent;
              -webkit-background-clip: text;">SSC</b>?</h1>
          </div>
          <b-row>
            <!-- 사진은 임시로 넣어둠, 수정 필요하면 나중에-->
            <b-col cols="4">
              <router-link :to="{name:'Product', params:{ cgid:1 }}" class="linkveg" >
                <CategoryItem />
              </router-link>
              <router-link :to="{name:'Product', params:{ cgid:4 }}" class="linknut" >
                <CategoryItem />
              </router-link>
              <router-link :to="{name:'Product', params:{ cgid:7 }}" class="linkmilk">
                <CategoryItem />
              </router-link>
              <router-link :to="{name:'Product', params:{ cgid:10 }}" class="linksource">
                <CategoryItem />
              </router-link>
              <router-link :to="{name:'Product', params:{ cgid:13 }}" class="linkdrink">
                <CategoryItem />
              </router-link>
            </b-col>
            <b-col cols="4">
              <router-link :to="{name:'Product', params:{ cgid:2 }}" class="linkfru">
                <CategoryItem />
              </router-link>
              <router-link :to="{name:'Product', params:{ cgid:5 }}" class="linkfish">
                <CategoryItem />
              </router-link>
              <router-link :to="{name:'Product', params:{ cgid:8 }}" class="linkcan">
                <CategoryItem />
              </router-link>
              <router-link :to="{name:'Product', params:{ cgid:11 }}" class="linkinst">
                <CategoryItem />
              </router-link>
              <router-link :to="{name:'Product', params:{ cgid:14 }}" class="linksnack">
                <CategoryItem />
              </router-link>
            </b-col>
            <b-col cols="4">
              <router-link :to="{name:'Product', params:{ cgid:3 }}" class="linkrice">
                <CategoryItem />
              </router-link>
              <router-link :to="{name:'Product', params:{ cgid:6 }}" class="linkmeat">
                <CategoryItem />
              </router-link>
              <router-link :to="{name:'Product', params:{ cgid:9 }}" class="linkfrozen">
                <CategoryItem />
              </router-link>
              <router-link :to="{name:'Product', params:{ cgid:12 }}" class="linktea">
                <CategoryItem />
              </router-link>
            </b-col>      
          </b-row>

        <!-- <b-row>
          <b-col v-for="area in areas" v-bind:key="area.area_seq" cols="4">
            <router-link :to="{name:'Product', params:{ cgid:area.area_seq }}">
              <CategoryItem v-bind:area="area"/>
            </router-link>
          </b-col>
        </b-row> -->

    </b-container>

    </div>
</template>

<script>
import CategoryItem from '@/components/product/CategoryItem.vue'

export default {
  name:'CategoryView',
  methods:{
  
  },
  components: { 
    CategoryItem 
  },
  computed:{
    areas(){
      return this.$store.state.areas;
    },
  },
  created(){
    this.$store.dispatch('getAreas')
  }
}
</script>

<style scoped>
@font-face {
  font-family: 'NanumSquare_acB';
  src: url('../../../public/fonts/NanumSquare_acB.ttf');
}
@font-face {
  font-family: 'NanumSquare_acEB';
  src: url('../../../public/fonts/NanumSquare_acEB.ttf');
}
@font-face {
  font-family: 'NanumSquare_acL';
  src: url('../../../public/fonts/NanumSquare_acL.ttf');
}
@font-face {
  font-family: 'NanumSquare_acR';
  src: url('../../../public/fonts/NanumSquare_acR.ttf');
}
@font-face {
  font-family: 'NanumSquareB';
  src: url('../../../public/fonts/NanumSquareB.ttf');
}
@font-face {
  font-family: 'NanumSquareEB';
  src: url('../../../public/fonts/NanumSquareEB.ttf');
}
@font-face {
  font-family: 'NanumSquareL';
  src: url('../../../public/fonts/NanumSquareL.ttf');
}
@font-face {
  font-family: 'NanumSquareR';
  src: url('../../../public/fonts/NanumSquareR.ttf');
}


.cate{
  margin-top:30px;
  margin-left: 150px;  
  margin-right: 150px;  
  font-family: 'NanumSquareR';
}

.catetitlediv {
  display: flex;
  justify-content: center;
  font-family: 'NanumSquare_acEB';
}

.catetitle {
  padding: 40px;
}


  .linkveg {
  display: flex;
  justify-content: center;
  background-image: url(../../../public/images/category/채소.png);
  background-position: center;
  background-size: contain;
  background-repeat:no-repeat;
  }
  .linknut {
  display: flex;
  justify-content: center;
  background-image: url(../../../public/images/category/견과.png);
  background-position: center;
  background-size: contain;
  background-repeat:no-repeat;
  }
  .linkmilk {
  display: flex;
  justify-content: center;
  background-image: url(../../../public/images/category/우유_유제품.png);
  background-position: center;
  background-size: contain;
  background-repeat:no-repeat;
  }
  .linksource {
  display: flex;
  justify-content: center;
  background-image: url(../../../public/images/category/장류_양념.png);
  background-position: center;
  background-size: contain;
  background-repeat:no-repeat;
  }
  .linkfru {
  display: flex;
  justify-content: center;
  background-image: url(../../../public/images/category/과일.png);
  background-position: center;
  background-size: contain;
  background-repeat:no-repeat;
  }
  .linkfish {
  display: flex;
  justify-content: center;
  background-image: url(../../../public/images/category/수산물_건어물.png);
  background-position: center;
  background-size: contain;
  background-repeat:no-repeat;
  }
  .linkcan {
  display: flex;
  justify-content: center;
  background-image: url(../../../public/images/category/통조림.png);
  background-position: center;
  background-size: contain;
  background-repeat:no-repeat;
  }
  .linkrice {
  display: flex;
  justify-content: center;
  background-image: url(../../../public/images/category/쌀_잡곡.png);
  background-position: center;
  background-size: contain;
  background-repeat:no-repeat;
  }
  .linkmeat {
  display: flex;
  justify-content: center;
  background-image: url(../../../public/images/category/정육_계란.png);
  background-position: center;
  background-size: contain;
  background-repeat:no-repeat;
  }
  .linkdrink {
  display: flex;
  justify-content: center;
  background-image: url(../../../public/images/category/생수_음료.png);
  background-position: center;
  background-size: contain;
  background-repeat:no-repeat;
  }
  .linksnack {
  display: flex;
  justify-content: center;
  background-image: url(../../../public/images/category/과자_시리얼.png);
  background-position: center;
  background-size: contain;
  background-repeat:no-repeat;
  }
  .linktea {
  display: flex;
  justify-content: center;
  background-image: url(../../../public/images/category/커피_차.png);
  background-position: center;
  background-size: contain;
  background-repeat:no-repeat;
  }
  .linkinst {
  display: flex;
  justify-content: center;
  background-image: url(../../../public/images/category/라면_즉석식품.png);
  background-position: center;
  background-size: contain;
  background-repeat:no-repeat;
  }
  .linkfrozen {
  display: flex;
  justify-content: center;
  background-image: url(../../../public/images/category/냉동_밀키트.png);
  background-position: center;
  background-size: contain;
  background-repeat:no-repeat;
  }

</style>