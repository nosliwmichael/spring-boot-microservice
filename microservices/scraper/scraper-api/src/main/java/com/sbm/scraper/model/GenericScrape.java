package com.sbm.scraper.model;

import com.sbm.jacksonmapping.deserializer.CustomStringDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class GenericScrape {

    @JsonDeserialize(using = CustomStringDeserializer.class)
    private String url;
    @JsonDeserialize(using = CustomStringDeserializer.class)
    private String regex;

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getRegex() {
        return regex;
    }
    public void setRegex(String regex) {
        this.regex = regex;
    }

}
