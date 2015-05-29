'use strict';

var categoryModule = angular.module('lireJarpApp.category', ['ngRoute']);

categoryModule.config(['$routeProvider', function($routeProvider) {

  $routeProvider.when('/news_category/:id', {
		controller : 'newsByCategoryController',
		title : "Category News",
		subtitle : "",
		templateUrl : "category/news_category.html"
	}).when('/category_maintain/create/', {
		controller : 'categoryCreateController',
		title : "Create Category",
		subtitle : "",
		templateUrl : "category/category_maintain.html"
	}).when('/category_maintain/update/:id', {
		controller : 'categoryUpdateController',
		title : "Update Category",
		subtitle : "",
		templateUrl : "category/category_maintain.html"
	});
}])

categoryModule.controller(categoryControllers);
categoryModule.factory('categoryConnectorFactory', categoryConnectorFactory);
