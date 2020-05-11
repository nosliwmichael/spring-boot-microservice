package com.aperture.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.aperture.user.endpoint.UserEndpoint;
import com.aperture.user.remote.UserRemote;
import com.aperture.user.service.UserService;

@RestController
public class UserController implements UserEndpoint {
	
	@Autowired
	private UserService userService;

	@Override
	public UserRemote getUserById(Long userId) {
		return userService.getUserById(userId);
	}

}
