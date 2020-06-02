---
layout: default
title: Aperture
display_name: Validator
parent_name: Utils
app_path: utils/validator/
files:
  - file:
    name: pom.xml
  - file:
    path: src/main/java/com/aperture/validator/validators/
    name: BasicValidator.java
  - file:
    path: src/main/java/com/aperture/validator/validators/
    name: NumericValidator.java
  - file:
    path: src/main/java/com/aperture/validator/validators/
    name: CollectionValidator.java
  - file:
    path: src/main/java/com/aperture/validator/validators/
    name: PatternValidator.java
  - file:
    path: src/main/java/com/aperture/validator/builders/
    name: ValidatorBuilder.java
  - file:
    path: src/main/java/com/aperture/validator/builders/
    name: ValidatorBuilderBasic.java
  - file:
    path: src/main/java/com/aperture/validator/builders/
    name: ValidatorBuilderNumber.java
  - file:
    path: src/main/java/com/aperture/validator/builders/
    name: ValidatorBuilderCollection.java
  - file:
    path: src/main/java/com/aperture/validator/builders/
    name: ValidatorBuilderPattern.java
description: This module contains several validation interfaces that supply their own static implementations of their methods. The ValidationBuilder implements all of the other Builder interfaces. The Builder interfaces contain default methods to call their respective validation methods, update the Builder's valid status, record tests failed and return the ValidatorBuilder.
---
{% include project-display.md %}