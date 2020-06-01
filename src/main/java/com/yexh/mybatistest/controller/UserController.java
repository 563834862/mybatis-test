package com.yexh.mybatistest.controller;

import com.yexh.mybatistest.dao.UserDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by 18396 on 2020/6/2 7:12
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserDao userDao;

    @RequestMapping("/insert")
    public void batchInsert(){
    }
}
