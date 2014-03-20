/**
 * 
 */

var lireJarpApp = angular.module('lireJarpApp', [ 'ngRoute' ]);
lireJarpApp.controller(controllers);

// route config
lireJarpApp.config(function($routeProvider) {
	$routeProvider.when('/', {
		controller : 'mainController',
		title : "Recent News",
		subtitle : "",
		templateUrl : "views/news_today.html"
	}).when('/news_category/:id', {
		controller : 'newsByCategoryController',
		title : "Category News",
		subtitle : "",
		templateUrl : "views/news_category.html"
	}).otherwise({
		redirectTo : '/'
	});
});

//add factories
lireJarpApp.factory('restConnectorFactory', restConnectorFactory);