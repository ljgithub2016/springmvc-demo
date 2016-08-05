package com.xuxiao.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 
* @ClassName: User
* @Description: 用户实体
* @author zuozuo  
* @date 2016年8月4日 上午9:18:11 
*
 */
@Table(name="user_t")
@Entity
public class User implements Serializable{
	
	private static final long serialVersionUID = 3121952108038414094L;
	private int id;
	private String username;
	private String password;
	private boolean sex;//默认为0，0表示为男，1表示为女
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false,length=9)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="user_name",nullable=false,length=20)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name="password",nullable=false,length=20)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="sex",nullable=false,length=1)
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	@Override
	public String toString(){
		return "User [ \nid : " + this.id + "\nusername : " + this.username
				+ "\npassword : " + this.password + "\nsex : " + this.sex
				+ " ]";
		
	}

}
