import base from "./base"
import axios from "../request" // 导入axios实例

const article = {
    // 全部新闻
    getAllArticles() {
        return axios.get(`${base.blog}/articles/`);
    },
    // 根据ID获取
    getArticleByID(articleID) {
        return axios.get(`${base.blog}/articles/${articleID}`)
    },
    getArticleInfoByID(articleID) {
        return axios.get(`${base.blog}/articles/info/${articleID}`)
    },
    saveArticle(article, labels) {
        return axios.post(
            `${base.blog}/articles/`,
            { article: article, labels: labels });
    },
    deleteArticle(articleID) {
        return axios.delete(`${base.blog}/articles/${articleID}`)
    },
    updateArticle(article) {
        return axios.put(`${base.blog}/articles/`, article);
    },
    addReadNum(articleID) {
        return axios.put(`${base.blog}/articles/read/${articleID}`);
    }
}

export default article;