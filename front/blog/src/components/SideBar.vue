<template>
  <div class="sideBar">
    <div class="sidebar-toggle" @click="toggleNav">
      <Icon type="ios-menu" color="#fff" size="30" />
    </div>
    <transition enter-active-class="slideInRight" leave-active-class="slideOutRight">
      <aside v-show="flag" class="animated">
        <div class="side-inner">sss</div>
      </aside>
    </transition>
  </div>
</template>

<style scoped>
.sidebar-toggle {
  padding: 8px 12px;
  position: fixed;
  bottom: 70px;
  right: 30px;
  cursor: pointer;
  z-index: 2;
}
aside {
  right: 0;
  top: 0;
  bottom: 0;
  height: 100%;
  width: 320px;
  z-index: 1;
  box-shadow: inset 0 2px 6px #000;
  background: #222;
  overflow-x: hidden;
  position: fixed;
}
</style>


<script>
export default {
  data() {
    return {
      flag: false
    };
  },
  methods: {
    toggleNav() {
      this.flag = !this.flag;
      if (this.$route.path == "/home") {
        this.flag
          ? (document.getElementById("home").style.marginRight = "320px")
          : (document.getElementById("home").style.marginRight = 0);
      } else if (this.$route.path.search(/articles/i) != -1) {
        this.flag
          ? (document.getElementById("article").style.marginRight = "320px")
          : (document.getElementById("article").style.marginRight = 0);
      }
    }
  }
};
</script>