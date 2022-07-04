package com.kaia.kshop;

import com.kaia.kshop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class dbTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        System.out.println(userService.count(null));
    }

    @Test
    public void testRedis(){
        redisTemplate.opsForValue().set("token","1234");
    }

}
