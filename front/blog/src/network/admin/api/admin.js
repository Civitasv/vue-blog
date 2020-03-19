import base from "./base"
import axios from "../request" // 导入axios实例
// import qs from "qs"

const admin = {
    // 全部新闻
    uploadImage(formdata) {
        return axios.post(`${base.blog}/upload/`, formdata);
    },
    save(article) {
        return axios.post(`${base.blog}/save/`, article);
    }
}

export default admin;