<template>
  <div>
    <div id="archives">
      <div class="wrap">
        <Header></Header>
        <TimeLine></TimeLine>
      </div>
      <Footer></Footer>
      <GoTop></GoTop>
    </div>
    <SideBar></SideBar>
  </div>
</template>

<script>
import TimeLine from "../../components/TimeLine";
import Header from "../../components/Header";
import Footer from "../../components/Footer";
import GoTop from "../../components/GoTop";
import SideBar from "../../components/SideBar";
export default {
  components: {
    TimeLine,
    Header,
    Footer,
    GoTop,
    SideBar
  }
};
</script>

<style scoped>
#archives {
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