<template>
  <main>
    <section>
      <article v-for="article in articleList" :key="article.id">
        <h1>标题</h1>
        <p>内容</p>
      </article>
    </section>
  </main>
</template>

<style>
</style>

<script>
export default {
  data() {
    return {
      articleList: []
    };
  },
  mounted() {
    this.$api.article.getAllArticles().then(res => {
      console.log(res);
    });
  }
};
</script>