package com.ajie.wechat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ajie.wechat.model.User;
/**
 * 
 * @ClassName: UserDao
 * @Description: user dao层
 * @author zuozuo
 * @date 2016年8月3日 下午1:45:24
 *
 */
public interface UserDao extends JpaRepository<User, Long> {
	/**
	 * 
	* @Title: getListIsNull 
	* @Description: 查询所有用户信息
	* @return  List<User>    返回类型  
	* @throws
	 */
	@Query("select u from User u")
	public List<User> getListIsNull();

}