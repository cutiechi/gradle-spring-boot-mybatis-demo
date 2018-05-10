package com.cutiechi.demo.dao;

import com.cutiechi.demo.model.entity.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import org.springframework.stereotype.Repository;

/**
 * 用户数据访问接口
 *
 * @author Cutie Chi
 */
@Repository
public interface UserDao {

    /**
     * 通过用户名称获取用户
     *
     * @param userName 用户名称
     * @return 用户
     */
    @Select("select user_id, user_name, user_password from user where user_name = #{userName}")
    User getByName (final String userName);

    /**
     * 添加用户
     *
     * @param user 用户
     */
    @Insert("insert into user values (#{userId}, #{userName}, #{userPassword})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    void insert (final User user);
}
