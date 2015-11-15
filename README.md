# LireJarp
## General Idea ##
LireJarp enables you to setup JEE projects quickly. It is driven by the idea to provide a project template 
covering:
* rapid project setup
* code standardization and naming conventions
* possibility to individually adopt code 
* create your own codetemplates
* rapid GUI design
** designer friendly HMTL and AngularJS frontend
** fast one-click deployment of UI changes

## Sub Projects ##
This project has three sub projects. 
* [LireJarp project] (https://github.com/witchpou/lirejarp/tree/master/lirejarp) which contains the actual project template and is the base for developing your application. It consists of following subprojects:
  * [persistence]: entities and services for database access
  * [business]: REST API to connect the frontend with the backend
  * [frontend]: HTML and AngularJS based frontend
* [TomEE] (https://github.com/witchpou/lirejarp/tree/master/tomee) provides a JEE runtime for your application. 
* [Project Builder] (https://github.com/witchpou/lirejarp/tree/master/projectbuilder) helps you setup a new project by renaming stuff and generating some basic code.

#Installation
## Prerequisites ##
* Java 7 SE Development Kit (binaries on PATH, JAVA_HOME set)
* Maven (mvn on PATH)
* Passion for software development ;)

## Quick Introduction ##

* git clone whole repo
* ```mvn package``` in Project Builder
* run ```java -jar target/projectbuilder.jar```
* Define your project name and a domain object and generate code
* ```mvn package``` in folder LireJarp
* ```mvn tomee:start``` in folder tomee
* Browse to http://localhost:8080/lirejarp
