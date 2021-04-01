<template>
    <div class="login-wrap">
        <div class="ms-title">music 后台管理登录</div>
        <div class="ms-login">
            <el-form :model="loginForm" :rules="rules" ref="loginForm">
                <el-form-item prop="userName">
                    <el-input v-model="loginForm.userName" placeholder="请输入用户名"></el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input type="password" v-model="loginForm.password" placeholder="请输入用户名"></el-input>
                </el-form-item>
            </el-form>
            <div class="login-btn">
                <el-button type="primary" @click="submitForm">登录</el-button>
            </div>
        </div>
    </div>
</template>

<script>
import { adminLoginStatus } from "../api/index";
import { baseUtil } from "../baseUtil/index.js";
export default {
    baseUtil: [baseUtil],
    data() {
        return {
            loginForm: {
                userName: "admin",
                password: "123",
            },
            rules: {
                userName: [
                    {
                        required: true,
                        message: "请输入用户名",
                        trigger: "blur",
                    },
                ],
                password: [
                    {
                        required: true,
                        message: "请输入密码",
                        trigger: "blur",
                    },
                ],
            },
        };
    },
    methods: {
        submitForm() {
            let params = new URLSearchParams();
            params.append("userName", this.loginForm.userName);
            params.append("password", this.loginForm.password);
            adminLoginStatus(params).then((res) => {
                if (res.code == 1) {
                    this.notify("登陆成功", "success");
                } else {
                    this.notify("登录失败", "error");
                }
            });
        },
    },
};
</script>

<style scoped>
.login-wrap {
    position: relative;
    background: url("../assets/img/background.jpg");
    background-attachment: fixed;
    background-position: center;
    background-size: cover;
    width: 100%;
    height: 100%;
}
.ms-title {
    position: absolute;
    top: 50%;
    width: 100%;
    margin-top: -230px;
    text-align: center;
    font-size: 30px;
    font-weight: 600;
    color: #fff;
}
.ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 300px;
    height: 160px;
    margin-left: -190px;
    margin-top: -150px;
    padding: 40px;
    border-radius: 5px;
    background: #fff;
}
.login-btn {
    text-align: center;
}
.login-btn button {
    width: 100%;
    height: 36px;
}
</style>
