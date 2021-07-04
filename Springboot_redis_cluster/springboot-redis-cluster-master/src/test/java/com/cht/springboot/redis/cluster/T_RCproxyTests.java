package com.cht.springboot.redis.cluster;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;
import redis.clients.jedis.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest(classes= {SpringbootRedisClusterApplication.class})
@RunWith(SpringRunner.class)
@Slf4j
public class T_RCproxyTests {
	
	@Autowired
	private StringRedisTemplate redisTemplate;

	//启动集群的时候要根据实际id启动，不然java程序连接就直接导致拒绝连接，连接失败等问题

	@Test
	public void testRedisCluster() {
		for(int i=0;i<100;i++) {
			String val=String.valueOf(i);
			redisTemplate.opsForValue().set(val, val);
		}
		
		for(int i=0;i<100;i++) {
			String key=String.valueOf(i);
			String val=redisTemplate.opsForValue().get(key);
			System.out.println("-----------------"+val);
		}
	}

	/*Jedis jedis = JedisPoolClient.getJedis();
	@Test
	public void testJedis()
	{

		System.out.println("开始");
		jedis.set("k1","11-10");
		System.out.println(jedis.get("k1"));



	}
	@After
	public void after(){
		System.out.println("最后");
		JedisPoolClient.returnResource(jedis);
	}*/

    /**
     * 直接测试Redis
     */
    @Test
    public void testJedis7(){
        Jedis jedis = new Jedis("127.0.0.1", 6380, 1000000);
       /* Pipeline pipe = jedis.pipelined(); // 先创建一个 pipeline 的链接对象
        long start_pipe = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            pipe.set(String.valueOf(i), String.valueOf(i));
        }
        pipe.syncAndReturnAll();
        long end_pipe = System.currentTimeMillis();
        System.out.println("时间"+(end_pipe - start_pipe));
        System.out.println(jedis.get("1"));*/

    }

    /**
     * 网易测试--- 普通
     */
    @Test
    public void Test07(){
        Jedis jedis = new Jedis("127.0.0.1", 8699, 100000000);
        String pass123 = jedis.auth("password123");
//        System.out.println(jedis.get("k2"));
//        String k17 = jedis.set("k2", "v2");
        System.out.println(jedis.get("k1"));
    }

    /**
     * 网易测试----MsetNx
     */
    @Test
    public void Test08(){
        Jedis jedis = new Jedis("127.0.0.1", 8699, 100000000);
        String pass123 = jedis.auth("password123");
        jedis.msetnx("k2","v2","k1","v1");
    }
    /**
     * 网易测试 ----mset
     */
	@Test
	public void testJedis(){
		Jedis jedis = new Jedis("127.0.0.1", 8699, 100000000);
        String pass123 = jedis.auth("password123");
       /* String k17 = jedis.set("key1", "value1");
        String k1 = jedis.get("key1");
        log.info("密码鉴权情况"+" "+pass123);
        log.info("set值情况"+" "+k17);
        log.info("get值为"+" "+k1);*/
        jedis.mset("name","zhangyuan","sex","nan","nian","18");
        List<String> mget = jedis.mget("name", "sex", "nian");

        System.out.println(mget.toString());

	}

    /**
     * 网易测试 ==pipeline
     */
    @Test
    public void testJedis2(){
        Jedis jedis = new Jedis("127.0.0.1", 8699, 100000000);
        String pass123 = jedis.auth("password123");
        Pipeline pipe = jedis.pipelined(); // 先创建一个 pipeline 的链接对象
        long start_pipe = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            pipe.set(String.valueOf(i), String.valueOf(i));
        }
        pipe.sync();
        long end_pipe = System.currentTimeMillis();
        System.out.println("时间"+(end_pipe - start_pipe));

    }

	/**
	 * 测试虚拟内存项目的-pipeline
	 */
	@Test
	public void testJedis5(){
		Jedis jedis = new Jedis("127.0.0.1", 8089, 1000000);
		jedis.auth("pwd03");

		Pipeline pipe = jedis.pipelined(); // 先创建一个 pipeline 的链接对象
		long start_pipe = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			pipe.set(String.valueOf(i), String.valueOf(i));
		}
		pipe.sync();
		long end_pipe = System.currentTimeMillis();
		System.out.println("时间"+(end_pipe - start_pipe));

	}

    /**
     * 测试虚拟内存项目的-pipeline
     */
    @Test
    public void testJedis4(){

        JedisPoolConfig config = new JedisPoolConfig();
        //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        config.setMaxIdle(5);
        //表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
        config.setMaxWaitMillis(1000 * 100);
        //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
        config.setTestOnBorrow(true);
       JedisPool  jedisPool = new JedisPool(config,"127.0.0.1",8089);

        Jedis jedis = jedisPool.getResource();

//        Jedis jedis = new Jedis("127.0.0.1", 8089, 1000000);
        jedis.auth("pwd03");

       /* Pipeline pipe = jedis.pipelined(); // 先创建一个 pipeline 的链接对象
        long start_pipe = System.currentTimeMillis();
        for (int i = 0; i < 4; i++) {
            pipe.set(String.valueOf(i), String.valueOf(i));
        }
        pipe.sync();*/
       jedis.set("k2","v2");

//        long end_pipe = System.currentTimeMillis();
//        System.out.println("时间"+(end_pipe - start_pipe));

    }

    /**
     * 测试虚拟内存
     */
    @Test
    public void testJedis3(){
        JedisPoolConfig config = new JedisPoolConfig();
        //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        config.setMaxIdle(5);
        //表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
        config.setMaxWaitMillis(1000 * 100);
        //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
        config.setTestOnBorrow(true);
        JedisPool  jedisPool = new JedisPool(config,"127.0.0.1",8089);

        Jedis jedis = jedisPool.getResource();

//        Jedis jedis = new Jedis("127.0.0.1", 8089, 1000000);
        jedis.auth("pwd03");

//        jedis.set("k1","11-10");
        jedis.set("k2","v2");
        System.out.println(jedis.get("k2"));
        System.out.println(jedis.get("k1"));
    }


    @Test
    public void TestHotkey(){
        Jedis jedis = new Jedis("127.0.0.1", 9999, 1000000);
        jedis.set("k1","v1");
        for (int i = 0; i <100 ; i++) {
            String k1 = jedis.get("k1");
        }
    }


    /**
     * redis cluster下的跨片操作。
     */
    @Test
    public void Test06(){
        JedisPoolConfig config = new JedisPoolConfig();
// 最大连接数
        config.setMaxTotal(30);
      // 最大连接空闲数
        config.setMaxIdle(2);

      //集群结点

        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();

        jedisClusterNode.add(new HostAndPort("127.0.0.1", 6380));
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 6381));
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 6382));
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 6383));
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 6384));
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 6385));

        JedisCluster jc = new JedisCluster(jedisClusterNode, config);
        JedisCluster jcd = new JedisCluster(jedisClusterNode);
        JedisCluster jcd2 = new JedisCluster(jedisClusterNode);

        String name = jcd.get("name");

        System.out.println(name);


    }



    /**
     * 测试虚拟内存项目的-跨片操作
     */
    @Test
    public void test7(){
        Jedis jedis = new Jedis("127.0.0.1", 8089, 1000000);
        jedis.auth("pwd03");
        jedis.set("k2","hh");
//        jedis.mset("name","zhangyuan","sex","nan","nian","18");
        String name = jedis.get("k2");

        System.out.println(name);

    }


    /**
     * 网易测试 ==pipeline
     */
    @Test
    public void testJedis8(){
        Jedis jedis = new Jedis("192.168.31.116", 6379, 100000000);
        Map<String, String> map = jedis.hgetAll("user1000385178204227360");
        System.out.println(map.get("field5").toString());



    }

    @Test
    public void Test09(){
        JedisPoolConfig config = new JedisPoolConfig();
        // 最大连接数
        config.setMaxTotal(30);
        // 最大连接空闲数
        config.setMaxIdle(2);
        //集群结点
        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
        jedisClusterNode.add(new HostAndPort("192.168.31.116", 7001));
        jedisClusterNode.add(new HostAndPort("192.168.31.116", 7002));
        jedisClusterNode.add(new HostAndPort("192.168.31.117", 7003));
        jedisClusterNode.add(new HostAndPort("192.168.31.117", 7004));
        jedisClusterNode.add(new HostAndPort("192.168.31.118", 7005));
        jedisClusterNode.add(new HostAndPort("192.168.31.118", 7006));
        jedisClusterNode.add(new HostAndPort("192.168.31.109", 7007));
        jedisClusterNode.add(new HostAndPort("192.168.31.109", 7008));
        JedisCluster jc = new JedisCluster(jedisClusterNode, config);
        JedisCluster jcd = new JedisCluster(jedisClusterNode);
        JedisCluster jcd2 = new JedisCluster(jedisClusterNode);

        String name = jcd.get("name");

        System.out.println(name);


    }

/*
    @Test
    public void test09(){
        int slot = -1;
        for(String key : keys){
            temp = getSlot(key);
           if(slot > 0){
               if(slot != temp){
                   return "所有key不在同一个哈希槽内";
               }
           }
           slot = temp;
        }
    }

    private Object getSlot(String key) {
    }
*/



    @Test
    public void Comp_test_get(){

        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
        jedisClusterNode.add(new HostAndPort("192.168.31.116", 7001));
        jedisClusterNode.add(new HostAndPort("192.168.31.116", 7002));
        jedisClusterNode.add(new HostAndPort("192.168.31.117", 7003));
        jedisClusterNode.add(new HostAndPort("192.168.31.117", 7004));
        jedisClusterNode.add(new HostAndPort("192.168.31.118", 7005));
        jedisClusterNode.add(new HostAndPort("192.168.31.118", 7006));
        jedisClusterNode.add(new HostAndPort("192.168.31.109", 7007));
        jedisClusterNode.add(new HostAndPort("192.168.31.109", 7008));
        JedisCluster jc = new JedisCluster(jedisClusterNode);
        String k1 = jc.get("k1");
        System.out.println("直连Redis cluster返回值: "+k1);

        Jedis jedis = new Jedis("127.0.0.1", 8699, 1000);
        jedis.auth("password123");
        String k11 = jedis.get("k1");
        System.out.println("连接T_RCProxy返回值: "+k11);

        if(k1.equals(k11)){
            System.out.println("结果一致,测试通过");
        }else{
            System.out.println("结果不一致，测试不通过");
        }
    }
    @Test
    public void Test11(){
        Jedis jedis = new Jedis("127.0.0.1", 6379, 1000);
//        jedis.auth("password123");
        String k1 = jedis.get("k2");
        String k2 = jedis.get("k3");
        if((k1 != null && k1.equals(k2)) || (k1 == null && k2 == null)){
            System.out.println("1");
        }else {
            System.out.println("2");
        }

    }

}
