package com.cutiechi.demo.dao;

import com.cutiechi.demo.model.entity.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 获取全部用户列表
     *
     * @return 全部用户列表
     */
    @Select("select user_id, user_name, user_password from user")
    List<User> listAll ();

    /**
     * 根据用户 ID 获取用户
     *
     * @param userId 用户 ID
     * @return 用户
     */
    @Select("select user_id, user_name, user_password from user where user_id = #{userId}")
    User getById (final Integer userId);


    /**
     * 根据用户 ID 删除用户
     *
     * @param userId 用户 ID
     */
    @Delete("delete from user where user_id = #{userId}")
    void deleteById (final Integer userId);
}
