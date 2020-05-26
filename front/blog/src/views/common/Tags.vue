<template>
  <div>
    <div id="tags">
      <div class="wrap">
        <Header></Header>
        <tag-cloud :data="labels" :maxFont="30" @clickTag="clickTag"></tag-cloud>
      </div>
      <Footer></Footer>
      <GoTop></GoTop>
    </div>
    <SideBar></SideBar>
  </div>
</template>

<style scoped>
#tags {
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
import { mapState } from "vuex";
import { mapActions } from "vuex";
const Header = () => import("../../components/Header");
const Footer = () => import("../../components/Footer");
const GoTop = () => import("../../components/GoTop");
const SideBar = () => import("../../components/SideBar");
export default {
  data() {
    return {};
  },
  // state.模块名.属性名
  computed: {
    ...mapState({
      labels: state => state.label.labels
    })
  },
  methods: {
    ...mapActions("label", ["getAllLabels"]),
    clickTag(tag) {
      let content = tag.name;
      this.$router.push({ path: "/tags/" + content });
    }
  },
  mounted() {
    if (this.labels.length == 0) this.getAllLabels();
  },
  components: {
    Header,
    Footer,
    GoTop,
    SideBar
  }
};
</script>