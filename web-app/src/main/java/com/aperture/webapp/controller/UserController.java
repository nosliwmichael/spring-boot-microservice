package com.aperture.webapp.controller;

import com.aperture.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

	private final UserClient userClient;

	@Autowired
	public UserController(UserClient userClient) {
		this.userClient = userClient;
	}

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
