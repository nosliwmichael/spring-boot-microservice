package com.aperture.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aperture.client.UserClient;

@RequestMapping(value = "/user")
public class UserController extends BaseController {

	@Autowired
	private UserClient userClient;

	@GetMapping("")
	public String getUserPage() {
		return "user/user";
	}

	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<?> getAllUsers() {
		return new ResponseEntity<>(userClient.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	@ResponseBody
	public ResponseEntity<?> getAllUsers(@PathVariable("userId") Long userId) {
		return new ResponseEntity<>(userClient.getUserById(userId), HttpStatus.OK);
	}

}
