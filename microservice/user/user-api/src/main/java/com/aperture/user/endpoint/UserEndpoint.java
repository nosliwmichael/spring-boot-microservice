package com.aperture.user.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aperture.user.remote.UserRemote;

@RequestMapping(value="/user")
public interface UserEndpoint {
	
	@GetMapping(value="/{userId}")
	UserRemote getUserById(@PathVariable("userId") Long userId);

}
