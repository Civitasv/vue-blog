import base from "./base"
import axios from "../request" // 导入axios实例
// import qs from "qs"

const article = {
    // 全部新闻
    getAllArticles() {
        return axios.get(`${base.blog}/articles`);
    }
    // 其它...
}

export default article;