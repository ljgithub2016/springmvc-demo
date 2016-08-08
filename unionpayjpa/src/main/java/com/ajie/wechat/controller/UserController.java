package com.ajie.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ajie.wechat.model.User;
import com.ajie.wechat.service.UserService;
/**
 * 
 * @ClassName: UserController
 * @Description: user controller层
 * @author zuozuo
 * @date 2016年8月3日 下午1:47:00
 *
 */
@ControllerAdvice
@RequestMapping(value = "")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 
	 * @Title: saveUser @Description: 添加用户信息 post提交方式 @param user @return String
	 * 返回类型 @throws
	 */
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=UTF-8")
	public String saveUser(@RequestBody User user) {
		return userService.add(user);
	}
	/**
	 * 
	 * @Title: add @Description: 添加用户信息 get方式提交 @param account @return String
	 * 返回类型 @throws
	 */
	@RequestMapping(value = "/saveUser/{account}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=UTF-8")
	public String add(@PathVariable String account) {
		return userService.addUser(account);
	}
	/**
	 * 
	 * @Title: add @Description: 根据id查询用户信息 @param id @return User 返回类型 @throws
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=UTF-8")
	public User add(@PathVariable Long id) {
		return userService.getOneUser(id);
	}
	/**
	 * 
	 * @Title: test @Description: 测试 @return String 返回类型 @throws
	 */
	@RequestMapping(value = "/test")
	public ModelAndView test(ModelAndView mv) {
		mv = new ModelAndView("WEB-INF/success");
		mv.addObject("test", "ModelAndView");
		System.out.println(123465);
		return mv;
	}
	@RequestMapping(value = "/test2")
	public String test2(Model model) {
		model.addAttribute("test", "Model");
		return "WEB-INF/success";
	}
}