'use strict';

var addressModule = angular.module('lirejarpApp.address', ['ngRoute','pascalprecht.translate']).value('gotoAddress', {
    all: function(location) {
    	location.path('/views/address-all/');
    },
    update: function(location, id) {
    	location.path('/views/address-maintain/update/' + id);
    },
    create: function(location) {
    	location.path('/views/address-maintain/create/');
    },
    back: function(location) {
    	location.path('/');
    }    
});

addressModule.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/views/address-all/', {
		controller : 'loadAddressController',
		title : "address.all.title",
		subtitle : "",
		templateUrl : "views/address/address-all.html"
	}).when('/views/address-maintain/create/', {
		controller : 'maintainAddressController',
		title : "address.create.title",
		subtitle : "",
		mode:"create",
		templateUrl : "views/address/address-single.html"
	}).when('/views/address-maintain/update/:id', {
		controller : 'maintainAddressController',
		title : "address.update.title",
		subtitle : "",
		mode:"update",
		templateUrl : "views/address/address-single.html"
	});
}]);

addressModule.controller(addressControllers);
addressModule.factory('addressConnectorFactory', addressConnectorFactory);
