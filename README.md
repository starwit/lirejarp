# LireJarp
## General Idea ##
LireJarp is the template for [LireJarp Project Builder](https://github.com/witchpou/lj-projectbuilder) and enables you to setup JEE projects quickly. It is driven by the idea to provide a project template 
covering:
* rapid project setup
* code standardization and naming conventions
* possibility to individually adopt code 
* create your own codetemplates
* rapid GUI design
** designer friendly HMTL and AngularJS frontend
** fast one-click deployment of UI changes

#Installation
## Prerequisites ##
* Java 8 SE Development Kit (binaries on PATH, JAVA_HOME set)
* Maven (mvn on PATH)
* Ant (on PATH)
* Passion for software development ;)

## Quick Introduction ##

* git clone whole repo
* go to lirejarp
* run ```ant setup_project```
* browse to http://localhost:8080/lirejarp

## Architecture ##

For Architecture, see projects `lirejarp` and `lj-project builder`. 

The following class diagramm shows the general architecture.

![](https://github.com/witchpou/lirejarp/blob/master/docs/images/classDiagramm.png?raw=true)

## Sub Projects ##
LireJarp contains the lirejarp application itself and the application server as well as builds scripts to install, start and stop the application.
* [LireJarp project] (https://github.com/witchpou/lirejarp/tree/master/lirejarp) which contains the actual project template and is the base for developing your application. It consists of following subprojects:
  * [persistence]: entities and services for database access
  * [business]: REST API to connect the frontend with the backend
  * [frontend]: HTML and AngularJS based frontend
  * [packagewar]: Used to create the war-file
* [TomEE] (https://github.com/witchpou/lirejarp/tree/master/tomee) provides a JEE runtime for your application. 

The following component diagram shows the structure of the project.

![Component Diagram LireJarp](https://wp.starwit.de/ljprojectbuilder/wp-content/uploads/sites/7/2017/02/komponentendiagrammPS-LireJarp.png)

