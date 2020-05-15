import base from "./base"
import axios from "../request" // 导入axios实例
// import qs from "qs"

const label = {
    // 全部新闻
    getAllLabels() {
        return axios.get(`${base.blog}/labels/`);
    },
    // 根据ID获取
    getLabelByContent(content) {
        return axios.get(`${base.blog}/labels/${content}`)
    },
    // 根据ID获取
    getLabelInfoByContent(content) {
        return axios.get(`${base.blog}/labels/info/${content}`)
    }
}

export default label;