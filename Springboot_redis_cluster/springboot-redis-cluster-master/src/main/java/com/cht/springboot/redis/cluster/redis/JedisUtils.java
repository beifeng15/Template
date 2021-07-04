/*
package com.cht.springboot.redis.cluster.redis;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

*/
/**
 * @Description TODO
 * @Author Mr.Wu
 * @Date 2020/11/10 16:27
 * @Version 1.0
 **//*

public class JedisUtils {


    */
/**
     * 自动注入Redis连接实例对象线程池
     *//*

    @Autowired
    private JedisPool jedisPool;

    */
/**
     * 获取Jedis对象
     *
     * @return
     *//*

    public synchronized Jedis getJedis() {
        Jedis jedis = null;
        if (jedisPool != null) {
            try {
                if (jedis == null) {
                    jedis = jedisPool.getResource();
                }
            } catch (Exception e) {
              e.printStackTrace();
            }
        }
        return jedis;
    }

    */
/**
     * 回收Jedis对象资源
     *
     * @param jedis
     *//*

    public synchronized void returnResource(Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }

    */
/**
     * Jedis对象出异常的时候，回收Jedis对象资源
     *
     * @param jedis
     *//*

    public synchronized void returnBrokenResource(Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnBrokenResource(jedis);
        }

    }
}

*/
