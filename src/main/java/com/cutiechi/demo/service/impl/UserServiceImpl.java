package com.cutiechi.demo.service.impl;

import com.cutiechi.demo.dao.UserDao;
import com.cutiechi.demo.exception.InternalServerErrorException;
import com.cutiechi.demo.model.dto.ServiceResult;
import com.cutiechi.demo.model.entity.User;
import com.cutiechi.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务逻辑实现类
 *
 * @author Cutie Chi
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 用户数据访问接口对象
     */
    private final UserDao userDao;

    /**
     * Spring 自动注入
     *
     * @param userDao 用户数据访问接口对象
     */
    @Autowired
    public UserServiceImpl (UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 添加用户
     *
     * @param user 用户
     * @return 业务逻辑结果
     * @throws InternalServerErrorException 内部服务器错误异常
     */
    @Override
    public ServiceResult insert (User user) throws InternalServerErrorException {

        // 添加用户前判断用户名称是否已存在
        if (null != userDao.getByName(user.getUserName())) {

            // 用户名已存在返回附带错误信息的业务逻辑结果
            return ServiceResult.fail("用户名已存在，添加用户失败！");
        } else {
            try {

                // 用户名不存在添加用户, 添加成功会将自增的主键给 user 对象
                userDao.insert(user);

                // 添加成功返回附带添加的用户的业务逻辑结果
                return ServiceResult.success("添加用户成功！", user);
            } catch (Exception exception) {

                // 添加失败抛出内部服务器错误异常
                throw new InternalServerErrorException("服务器错误，添加用户失败！");
            }
        }
    }
}
