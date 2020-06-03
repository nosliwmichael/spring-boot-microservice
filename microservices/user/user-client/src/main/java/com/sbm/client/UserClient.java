package com.sbm.client;

import org.springframework.cloud.openfeign.FeignClient;

import com.sbm.user.endpoint.UserEndpoint;

@FeignClient(name = "user-api", url = "${gateway.endpoint}")
public interface UserClient extends UserEndpoint {}
