package com.xuxiao.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xuxiao.model.User;

/**
 * 
* @ClassName: UserDao
* @Description: 用户DAO层
* @author zuozuo  
* @date 2016年8月4日 上午9:18:42 
*
 */
@Repository("userDao")
public class UserDao {
	@Autowired
	protected SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	public boolean isExit(User user){
		Session session=this.getSession();
		String hql = "from User where username =? and password = ?";
		Query query = session.createQuery(hql);
		query.setString(0, user.getUsername());
		query.setString(1, user.getPassword());
		if (query.list().size() >= 1) {
			return true;
		}
		return false;
	}
}
