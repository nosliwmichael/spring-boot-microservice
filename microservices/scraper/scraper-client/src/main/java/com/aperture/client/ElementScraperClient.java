package com.aperture.client;

import com.aperture.scraper.endpoint.ElementScraperEndpoint;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "scraper-api", url = "${gateway.endpoint}")
public interface ElementScraperClient extends ElementScraperEndpoint {}
