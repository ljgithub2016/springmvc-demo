package com.xuxiao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xuxiao.dao.UserDao;
import com.xuxiao.model.User;
import com.xuxiao.service.UserService;

/**
 * 
* @ClassName: UserServiceImpl
* @Description: 用户 service实现
* @author zuozuo  
* @date 2016年8月4日 上午9:19:56 
*
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean isExist(User user) {
		return userDao.isExit(user);
	}
	

}
