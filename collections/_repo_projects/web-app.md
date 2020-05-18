---
layout: documentation
title: Aperture
display_name: Web-App
level: top
app_path: web-app/
files:
  - file:
    name: pom.xml
  - file:
    path: src/main/java/com/aperture/webapp/
    name: ServletInitializer.java
  - file:
    path: src/main/java/com/aperture/webapp/
    name: WebAppApplication.java
  - file:
    path: src/main/java/com/aperture/webapp/config/
    name: WebConfig.java
  - file:
    path: src/main/java/com/aperture/webapp/config/
    name: WebSecurityConfig.java
  - file:
    path: src/main/java/com/aperture/webapp/controller/
    name: MainController.java
  - file:
    path: src/main/resources/public/js/angular/user/
    name: user.module.js
  - file:
    path: src/main/resources/public/js/angular/user/
    name: user.controller.js
  - file:
    path: src/main/resources/public/js/angular/user/
    name: user.service.js
  - file:
    path: src/main/resources/templates/user/
    name: user.html
  - file:
    path: src/main/resources/
    name: bootstrap.yml
description: A lightweight web application used to showcase the simplicity of using Spring Boot/Cloud, OpenFeign, and microservices from a client's perspective.
---
{% include project-display.md %}