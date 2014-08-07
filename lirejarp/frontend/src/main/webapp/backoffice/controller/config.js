/**
 * 
 */

var lireJarpApp = angular.module('lireJarpApp', [ 'ngRoute' ]);
lireJarpApp.controller(controllers);

lireJarpApp.value('$strapConfig', {
	datepicker: {
	language: 'de',
	format: 'M d, yyyy'
	}
	});

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
	}).when('/news_maintain/create/', {
		controller : 'newsCreateController',
		title : "Create News",
		subtitle : "",
		templateUrl : "views/news_maintain.html"
	}).when('/news_maintain/update/:id', {
		controller : 'newsUpdateController',
		title : "Update News",
		subtitle : "",
		templateUrl : "views/news_maintain.html"			
	}).when('/category_maintain/create/', {
		controller : 'categoryCreateController',
		title : "Create Category",
		subtitle : "",
		templateUrl : "views/category_maintain.html"
	}).when('/category_maintain/update/:id', {
		controller : 'categoryUpdateController',
		title : "Update Category",
		subtitle : "",
		templateUrl : "views/category_maintain.html"
	}).otherwise({
		redirectTo : '/'
	});
});

//add factories
lireJarpApp.factory('restConnectorFactory', restConnectorFactory);