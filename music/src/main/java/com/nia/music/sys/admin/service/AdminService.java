package com.nia.music.sys.admin.service;

import com.nia.music.sys.admin.dao.AdminMapper;
import com.nia.music.sys.admin.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName AdminService
 * @Description 管理员表 业务服务类
 * @Author ganwei
 * @Date 2021/3/31 0:37
 * @VERSION 1.0
 **/
@Service
public class AdminService {

    @Resource
    private AdminMapper adminMapper;

    public boolean verifyLogin(String userName, String password){
        Admin admin = adminMapper.selectByPasswordAndUserName(userName, password);
        return admin != null;
    }

}
