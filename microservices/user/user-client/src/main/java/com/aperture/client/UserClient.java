package com.aperture.client;

import org.springframework.cloud.openfeign.FeignClient;

import com.aperture.user.endpoint.UserEndpoint;

@FeignClient(name = "user-api", url = "${gateway.endpoint}")
public interface UserClient extends UserEndpoint {}
