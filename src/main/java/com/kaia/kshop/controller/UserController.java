package com.kaia.kshop.controller;


import com.alibaba.fastjson.JSON;
import com.kaia.kshop.entity.Result;
import com.kaia.kshop.entity.User;
import com.kaia.kshop.entity.Vo.UserVo;
import com.kaia.kshop.service.UserService;
import com.kaia.kshop.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kaia
 * @since 2022-05-26
 */
@RestController
@RequestMapping("/kshop/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public void login(@RequestParam String username, @RequestParam String password, HttpServletResponse response, HttpServletRequest request) throws IOException {
        if(!StringUtils.hasText(username) || !StringUtils.hasText(password)){
            request.setAttribute("message","账号密码不能为空");
            return ;
        }
        UserVo user = userService.login(username,password);
        /** 账号错误时 **/
        if(Objects.isNull(user)){
            request.setAttribute("message","账号或密码错误");
            return ;
        }

        String token = JwtUtil.createJWT(JSON.toJSONString(user));
        request.setAttribute("token",token);
        response.sendRedirect("/success.jsp");


    }

    @PostMapping("/register")
    public Result register(@RequestBody User user){

        boolean registerResult = userService.register(user);

        if(!registerResult){
            return Result.error().message("注册失败");
        }

        return Result.ok().message("注册成功");
    }

}

