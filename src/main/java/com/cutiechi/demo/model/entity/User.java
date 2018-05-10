package com.cutiechi.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户
 *
 * @author Cutie Chi
 */
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString
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
