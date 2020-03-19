import Vue from 'vue'
import Vuex from "vuex"
import article from "./modules/article"
import label from "./modules/label"
import user from "./modules/user"

Vue.use(Vuex)

const debug = process.env.NODE_ENV !== 'production'

const store = new Vuex.Store({
    modules: {
        article, label, user
    },
    strict: debug
})

export default store