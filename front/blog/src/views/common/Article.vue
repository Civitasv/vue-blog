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
          <label v-for="(label,id) in article.labels" :key="id">
            <Icon type="md-pricetags" />&nbsp;&nbsp;
            <router-link
              :to="'/tags/'+ label.label"
              tag="span"
              id="label"
            >{{label.label}}&nbsp;&nbsp;</router-link>
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
        <div class="markdown-body md" :style="[styleObj]">
          <no-ssr>
            <mavon-editor
              class="md"
              :value="article.content"
              :boxShadow="true"
              :subfield="prop.subfield"
              :defaultOpen="prop.defaultOpen"
              :toolbarsFlag="prop.toolbarsFlag"
              :editable="prop.editable"
              :scrollStyle="prop.scrollStyle"
              :ishljs="prop.ishljs"
            ></mavon-editor>
          </no-ssr>
          <Comment></Comment>
        </div>
      </div>
      <Footer></Footer>
      <GoTop></GoTop>
    </div>
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
  margin: 0 auto;
  margin-top: 5vh;
  margin-bottom: 15vh;
}
.title {
  text-align: center;
  line-height: 4em;
  color: whitesmoke;
  margin-top: 20vh;
}

.descip {
  text-align: center;
  color: #f1e7e2;
  font-size: 1rem;
}
</style>
<script>
import article from "../../network/common/api/article";
import NoSSR from "vue-no-ssr";

const Header = () => import("../../components/Header");
const Footer = () => import("../../components/Footer");
const GoTop = () => import("../../components/GoTop");
const Comment = () => import("../../components/Comment");

import formatDate from "../../utils/timeStampUtil";

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
      },
      styleObj: ""
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
    created() {
      if (/(iPhone|iPad|iPod|iOS|Android)/i.test(navigator.userAgent)) {
        //移动端
        this.styleObj = { width: "100vw" };
      } else {
        this.styleObj = { width: "60vw" };
      }
    },
    init() {
      let articleID = this.$route.params.id;
      console.log(articleID);
      article.addReadNum(articleID);
      article.getArticleByID(articleID).then(res => {
        this.article.content = res.data.content;
        this.article.publicTime = formatDate(res.data.publicTime);
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
    this.created();
  },
  components: {
    "no-ssr": NoSSR,
    Header,
    Footer,
    GoTop,
    Comment
  }
};
</script>