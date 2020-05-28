package com.aperture.scraper.model;

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

import java.util.List;
import java.util.Map;

public class ElementCriteria {

    private String url;
    private String tagName;
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
