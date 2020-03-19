import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from "../views/common/Home"
import Archives from "../views/common/Archives"
import Tags from "../views/common/Tags"
import Search from "../views/common/Search"
import About from "../views/common/About"
import Link from "../views/common/Link"
import Content from "../views/common/Article"
import Tag from "../views/common/Tag"
import Admin from "../views/admin/Admin"
import Login from "../views/admin/Login"
import Write from "../views/admin/Write"

Vue.use(VueRouter)

const routes = [
  { path: "/", name: "index", redirect: "/home" },
  { path: "/articles", name: "articles", redirect: "/home" },
  {
    path: "/home", name: "home", component: Home
  },
  { path: "/archives", name: "archives", component: Archives },
  { path: "/tags", name: "tags", component: Tags },
  { path: "/tags/:id", name: "tag", component: Tag },
  { path: "/search", name: "search", component: Search },
  { path: "/about", name: "about", component: About },
  { path: "/link", name: "link", component: Link },
  { path: "/articles/:id", name: "content", component: Content },
  { path: "/login", name: "login", component: Login },
  {
    path: '/admin',
    name: 'admin',
    component: Admin,
    meta: {
      requireAuth: true
    }
  },
  { path: "/write", name: "write", component: Write },

]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router
