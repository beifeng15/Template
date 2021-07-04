package com.cht.springboot.redis.cluster.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cht.springboot.redis.cluster.model.Goods;
import com.cht.springboot.redis.cluster.service.GoodsService;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

@RestController
@CrossOrigin
@RequestMapping("/goods")
public class GoodsController {
 
	@Autowired
	private GoodsService goodsService;

	@Autowired
	private JedisCluster jedisCluster;
	
	@GetMapping("/getList")
	public List<Goods> getList(){
		return goodsService.getList();
	}
	
	@GetMapping("/getById")
	public Goods getById(@RequestParam("id") int id){
		return goodsService.getById(id);
	}
	static {
		Jedis jedis = new Jedis("192.168.31.116", 6379,1000000);
	}


	@GetMapping("/migrate")
	public void migrate(){
		jedisCluster.set("k11","v11");
		System.out.println(jedisCluster.get("k11"));

	}
}
