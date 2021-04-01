package com.nia.music.sys.admin.dao;

import com.nia.music.sys.admin.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 管理员表 Mapper 接口
 * </p>
 *
 * @author ganwei
 * @since 2021-03-31
 */
public interface AdminMapper extends BaseMapper<Admin> {

    Admin selectByPasswordAndUserName(@Param("userName") String userName, @Param("password")String password);
}
