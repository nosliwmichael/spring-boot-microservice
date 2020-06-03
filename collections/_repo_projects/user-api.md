---
layout: default
title: Spring Boot Microservice
display_name: User-API
parent_name: User
app_path: microservices/user/user-api/
files:
  - file:
    name: pom.xml
  - file:
    path: src/main/java/com/sbm/user/endpoint/
    name: UserEndpoint.java
  - file:
    path: src/main/java/com/sbm/user/model/
    name: Person.java
  - file:
    path: src/main/java/com/sbm/user/model/
    name: User.java
  - file:
    path: src/main/java/com/sbm/user/remote/
    name: UserRemote.java
description: Contains interfaces that describe how the service should behave.
---
{% include project-display.md %}