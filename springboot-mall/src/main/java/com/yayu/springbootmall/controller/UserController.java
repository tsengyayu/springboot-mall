package com.yayu.springbootmall.controller;

import com.yayu.springbootmall.dto.UserLoginResquest;
import com.yayu.springbootmall.dto.UserRegisterRequest;
import com.yayu.springbootmall.model.User;
import com.yayu.springbootmall.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest){
        Integer userId = userService.register(userRegisterRequest);
        User user = userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/users/login")
    public ResponseEntity<User> login(@RequestBody @Valid UserLoginResquest userLoginResquest){

        User user = userService.login(userLoginResquest);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
