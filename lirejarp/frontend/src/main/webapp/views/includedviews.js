'use strict';

// Declare app level module which depends on views, and components
var lirejarpApp = angular.module('lirejarpApp', [
    'pascalprecht.translate',
    //###begin### include generated files
	 'lirejarpApp.mytest',
	//###end### include generated files
	'ngRoute'
]);

lirejarpApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/'});
}]);

lirejarpApp.config(['$translateProvider', function($translateProvider, $translatePartialLoaderProvider ) {
	$translateProvider.useLoader('$translatePartialLoader', {
		urlTemplate: 'localization/{lang}/{part}.json'
	});

	$translateProvider.preferredLanguage('de-DE')
	  .useSanitizeValueStrategy('escaped') // Security for escaping variables
	  .usePostCompiling(true); // Post compiling angular filters
}]);
	

lirejarpApp.factory('restConnectorFactory', restConnectorFactory);