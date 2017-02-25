# How To
* ![General](https://github.com/witchpou/lirejarp)
* ![application server (tomee) usage](https://github.com/witchpou/lirejarp/tree/master/tomee)
* ![architecture](https://github.com/witchpou/lirejarp/blob/master/architecture.md)
* ![webclient](https://github.com/witchpou/lirejarp/tree/master/lirejarp/webclient)

# Architecture

Yet still a lot of boiler plate code needs to be written and creating JEE application quickly remains a challenge. Therefore approach described here shall provide a guide in how to setup an architecture implementing persistence and a RESTful interface layer. To do that properly a (reusable) pattern of inheritance + generic data types is proposed. This (yet unnamed) pattern is applied in persistence, Enterprise Java Beans and in RESTful web service implementation and therefore proved to be quite flexible. If you want to build an web-application, Project Builder provides you a platform to fulfill your ideas. Nevertheless, you have all flexibility to change your application. If you want to have a software which is easy to implement and easy to change, you should use standards. You will find these standards in the lirejarp project template.

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
