package com.sbm.scraper.controller;


import com.sbm.scraper.endpoint.GenericScraperEndpoint;
import com.sbm.scraper.model.GenericScrape;
import com.sbm.scraper.service.GenericScraperService;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class GenericScraperController implements GenericScraperEndpoint {

    @Autowired
    private GenericScraperService genericScraperService;

    private Response getResponse(String url) {
        return genericScraperService.response(url);
    }

    @Override
    public String response(String url) {
        return getResponse(url).toString();
    }

    @Override
    public String responseParse(GenericScrape genericScrape) {
        String body = response(genericScrape.getUrl());
        Pattern pattern = Pattern.compile(genericScrape.getRegex(), Pattern.DOTALL);
        Matcher matcher = pattern.matcher(body);
        return matcher.find() ? matcher.group() : null;
    }

    @Override
    public String responseBody(String url) {
        return genericScraperService.responseBody(url);
    }

    @Override
    public String responseBodyParse(GenericScrape genericScrape) {
        String body = responseBody(genericScrape.getUrl());
        Pattern pattern = Pattern.compile(genericScrape.getRegex(), Pattern.DOTALL);
        Matcher matcher = pattern.matcher(body);
        return matcher.find() ? matcher.group() : null;
    }
}
