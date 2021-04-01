package com.nia.music.sys.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.nia.music.sys.admin.constants.Constants;
import com.nia.music.sys.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author ganwei
 * @since 2021-03-31
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(HttpServletRequest request, HttpSession session){

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        JSONObject jsonObject = new JSONObject();
        boolean flag = adminService.verifyLogin(userName, password);
        if (flag){
            jsonObject.put(Constants.CODE, 1);
            jsonObject.put(Constants.MSG, "登录成功");
            session.setAttribute(Constants.NAME, userName);
            return jsonObject;
        }

        jsonObject.put(Constants.CODE, 2);
        jsonObject.put(Constants.MSG, "用户或密码错误");

        return jsonObject;
    }


}

