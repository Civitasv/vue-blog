<template>
  <div>
    <main>
      <div class="main-inner">
        <section>
          <!-- 题目--发表时间--标签--观看人数--点赞数--热度--摘要-->
          <article v-for="article in showArticles" :key="article.articleID">
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
      </div>
    </main>
    <div class="page">
      <Page :total="articles.length" :page-size="pageSize" @on-change="changePage" show-total />
    </div>
  </div>
</template>

<style scoped>
.main-inner {
  text-align: center;
  margin-top: 20vh;
  color: whitesmoke;
}
#label {
  cursor: pointer;
  border-bottom: 1px solid #fff;
}

.title {
  text-align: center;
  font-size: 1.3rem;
}

.descip {
  text-align: center;
  color: #f1e7e2;
  font-size: 1rem;
}

.digest {
  width: 50%;
  margin: 0 auto;
  margin-top: 8vh;
  margin-bottom: 6vh;
}
.readmore {
  text-align: center;
  margin-bottom: 8vh;
}

.readmore button {
  background-color: whitesmoke;
  color: #396882;
  font-size: 1.1rem;
  font-weight: bold;
  border: 0.3rem solid whitesmoke;
  padding: 0.5rem 1rem 0.5rem 1rem;
  transition-property: background-color;
  transition-duration: 0.2s;
  transition-timing-function: ease-in-out;
  transition-delay: 0s;
  cursor: pointer;
}

.readmore button:hover {
  background-color: #396882;
  color: whitesmoke;
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