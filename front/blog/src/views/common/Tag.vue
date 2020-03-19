<template>
  <div>
    <div id="tag">
      <div class="wrap">
        <Header></Header>
        <div class="tag-content">
          <Timeline>
            <TimelineItem color="#493374">
              {{label.val}}
              <label style="color:gray">Tag</label>
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
  padding-bottom: 100px;
}
.tag-content {
  width: 40vw;
  margin: 0 auto;
  margin-top: 15vh;
  color: whitesmoke;
}

#title {
  font-size: 16px;
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
import Header from "../../components/Header";
import Footer from "../../components/Footer";
import GoTop from "../../components/GoTop";
import SideBar from "../../components/SideBar";
import label from "../../network/common/api/label";

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
      let labelID = this.$route.params.id;
      label.getLabelByID(labelID).then(res => {
        this.label.val = res.data.label;
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