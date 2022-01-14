package com.liudi.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liudi.entity.SysUser;
import com.liudi.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<SysUser> {


    List<SysUser> getLiveUser();

}