package com.aperture.scraper.model;

import com.aperture.jacksonmapping.deserializer.CustomStringDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.Map;

public class ElementCriteria {

    @JsonDeserialize(using = CustomStringDeserializer.class)
    private String url;
    @JsonDeserialize(using = CustomStringDeserializer.class)
    private String tagName;
    @JsonDeserialize(using = CustomStringDeserializer.class)
    private String id;
    private List<String> classNames;
    private Map<String, String> attributes;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getClassNames() {
        return classNames;
    }

    public void setClassNames(List<String> classNames) {
        this.classNames = classNames;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

}
