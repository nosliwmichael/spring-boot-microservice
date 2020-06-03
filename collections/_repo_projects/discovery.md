---
layout: default
title: Spring Boot Microservice
display_name: Discovery
level: top
app_path: discovery/
files:
  - file:
    name: pom.xml
  - file:
    path: src/main/java/com/sbm/discovery/
    name: DiscoveryApplication.java
  - file:
    path: src/main/resources/
    name: bootstrap.yml
description: A service that handles load balancing and keeps track of running instances of microservices.
---
{% include project-display.md %}