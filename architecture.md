# How To
* ![General](https://github.com/witchpou/lirejarp)
* ![application server (tomee) usage](https://github.com/witchpou/lirejarp/tree/master/tomee)
* ![architecture](https://github.com/witchpou/lirejarp/blob/master/architecture.md)
* ![webclient](https://github.com/witchpou/lirejarp/tree/master/lirejarp/webclient)

# Architecture

## Subprojects
LireJarp contains the lirejarp application itself and the application server as well as builds scripts to install, start and stop the application.
* [LireJarp project] (https://github.com/witchpou/lirejarp/tree/master/lirejarp) which contains the actual project template and is the base for developing your application. It consists of following subprojects:
  * [persistence]: entities and services for database access
  * [business]: REST API to connect the frontend with the backend
  * [frontend]: HTML and AngularJS based frontend
  * [packagewar]: Used to create the war-file
* [TomEE] (https://github.com/witchpou/lirejarp/tree/master/tomee) provides a JEE runtime for your application. 

The following component diagram shows the structure of the project.

![Component Diagram LireJarp](https://wp.starwit.de/ljprojectbuilder/wp-content/uploads/sites/7/2017/02/komponentendiagrammPS-LireJarp.png)

## About implementing data access
You have a group of objects which are different in its structure but should implement the same basic behavior. You have a lots of data objects in your application for whom the standard CRUD-functionality should be provided? For this purpose, an AbstractDao is a common way to handle the implementation of the basic stuff. An AbstractEntity is created as base class for all entities. In the AbstractDao general CRUD functions are implemented using the AbstractEntity. E.g. http://sidaof.sourceforge.net/sidaof/ is a project, which implements an AbstractDao-class. Binding concrete entities to AbstractDao is done via generics.

The architecture presented here goes further and uses this pattern through all layers of the entire architecture: business services (EJBs), RESTful webservices and junit-tests. Data objects extends the class “AbstractEntity”. Each kind of service (EJB, restful webservice, jUnit-testclass) implements the general functionality around the data objects in an abstract class. For each data object and each kind of service concrete service-implementations are added. To prevent class-casts, generics ensure the usage of concrete data object in the abstract part of the implementation.

The following class diagramm shows the general architecture.

![](https://github.com/witchpou/lirejarp/blob/master/docs/images/classDiagramm.png?raw=true)

