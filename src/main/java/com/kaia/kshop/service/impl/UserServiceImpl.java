package com.kaia.kshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kaia.kshop.entity.Result;
import com.kaia.kshop.entity.User;
import com.kaia.kshop.entity.Vo.UserVo;
import com.kaia.kshop.mapper.UserMapper;
import com.kaia.kshop.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kaia
 * @since 2022-05-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /** 登录 **/
    @Override
    public UserVo login(String username, String password) {

        /** 账号错误 **/
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,username);
        User user = getOne(queryWrapper);
        if(Objects.isNull(user)){
            return null;
        }

        /** 密码错误 **/
        if(!user.getPassword().equals(password)){
            return null;
        }

        /**封装user**/
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user,userVo);

        return userVo;
    }


    /** 注册 **/
    @Override
    public boolean register(User user) {
        /** 用户信息不全 **/
        if(user.getUsername() == null || user.getPassword() == null){
            return false;
        }
        /** 判断用户名（手机号）是否存在 **/
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,user.getUsername());
        if(count(queryWrapper) != 0){
            return false;
        }

        save(user);
        return true;
    }

}
