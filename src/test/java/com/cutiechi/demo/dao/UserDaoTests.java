package com.cutiechi.demo.dao;

import com.cutiechi.demo.ApplicationTests;
import com.cutiechi.demo.model.entity.User;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户数据访问接口测试类
 */
class UserDaoTests extends ApplicationTests {

    /**
     * Spring 自动注入用户数据访问接口
     */
    @Autowired
    private UserDao userDao;

    /**
     * 测试添加用户方法
     */
    @Test
    void testInsert () {
        userDao.insert(new User(null, "super", "123456"));
    }
}
