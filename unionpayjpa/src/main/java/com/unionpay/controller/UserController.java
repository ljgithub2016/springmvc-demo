package com.unionpay.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	 * @Title: saveUser
	 * @Description: 添加用户信息 post提交方式
	 * @param user
	 * @return String 返回类型
	 */
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=UTF-8")
	public String saveUser(@RequestBody User user) {
		return userService.add(user);
	}

	/**
	 * @Title: add
	 * @Description: 添加用户信息 get方式提交
	 * @param account
	 * @return String 返回类型
	 */
	@RequestMapping(value = "/saveUser/{account}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=UTF-8")
	public String add(@PathVariable String account) {
		return userService.addUser(account);
	}

	/**
	 * @Title: get
	 * @Description: 根据id查询用户信息
	 * @param id
	 * @return User 返回类型
	 */
	@RequestMapping(value = "/user/{id}")
	public User get(@PathVariable Long id) {
		return userService.getOneUser(id);
	}

	/**
	 * @Title: test
	 * @Description: 测试
	 * @return JSONObject 返回类型
	 */
	@RequestMapping(value = "/test")
	public JSONObject test() {
		JSONObject json = new JSONObject();
		json.put("test", "我是一个json");
		return json;
	}

	/**
	 * @Title: test2
	 * @Description: 返回页面
	 * @param model
	 * @return String 返回类型
	 */
	@RequestMapping(value = "/test2")
	public String test2(Model model) {
		model.addAttribute("test", "Model");
		return "WEB-INF/success";
	}

	/**
	 * 
	 * @Title: listSourceCode
	 * @Description: 查询用户信息并分页
	 * @param request
	 * @param response
	 * @return ModelAndView 返回类型
	 */
	@RequestMapping(value = "list")
	public JSONObject listSourceCode(HttpServletRequest request, HttpServletResponse response,ModelAndView modelAndView) {
		String pageNumberStr = request.getParameter("pageNumber");
		if (pageNumberStr == null || "".equals(pageNumberStr)) {
			pageNumberStr = "1";
		}
		int pageNumber = Integer.parseInt(pageNumberStr);
		int pageSize = 2;
		modelAndView = new ModelAndView();
		modelAndView.setViewName("list");// 返回页面
		Page<User> userlist = this.userService.getUserAll(pageNumber, pageSize);
		modelAndView.addObject("sourceCodeList", userlist.getContent());// 返回内容
		modelAndView.addObject("totalPageNumber", userlist.getTotalElements());// 返回总条数
		modelAndView.addObject("pageSize", pageSize);// 返回一页显示的总数
		
		
		JSONObject json=new JSONObject();
		json.put("pageNumber", pageNumberStr);
		json.put("sourceCodeList", userlist.getContent());
		json.put("totalPageNumber", userlist.getTotalElements());
		json.put("pageSize", pageSize);
		return json;

	}
}