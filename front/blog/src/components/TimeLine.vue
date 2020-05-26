<template>
  <div class="timeline">
    <Timeline>
      <TimelineItem color="white">Nice! {{articles.length}} posts in total. Keep on posting.</TimelineItem>
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
      articles: state => state.article.articles,
      showArticles: state => state.article.showArticles,
      pageSize: state => state.article.pageSize
    })
  },
  methods: {
    ...mapActions("article", ["getAllArticles"]),
    ...mapMutations("article", ["changePage"])
  },
  mounted() {
    if (this.articles.length == 0) this.getAllArticles();
  }
};
</script>