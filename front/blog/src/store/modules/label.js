import label from "../../network/common/api/label"

const state = {
    labels: []
}

// getters
const getters = {

}

// actions
const actions = {
    getAllLabels({ commit }) {
        label.getAllLabels().then(
            function (res) {
                commit('setLabels', res.data);
            }
        )
    }
}

// mutatios
const mutations = {
    setLabels(state, labels) {
        state.labels.splice(0, state.labels.length);
        for (var i = 0; i < labels.length; i++) {
            var obj = {
                name: labels[i].label,
                articles: labels[i].articles
            }
            state.labels.push(obj);
        }
    }
}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}