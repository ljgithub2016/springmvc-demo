package com.unionpay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.dao.UserDao;
import com.unionpay.model.User;

/**
 *
 * @ClassName: UserService
 * @Description: user service层
 * @author zuozuo
 * @date 2016年8月3日 下午1:46:48
 *
 */
@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;

	/**
	 * @Title: add
	 * @Description: 添加用户信息 (用户信息封装为对象)
	 * @param user
	 * @return String 返回类型
	 */
	public String add(User user) {
		userDao.save(user);
		return "添加成功！";
	}

	/**
	 * @Title: addUser
	 * @Description: 添加用户信息
	 * @param account
	 * @return String 返回类型
	 */
	public String addUser(String account) {
		User user = new User();
		user.setAccount(account);
		userDao.save(user);
		return "添加成功！";
	}

	/**
	 * @Title: getOneUser
	 * @Description: 根据id查询用户信息
	 * @param id
	 * @return User 返回类型
	 */
	public User getOneUser(Long id) {
		return userDao.findOne(id);
	}

	/**
	 * @Title: getUserAll
	 * @Description: 查询用户并分页
	 * @param pageNumber 页数
	 * @param pageSize 显示条数
	 * @return Page<User> 返回类型
	 */
	public Page<User> getUserAll(int pageNumber, int pageSize) {
		PageRequest request = this.buildPageRequest(pageNumber, pageSize);
		Page<User> userlist = this.userDao.findAll(request);
		return userlist;
	}

	/**
	 * 
	 * @Title: buildPageRequest
	 * @Description: 绑定页数和显示条数
	 * @param pageNumber
	 * @param pagzSize
	 * @return PageRequest 返回类型
	 */
	// 构建PageRequest
	private PageRequest buildPageRequest(int pageNumber, int pagzSize) {
		return new PageRequest(pageNumber - 1, pagzSize, null);
	}
}