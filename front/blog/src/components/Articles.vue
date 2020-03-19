<template>
  <div>
    <main>
      <section>
        <!-- 题目--发表时间--标签--观看人数--点赞数--热度--摘要-->
        <article v-for="article in showArticles" :key="article.articleID">
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
          <div class="digest">
            <p>{{article.digest}}</p>
          </div>
          <div class="readmore">
            <router-link :to="'/articles/'+ article.articleID" tag="button">Read More>></router-link>
            <!--<button @click="readMore(article.articleID)"></button>-->
          </div>
          <Divider id="divider" />
        </article>
      </section>
    </main>
    <div class="page">
      <Page :total="articles.length" :page-size="pageSize" @on-change="changePage" show-total />
    </div>
  </div>
</template>

<style scoped>
main {
  width: 50vw;
  margin: 0 auto;
  margin-top: 20vh;
  color: whitesmoke;
}
#label {
  cursor: pointer;
  border-bottom: 1px solid #fff;
}

.title {
  text-align: center;
  line-height: 4em;
}

.descip {
  text-align: center;
  color: #f1e7e2;
  font-size: 12px;
}

.digest {
  margin-top: 8vh;
  margin-bottom: 6vh;
}
.readmore {
  text-align: center;
  margin-bottom: 8vh;
}

.readmore button {
  background-color: #493374;
  color: white;
  border: 3px solid #493374;
  padding: 5px 10px 5px 10px;
  transition-property: background-color;
  transition-duration: 0.2s;
  transition-timing-function: ease-in-out;
  transition-delay: 0s;
  cursor: pointer;
}

.readmore button:hover {
  background-color: whitesmoke;
  color: #493374;
}
</style>

<script>
import { mapState } from "vuex";
import { mapActions } from "vuex";
import { mapMutations } from "vuex";

export default {
  data() {
    return {};
  },
  // state.模块名.属性名
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
    /*readMore(id) {
      this.setContent(id);
      this.$route.params.id;
      this.$router.push({ path: "/content" });
    }*/
  },
  mounted() {
    if (this.articles.length == 0) this.getAllArticles();
  }
};
</script>