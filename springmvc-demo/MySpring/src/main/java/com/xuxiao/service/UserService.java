package com.xuxiao.service;

import com.xuxiao.model.User;
/**
 * 
* @ClassName: UserService
* @Description: service层
* @author zuozuo  
* @date 2016年8月4日 上午9:19:25 
*
 */
public interface UserService{
	public boolean isExist(User user);//验证用户是否存在
}