const state = {
    user: {
        username: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).username
    }
}

// getters
const getters = {

}

// actions
const actions = {
}

// mutatios
const mutations = {
    login(state, user) {
        state.user = user
        window.localStorage.setItem('user', JSON.stringify(user))
    }
}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}