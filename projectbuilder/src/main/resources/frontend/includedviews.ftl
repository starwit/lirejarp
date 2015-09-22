'use strict';

// Declare app level module which depends on views, and components
var ${appName}App = angular.module('${appName}App', [
	<#list (domainnames) as name>
	  '${appName}App.${name}',
	</#list>
	'ngRoute'
]);

${appName}App.config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/'});
}]);

${appName}App.factory('restConnectorFactory', restConnectorFactory);