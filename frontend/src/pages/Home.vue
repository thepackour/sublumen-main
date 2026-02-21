<template>
  <div class="intro">
    <h1 class="text-4xl font-bold mb-4">개발의 무한 루프</h1>
    <h3 class="text-2xl font-semibold mb-6">Studying:</h3>
    <ul class="text-lg text-gray-300">
      <li>Springboot</li>
      <li>AWS</li>
      <li>Oracle Cloud</li>
    </ul>
    <h3 class="text-2xl font-semibold mb-6">TODO:</h3>
    <ul class="text-lg text-gray-300">
      <li>ZP 서버 Oracle Cloud로 옮기기</li>
      <li>예약 시스템 완성</li>
      <li>OHPS 봇 리팩토링</li>
    </ul>
  </div>

  <div class="card-container">
    <router-link to="/services" class="card">
      <h2 class="text-xl font-semibold">서비스</h2>
      <p>운영 중인 서비스</p>
    </router-link>

    <router-link to="/projects" class="card">
      <h2 class="text-xl font-semibold">프로젝트</h2>
      <p>전체 프로젝트 모음</p>
    </router-link>

    <router-link to="/devlog" class="card">
      <h2 class="text-xl font-semibold">블로그</h2>
      <p>개발 일지 및 블로그</p>
    </router-link>
  </div>

  <div v-for="i in 20" :key="i"> dummy text <br><br> </div>
    
</template>

<script>
export default {
  name: 'HomePage'
}
</script>

<style>

.intro {
  max-width: 800px;
  margin: 0 auto 5rem auto;
  text-align: left;
}

.card-container {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 5rem;
  height: 200px;
  margin-bottom: 10rem;
}

.card {
  display: block;
  background: rgba(0, 0, 0, 0.3);
  padding: 1.5rem;
  border-radius: 12px;
  box-shadow: 0 2px 6px rgba(0,0,0,0.1);
  text-decoration: none;
  color: inherit;
  align-content: center;
  border: 2px solid #ddd;
  box-shadow: 0 0 20px rgba(255, 255, 255, 0.3);
  box-shadow: 0 0 20px rgba(255, 255, 255, 0.3) inset;

  backdrop-filter: blur(8px);
  -webkit-backdrop-filter: blur(8px);

  transition: transform 0.3s ease, background-color 0.3s ease, box-shadow 0.3s ease, color 0.3s ease;
}

.card:hover {
  transform: scale(1.05);
  background-color: rgba(255, 255, 255, 0.8);
  box-shadow: 0 6px 12px rgba(0,0,0,0.15);
  color: #000000;
  border-color: #fff;
}


</style>
