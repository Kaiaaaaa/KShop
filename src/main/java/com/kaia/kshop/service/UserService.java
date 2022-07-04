package com.kaia.kshop.service;

import com.kaia.kshop.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kaia.kshop.entity.Vo.UserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kaia
 * @since 2022-05-26
 */
public interface UserService extends IService<User> {

    UserVo login(String username, String password);

    boolean register(User user);
}
