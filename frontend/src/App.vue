<template>
  <div :class="['page-wrapper', $route.name]">
    <NavBar />
    
    <main>
      <router-view :class="$route.name" />
    </main>

    <Footer />
  </div>
</template>

<script>

import NavBar from './components/NavBar.vue';
import Footer from './components/MyFooter.vue';

export default {
  name: 'App',
  components: {
    NavBar,
    Footer
  }
};

window.addEventListener('scroll', () => {
  const scrollY = window.scrollY;
  document.body.style.backgroundPosition = `center ${scrollY * 0.8}px`;
  const pageWrapper = document.querySelector('.page-wrapper');
  pageWrapper.style.setProperty('--scroll-offset', `${-700 + scrollY * 0.4}px`);
});

</script>

<style>

</style>
