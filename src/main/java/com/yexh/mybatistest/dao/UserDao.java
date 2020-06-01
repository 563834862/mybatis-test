package com.yexh.mybatistest.dao;

import com.yexh.mybatistest.entity.User;

import java.util.List;

/**
 * Created by 18396 on 2020/6/2 6:58
 */
public interface UserDao {
    void batchInsertUser(List<User> list);
}
