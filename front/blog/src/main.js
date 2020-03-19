import Vue from 'vue'
import App from './App.vue'
import router from './router/Router.js'
import store from "./store/index.js"
// 引入view-design
import ViewUI from "view-design"
// 引入css
import 'view-design/dist/styles/iview.css'
import echarts from "echarts"
// 导入axios api
import api from "./network/common/api"
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import animate from "animate.css"
import tagCloud from 'v-tag-cloud'
import "./assets/css/page.css";

Vue.use(animate)
// use
Vue.use(mavonEditor)
Vue.config.productionTip = false
// 安装ViewUI
Vue.use(ViewUI)
// 词云
Vue.use(tagCloud)

// 全局作用域
Vue.prototype.$echarts = echarts
// 挂载api
Vue.prototype.$api = api

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
    next()
  }
}
)

new Vue({
  store,
  router,
  render: h => h(App)
}).$mount('#app')
