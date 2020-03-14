import article from "../../network/common/api/article"

const state = {
    articles: []
}

// getters
const getters = {

}

// actions
const actions = {
    getAllArticles({ commit }) {
        article.getAllArticles().then(
            function (res) {
                commit('setArticles', res.data);
            }
        )
    }
}

// mutatios
const mutations = {
    setArticles(state, articles) {
        state.articles = articles;
    }
}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}