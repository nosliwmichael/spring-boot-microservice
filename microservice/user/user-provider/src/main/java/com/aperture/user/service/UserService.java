package com.aperture.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aperture.user.dao.UserDao;
import com.aperture.user.remote.UserRemote;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public UserRemote getUserById(Long userId) {
		return UserRemote.convert(userDao.getUserById(userId));
	}
	
}
