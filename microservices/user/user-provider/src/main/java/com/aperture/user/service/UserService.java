package com.aperture.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aperture.user.dao.UserDao;
import com.aperture.user.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	public List<? extends User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	@Transactional
	public User getUserById(Long userId) {
		return userDao.getUserById(userId);
	}
	
}
