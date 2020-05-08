package com.aperture.user.api.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aperture.user.api.model.User;

@RequestMapping(value="/user")
public interface UserEndpoint {
	
	@GetMapping(value="/{userId}")
	User getUserById(@PathVariable("userId") Long userId);

}
