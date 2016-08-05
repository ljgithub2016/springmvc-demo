package com.xuxiao.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuxiao.model.User;
import com.xuxiao.service.UserService;

/**
 * 
 * @author xuxiao
 *
 */
@Controller
@RequestMapping("userController")
public class UserController {
	@Autowired
	private UserService userService;
	@ResponseBody
	@RequestMapping(value="/isExist",method=RequestMethod.POST)
	/***
	 * 检测用户是否存在
	 * @param user
	 * @return
	 */
	public Map<String ,Object>isExist(User user){
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println(user.toString());
		boolean loginResult = userService.isExist(user);
		map.put("loginResult", loginResult);
		return map;
		
	}

}
