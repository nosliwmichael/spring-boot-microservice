package com.sbm.client;

import com.sbm.scraper.endpoint.GenericScraperEndpoint;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "generic-scraper-api", url = "${gateway.endpoint}")
public interface GenericScraperClient extends GenericScraperEndpoint {}
