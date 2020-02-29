import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from "../views/common/Home"
import Contact from "../views/common/Contact"
import Archives from "../views/common/Archives"
import Tags from "../views/common/Tags"
import Search from "../views/common/Search"
import Message from "../views/common/Message"
import Link from "../views/common/Link"
Vue.use(VueRouter)

const routes = [
  { path: "/", name: "index", redirect: "/home" },
  { path: "/home", name: "home", component: Home },
  { path: "/contact", name: "contact", component: Contact },
  { path: "/archives", name: "archives", component: Archives },
  { path: "/tags", name: "tags", component: Tags },
  { path: "/search", name: "search", component: Search },
  { path: "/message", name: "message", component: Message },
  { path: "/link", name: "link", component: Link }

]

const router = new VueRouter({
  routes
})

export default router
