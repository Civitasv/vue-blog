import Vue from 'vue'
import Vuex from "vuex"
import blog from "./modules/blog"

Vue.use(Vuex)

const debug = process.env.NODE_ENV !== 'production'

const store = new Vuex.Store({
    modules: {
        blog
    },
    strict: debug
})

export default store