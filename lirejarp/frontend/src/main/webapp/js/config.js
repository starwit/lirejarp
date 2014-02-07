/**
 * 
 */

var lireJarpApp = angular.module('lireJarpApp', [ 'ngRoute' ]);
lireJarpApp.controller(controllers);

// route config
lireJarpApp.config(function($routeProvider) {
	$routeProvider.when('/', {
		controller : 'newsController',
		title : "Recent News",
		subtitle : "",
		templateUrl : "views/news_today.html"
	}).otherwise({
		redirectTo : '/'
	});
});

//add factories
lireJarpApp.factory('serviceConnector', serviceConnector);