---
layout: default
title: Spring Boot Microservice
display_name: Scraper-Provider
parent_name: Scraper
app_path: microservices/scraper/scraper-provider/
files:
  - file:
    name: pom.xml
  - file:
    path: src/main/java/com/sbm/scraper/
    name: ScraperProviderApplication.java
  - file:
    path: src/main/java/com/sbm/scraper/controller/
    name: ElementScraperController.java
  - file:
    path: src/main/java/com/sbm/scraper/controller/
    name: GenericScraperController.java
  - file:
    path: src/main/java/com/sbm/scraper/internalendpoint/
    name: GenericEndpoint.java
  - file:
    path: src/main/java/com/sbm/scraper/service/
    name: GenericScraperService.java
  - file:
    path: src/main/resources/
    name: bootstrap.yml
description: The actual service implementation that contains the business logic.
---
{% include project-display.md %}