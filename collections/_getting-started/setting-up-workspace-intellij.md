---
layout: default
title: Aperture
display_name: Getting Started With IntelliJ
permalink: /getting-started/intellij
---

# {{ page.display_name }}

### Assumptions

1. You have basic knowledge of web development.
2. You are familiar with Git, Java (Spring), and Maven.
3. You are using the [IntelliJ IDEA Ultimate](https://www.jetbrains.com/idea/){:target="_blank"}.

**Note:** The IntelliJ Community edition does not support JavaEE. This may cause you to experience ClassNotFound exceptions when attempting to run spring boot applications that use the spring-boot-starter-tomcat dependency with a provided scope. If that's the case, either change the scope to compile (not recommended) or run your own tomcat server.

## Creating A Workspace

With the way IntelliJ treats Projects and Modules, you can go about setting up your workspace one of two ways:
1. Choose `Get from Version Control` and treat the entire repository as a project.
2. Choose `Create New Project` and add the repository as a module.

If you only intend to work with this single repository, then the go with the first option. If you want the flexibility of being able to include other projects from other repositories, go with the second option. As you'll see in the next section, **Configuration Repository**, I'll be interacting with a separate repository for my configuration files. With this in mind, I'll briefly go over option 2.

Select `Create New Project` from the main splash menu and create an empty project. Name it something that doesn't conflict with the repository, like, `aperture-project`.

![New IntelliJ Project]({{ '/images/new-project-intellij.PNG' | relative_url }})

Next you'll want to clone the aperture repository inside of the new project you've created. `https://github.com/nosliwmichael/aperture.git` 

![Clone Repository Window]({{ '/images/clone-repo-intellij.PNG' | relative_url }})

Click cancel on the popup that appears asking you if you want to open the project in a new window or the existing one. Then repeat the same steps for the aperture-config repository. `https://github.com/nosliwmichael/aperture-config.git` Once that's complete you should have a project structure similar to this:

![IntelliJ Project Structure]({{ '/images/project-structure-intellij.PNG' | relative_url }})

## Installation

IntelliJ makes installing Maven projects very simple. In the Project explorer panel, navigate to **aperture** -> **parent**, right click on the **pom.xml** and select "Add as Maven project". A Maven panel should appear on the right side of the window with all of the sub-modules. From here we can go into **parent** -> **Lifecycle** and select **install**. Since every project is a descendant of parent, they will all be installed from this single run configuration.

## Configuration Repository

Before we move onto running the application, I want to explain the purpose of the `aperture-config` repository. This repo only contains .yml property files. This is the location that the config service pulls and shares configuration properties from. When it comes to setting up the config service, you don't *have* to keep your property files in a separate repository. You could store them in the resources folder in the config module or you could put them in their own folder within the same repository as the other aperture projects. In fact, you don't even need to clone this repository at all. If you have no intention of changing any of the configuration files, you could simply point your config service directly to the GitHub repository. In any case, this article is going to assume you'll use the provided config repository for your property files.

## Running The Apps

There are 5 spring boot applications to run: config, discovery, gateway, user-provider, and web-app. The config service must be run before anything else because all other apps reach out to the config service to fetch their configuration properties. The discovery service must be run second because all service instances will need to register themselves to be accessible to other apps. The rest can be run in any order as they do not depend on each other on startup. There are two main ways to run the application in your IDE. The first is to create a ![Maven Run Configuration]({{ '/images/maven-run-config-option-intellij.PNG' | relative_url }}) run configuration with a goal of `spring-boot:run` and the second is to create an ![Application Run Configuration]({{ '/images/application-run-config-option-intellij.PNG' | relative_url }}) run configuration. I chose to go with the later option but I'll briefly describe how to setup the Maven run configuration and the issues you might face.

#### Running as a Maven Build

Starting in Spring Boot 2.2.0.RELEASE, the JVM process is forked by default when starting from the `spring-boot-maven-plugin`. You can read more about why that decision was made in this spring-boot issue: [#16945](https://github.com/spring-projects/spring-boot/issues/16945){:target="_blank"}. This has several consequences that determine how we should run the application. First off, the IDE won't be able to associate the child (forked) process to the initial JVM process. This means your VM arguments won't be passed to spring-boot and in some cases you won't be able to terminate the process that is listening on its designated port. This also becomes an issue when you want to run the app in debug mode and are unable to trigger any breakpoints. Here are some options to get around this issue:

1. **Disable Forking** - 
One simple way to get around this is to disable the JVM from forking the spring-boot process. This can be accomplished by passing `-Dspring-boot.run.fork=false` as a command line or VM argument when you run the app. Alternatively you can set this property directly in the pom as mentioned in this [StackOverflow post](https://stackoverflow.com/questions/58509682/spring-boot-2-2-0-process-fails-to-terminate-when-launched-in-debug-mode/58701275#58701275){:target="_blank"}. Keep in mind that this will prevent the `optimizedLaunch` setting from occurring and is not considered the [recommended approach](https://github.com/spring-projects/spring-boot/issues/18706#issuecomment-545436541){:target="_blank"}.

2. **Remote Debugging** - 
Another way is to setup remote debugging within your application. This is accomplished by pointing the `spring-boot-maven-plugin` to a remote debugger running on a particular `hostname:port`. You can find more information on the changes you will need to make to the Spring Boot application [here](https://docs.spring.io/spring-boot/docs/2.3.0.BUILD-SNAPSHOT/maven-plugin/reference/html/#run-example-debug){:target="_blank"} and how to create a remote debugger in IntelliJ [here](https://www.jetbrains.com/help/idea/tutorial-remote-debug.html){:target="_blank"}. 

#### Running as an Application
The easiest way to create an Application run configuration is to right click on the main class and select `Create '{APP-NAME}Application....main()...'`. Make sure you select the correct module in the **User classpath of module:** dropdown. In the **VM options** input box you will need to provide arguments the app will need in order to startup properly. Here's what they would look like for the ConfigApplication run configuration:

```
-DlocalConfigRepo={PATH_TO_LOCAL_CONFIG_FILES}
-DremoteConfigRepo=https://github.com/nosliwmichael/aperture-config
-DrepoUsername=username
-DrepoPassword=password
-Dspring.profiles.active=dev
```

Be sure to replace `{PATH_TO_LOCAL_CONFIG_FILES}` with an actual path if you intend to use a local folder on your file system to hold your properties files. You can repeat the same process for the other spring boot apps as well. The only difference is that they will just need the one `-Dspring.profiles.active=dev` argument.

![Application Run Configuration]({{ '/images/java-run-config-intellij.PNG' | relative_url }})

Now let's cover what these variables are for and which ones are necessary. The spring.profiles one allows us to specify what profile we're running the app in. You can make up your own profile names if you want. Just be sure to update the .yml property files to accommodate them. All apps can run local, dev, and prod profiles. Use local if you want to test a standalone app by itself. Use dev if you want to test how the apps interact with each other. Use prod in a production environment. The config service has an additional profile it can run on called, native. Set this one specifically in the bootstrap.yml of the config app if you want to use it. I'll explain what it's for in a moment. The local / remote config repository argument should be obvious. This is the location that we're storing the application specific property files we covered in the Configuration Repository section. The localConfigRepo variable is used when the app is run with a profile of "native" and the remoteConfigRepo variable is used when the app is run with a profile of local, dev or prod. The localConfigRepo can point to a folder on your machine or a [place in your classpath](https://cloud.spring.io/spring-cloud-config/reference/html/#_file_system_backend){:target="_blank"}. For that to work, you would need to update the bootstrap.yml property and change "file:///" to "classpath:/". The remoteConfigRepo can point to a [local repository on your machine or an external one](https://cloud.spring.io/spring-cloud-config/reference/html/#_environment_repository){:target="_blank"}. I should also mention that the username and password arguments are **not required** unless you're configuration repository requires authentication. For example, if your github repo is set to private.

With that, you should be able to run the each spring boot application without any problems. I should point out that not only does the order you run the application matter, but the timing does as well. You will need to run the config application and wait for it to say, "Server started" in the console. Then run the discovery application and wait for the same message to appear in its console. After that, the other apps can be run in any order. Unlike Eclipse, IntelliJ doesn't offer a smart way to stagger these run configurations. If you're looking for a way to run all of the apps in a single click you could download and install the [Multirun plugin](https://plugins.jetbrains.com/plugin/7248-multirun){:target="_blank"} to run multiple run configurations. The difference between this and Compound is that Multirun offers some additional settings such as setting a delay between each run config.

![Multirun Configuration]({{ '/images/run-all-intellij.PNG' | relative_url }})