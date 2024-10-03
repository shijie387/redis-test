package com.atshijie.jedis.test;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class JedisTest {

    @Test
    public void testConnection() throws Exception{
        Jedis jedis = new Jedis("10.211.55.10", 6379);

        String ping = jedis.ping();
        System.out.println(ping);
    }

    @Test
    public void testGetRedisData() throws Exception{
        Jedis jedis = new Jedis("10.211.55.10", 6379);

        //string
        String k1 = jedis.get("k1");
        System.out.println("k1 = " + k1);

        //list
        List<String> k2 = jedis.lrange("k2", 0, -1);
        System.out.println("k2 as below");
        k2.forEach(System.out::println);

        //set
        Set<String> k4 = jedis.smembers("k4");
        System.out.println("k4 as below");
        k4.forEach(System.out::println);

        //hash
        Set<String> k6 = jedis.hkeys("k6");
        List<String> hvals = jedis.hvals("k6");
        System.out.println("k6 keys as below");
        k6.forEach(System.out::println);
        System.out.println("hvals as below");
        hvals.forEach(System.out::println);

        //zset
        Set<String> k7 = jedis.zrange("k7", 0, -1);
        System.out.println("k7 as below");
        k7.forEach(System.out::println);
    }
}
