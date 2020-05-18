---
layout: documentation
title: Aperture
display_name: Getting Started
permalink: /getting-started
---

# {{ page.display_name }}

### Assumptions

1. You have basic knowledge of web development.
2. You are familiar with Git, Java (Spring), and Maven.

Continue reading to learn how to set up your workspace for installing and running the apps.

## Installation

As mentioned on the home page, you should 
start by cloning the repository to your local workspace. 
For me this will be in my D:/eclipse-workspace folder.
Import the projects into your preferred IDE.
You should have something like this:

![Aperture Project Structure]({{ '/images/project-structure-eclipse.PNG' | relative_url }})

Since this repository contains 3 main projects, you will need to create a Maven Build run 
configuration for each one with a goal of "install". Go to your Run Configurations menu, 
select the ![Maven Build Icon]({{ '/images/maven-build-run-config-option.PNG' | relative_url }}) option 
in the left panel and then select the "New launch configuration" 
![New Launch Configuration Button]({{ '/images/new-run-config-icon.PNG' | relative_url }}) button at the top. 
From here you should fill out the name, base directory, goal, and user settings (if different from default).
Your run configuration should look something like this for each top level project: (parent, microservice, web-app)

![Maven Install]({{ '/images/maven-install-run-config.PNG' | relative_url }})

Once you've created all three run configuration, you should run them in the following order: parent, microservice, web-app. 
Parent needs to be first because all projects point towards the parent project in their pom.  Microservice needs to be installed 
next because it contains -clients that other projects, such as web-app, depend on. You should notice in the console that by installing 
the top-level projects like parent or microservice, all of their sub-modules are installed as a result. You could take this a step further 
and make all three top-level projects a sub-module of yet another pom. Then you could create a single run configuration that would install 
everything in the repository in one go.

## Configuration Repository

Before you can run the apps, there is one more dependency we should cover, the 
[aperture-confi repository](https://github.com/nosliwmichael/aperture-config). This repository only contains .yml property files. This is the 
location that the config service pulls and shares configuration properties from. When it comes to setting up the config service, you don't 
*have* to keep your property files in a separate repository. You could store them in the resources folder in the config project or you could 
put them in their own folder within the same repository as the other aperture projects. In any case, this article is going to assume you'll use 
the provided config repository for your property files.

## Running The Apps

There are different ways to run these spring boot applications. If you have maven installed, you can run them from the command line:
```
java -jar target/path-to-jar
mvn spring-boot:run
```
I won't be covering this method in detail because as you'll see in a bit, this application relies several environment variables being passed in. 
This is still possible using the command line, but for development purposes, it's easier to use an IDE.

Using Eclipse, there are 2 ways to run the app. The first is creating a ![Maven Build Icon]({{ '/images/maven-build-run-config-option.PNG' | relative_url }}) 
just like you did before except the goal would be spring-boot: run. I don't recommend this method because when you stop the application, Eclipse 
will not terminate the process listening on the designated port. This means you won't be able to reuse that port until you find and end the process. 
The good news is, you can just run each of these apps as a Java Application instead.

There are 5 spring boot applications to run: config, discovery, gateway, user-provider, and web-app. The config service must be run before anything else because 
all the other apps reach out to the config service to fetch their configuration properties. The discovery service must be run second because all service 
apps need to register themselves. The rest can be run in any order as they do not depend on each other on startup.

To create a Java Application run configuration, go to your run configurations and select the 
![Java Application Run Config Option]({{ '/images/java-application-run-config-option.PNG' | relative_url }}) option in the left panel. Then select the 
![New Launch Configuration Button]({{ '/images/new-run-config-icon.PNG' | relative_url }}) button at the top. From here you should fill out the Name, Project, 
and Main Class fields. Here are a list of the main classes for each spring boot app:

`com.aperture.config.ConfigApplication`
`com.aperture.discovery.DiscoveryApplication`
`com.aperture.gateway.GatewayApplication`
`com.aperture.user.UserProviderApplication`
`com.aperture.webapp.WebAppApplication`

![Java Run Config Main]({{ '/images/java-run-config-main.PNG' | relative_url }})

In addition to telling the IDE which apps to run, we need to provide arguments or environment variables that these apps are expecting. Arguments are easier to 
copy & paste so let me show you what that looks like:

```
-DlocalConfigRepo=C:/eclipse-workspace/aperture-config/
-DremoteConfigRepo=https://github.com/nosliwmichael/aperture-config
-DrepoUsername=username
-DrepoPassword=password
-Dspring.profiles.active=dev
```

![Java Run Config Arguments]({{ '/images/java-run-config-arguments.PNG' | relative_url }})

You can either set these arguments equal to a value directly like I did in the text example or you can set them equal to variables like I did in the image example. 
If you plan on placing these apps into containers and exposing these values through environment variables instead, you can simulate that on the Environment tab.

![Java Run Config Environment]({{ '/images/java-run-config-environment.PNG' | relative_url }})

Now let's cover what these variables are for and which ones are necessary. The spring.profiles one allows us to specify what profile we're running the app in. You can 
make up your own profile names if you want. Just be sure to update the .yml property files to accomdate them. All apps can run local, dev, and prod profiles. Use local if you want to test a standalone app by itself. Use dev if you want to test how the apps interact with each other. Use prod in a production environment. The config service has an additional profile it can run on called, native. Set this one specifically in the bootstrap.yml of the config app if you want to use it. I'll explain what it's for in a moment. The local / remote config repository argument should be obvious. This is the location that we're storing the application specific property files we covered in the Configuration Repository section. The localConfigRepo variable is used when the app is run with a profile of "native" and the remoteConfigRepo variable is used when the app is run with a profile of local, dev or prod. The localConfigRepo can point to a folder on your machine or a [place in your classpath](https://cloud.spring.io/spring-cloud-config/reference/html/#_file_system_backend). For that to work, you would need to update the bootstrap.yml property and change "file:///" to "classpath:/". The remoteConfigRepo can point to a [local repository on your machine or an external one](https://cloud.spring.io/spring-cloud-config/reference/html/#_environment_repository). I should also mention that the username and password arguments are **not required** unless you're configuration repository requires authentication. For example, if your github repo is set to private.

With that, you should be able to run the config app with no problems. The run configuration for the other apps only require the -Dspring.profiles.active argument.

![Java Run Web App Environment]({{ '/images/java-run-webapp-environment.PNG' | relative_url }})

To simplify the installation process, you can create different Launch Groups in your Run Configurations to install and run all of the apps for you.

![Java Run All Apps]({{ '/images/java-run-all.PNG' | relative_url }})