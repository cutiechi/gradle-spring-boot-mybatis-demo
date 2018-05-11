package com.cutiechi.demo.service.impl;

import com.cutiechi.demo.dao.UserDao;
import com.cutiechi.demo.exception.InternalServerErrorException;
import com.cutiechi.demo.model.dto.ServiceResult;
import com.cutiechi.demo.model.entity.User;
import com.cutiechi.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 获取全部用户列表
     *
     * @return 全部用户列表
     * @throws InternalServerErrorException 内部服务器错误异常
     */
    @Override
    public ServiceResult listAll () throws InternalServerErrorException {
        try {

            // 获取全部用户列表
            List<User> users = userDao.listAll();

            // 获取成功返回附带用户列表的业务逻辑列表
            return ServiceResult.success("获取全部用户列表成功！", users);
        } catch (Exception exception) {

            // 获取失败抛出内部服务器错误异常
            throw new InternalServerErrorException("服务器错误，获取全部用户列表失败！");
        }
    }

    /**
     * 根据用户 ID 获取用户
     *
     * @param userId 用户 ID
     * @return 附带用户的业务逻辑结果
     * @throws InternalServerErrorException 内部服务器错误异常
     */
    @Override
    public ServiceResult getById (Integer userId) throws InternalServerErrorException {
        try {

            // 根据用户 ID 获取用户
            User user = userDao.getById(userId);

            // 判断用户是否为 null
            if (null != user) {

                // 用户不为 null 返回附带用户的业务逻辑结果
                return ServiceResult.success("获取用户成功！", user);
            } else {

                // 用户为 null 返回附带错误信息的业务逻辑结果
                return ServiceResult.fail("用户不存在，获取用户失败！");
            }
        } catch (Exception e) {

            // 获取失败抛出内部服务器错误异常
            throw new InternalServerErrorException("服务器错误，获取用户失败！");
        }
    }

    /**
     * 根据用户 ID 删除用户
     *
     * @param userId 用户 ID
     * @return 附带删除用户的业务逻辑结果
     * @throws InternalServerErrorException 内部服务器错误异常
     */
    @Override
    public ServiceResult deleteById (Integer userId) throws InternalServerErrorException {
        try {

            // 删除前根据 ID 获取要删除的用户
            User user = userDao.getById(userId);

            // 判断用户是否存在
            if (null != user) {

                // 获取到的用户不为空根据用户 ID 删除用户
                userDao.deleteById(userId);

                // 删除成功返回附带 user 对象的业务逻辑结果
                return ServiceResult.success("删除用户成功！", user);
            } else {

                // 用户不存在返回附带错误信息的业务逻辑结果
                return ServiceResult.fail("用户不存在，删除用户失败！");
            }
        } catch (Exception exception) {

            // 根据 ID 获取用户或删除失败抛出内部服务器错误异常
            throw new InternalServerErrorException("服务器错误，删除用户失败！");
        }
    }

    /**
     * 修改用户
     *
     * @param user 用户
     * @return 附带修改后用户的业务逻辑结果
     * @throws InternalServerErrorException 内部服务器错误异常
     */
    @Override
    public ServiceResult update (final User user) throws InternalServerErrorException {
        try {

            // 删除前先根据用户 ID 获取用户修改之前的信息
            final User oldUser = userDao.getById(user.getUserId());

            // 判断用户是否存在
            if (null != oldUser) {

                // oldUser 不为 null, 说明用户存在, 获取新旧用户名
                final String oldUserName = oldUser.getUserName();
                final String newUserName = user.getUserName();

                // 判断新旧用户名是否相等
                if (!oldUserName.equals(newUserName)) {

                    // 不相等判断新用户名是否已经使用
                    if (null != userDao.getByName(newUserName)) {

                        // 已经使用返回附带错误信息的业务逻辑结果
                        return ServiceResult.fail("用户名已存在，修改用户失败！");
                    }
                }

                // 修改用户
                userDao.update(user);

                // 返回附带修改后用户的业务逻辑结果
                return ServiceResult.success("修改用户成功！", user);
            } else {

                // oldUser 为 null, 说明用户不存在, 返回附带错误信息的业务逻辑结构钢
                return ServiceResult.fail("用户不存在，修改用户失败！");
            }
        } catch (Exception exception) {
            throw new InternalServerErrorException("服务器错误，修改用户失败！");
        }
    }
}
