package com.aperture.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aperture.config.UserClient;

import feign.FeignException;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserClient userClient;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception ex) {
		logger.error("Unexpected Error: ", ex);
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(FeignException.class)
	public ResponseEntity<?> handleException(FeignException ex) {
		logger.error("503 Service Unavailable: ", ex);
		return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
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
