package com.aperture.webapp.controller;

import com.aperture.client.ElementScraperClient;
import com.aperture.client.GenericScraperClient;
import com.aperture.scraper.model.ElementCriteria;
import com.aperture.scraper.model.GenericScrape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/scraper")
public class ScraperController {

    @Autowired
    private ElementScraperClient elementScraperClient;

    @Autowired
    private GenericScraperClient genericScraperClient;

    @GetMapping("")
    public String getScraperPage() {
        return "scraper/scraper";
    }

    @GetMapping("/response")
    @ResponseBody
    public ResponseEntity<?> response(@RequestBody String url) {
        return new ResponseEntity<>(
                genericScraperClient.response(url),
                HttpStatus.OK);
    }

    @GetMapping("/response/_parse")
    @ResponseBody
    public ResponseEntity<?> responseParse(@RequestBody GenericScrape genericScrape) {
        return new ResponseEntity<>(
                genericScraperClient.responseParse(genericScrape),
                HttpStatus.OK);
    }

    @GetMapping("/response/body")
    @ResponseBody
    public ResponseEntity<?> responseBody(@RequestBody String url) {
        return new ResponseEntity<>(
                genericScraperClient.responseBody(url),
                HttpStatus.OK);
    }

    @GetMapping("/response/body/_parse")
    @ResponseBody
    public ResponseEntity<?> responseBodyParse(@RequestBody GenericScrape genericScrape) {
        return new ResponseEntity<>(
                genericScraperClient.responseBodyParse(genericScrape),
                HttpStatus.OK
        );
    }

    @GetMapping("/elements/_scrape")
    @ResponseBody
    public ResponseEntity<?> scrapePage(@RequestBody ElementCriteria criteria) {
        return new ResponseEntity<>(
                elementScraperClient.getElements(criteria),
                HttpStatus.OK
        );
    }

}
