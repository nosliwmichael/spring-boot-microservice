package com.sbm.webapp.controller;

import com.sbm.client.ElementScraperClient;
import com.sbm.client.GenericScraperClient;
import com.sbm.scraper.model.ElementCriteria;
import com.sbm.scraper.model.GenericScrape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/scraper")
public class ScraperController extends BaseController {

    private final ElementScraperClient elementScraperClient;
    private final GenericScraperClient genericScraperClient;

    @Autowired
    public ScraperController(ElementScraperClient elementScraperClient, GenericScraperClient genericScraperClient) {
        this.elementScraperClient = elementScraperClient;
        this.genericScraperClient = genericScraperClient;
    }

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
