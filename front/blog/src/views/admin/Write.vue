<template>
  <div id="write">
    <Input v-model="article.title" placeholder="输入文章标题" clearable />
    <mavon-editor
      v-model="article.content"
      :ishljs="true"
      ref="md"
      @imgAdd="$imgAdd"
      @imgDel="$imgDel"
      @save="$save"
    ></mavon-editor>
  </div>
</template>

<script>
import admin from "../../network/admin/api/admin";

export default {
  data() {
    return {
      content: "",
      img_file: [],
      article: {
        content: "",
        publicTime: "",
        title: "",
        digest: "",
        labels: []
      }
    };
  },
  methods: {
    // 绑定@imgAdd event
    $imgAdd(pos, $file) {
      // 第一步.将图片上传到服务器.
      var formdata = new FormData();
      formdata.append("image", $file);
      this.img_file[pos] = $file;
      admin.uploadImage(formdata).then(res => {
        let _res = res.data;
        // 第二步.将返回的url替换到文本原位置![...](0) -> ![...](url)
        this.$refs.md.$img2Url(pos, _res.url);
      });
    },
    $imgDel(pos) {
      delete this.img_file[pos];
    },
    $save() {
      console.log(this.article);
    }
  }
};
</script>