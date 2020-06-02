package com.aperture.scraper.endpoint;

import com.aperture.scraper.model.GenericScrape;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scraper-api/response")
public interface GenericScraperEndpoint {

    @PostMapping
    String response(@RequestBody String url);

    @PostMapping(value = "/_parse")
    String responseParse(@RequestBody GenericScrape genericScrape);

    @PostMapping(value = "/body")
    String responseBody(@RequestBody String url);

    @PostMapping(value = "/body/_parse")
    String responseBodyParse(@RequestBody GenericScrape genericScrape);

}
