package com.dcy.redis;

import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTest {

    /**
     * 该对象存泛型RedisTemplate<K, V> 可以对需要存储的东西进行序列化，也可以用redisTemplate的子类来进行专门数据类型处理。
     */
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads(){
        stringRedisTemplate.opsForValue().set("name","jack");
        String name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);
        stringRedisTemplate.opsForHash().put("user:123","name","dcy");
        BoundHashOperations<String, Object, Object> ops = stringRedisTemplate.boundHashOps("user:123");
        ops.put("age","1");
    }

    @Test
    public void hash(){
        BoundHashOperations<String, Object, Object> ops = stringRedisTemplate.boundHashOps("user:123");
        String name = (String) ops.get("name");
        System.out.println(name);
    }
}
