<template>
  <div class="about-page">
    <h1>About Page</h1>
    <p>여기는 소개 페이지입니다.</p>
  </div>
</template>

<script>
import { defineComponent } from 'vue'

export default defineComponent({
  name: 'AboutPage'
})
</script>

<style scoped>
.about-page {
  max-width: 1920px;
  margin: 0 auto;
  padding: 2rem;
  text-align: left;
}

</style>