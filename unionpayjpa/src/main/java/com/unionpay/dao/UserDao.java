package com.unionpay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unionpay.model.User;

/**
 * 
 * @ClassName: UserDao
 * @Description: user dao层
 * @author zuozuo
 * @date 2016年8月12日 下午4:16:25
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

	/**
	 * @Title: getListIsNull
	 * @Description: 查询所有用户信息
	 * @return List<User> 返回类型
	 */
	@Query("select u from User u")
	public List<User> getListIsNull();
}