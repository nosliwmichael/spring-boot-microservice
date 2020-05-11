package com.aperture.config;

import org.springframework.cloud.openfeign.FeignClient;

import com.aperture.user.endpoint.UserEndpoint;

@FeignClient("user-provider")
public interface UserClient extends UserEndpoint {}
