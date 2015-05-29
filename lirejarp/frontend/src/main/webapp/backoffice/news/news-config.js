'use strict';

var newsModule = angular.module('lireJarpApp.news', ['ngRoute', 'lireJarpApp.category'])

newsModule.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/', {
		controller : 'mainController',
		title : "Recent News",
		subtitle : "",
		templateUrl : "news/news_today.html"
	}).when('/news_category/:id', {
		controller : 'newsByCategoryController',
		title : "Category News",
		subtitle : "",
		templateUrl : "news/news_category.html"
	}).when('/news_maintain/create/', {
		controller : 'newsCreateController',
		title : "Create News",
		subtitle : "",
		templateUrl : "news/news_maintain.html"
	}).when('/news_maintain/update/:id', {
		controller : 'newsUpdateController',
		title : "Update News",
		subtitle : "",
		templateUrl : "news/news_maintain.html"
	});
}]);

newsModule.controller(newsControllers);
newsModule.factory('newsConnectorFactory', newsConnectorFactory);
