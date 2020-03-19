<template>
  <div>
    <div id="article">
      <div class="wrap">
        <Header></Header>
        <div class="title">
          <h2>{{article.title}}</h2>
        </div>
        <div class="descip">
          <label>Posted on {{article.publicTime}}&nbsp;&nbsp;</label>
          |
          <Icon type="md-pricetags" />&nbsp;&nbsp;
          <label v-for="label in article.labels" :key="label.labelID">
            <router-link :to="'/tags/'+ label.labelID" tag="span" id="label">{{label.label}}</router-link>&nbsp;&nbsp;
          </label>
          <label>| visitors:{{article.readNum}}&nbsp;&nbsp;</label>
          <!--<label>
            |
            <Icon type="md-heart" />
            {{article.commendNum}}&nbsp;&nbsp;
          </label>
          <label>
            |
            <Icon type="ios-bonfire" />
            {{article.heat}}&nbsp;&nbsp;
          </label>-->
        </div>
        <div class="markdown-body md">
          <no-ssr>
            <mavon-editor
              class="md"
              :value="article.content"
              boxShadow="true"
              :subfield="prop.subfield"
              :defaultOpen="prop.defaultOpen"
              :toolbarsFlag="prop.toolbarsFlag"
              :editable="prop.editable"
              :scrollStyle="prop.scrollStyle"
              :ishljs="prop.ishljs"
              navigation="true"
            ></mavon-editor>
          </no-ssr>
        </div>
      </div>
      <Footer></Footer>
      <GoTop></GoTop>
    </div>
    <SideBar></SideBar>
  </div>
</template>

<style scoped>
#label {
  cursor: pointer;
  border-bottom: 1px solid #fff;
}
#label:hover {
  color: white;
}
.wrap {
  min-height: 100vh;
  padding-bottom: 100px;
}
#article {
  background-image: url("../../assets/images/bg.jpg");
  background-size: cover;
  background-attachment: fixed;
  background-repeat: no-repeat;
  transition: margin-right 1s;
}
.md {
  border: none;
  width: 60vw;
  margin: 0 auto;
  margin-top: 5vh;
}
.title {
  text-align: center;
  line-height: 4em;
  color: whitesmoke;
  margin-top: 10vh;
}

.descip {
  text-align: center;
  color: #f1e7e2;
  font-size: 12px;
}
</style>
<script>
import article from "../../network/common/api/article";
import NoSSR from "vue-no-ssr";
import Header from "../../components/Header";
import Footer from "../../components/Footer";
import GoTop from "../../components/GoTop";
import SideBar from "../../components/SideBar";

export default {
  data() {
    return {
      article: {
        content: "",
        publicTime: "",
        title: "",
        heat: "",
        commendNum: "",
        readNum: "",
        labels: [],
        comments: []
      }
    };
  },
  computed: {
    prop() {
      let data = {
        subfield: false, // 单双栏模式
        defaultOpen: "preview", //edit： 默认展示编辑区域 ， preview： 默认展示预览区域
        editable: false,
        toolbarsFlag: false,
        scrollStyle: true,
        ishljs: true
      };
      return data;
    }
  },
  methods: {
    init() {
      let articleID = this.$route.params.id;
      article.getArticleByID(articleID).then(res => {
        this.article.content = res.data.content;
        this.article.publicTime = res.data.publicTime;
        this.article.title = res.data.title;
        this.article.heat = res.data.heat;
        this.article.commendNum = res.data.commendNum;
        this.article.readNum = res.data.readNum;
        this.article.labels = res.data.labels;
        this.article.comments = res.data.comments;
      });
    }
  },
  mounted() {
    this.init();
  },
  components: {
    "no-ssr": NoSSR,
    Header,
    Footer,
    GoTop,
    SideBar
  }
};
</script>