import Vue from 'vue'
import App from './App.vue'
import router from './router/Router.js'
import store from "./store/index.js"
// 引入view-design
// import ViewUI from "view-design"
import ViewUI from "./assets/ViewUI"

// 引入css
import 'view-design/dist/styles/iview.css'
// import echarts from "echarts"
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import animate from "animate.css"
import tagCloud from 'v-tag-cloud'
import "./assets/css/page.css";
import "./assets/css/app.css";
import article from "./network/common/api/article";
import label from "./network/common/api/label";

Vue.use(animate)
// use
Vue.use(mavonEditor)
Vue.config.productionTip = false
// 安装ViewUI
// Vue.use(ViewUI)
Vue.use(ViewUI)
// 词云
Vue.use(tagCloud)

// 全局作用域
// Vue.prototype.$echarts = echarts

router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    if (store.state.user.user.username) {
      next()
    } else {
      next({
        path: 'login',
        query: { redirect: to.fullPath }
      })
    }
  } else {
    if (to.name === "content") {
      article.getArticleInfoByID(to.params.id).then(res => {
        document.title = res.data + " | Civitasv's blog"
      })
    } else if (to.name === "tag") {
      console.log(to)
      label.getLabelInfoByContent(to.params.content).then(res => {
        document.title = res.data + " | Civitasv's blog"
      })
    } else {
      document.title = to.meta.title || "Civitasv's blog"
    }
    next()
  }
}
)

new Vue({
  store,
  router,
  render: h => h(App)
}).$mount('#app')
