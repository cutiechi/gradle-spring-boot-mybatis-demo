package com.cutiechi.demo.service;

import com.cutiechi.demo.exception.InternalServerErrorException;
import com.cutiechi.demo.model.dto.ServiceResult;
import com.cutiechi.demo.model.entity.User;

/**
 * 用户业务逻辑接口
 *
 * @author Cutie Chi
 */
public interface UserService {

    /**
     * 添加用户
     *
     * @param user 用户
     * @return 业务逻辑结果
     * @throws InternalServerErrorException 内部服务器错误异常
     */
    ServiceResult insert (final User user) throws InternalServerErrorException;
}
