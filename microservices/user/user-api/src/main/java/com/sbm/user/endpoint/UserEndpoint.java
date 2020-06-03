package com.sbm.user.endpoint;

import java.util.List;

import com.sbm.user.remote.UserRemote;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user-api")
public interface UserEndpoint {

	@GetMapping(value = "/user/")
	List<UserRemote> getAllUsers();

	@GetMapping(value = "/user/{userId}")
	UserRemote getUserById(@PathVariable("userId") Long userId);

}
