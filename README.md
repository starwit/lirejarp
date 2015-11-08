# LireJarp
LireJarp is a repository that is driven by the idea to provide a project template 
covering:
* a compact JEE based backend architecture based on patterns
* a Javascript frontend based on AngularJS
* a project setup tool
* a runtime environment based on TomEE

## General Idea ##

## Prerequisites ##
* Java Runtime (binaries on PATH, JAVA_HOME set)
* Maven (mvn on PATH)
* Passion for software development ;)

## Sub Projects ##
This project has three sub projects. Main part is the [LireJarp project] (https://github.com/witchpou/lirejarp/tree/master/lirejarp) which contains the actual project template and is the base for developing your application. Sub project [TomEE] (https://github.com/witchpou/lirejarp/tree/master/tomee) provides a JEE runtime for your application. 
[Project Builder] (https://github.com/witchpou/lirejarp/tree/master/projectbuilder) helps you setup a new project by renaming stuff and generating some basic code.

## Quick Introduction ##

* git clone whole repo
* ```mvn package``` in Project Builder
* run ```java -jar target/projectbuilder.jar```
* Define your project name and a domain object
* Generate code
* ```mvn package``` in folder LireJarp
* ```mvn tomee:start``` in folder tomee
* Browse to http://localhost:8080/lirejarp
