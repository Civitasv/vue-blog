<template>
  <div id="write">
    <div class="title">
      <router-link to="/admin" tag="span" class="back">
        <Icon type="ios-arrow-back" size="30" />
      </router-link>
      <Input class="titleContent" v-model="article.title" placeholder="输入文章标题..." clearable />
      <Button type="warning" @click="flag=!flag">发布文章</Button>
    </div>
    <Card v-show="flag">
      <div class="para">
        <h3>发布文章</h3>
        <label>文章标签:</label>
        <span @click="flag2=!flag2">
          <Icon type="ios-add-circle-outline" />添加标签
        </span>
        <Card v-show="flag2 && !updateFlag">
          <Button shape="circle" v-for="(label,id) in labels" :key="id">
            {{label}}
            <Icon type="ios-close" @click="deleteLabel(id)" />
          </Button>
          <Input
            class="tags"
            placeholder="Enter键入可添加自定义标签"
            @on-enter="addLabel"
            v-model="label"
            clearable
          />
        </Card>
        <div class="digest">
          <Input
            v-model="article.digest"
            type="textarea"
            :autosize="{minRows: 2,maxRows: 5}"
            placeholder="摘要"
          />
        </div>
        <div class="btn">
          <Button type="warning" @click="updateFlag?$update():$save()">发布文章</Button>
        </div>
      </div>
    </Card>
    <mavon-editor
      v-model="article.content"
      :ishljs="true"
      ref="md"
      @imgAdd="$imgAdd"
      @imgDel="$imgDel"
    ></mavon-editor>
  </div>
</template>

<style scoped>
.title {
  margin: 10px 10px 20px 20px;
  width: 70%;
  display: flex;
}
.titleContent {
  margin-right: 20px;
}
.back {
  cursor: pointer;
}
.para span {
  cursor: pointer;
}
</style>
<script>
import admin from "../../network/admin/api/admin";
import article from "../../network/common/api/article";

export default {
  data() {
    return {
      flag: false,
      flag2: false,
      content: "",
      label: "",
      article: {
        content: "",
        publicTime: 0,
        title: "",
        digest: ""
      },
      labels: [],
      updateFlag: false,
      updateID: -1,
      images: []
    };
  },
  methods: {
    init() {
      let articleID = this.$route.params.id;
      if (typeof articleID != "undefined") {
        console.log("enter");
        this.updateFlag = true;
        this.updateID = articleID;
        article.getArticleByID(articleID).then(res => {
          this.article.content = res.data.content;
          this.article.publicTime = res.data.publicTime;
          this.article.title = res.data.title;
        });
      }
    },
    // 绑定@imgAdd event
    $imgAdd(pos, $file) {
      // 第一步.将图片上传到服务器.
      var formdata = new FormData();
      formdata.append("image", $file);
      admin.uploadImage(formdata).then(res => {
        let _res = res.data;
        // 第二步.将返回的url替换到文本原位置![...](0) -> ![...](url)
        this.$refs.md.$img2Url(pos, _res.url);
        this.images[pos] = _res.image;
      });
    },
    $imgDel(pos) {
      console.log("deles");
      admin.deleteImage(this.images[pos]).then(res => {
        alert(res.data);
      });
      delete this.images[pos];
    },
    $save() {
      // 弹出
      // 获取当前时间
      var timestamp = new Date().getTime();
      this.article.publicTime = timestamp;
      article.saveArticle(this.article, this.labels).then(res => {
        console.log(res.data);
        alert("保存成功！");
      });
    },
    $update() {
      article
        .updateArticle({
          articleID: this.updateID,
          content: this.article.content,
          publicTime: this.article.publicTime,
          title: this.article.title,
          digest: this.article.digest
        })
        .then(res => {
          console.log(res.data);
          alert("更新成功！");
        });
    },
    addLabel() {
      console.log("add");
      this.labels.push(this.label);
    },
    deleteLabel(id) {
      this.labels.splice(id, 1);
    }
  },
  mounted() {
    this.init();
  }
};
</script>