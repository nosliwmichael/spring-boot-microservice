---
layout: documentation
title: Aperture
display_name: User-Provider
parent_name: User
app_path: microservices/user/user-provider/
files:
  - file:
    name: pom.xml
  - file:
    path: src/main/java/com/aperture/user/
    name: UserProviderApplication.java
  - file:
    path: src/main/java/com/aperture/user/controller/
    name: UserController.java
  - file:
    path: src/main/java/com/aperture/user/service/
    name: UserService.java
  - file:
    path: src/main/java/com/aperture/user/dao/
    name: UserDao.java
  - file:
    path: src/main/java/com/aperture/user/entity/
    name: UserImpl.java
  - file:
    path: src/main/resources/
    name: bootstrap.yml
description: The actual service implementation that contains the business logic and data access layer.
---
{% include project-display.md %}