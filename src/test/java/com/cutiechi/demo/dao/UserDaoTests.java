package com.cutiechi.demo.dao;

import com.cutiechi.demo.ApplicationTests;
import com.cutiechi.demo.model.entity.User;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
     * 测试根据用户名称取用户方法
     */
    @Test
    void testGetByName () {
        final String userName = "super";
        System.out.println(userDao.getByName(userName));
    }

    /**
     * 测试添加用户方法
     */
    @Test
    void testInsert () {
        userDao.insert(new User(null, "super", "123456"));
    }
}
