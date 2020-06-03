package com.sbm.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.sbm.user.endpoint.UserEndpoint;
import com.sbm.user.remote.UserRemote;
import com.sbm.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserEndpoint {
	
	@Autowired
	private UserService userService;

	@Override
	public List<UserRemote> getAllUsers() {
		return userService.getAllUsers().stream().map(UserRemote::convert).collect(Collectors.toList());
	}

	@Override
	public UserRemote getUserById(Long userId) {
		return UserRemote.convert(userService.getUserById(userId));
	}

}
