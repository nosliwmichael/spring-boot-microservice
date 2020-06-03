package com.sbm.scraper.endpoint;

import com.sbm.scraper.model.ElementCriteria;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/scraper-api")
public interface ElementScraperEndpoint {

    @PostMapping(value = "/element")
    List<String> getElements(@RequestBody ElementCriteria criteria);

}
