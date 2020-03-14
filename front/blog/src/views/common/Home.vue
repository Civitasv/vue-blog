<template>
  <div id="app">
    <div class="img1"></div>
    <Header></Header>
    <Articles></Articles>
    <Footer></Footer>
  </div>
</template>

<style>
#app {
  margin: 0;
  padding: 0;
  background-image: url("../../assets/images/bg.jpg");
  background-size: cover;
}
</style>

<script>
import Header from "../../components/Header";
import Footer from "../../components/Footer";
import Articles from "../../components/Articles";

export default {
  components: {
    Header,
    Footer,
    Articles
  }
};
</script>