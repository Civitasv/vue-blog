<template>
  <div class="markdown-body">
    <mavon-editor class="md" v-model="article"></mavon-editor>
  </div>
</template>

<script>
export default {
  data() {
    return {
      article: ""
    };
  },
  watch: {
    article: function() {
      console.log(this.article);
    }
  },
  methods: {},
  mounted() {},
  components: {}
};
</script>