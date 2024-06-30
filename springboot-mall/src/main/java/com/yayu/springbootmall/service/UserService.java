package com.yayu.springbootmall.service;

import com.yayu.springbootmall.dto.UserRegisterRequest;
import com.yayu.springbootmall.model.User;

public interface UserService {

    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);


}
