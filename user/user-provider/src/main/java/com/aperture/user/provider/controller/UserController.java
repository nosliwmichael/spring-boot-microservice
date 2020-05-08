package com.aperture.user.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.aperture.user.api.endpoint.UserEndpoint;
import com.aperture.user.api.model.User;
import com.aperture.user.provider.service.UserService;

@RestController
public class UserController implements UserEndpoint {
	
	@Autowired
	private UserService userService;

	@Override
	public User getUserById(Long userId) {
		return userService.getUserById(userId);
	}

}
