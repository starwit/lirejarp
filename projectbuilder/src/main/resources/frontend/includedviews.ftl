'use strict';

// Declare app level module which depends on views, and components
var ${appName}App = angular.module('${appName}App', [
    'pascalprecht.translate',
	<#list (domainnames) as name>
	  '${appName}App.${name?lower_case}',
	</#list>
	'ngRoute'
]);

${appName}App.config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/'});
}]);

${appName}App.config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/views/mytest-all/'});
}]);

${appName}App.config(['$translateProvider', function($translateProvider, $translatePartialLoaderProvider ) {
	$translateProvider.useLoader('$translatePartialLoader', {
		urlTemplate: 'localization/{lang}/{part}.json'
	});

	$translateProvider.preferredLanguage('de-DE')
	  .useSanitizeValueStrategy('escaped') // Security for escaping variables
	  .usePostCompiling(true); // Post compiling angular filters
}]);
	

${appName}App.factory('restConnectorFactory', restConnectorFactory);