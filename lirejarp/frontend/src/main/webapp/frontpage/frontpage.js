'use strict';

// Declare app level module which depends on views, and components
var lireJarpApp = angular.module('lireJarpApp', [
  'ngRoute',
  'lireJarpApp.category',
  'lireJarpApp.news'
]);

lireJarpApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/news'});
}]);

lireJarpApp.factory('restConnectorFactory', restConnectorFactory);