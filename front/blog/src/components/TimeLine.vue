<template>
  <div class="timeline">
    <Timeline>
      <TimelineItem v-for="article in articles" :key="article.articleID">发布1.0版本</TimelineItem>
    </Timeline>
  </div>
</template>

<style scoped>
.timeline {
  width: 40vw;
  margin: 0 auto;
  margin-top: 15vh;
}
</style>

<script>
import { mapState } from "vuex";
import { mapActions } from "vuex";
export default {
  computed: {
    ...mapState({
      articles: state => state.blog.articles
    })
  },
  methods: {
    ...mapActions("blog", ["getAllArticles"])
  },
  mounted() {
    if (this.articles.length == 0) this.getAllArticles();
  }
};
</script>