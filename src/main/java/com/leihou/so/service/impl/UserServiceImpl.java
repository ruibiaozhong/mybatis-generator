package com.leihou.so.service.impl;

import com.leihou.so.mapper.UserMapper;
import com.leihou.so.entity.User;
import com.leihou.so.service.UserService;
import com.leihou.so.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * Created by ruibiaozhong on 2018/10/19.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

}
