<template>
<body id="poster">
  <Form class="login-container" label-position="left">
    <h3 class="login_title">博客管理登录</h3>
    <FormItem>
      <Input type="text" v-model="loginForm.username" auto-complete="off" placeholder="账号" />
    </FormItem>
    <FormItem>
      <Input type="password" v-model="loginForm.password" auto-complete="off" placeholder="密码" />
    </FormItem>
    <FormItem style="width: 100%">
      <Button
        type="primary"
        style="width: 100%;background: #505458;border: none"
        v-on:click="validateLogin"
      >登录</Button>
    </FormItem>
  </Form>
</body>
</template>

<script>
import user from "../../network/common/api/user";
import { mapMutations } from "vuex";

export default {
  name: "Login",
  data() {
    return {
      loginForm: {
        username: "",
        password: ""
      },
      responseResult: []
    };
  },
  methods: {
    ...mapMutations("user", ["login"]),
    validateLogin() {
      var _this = this;
      user
        .validateLogin(this.loginForm.username, this.loginForm.password)
        .then(successResponse => {
          if (successResponse.data === 200) {
            _this.login(_this.loginForm);
            var path = this.$route.query.redirect;
            this.$router.replace({
              path: path === "/" || path === undefined ? "/admin" : path
            });
          }
        });
    }
  }
};
</script>

<style>
#poster {
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}
body {
  margin: 0px;
}
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
</style>

