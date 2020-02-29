<template>
  <div>
    <header>
      <div>
        <div class="title">
          <a href="/home">甜木木夕</a>
        </div>
        <div class="subtitle">Life is short, I just coding</div>
      </div>
      <router-link to="/home">Home</router-link>
      <router-link to="/contact">Contact</router-link>
      <router-link to="/archives">Archives</router-link>
      <router-link to="/tags">Tags</router-link>
      <router-link to="/search">Search</router-link>
      <router-link to="/message">Message</router-link>
      <router-link to="/link">Link</router-link>
    </header>
    <router-view></router-view>
  </div>
</template>

<style scoped>
</style>

<script>
</script>