package com.yexh.mybatistest.dao;

import com.yexh.mybatistest.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
class UserDaoTests {
    @Resource
    private UserDao userDao;

    @Test
    void batchInsert() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setName("user"+i);
            list.add(user);
        }
        userDao.batchInsertUser(list);
        for (User user: list){
            System.out.println(user.getId());
        }
    }

}
