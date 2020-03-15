<template>
  <div id="home">
    <div class="wrap">
      <Header></Header>
      <Articles></Articles>
    </div>
    <Footer></Footer>
  </div>
</template>

<style>
#home {
  background-image: url("../../assets/images/bg.jpg");
  background-size: cover;
  background-attachment: fixed;
  background-repeat: no-repeat;
}
.wrap {
  min-height: 100vh;
  padding-bottom: 100px;
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