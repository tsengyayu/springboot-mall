package com.yayu.springbootmall.service.impl;

import com.yayu.springbootmall.dao.UserDao;
import com.yayu.springbootmall.dto.UserRegisterRequest;
import com.yayu.springbootmall.model.User;
import com.yayu.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
