import base from "./base"
import axios from "../request" // 导入axios实例
// import qs from "qs"

const user = {
    validateLogin(username, password) {
        return axios.post(`${base.blog}/admin/`, {
            username: username,
            password: password
        });
    },
}

export default user;