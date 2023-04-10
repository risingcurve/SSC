<template>
  <b-carousel
    id="carousel-fade"
    style="text-shadow: 0px 0px 2px #000;"
    fade
    indicators
    img-width="100%"
    img-height="100%"
  >
    <b-carousel-slide
      caption="First Slide"
      img-src="https://picsum.photos/1920/1080/?image=10"
      class="h-100"
      id="b-c-slide"
      
    ></b-carousel-slide>
    <b-carousel-slide
      caption="Second Slide"
      img-src="https://picsum.photos/1920/1080/?image=12"
      id="b-c-slide"
    ></b-carousel-slide>
    <b-carousel-slide
      caption="Third Slide"
      img-src="https://picsum.photos/1920/1080/?image=22"
      id="b-c-slide"
    ></b-carousel-slide>
  </b-carousel>
</template>

<script>
export default {

}
</script>

<style>
#b-c-slide{
  width: 100%;
  height: 100%;
}
#carousel-fade{
  width: 100%;
  height: 100%;
}
.carousel-inner{
  width: 100%;
  height: 100%;
}
#b-c-slide>img{
  height: 100%;
}
</style>