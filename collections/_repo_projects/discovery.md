---
layout: default
title: Aperture
display_name: Discovery
level: top
app_path: discovery/
files:
  - file:
    name: pom.xml
  - file:
    path: src/main/java/com/aperture/discovery/
    name: DiscoveryApplication.java
  - file:
    path: src/main/resources/
    name: bootstrap.yml
description: A service that handles load balancing and keeps track of running instances of microservices.
---
{% include project-display.md %}