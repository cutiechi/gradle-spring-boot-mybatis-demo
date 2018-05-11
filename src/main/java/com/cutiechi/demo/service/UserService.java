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

    /**
     * 获取全部用户列表
     *
     * @return 全部用户列表
     * @throws InternalServerErrorException 内部服务器错误异常
     */
    ServiceResult listAll () throws InternalServerErrorException;

    /**
     * 根据用户 ID 获取用户
     *
     * @param userId 用户 ID
     * @return 附带用户的业务逻辑结果
     * @throws InternalServerErrorException 内部服务器错误异常
     */
    ServiceResult getById (final Integer userId) throws InternalServerErrorException;

    /**
     * 根据用户 ID 删除用户
     *
     * @param userId 用户 ID
     * @return 附带删除用户的业务逻辑结果
     * @throws InternalServerErrorException 内部服务器错误异常
     */
    ServiceResult deleteById (final Integer userId) throws InternalServerErrorException;

    /**
     * 修改用户
     *
     * @param user 用户
     * @return 附带修改后用户的业务逻辑结果
     * @throws InternalServerErrorException 内部服务器错误异常
     */
    ServiceResult update (final User user) throws InternalServerErrorException;
}
