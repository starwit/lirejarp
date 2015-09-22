'use strict';

var ${domainLower}Module = angular.module('${appName}App.${domainLower}', ['ngRoute']).value('goto${domainLower}', {
    update: function(location, id) {
    	location.path('/views/${domainLower}-maintain/update/' + id);
    },
    create: function(location) {
    	location.path('/views/${domainLower}-maintain/create/');
    }
  });

${domainLower}Module.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('views/${domainLower}/all', {
		controller : 'load${domain}Controller',
		title : "${domain}.",
		subtitle : "",
		templateUrl : "views/${domainLower}/${domainLower}-all.html"
	}).when('/views/${domainLower}_maintain/create/', {
		controller : 'create${domain}Controller',
		title : "${domainLower}.create.title",
		subtitle : "",
		templateUrl : "views/${domainLower}/${domainLower}-maintain.html"
	}).when('/views/${domainLower}_maintain/update/:id', {
		controller : 'update${domain}Controller',
		title : "${domainLower}.update.title",
		subtitle : "",
		templateUrl : "views/${domainLower}/${domainLower}-maintain.html"
	});
}]);


${domainLower}Module.controller(${domainLower}Controllers);
${domainLower}Module.factory('${domainLower}ConnectorFactory', ${domainLower}ConnectorFactory);
