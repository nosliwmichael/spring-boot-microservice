package com.aperture.client;

import com.aperture.scraper.endpoint.GenericScraperEndpoint;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "scraper-api", url = "${gateway.endpoint}")
public interface GenericScraperClient extends GenericScraperEndpoint {}
