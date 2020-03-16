import article from "../../network/common/api/article"

const state = {
    articles: [],
    showArticles: [],
    pageSize: 10
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
        if (state.articles.length < state.pageSize) {
            state.showArticles = state.articles;
        } else {
            state.showArticles = state.articles.slice(0, state.pageSize);
        }
    },
    changePage(state, index) {
        console.log(index)
        var _start = (index - 1) * state.pageSize;
        var _end = index * state.pageSize;
        state.showArticles = state.articles.slice(_start, _end);
    }
}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}