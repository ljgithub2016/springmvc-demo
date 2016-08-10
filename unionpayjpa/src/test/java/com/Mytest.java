package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.unionpay.model.User;
import com.unionpay.service.UserService;




@ContextConfiguration(locations= {"classpath:spring-mvc.xml","classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class Mytest {
	@Autowired
	private UserService userService;
	/**
	 * 
	 * @Title: testIsExist 
	 * @Description: 验证用户是否存在
	 * @throws
	 */
	@Test
	public void testIsExist(){
		User user=userService.getOneUser(Long.valueOf(1));
		System.out.println(user.getAccount());
	}

}
