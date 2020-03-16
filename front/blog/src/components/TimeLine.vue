<template>
  <div class="timeline">
    <Timeline>
      <TimelineItem color="#493374">Nice! {{articles.length}} posts in total. Keep on posting.</TimelineItem>
      <TimelineItem v-for="article in showArticles" :key="article.articleID" :color="color">
        <router-link :to="'/articles/'+ article.articleID" tag="div">
          <div class="line">
            <label id="time">{{article.publicTime}}</label> &nbsp;&nbsp;
            <label id="title">{{article.title}}</label>
          </div>
        </router-link>
      </TimelineItem>
    </Timeline>
    <div class="page">
      <Page :total="articles.length" :page-size="pageSize" @on-change="changePage" show-total />
    </div>
  </div>
</template>

<style scoped>
.timeline {
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
import { mapState } from "vuex";
import { mapActions } from "vuex";
import { mapMutations } from "vuex";
export default {
  data() {
    return {
      color: "whitesmoke"
    };
  },
  computed: {
    ...mapState({
      articles: state => state.blog.articles,
      showArticles: state => state.blog.showArticles,
      pageSize: state => state.blog.pageSize
    })
  },
  methods: {
    ...mapActions("blog", ["getAllArticles"]),
    ...mapMutations("blog", ["changePage"])
  },
  mounted() {
    if (this.articles.length == 0) this.getAllArticles();
  }
};
</script>