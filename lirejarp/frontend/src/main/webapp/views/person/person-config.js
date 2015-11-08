'use strict';

var personModule = angular.module('lirejarpApp.person', ['ngRoute','pascalprecht.translate']).value('gotoPerson', {
    all: function(location) {
    	location.path('/views/person-all/');
    },
    update: function(location, id) {
    	location.path('/views/person-maintain/update/' + id);
    },
    create: function(location) {
    	location.path('/views/person-maintain/create/');
    },
    back: function(location) {
    	location.path('/');
    }    
});

personModule.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/views/person-all/', {
		controller : 'loadPersonController',
		title : "person.all.title",
		subtitle : "",
		templateUrl : "views/person/person-all.html"
	}).when('/views/person-maintain/create/', {
		controller : 'maintainPersonController',
		title : "person.create.title",
		subtitle : "",
		mode:"create",
		templateUrl : "views/person/person-single.html"
	}).when('/views/person-maintain/update/:id', {
		controller : 'maintainPersonController',
		title : "person.update.title",
		subtitle : "",
		mode:"update",
		templateUrl : "views/person/person-single.html"
	});
}]);

personModule.controller(personControllers);
personModule.factory('personConnectorFactory', personConnectorFactory);
