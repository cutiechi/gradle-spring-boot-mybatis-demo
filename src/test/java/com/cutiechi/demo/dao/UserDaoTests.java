package com.cutiechi.demo.dao;

import com.cutiechi.demo.ApplicationTests;

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
}
