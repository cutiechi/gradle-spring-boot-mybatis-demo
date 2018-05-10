package com.cutiechi.demo.dao;

import com.cutiechi.demo.model.entity.User;

import org.apache.ibatis.annotations.Insert;

import org.springframework.stereotype.Repository;

/**
 * 用户数据访问接口
 *
 * @author Cutie Chi
 */
@Repository
public interface UserDao {

    /**
     * 添加用户
     *
     * @param user 用户
     */
    @Insert("insert into user values (#{userId}, #{userName}, #{userPassword})")
    void insert (final User user);
}
