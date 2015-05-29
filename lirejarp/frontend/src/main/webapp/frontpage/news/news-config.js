'use strict';

var newsModule = angular.module('lireJarpApp.news', ['ngRoute', 'lireJarpApp.category'])

newsModule.config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		controller : 'mainController',
		title : "Recent News",
		subtitle : "",
		templateUrl : "news/news_today.html"
	}).otherwise({
		redirectTo : '/'
	});
}]);

newsModule.controller(newsControllers);
newsModule.factory('newsConnectorFactory', newsConnectorFactory);
