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
  {
    path: "/", name: "index", redirect: "/home"
  },
  { path: "/articles", name: "articles", redirect: "/home" },
  {
    path: "/home", name: "home", component: Home, meta: { title: 'Civitasv\'s blog' }
  },
  { path: "/archives", name: "archives", component: Archives, meta: { title: 'Archives | Civitasv\'s blog' } },
  { path: "/tags", name: "tags", component: Tags, meta: { title: 'Tags | Civitasv\'s blog' } },
  { path: "/tags/:content", name: "tag", component: Tag },
  { path: "/search", name: "search", component: Search, meta: { title: 'Search | Civitasv\'s blog' } },
  { path: "/about", name: "about", component: About, meta: { title: 'About | Civitasv\'s blog' } },
  { path: "/link", name: "link", component: Link, meta: { title: 'Link | Civitasv\'s blog' } },
  { path: "/articles/:id", name: "content", component: Content },
  { path: "/login", name: "login", component: Login, meta: { title: 'Login | Civitasv\'s blog' } },
  {
    path: '/admin',
    name: 'admin',
    component: Admin,
    meta: {
      title: 'Admin | Civitasv\'s blog',
      requireAuth: true
    }
  },
  {
    path: "/write", name: "write", component: Write, meta: {
      title: 'Write | Civitasv\'s blog',
      requireAuth: true
    },
  },
  {
    path: "/write/:id", name: "update", component: Write, meta: {
      requireAuth: true
    }
  },
  {
    path: '*',    // 此处需特别注意至于最底部
    name: '404',
    component: () => import('../views/common/404'),
    meta: { title: '404 | Civitasv\'s blog' },
  }

]

const router = new VueRouter({
  mode: "history",
  routes
})

export default router
