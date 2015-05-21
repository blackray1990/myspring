package com.hjs.study.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjs.study.spring.bean.PersonDO;

import redis.clients.jedis.JedisPoolConfig;

@Controller
@RequestMapping("redis")
public class CommonRedisController {

	@Resource
	private StringRedisTemplate template;
	
	/**
	 * redis写入
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("saveperson")
	public String savePerson(HttpServletRequest request,PersonDO persondo){
			if(persondo.getId()==null){
				persondo = new PersonDO();
				persondo.setId(1);
				persondo.setName("HEJINSHENG");
				persondo.setPhone("13634127281");
				persondo.setSex(1);
				persondo.setDesc("管理员");
			}
	        // save as hash 一般key都要加一个前缀，方便清除所有的这类key
	        BoundHashOperations<String, String, String> ops = template.boundHashOps("person-"+persondo.getId());
	        Map<String, String> data = new HashMap<String,String>();
	        data.put("id", persondo.getId().toString());
	        data.put("name", persondo.getName());
	        data.put("phone", persondo.getPhone());
	        data.put("sex", persondo.getSex().toString());
	        data.put("desc", persondo.getDesc());

	        try {
	            ops.putAll(data);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		return "write to redis success";
	}
	
	/**
	 * 从redis中读取
	 */
	@RequestMapping("readperson")
	public String readPerson(HttpServletRequest request,Model model,Integer id){
		final String strkey = "person-"+ id;
	    PersonDO entity = template.execute(new RedisCallback<PersonDO>() {
	           @Override  
	           public PersonDO doInRedis(RedisConnection connection) throws DataAccessException {
	               byte[] bkey = template.getStringSerializer().serialize(strkey);  
	               if (connection.exists(bkey)) {
	                   List<byte[]> value = connection.hMGet(bkey,  
	                		   template.getStringSerializer().serialize("id"), template
	                                   .getStringSerializer().serialize("name"), template
	                                   .getStringSerializer().serialize("phone"), template
	                                   .getStringSerializer().serialize("sex"), template
	                                   .getStringSerializer().serialize("desc"));  
	                   PersonDO personDO = new PersonDO();
	                   personDO.setId(Integer.parseInt(template.getStringSerializer().deserialize(value.get(0))));
	                   personDO.setName(template.getStringSerializer().deserialize(value.get(1)));
	                   personDO.setPhone(template.getStringSerializer().deserialize(value.get(2)));
	                   personDO.setSex(Integer.parseInt(template.getStringSerializer().deserialize(value.get(3))));
	                   personDO.setDesc(template.getStringSerializer().deserialize(value.get(4)));
	                   return personDO;  
	               }
				return null;
	           }
	    });
	    System.out.println("entity:"+entity);
	    model.addAttribute("person",entity);
		return null;
	}
	/**
	 * 清除redis缓存
	 */
	@ResponseBody
	@RequestMapping("cleancache")
	public void cleanCache(HttpServletRequest request){
		System.out.println("come here");
		//TODO
	}
}
