# Introduction Webclient

The following text provides an explanation of the webclient build with AngularJS 1.x. It shall also help to learn AngularJS by example and no previous knowledge of this technologie is assumed. The mentioned sourcecode is located in **src/main/webapp**.

## app.module.js

### module definition

In **app.module.js**, a **module named lirejarpApp** is created: 

```
angular.module('lirejarpApp', [
```
This module is used as app as we will see later.

A module contains the different components of an AngularJS app. In our case, all defined domains are components. We created the domains *project*, *domain* and *generator*. to prevent confusion if you want to add more than one app in future, the prefix *lirejarpApp.* is added to each module contained in *lirejarpApp*. We used also the module *pascalprecht.translate* for language translation and *ngRoute* for navigation:

```
angular.module('lirejarpApp', [
	    'pascalprecht.translate',
	  
	    //###BEGIN### include generated files
		'lirejarpApp.project',
		'lirejarpApp.domain',
		'lirejarpApp.generator',
		//###END### include generated files
		'ngRoute'
	]);
```

### global controller definition

To handle global stuff in the app, a **controller** named *appController* is defined. A controllers manage the data of your app.


```
	/**
	 * Controller for global behavior when changing the view (routeChange).
	 * @param $scope
	 * @returns
	 */
	function appController($scope, $window) {
		$scope.locale = $window.navigator.language || $window.navigator.userLanguage; 
		$scope.$on('$routeChangeSuccess', function (scope, next, current) {
			$scope.title=next.title;
			$scope.subtitle=next.subtitle;
		});
	}
```

This controller is added to the module *lirejarpApp*:


```
	angular.module('innovationlabApp').controller('appController', appController);
```
## index.html

In index.html, you will find `<html lang="<%= locale %>" ng-app="lirejarpApp"  ng-controller="appController">` as first line. This line will be explained in the following text.

### add module lirejarpApp as app to the page

`ng-app="lirejarpApp"` is added. *ng-app* is a **directive**. The module 'lirejarpApp' will be available in the `<html>` tag and defines the application scope.

### add controller appController to the page
The directive `ng-controller="appController"` adds the controller *appController* (defined in app.module.js) to the page. The controller has an own scope. Hence, all properties attached to $scope in appController are avaiable in the html-tag in which the controller is defined. Because the controller is defined in `<html>`-tag, the scope is available in the whole page. E.g. to access $scope.title, we use *{{title}}*. {{title}} is an **expression**. Expressions are used to display values on the page. In this way we can communicate between html-page (view) and controller.

