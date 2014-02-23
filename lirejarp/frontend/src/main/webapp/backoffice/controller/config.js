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
	}).when('/news_maintain/:id', {
		controller : 'newsMaintainController',
		title : "Recent News",
		subtitle : "",
		templateUrl : "views/news_maintain.html"
	}).otherwise({
		redirectTo : '/'
	});
});

//add factories
lireJarpApp.factory('restConnectorFactory', restConnectorFactory);