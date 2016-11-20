/** 
 * Navigation and routing for module ljprojectbuilderApp.
 */
angular.module('lirejarpApp').config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/viewcomponents/home/', {
		title : "home.title",
		subtitle : "",
		templateUrl : "viewcomponents/home.html"
	})	.otherwise({redirectTo: '/viewcomponents/home/'});
}]);
