package com.chen.boot05webadmin.service.Implement;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.boot05webadmin.bean.User;
import com.chen.boot05webadmin.mapper.UserMapper;
import com.chen.boot05webadmin.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
