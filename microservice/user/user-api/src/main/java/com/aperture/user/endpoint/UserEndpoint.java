package com.aperture.user.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aperture.user.remote.UserRemote;

@RestController
@RequestMapping(value="/user-api")
public interface UserEndpoint {
	
	@GetMapping(value="/user/{userId}")
	UserRemote getUserById(@PathVariable("userId") Long userId);

}
