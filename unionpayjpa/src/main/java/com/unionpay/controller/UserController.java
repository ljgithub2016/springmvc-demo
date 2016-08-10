package com.unionpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.alibaba.fastjson.JSONObject;
import com.unionpay.model.User;
import com.unionpay.service.UserService;
/**
 * 
 * 
 * @ClassName: UserController
 * @Description: user controller层
 * @author zuozuo
 * @date 2016年8月3日 下午1:47:00
 *
 */
@RestController
@RequestMapping(value = "")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 
	 * @Title: saveUser 
	 * @Description: 添加用户信息 post提交方式 
	 * @param user
	 * @return  String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=UTF-8")
	public String saveUser(@RequestBody User user) {
		return userService.add(user);
	}
	/**
	 * 
	 * @Title: add 
	 * @Description: 添加用户信息 get方式提交
	 * @param account
	 * @return  String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/saveUser/{account}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=UTF-8")
	public String add(@PathVariable String account) {
		return userService.addUser(account);
	}
	/**
	 * 
	 * @Title: get 
	 * @Description: 根据id查询用户信息
	 * @param id
	 * @return  User    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/user/{id}")
	public User get(@PathVariable Long id) {
		return userService.getOneUser(id);
	}
	/**
	 * 
	 * @Title: test 
	 * @Description: 测试 
	 * @param mv
	 * @return  ModelAndView    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/test")
	public JSONObject test() {
		JSONObject json=new JSONObject();
		json.put("test", "我是一个json");
		return json;
	}
	/**
	 * 
	 * @Title: test2 
	 * @Description: 返回页面
	 * @param model
	 * @return  String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/test2")
	public String test2(Model model) {
		model.addAttribute("test", "Model");
		return "WEB-INF/success";
	}
}