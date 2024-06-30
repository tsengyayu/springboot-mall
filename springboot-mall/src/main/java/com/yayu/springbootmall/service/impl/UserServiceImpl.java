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
import org.springframework.util.DigestUtils;
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
            //使用MD5 生成密碼的雜湊值
            String hashedPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes());
            userRegisterRequest.setPassword(hashedPassword);
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

        //檢查user是否存在
        if(user == null){
            logger.warn("該email{}尚未註冊",userLoginResquest.getEmail());
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        //使用MD5 生成密碼的雜湊值
        String hashedPassword = DigestUtils.md5DigestAsHex(userLoginResquest.getPassword().getBytes());

        //檢查密碼是否符合
        if(user.getPassword().equals(hashedPassword)){
            return user;
        } else{
            logger.warn("email{}的密碼不正確",userLoginResquest.getEmail());
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
