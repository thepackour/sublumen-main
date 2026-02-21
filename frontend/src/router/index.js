import { createRouter, createWebHistory } from 'vue-router'
import HomePage from '../pages/Home.vue'
import AboutPage from '../pages/About.vue'
//import NarrativePage from '../pages/Narrative.vue'

const routes = [
  { path: '/', name:'home', component: HomePage },
  { path: '/about', name:'about', component: AboutPage },
  //{ path: '/narrative', name:'narrative', component: NarrativePage }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router