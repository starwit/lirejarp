'use strict';

var categoryModule = angular.module('lireJarpApp.category', ['ngRoute']);

categoryModule.config(['$routeProvider', function($routeProvider) {

	$routeProvider.when('/news_category/:id', {
		controller : 'newsByCategoryController',
		title : "Category News",
		subtitle : "",
		templateUrl : "category/news_category.html"
	}).otherwise({
		redirectTo : '/'
	});
}])

categoryModule.controller(categoryControllers);
categoryModule.factory('categoryConnectorFactory', categoryConnectorFactory);
