package com.yayu.springbootmall.dao;

import com.yayu.springbootmall.dto.UserRegisterRequest;
import com.yayu.springbootmall.model.User;

public interface UserDao {

    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User getUserByEmail(String email);
}
