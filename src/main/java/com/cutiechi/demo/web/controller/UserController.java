package com.cutiechi.demo.web.controller;

import com.cutiechi.demo.exception.InternalServerErrorException;
import com.cutiechi.demo.model.dto.JsonResponse;
import com.cutiechi.demo.model.dto.ServiceResult;
import com.cutiechi.demo.model.entity.User;
import com.cutiechi.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户 REST 控制器
 *
 * @author Cutie Chi
 */
@CrossOrigin
@RequestMapping("/users")
@RestController
public final class UserController {

    /**
     * 用户业务逻辑对象
     */
    private final UserService userService;

    /**
     * Spring 自动注入
     *
     * @param userService 用户业务逻辑对象
     */
    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }

    /**
     * 添加用户, API 为 POST 请求 /users
     *
     * @param user 用户
     * @return JSON 响应
     * @throws InternalServerErrorException 内部服务器错误异常
     */
    @PostMapping("")
    public JsonResponse insert (@RequestBody User user) throws InternalServerErrorException {

        // 获取添加用户业务逻辑结果对象
        ServiceResult result = userService.insert(user);

        // 根据业务逻辑是否成功返回 JSON 响应
        return result.getStatus()
            ? new JsonResponse(20000, result.getMessage(), result.getResult())
            : new JsonResponse(40000, result.getMessage());
    }
}
