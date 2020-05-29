package com.aperture.webapp.controller;

import com.aperture.client.ElementScraperClient;
import com.aperture.client.GenericScraperClient;
import com.aperture.scraper.model.ElementCriteria;
import com.aperture.scraper.model.GenericScrape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/scraper")
public class ScraperController extends BaseController {

    @Autowired
    private ElementScraperClient elementScraperClient;

    @Autowired
    private GenericScraperClient genericScraperClient;

    @GetMapping("")
    public String getScraperPage() {
        return "scraper/scraper";
    }

    @PostMapping("/response")
    @ResponseBody
    public ResponseEntity<?> response(@RequestBody String url) {
        return new ResponseEntity<>(
                genericScraperClient.response(url),
                HttpStatus.OK);
    }

    @PostMapping("/response/_parse")
    @ResponseBody
    public ResponseEntity<?> responseParse(@RequestBody GenericScrape genericScrape) {
        return new ResponseEntity<>(
                genericScraperClient.responseParse(genericScrape),
                HttpStatus.OK);
    }

    @PostMapping("/response/body")
    @ResponseBody
    public ResponseEntity<?> responseBody(@RequestBody String url) {
        return new ResponseEntity<>(
                genericScraperClient.responseBody(url),
                HttpStatus.OK);
    }

    @PostMapping("/response/body/_parse")
    @ResponseBody
    public ResponseEntity<?> responseBodyParse(@RequestBody GenericScrape genericScrape) {
        return new ResponseEntity<>(
                genericScraperClient.responseBodyParse(genericScrape),
                HttpStatus.OK
        );
    }

    @PostMapping("/elements/_scrape")
    @ResponseBody
    public ResponseEntity<?> scrapePage(@RequestBody ElementCriteria criteria) {
        return new ResponseEntity<>(
                elementScraperClient.getElements(criteria),
                HttpStatus.OK
        );
    }

}
