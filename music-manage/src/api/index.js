import {get, post} from './http';

//判断管理员是否登录成功
export const adminLoginStatus = (params) => post(`admin/login`, params)