## Overview


## Creating Template

I used the maven archetype plugin to create the skeleton for this project running the following command

```
mvn archetype:generate 
   -DarchetypeGroupId=org.apache.maven.archetypes 
   -DarchetypeArtifactId=maven-archetype-quickstart 
   -DarchetypeVersion=1.1 
   -DinteractiveMode=false 
   -DgroupId=com.hiklas.mucking.around 
   -DartifactId=hmrcexercise
```

Annoyingly this creates a directory called 'mojoyster' and I can't find any 
setting [here](https://maven.apache.org/archetype/maven-archetype-plugin/generate-mojo.html) to fix that.  
Maven is a pain in the neck sometimes/always!

### Updating JUnit 

The npm tool for node.js allows you to easily find versions of code (using npm view <package>) it didn't seem as easy to do this with maven 
though [this post](http://stackoverflow.com/questions/2687220/maven-check-for-updated-dependencies-in-repository) helped

```
mvn versions:display-dependency-updates
```

This gave the following output

```
[INFO] artifact junit:junit: checking for updates from central
[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   junit:junit ............................................ 3.8.1 -> 4.12
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 28.322 s
[INFO] Finished at: 2016-11-28T12:30:36+00:00
[INFO] Final Memory: 14M/157M
[INFO] ------------------------------------------------------------------------
```

### Downloading Dependencies

I Had to include the hamcrest library dependency when realising that the hamcrest-core doesn't have the Matchers class.

Adding this to the pom is easy but then need to get the jar actually pulled into the local repository, used the following command

```
mvn dependency:resolve
```

Had to kick intelliJ by right-clicking on the pom.xml file and selecting the Maven->ReImport menu.