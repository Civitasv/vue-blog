import base from "./base"
import axios from "../request" // 导入axios实例
// import qs from "qs"

const label = {
    // 全部新闻
    getAllLabels() {
        return axios.get(`${base.blog}/labels/`);
    },
    // 根据ID获取
    getLabelByID(labelID) {
        return axios.get(`${base.blog}/labels/${labelID}`)
    }
}

export default label;