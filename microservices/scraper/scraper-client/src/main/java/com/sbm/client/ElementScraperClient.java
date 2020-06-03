package com.sbm.client;

import com.sbm.scraper.endpoint.ElementScraperEndpoint;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "element-scraper-api", url = "${gateway.endpoint}")
public interface ElementScraperClient extends ElementScraperEndpoint {}
