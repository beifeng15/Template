package com.cht.springboot.redis.cluster.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description TODO
 * @Author Mr.Wu
 * @Date 2021/1/7 11:26
 * @Version 1.0
 **/
@Configuration
public class JedisCluster {

    @Bean
    @ConditionalOnMissingBean(value = {redis.clients.jedis.JedisCluster.class})
    public redis.clients.jedis.JedisCluster test(){
        JedisPoolConfig config = new JedisPoolConfig();

        // 最大连接数
        config.setMaxTotal(30);
        // 最大连接空闲数
        config.setMaxIdle(2);
        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();

        jedisClusterNode.add(new HostAndPort("127.0.0.1", 6380));
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 6381));
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 6382));
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 6383));
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 6384));
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 6385));


        redis.clients.jedis.JedisCluster jcd = new redis.clients.jedis.JedisCluster(jedisClusterNode);
        return jcd;
    }


}
