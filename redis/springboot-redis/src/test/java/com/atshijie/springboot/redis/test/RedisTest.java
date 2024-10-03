package com.atshijie.springboot.redis.test;

import com.atshijie.springboot.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testString() throws Exception{
        redisTemplate.opsForValue().set("hello", "world");
        System.out.println(redisTemplate.opsForValue().get("hello"));
    }
    @Test
    public void testSaveUser() throws Exception{
        User ls = new User(1002, "ls", 22);
        redisTemplate.opsForValue().set("ls", ls);
        User redisUser = (User) redisTemplate.opsForValue().get("ls");
        System.out.println(redisUser);
    }

    @Test
    public void testSerializer() throws Exception{

    }
}
