package com.sbm.user.remote;

import org.springframework.beans.BeanUtils;

import com.sbm.user.model.User;

public class UserRemote implements User {
	
	private Long userId;
	private String name;
	private Integer age;

	public UserRemote() {}
	public UserRemote(User user) {
		BeanUtils.copyProperties(user, this, UserRemote.class);
	}
	public UserRemote(Long userId, String name, Integer age) {
		super();
		this.userId = userId;
		this.name = name;
		this.age = age;
	}
	
	public static UserRemote convert(User user) {
		if (user instanceof UserRemote || user == null) {
			return (UserRemote) user;
		} else {
			return new UserRemote(user);
		}
	}

	@Override
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
