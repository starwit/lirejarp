
# How To
* ![application server (tomee) usage](https://github.com/witchpou/lirejarp/tree/master/tomee)
* ![architecture](https://github.com/witchpou/lirejarp/blob/master/architecture.md)
* ![webclient](https://github.com/witchpou/lirejarp/tree/master/lirejarp/webclient)

# Architecture

The following class diagramm shows the general architecture.

![](https://github.com/witchpou/lirejarp/blob/master/docs/images/classDiagramm.png?raw=true)

## Subprojects ##
LireJarp contains the lirejarp application itself and the application server as well as builds scripts to install, start and stop the application.
* [LireJarp project] (https://github.com/witchpou/lirejarp/tree/master/lirejarp) which contains the actual project template and is the base for developing your application. It consists of following subprojects:
  * [persistence]: entities and services for database access
  * [business]: REST API to connect the frontend with the backend
  * [frontend]: HTML and AngularJS based frontend
  * [packagewar]: Used to create the war-file
* [TomEE] (https://github.com/witchpou/lirejarp/tree/master/tomee) provides a JEE runtime for your application. 

The following component diagram shows the structure of the project.

![Component Diagram LireJarp](https://wp.starwit.de/ljprojectbuilder/wp-content/uploads/sites/7/2017/02/komponentendiagrammPS-LireJarp.png)
