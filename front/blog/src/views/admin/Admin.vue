<style scoped>
.layout {
  border: 1px solid #d7dde4;
  background: #f5f7f9;
  position: relative;
  border-radius: 4px;
  overflow: hidden;
}
.layout-header-bar {
  background: #fff;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
}
</style>
<template>
  <div class="layout">
    <Sider :style="{position: 'fixed', height: '100vh', left: 0, overflow: 'auto'}">
      <Menu active-name="1-1" theme="dark" width="auto" :open-names="['1']">
        <MenuItem name="1-1">
          <Icon type="logo-markdown" />
          <router-link to="/write" tag="span">Markdown</router-link>
        </MenuItem>
        <Submenu name="2">
          <template slot="title">
            <Icon type="ios-keypad"></Icon>博客管理
          </template>
          <MenuItem name="2-1">文章管理</MenuItem>
          <MenuItem name="2-2">评论管理</MenuItem>
          <MenuItem name="2-3">标签管理</MenuItem>
        </Submenu>
      </Menu>
    </Sider>
    <Layout :style="{marginLeft: '200px'}">
      <Header :style="{background: '#fff', boxShadow: '0 2px 3px 2px rgba(0,0,0,.1)'}"></Header>
      <Content :style="{padding: '0 16px 16px'}">
        <Card style="margin-top:20px;">
          <div>
            <main>
              <section>
                <!-- 题目--发表时间--标签--观看人数--点赞数--热度--摘要-->
                <article v-for="article in showArticles" :key="article.articleID">
                  <div class="descip">
                    <h2>{{article.title}}</h2>
                    <label>Posted on {{article.publicTime}}&nbsp;&nbsp;</label>
                    |
                    <label v-for="(label,id) in article.labels" :key="id">
                      <Icon type="md-pricetags" />
                      &nbsp;&nbsp;
                      {{label.label}}&nbsp;&nbsp;
                    </label>
                    <label>| visitors:{{article.readNum}}&nbsp;&nbsp;</label>
                  </div>
                  <div class="manage">
                    <router-link :to="'/write/'+ article.articleID" tag="span">
                      <Button type="primary" ghost icon="ios-brush" style="margin-right:30px;">编辑</Button>
                    </router-link>
                    <Button
                      type="primary"
                      ghost
                      icon="md-close"
                      @click="deleteArticle(article.articleID)"
                    >删除</Button>
                  </div>
                  <Divider id="divider" />
                </article>
              </section>
            </main>
            <div class="page">
              <Page
                :total="articles.length"
                :page-size="pageSize"
                @on-change="changePage"
                show-total
              />
            </div>
          </div>
        </Card>
      </Content>
    </Layout>
  </div>
</template>
<script>
import { mapState } from "vuex";
import { mapActions } from "vuex";
import { mapMutations } from "vuex";
import article from "../../network/common/api/article";

export default {
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
    ...mapMutations("article", ["changePage"]),
    /*readMore(id) {
      this.setContent(id);
      this.$route.params.id;
      this.$router.push({ path: "/content" });
    }*/
    deleteArticle(id) {
      article.deleteArticle(id).then(res => {
        console.log(res.data);
        this.getAllArticles();
      });
    }
  },
  mounted() {
    if (this.articles.length == 0) this.getAllArticles();
  }
};
</script>
