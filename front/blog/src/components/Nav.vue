<template>
  <div>
    <div class="side-nav-toggle" @click="toggleSideNav">
      <Icon type="ios-menu" color="#fff" size="30" />
    </div>
    <transition enter-active-class="fadeIn" leave-active-class="fadeOut">
      <div class="nav animated" v-show="flag">
        <router-link to="/home" tag="span">
          <Icon type="ios-home" />&nbsp;&nbsp;Home
        </router-link>
        <router-link to="/archives" tag="span">
          <Icon type="ios-archive" />&nbsp;&nbsp;Archives
        </router-link>
        <router-link to="/tags" tag="span">
          <Icon type="ios-pricetags" />&nbsp;&nbsp;Tags
        </router-link>
        <router-link to="/search" tag="span">
          <Icon type="md-search" />&nbsp;&nbsp;Search
        </router-link>
        <router-link to="/about" tag="span">
          <Icon type="ios-at" />&nbsp;&nbsp;About
        </router-link>
        <router-link to="/link" tag="span">
          <Icon type="ios-link" />&nbsp;&nbsp;Link
        </router-link>
      </div>
    </transition>
  </div>
</template>

<style scoped>
.side-nav-toggle {
  position: absolute;
  top: 1rem;
  left: 1rem;
  cursor: pointer;
}
.nav {
  text-align: center;
  padding-top: 2vh;
  padding-bottom: 2vh;
  color: whitesmoke;
  font-size: 1rem;
  z-index: 999;
}
.nav span {
  margin: 1rem;
  cursor: pointer;
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
    toggleSideNav() {
      this.flag = !this.flag;
    },
    init() {
      if (/(iPhone|iPad|iPod|iOS|Android)/i.test(navigator.userAgent)) {
        //移动端
        this.flag = false;
      } else {
        this.flag = true;
      }
    }
  },
  mounted() {
    this.init();
  }
};
</script>