package com.jnu.community.service;

import com.jnu.community.dao.UserMapper;
import com.jnu.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id){
        User user = userMapper.selectById(id);
        return user;
    }
}
