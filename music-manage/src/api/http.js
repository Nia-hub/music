import axios from 'axios';
//axios到后台请求超时时间为5秒
axios.defaults.timeout = 5000;
//允许跨域访问
axios.defaults.withCredentials = true;
//Content-Type 响应头
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';
//基础url
axios.defaults.baseURL = 'http://localhost:8888'

//响应拦截器
axios.interceptors.response.use(
    response => {
        //如果response里的status是200，说明已访问到接口，否则错误
        if (response.status == 200) {
            //Promise用于处理异步访问
            return Promise.resolve(response);
        } else {
            return Promise.reject(response);
        }
    },
    error => {
        if (error.response.status) {
            switch (error.response.status) {
                case 401:
                    router.replace({
                        path: '/',
                        query: {
                            redirect: router.currentRoute.fullPath
                        }
                    })
                    break;
                case 404: //未找到
                    break;
            }
            return Promise.reject(error.response);
        }
    }
);

/**
 * 封装get方法
 * @param {*} url 
 * @param {*} params get请求参数传递--a&b&c...
 * @returns 
 */
export function get(url, params = {}) {
    return new Promise((resolve, reject) => {
        axios.get(url, {
            params: params
        }).then(response => {
            resolve(response.data);
        }).catch(err => {
            reject(err)
        })
    });
}

/**
 * 封装post方法
 * @param {*} url 
 * @param {*} data post请求参数传递以表单形式--对象
 * @returns 
 */
export function post(url, data = {}) {
    return new Promise((resolve, reject) => {
        axios.post(url, data).then(response => {
            resolve(response.data);
        }).catch(err => {
            reject(err)
        })
    });
}
