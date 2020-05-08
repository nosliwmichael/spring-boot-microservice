package com.aperture.user.provider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aperture.user. provider.dao.UserDao;
import com.aperture.user.provider.entity.UserImpl;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public UserImpl getUserById(Long userId) {
		return userDao.getUserById(userId);
	}
	
}
