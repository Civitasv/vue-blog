<template>
  <div>
    <div id="link">
      <div class="wrap">
        <Header></Header>
        <div class="links">
          <Icon type="ios-link" />&nbsp;&nbsp;
          <a href="http://www.cartovision.cn/">武汉大学慧图社</a>
          <Divider id="divider"></Divider>
        </div>
      </div>
      <Footer></Footer>
      <GoTop></GoTop>
    </div>
    <SideBar></SideBar>
  </div>
</template>

<style scoped>
#link {
  background-image: url("../../assets/images/bg.jpg");
  background-size: cover;
  background-attachment: fixed;
  background-repeat: no-repeat;
  transition: margin-right 1s;
}
.wrap {
  min-height: 100vh;
  padding-bottom: 10rem;
}
.links {
  text-align: center;
  margin-top: 25vh;
  color: whitesmoke;
}

.links a {
  color: whitesmoke;
}
</style>
<script>
const Header = () => import("../../components/Header");
const Footer = () => import("../../components/Footer");
const GoTop = () => import("../../components/GoTop");
const SideBar = () => import("../../components/SideBar");
export default {
  data() {
    return {};
  },
  computed: {},
  components: {
    Header,
    Footer,
    GoTop,
    SideBar
  },
  methods: {}
};
</script>