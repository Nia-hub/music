package com.nia.music.sys.admin.service.impl;

import com.nia.music.sys.admin.entity.Admin;
import com.nia.music.sys.admin.dao.AdminMapper;
import com.nia.music.sys.admin.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author ganwei
 * @since 2021-03-31
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
