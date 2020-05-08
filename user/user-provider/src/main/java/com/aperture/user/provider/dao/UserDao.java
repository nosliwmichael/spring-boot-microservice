package com.aperture.user.provider.dao;

import org.springframework.stereotype.Repository;

import com.aperture.user.provider.entity.UserImpl;

@Repository
public class UserDao {

	public UserImpl getUserById(Long userId) {
		return new UserImpl(1L, "Michael Wilson", 26);
	}
	
}
