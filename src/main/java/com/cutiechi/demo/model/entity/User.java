package com.cutiechi.demo.model.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户
 *
 * @author Cutie Chi
 */
@Getter
@Setter
public class User {

    /**
     * 用户 ID
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;
}
