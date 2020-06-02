package com.aperture.scraper.service;

import com.aperture.scraper.internalendpoint.GenericEndpoint;
import feign.Response;
import org.springframework.stereotype.Service;

@Service
public class GenericScraperService {

    public Response response(String url) {
        return GenericEndpoint.connect(url).getResponse();
    }

    public String responseBody(String url) {
        return response(url).body().toString();
    }

}