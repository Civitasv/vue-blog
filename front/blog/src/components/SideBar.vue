<template>
  <div class="sideBar">
    <div class="sidebar-toggle" @click="toggleNav">
      <Icon :type="iconType" :color="iconColor" size="30" />
    </div>
    <transition enter-active-class="slideInRight" leave-active-class="slideOutRight">
      <aside v-show="flag" class="animated">
        <div class="side-inner">
          <div class="head"></div>
          <div class="content">
            <div class="title">甜木木夕</div>
            <br />
            <div class="subtitle">Be Someone</div>
            <nav
              class="site-state motion-element"
              style="opacity: 1; display: flex; transform: translateX(0px);"
            >
              <div class="site-state-item site-state-posts">
                <router-link to="/archives/" tag="label">
                  <span class="site-state-item-count">{{this.articles.length}}</span>
                  <span class="site-state-item-name">Posts</span>
                </router-link>
              </div>
              <div class="site-state-item site-state-tags">
                <router-link to="/tags/" tag="label">
                  <span class="site-state-item-count">{{this.labels.length}}</span>
                  <span class="site-state-item-name">Tags</span>
                </router-link>
              </div>
            </nav>
          </div>
        </div>
      </aside>
    </transition>
  </div>
</template>

<style scoped>
.sidebar-toggle {
  padding: 0.8rem 1.2rem;
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
  z-index: 1;
  background: #ededed;
  overflow-x: hidden;
  position: fixed;
}
.side-inner {
  width: 100%;
  height: 100%;
  padding-top: 2rem;
}
.head {
  width: 10pc;
  height: 10pc;
  background-image: url("../assets/images/head.png");
  background-size: cover;
  margin: 0 auto;
  border-radius: 50%;
}
.content {
  text-align: center;
  color: black;
}
.site-state-item:first-child {
  border-left: none;
}
.site-state-item {
  padding: 0 1.5rem;
  border-left: 1px solid #333;
}
.site-state-item-count,
.site-state-item-name {
  cursor: pointer;
}
.site-state {
  justify-content: center;
  overflow: hidden;
  line-height: 1.4;
  white-space: nowrap;
  text-align: center;
  margin-top: 1rem;
}
.site-state-item-count {
  display: block;
  text-align: center;
  color: inherit;
  font-weight: 600;
  font-size: 1.8rem;
}
.site-state-item-name {
  font-size: 1.2rem;
}
</style>


<script>
import { mapState } from "vuex";
import { mapActions } from "vuex";
export default {
  data() {
    return {
      flag: false,
      iconColor: "#fff",
      iconType: "ios-menu"
    };
  },
  computed: {
    ...mapState({
      articles: state => state.article.articles,
      labels: state => state.label.labels
    })
  },
  mounted() {
    if (this.articles.length == 0) this.getAllArticles();
    if (this.labels.length == 0) this.getAllLabels();
  },
  methods: {
    ...mapActions("article", ["getAllArticles"]),
    ...mapActions("label", ["getAllLabels"]),

    toggleNav() {
      this.flag = !this.flag;
      console.log(this.$route.path);
      if (this.$route.path == "/home" || this.$route.path == "/home/") {
        this.flag
          ? (document.getElementById("home").style.marginRight = "320px")
          : (document.getElementById("home").style.marginRight = 0);
      } else if (this.$route.path.search(/articles/i) != -1) {
        this.flag
          ? (document.getElementById("article").style.marginRight = "320px")
          : (document.getElementById("article").style.marginRight = 0);
      } else if (
        this.$route.path == "/archives" ||
        this.$route.path == "/archives/"
      ) {
        this.flag
          ? (document.getElementById("archives").style.marginRight = "320px")
          : (document.getElementById("archives").style.marginRight = 0);
      } else if (this.$route.path == "/tags" || this.$route.path == "/tags/") {
        this.flag
          ? (document.getElementById("tags").style.marginRight = "320px")
          : (document.getElementById("tags").style.marginRight = 0);
      } else if (this.$route.path.search(/tags\/\d/i) != -1) {
        this.flag
          ? (document.getElementById("tag").style.marginRight = "320px")
          : (document.getElementById("tag").style.marginRight = 0);
      } else if (
        this.$route.path == "/search" ||
        this.$route.path == "/search/"
      ) {
        this.flag
          ? (document.getElementById("search").style.marginRight = "320px")
          : (document.getElementById("search").style.marginRight = 0);
      } else if (this.$route.path == "/link" || this.$route.path == "/link/") {
        this.flag
          ? (document.getElementById("link").style.marginRight = "320px")
          : (document.getElementById("link").style.marginRight = 0);
      } else if (
        this.$route.path == "/about" ||
        this.$route.path == "/about/"
      ) {
        this.flag
          ? (document.getElementById("about").style.marginRight = "320px")
          : (document.getElementById("about").style.marginRight = 0);
      }
      if (this.flag) {
        this.iconType = "md-close";
        this.iconColor = "#000000";
      } else {
        this.iconType = "ios-menu";
        this.iconColor = "#fff";
      }
    }
  }
};
</script>