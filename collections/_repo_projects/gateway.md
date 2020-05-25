---
layout: default
title: Aperture
display_name: Gateway
level: top
app_path: gateway/
files:
  - file:
    name: pom.xml
  - file:
    path: src/main/java/com/aperture/gateway/
    name: GatewayApplication.java
  - file:
    path: src/main/java/com/aperture/gateway/controller/
    name: FallbackController.java
  - file:
    path: src/main/resources/
    name: bootstrap.yml
description: A service in charge of routing clients to different microservices.
---
{% include project-display.md %}