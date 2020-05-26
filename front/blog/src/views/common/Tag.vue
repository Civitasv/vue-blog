<template>
  <div>
    <div id="tag">
      <div class="wrap">
        <Header></Header>
        <div class="tag-content">
          <Timeline>
            <TimelineItem color="white">
              {{label.val}}
              <label style="color:whitesmoke">Tag</label>
            </TimelineItem>
            <TimelineItem v-for="article in label.articles" :key="article.articleID" :color="color">
              <router-link :to="'/articles/'+ article.articleID" tag="div">
                <div class="line">
                  <label id="time">{{article.publicTime}}</label> &nbsp;&nbsp;
                  <label id="title">{{article.title}}</label>
                </div>
              </router-link>
            </TimelineItem>
          </Timeline>
        </div>
      </div>
      <Footer></Footer>
      <GoTop></GoTop>
    </div>
    <SideBar></SideBar>
  </div>
</template>

<style scoped>
#tag {
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
.tag-content {
  width: 80vw;
  margin: 0 auto;
  margin-top: 25vh;
  color: whitesmoke;
}

#title {
  font-size: 1.6rem;
}

#title,
#time {
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
import label from "../../network/common/api/label";
import formatDate from "../../utils/timeStampUtil";

export default {
  data() {
    return {
      label: {
        val: "",
        articles: []
      },
      color: "whitesmoke"
    };
  },
  methods: {
    init() {
      let content = this.$route.params.content;
      label.getLabelByContent(content).then(res => {
        this.label.val = res.data.label;
        for (var i = 0; i < res.data.articles.length; i++) {
          res.data.articles[i].publicTime = formatDate(
            res.data.articles[i].publicTime
          );
        }
        this.label.articles = res.data.articles;
      });
    }
  },
  mounted() {
    this.init();
  },
  components: {
    Header,
    Footer,
    GoTop,
    SideBar
  }
};
</script>