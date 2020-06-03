---
layout: default
title: Spring Boot Microservice
display_name: Scraper-API
parent_name: Scraper
app_path: microservices/scraper/scraper-api/
files:
  - file:
    name: pom.xml
  - file:
    path: src/main/java/com/sbm/scraper/model/
    name: ElementCriteria.java
  - file:
    path: src/main/java/com/sbm/scraper/model/
    name: GenericScrape.java
  - file:
    path: src/main/java/com/sbm/scraper/endpoint/
    name: ElementScraperEndpoint.java
  - file:
    path: src/main/java/com/sbm/scraper/endpoint/
    name: GenericScraperEndpoint.java
description: Contains interfaces that describe how the service should behave.
---
{% include project-display.md %}