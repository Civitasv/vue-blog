<template>
  <header>
    <div class="head">
      <div class="title">
        <router-link to="/home" tag="span" class="brand">甜木木夕</router-link>
      </div>
      <div class="subtitle">Be Someone</div>
    </div>
    <Nav></Nav>
  </header>
</template>

<style scoped>
.brand {
  background: #493374;
  color: white;
  font-size: 1.5rem;
  font-weight: bold;
  cursor: pointer;
  padding: 0.5rem 6rem;
}
.title {
  margin-bottom: 1rem;
}
.head {
  text-align: center;
  margin: 0 auto;
}
.subtitle {
  color: whitesmoke;
  font-size: 1rem;
}
</style>

<script>
import Nav from "../components/Nav";
export default {
  components: {
    Nav
  }
};
</script>