package com.sbm.user.service;

import java.util.List;

import com.sbm.user.dao.UserDao;
import com.sbm.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
