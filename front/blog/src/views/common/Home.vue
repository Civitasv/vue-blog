<template>
  <div>
    <div id="home">
      <div class="wrap">
        <Header></Header>
        <Articles></Articles>
      </div>
      <Footer></Footer>
      <GoTop></GoTop>
    </div>
    <SideBar></SideBar>
  </div>
</template>

<style>
#home {
  background-image: url("../../assets/images/bg.jpg");
  background-size: cover;
  background-attachment: fixed;
  background-repeat: no-repeat;
  transition: margin-right 1s;
}
.wrap {
  min-height: 100vh;
  padding-bottom: 100px;
}
</style>

<script>
const Header = () => import("../../components/Header");
const Footer = () => import("../../components/Footer");
const GoTop = () => import("../../components/GoTop");
const Articles = () => import("../../components/Articles");
const SideBar = () => import("../../components/SideBar");
export default {
  components: {
    Header,
    Footer,
    Articles,
    GoTop,
    SideBar
  }
};
</script>