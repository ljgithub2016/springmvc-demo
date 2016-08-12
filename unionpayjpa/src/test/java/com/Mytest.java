package com;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.unionpay.model.User;
import com.unionpay.service.UserService;

/**
 * 
 * @ClassName: Mytest
 * @Description: 测试类
 * @author zuozuo
 * @date 2016年8月12日 下午3:42:04
 *
 */
@ContextConfiguration(locations = { "classpath:spring-mvc.xml", "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class Mytest {
	@Autowired
	private UserService userService;

	/**
	 * @Title: testIsExist
	 * @Description: 验证用户是否存在
	 * @return void 返回类型
	 */
	@Test
	public void testIsExist() {
		User user = userService.getOneUser(Long.valueOf(1));
		System.out.println("存在：" + user.getAccount());
	}

	/**
	 * @Title: testlist
	 * @Description: 分页 测试方法
	 * @param test
	 * @return void 返回类型
	 */
	@Test
	public void testlist(String test) {
		Page<User> list = userService.getUserAll(1, 3);
		System.out.println(list.getTotalElements());// 总条数
		List<User> userlist = list.getContent();// 用户信息
		for (User user : userlist) {
			System.out.println(user.getAccount());
		}
	}
}
