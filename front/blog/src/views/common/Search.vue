<template>
  <div>
    <div id="search">
      <div class="wrap">
        <Header></Header>
        <div class="serachbox">
          <Input
            element-id="searchContent"
            placeholder="Enter something..."
            icon="ios-search"
            v-model="searchContent"
            @on-click="searchBoxClick"
            @on-enter="searchBoxClick"
          />
        </div>
        <!--搜索结果 -->
        <div class="res">
          <div class="info">共匹配到{{searchRes.length}}条记录</div>
          <Divider></Divider>
          <div v-for="(res,id) in searchRes" :key="id">
            <router-link :to="'/articles/'+ res.articleID" tag="div">
              <div class="line">
                <Icon type="md-book" />&nbsp;&nbsp;&nbsp;
                <label id="title" v-html="res.title"></label>
              </div>
            </router-link>
          </div>
        </div>
      </div>
      <Footer></Footer>
      <GoTop></GoTop>
    </div>
    <SideBar></SideBar>
  </div>
</template>

<style scoped>
#search {
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
.serachbox {
  width: 50vw;
  margin: 0 auto;
  margin-top: 25vh;
}
.res {
  color: whitesmoke;
  width: 50vw;
  margin: 0 auto;
  margin-top: 5vh;
}

#title {
  cursor: pointer;
}

.line:hover {
  color: #ccc;
  border-color: #ccc;
}

.line {
  border-bottom: 1px dashed whitesmoke;
}
</style>
<script>
const Header = () => import("../../components/Header");
const Footer = () => import("../../components/Footer");
const GoTop = () => import("../../components/GoTop");
const SideBar = () => import("../../components/SideBar");
import { mapState } from "vuex";
import { mapActions } from "vuex";
export default {
  data() {
    return {
      searchContent: "",
      searchRes: []
    };
  },
  computed: {
    ...mapState({
      articles: state => state.article.articles
    })
  },
  components: {
    Header,
    Footer,
    GoTop,
    SideBar
  },
  methods: {
    ...mapActions("article", ["getAllArticles"]),
    searchBoxClick() {
      this.searchRes.splice(0, this.searchRes.length);
      // 搜索内容
      var content = this.searchContent;
      if (content == "") return;
      // 从标题和内容中进行搜索
      for (var i = 0; i < this.articles.length; i++) {
        var _title = this.articles[i].title;
        // 忽略大小写
        content = new RegExp(content, "i");
        if (_title != null && _title.search(content) != -1) {
          var l = content.toString().length - 3;
          var index = _title.search(content);
          this.searchRes.push({
            title:
              _title.slice(0, index) +
              "<b style='color:red'>" +
              _title.slice(index, index + l) +
              "</b>" +
              _title.slice(index + l, _title.length),
            articleID: this.articles[i].articleID
          });
        }
      }
    }
  },
  mounted() {
    if (this.articles.length == 0) this.getAllArticles();
  }
};
</script>