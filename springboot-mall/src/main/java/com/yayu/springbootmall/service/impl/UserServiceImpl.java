package com.yayu.springbootmall.service.impl;

import com.yayu.springbootmall.dao.UserDao;
import com.yayu.springbootmall.dto.UserLoginResquest;
import com.yayu.springbootmall.dto.UserRegisterRequest;
import com.yayu.springbootmall.model.User;
import com.yayu.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {

        //檢查註冊的email
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());

        if(user != null){
            logger.warn("該email {} 已被註冊",userRegisterRequest.getEmail());
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }else{
            //創建帳號
            return userDao.createUser(userRegisterRequest);
        }

    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public User login(UserLoginResquest userLoginResquest) {
        User user = userDao.getUserByEmail(userLoginResquest.getEmail());

        if(user == null){
            logger.warn("該email{}尚未註冊",userLoginResquest.getEmail());
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if(user.getPassword().equals(userLoginResquest.getPassword())){
            return user;
        } else{
            logger.warn("email{}的密碼不正確",userLoginResquest.getEmail());
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
