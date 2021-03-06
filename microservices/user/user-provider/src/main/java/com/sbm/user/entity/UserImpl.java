package com.sbm.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sbm.user.model.User;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "PERSON")
public class UserImpl implements User {

	@Id
	@Column(name = "PERSON_ID")
	private Long userId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "AGE")
	private Integer age;

	public UserImpl() {
	}

	public UserImpl(User user) {
		BeanUtils.copyProperties(user, this, UserImpl.class);
	}

	public UserImpl(Long userId, String name, Integer age) {
		super();
		this.userId = userId;
		this.name = name;
		this.age = age;
	}

	public static UserImpl convert(User user) {
		if (user instanceof UserImpl || user == null) {
			return (UserImpl) user;
		} else {
			return new UserImpl(user);
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
