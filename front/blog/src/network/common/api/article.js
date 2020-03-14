import base from "./base"
import axios from "../request" // 导入axios实例
// import qs from "qs"

const article = {
    // 全部新闻
    getAllArticles() {
        return axios.get(`${base.blog}/articles/`);
    },
    // 根据ID获取
    getArticleByID(articleID) {
        return axios.get(`${base.blog}/articles/${articleID}`)
    }
}

export default article;