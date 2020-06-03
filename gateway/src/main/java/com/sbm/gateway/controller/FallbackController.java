package com.sbm.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	@GetMapping("/serviceFallback")
	public ResponseEntity<?> serviceFallback() {
		return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
	}
	
}
