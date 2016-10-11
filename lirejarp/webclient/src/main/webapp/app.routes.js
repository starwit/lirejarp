/** 
 * Navigation and routing for module ljprojectbuilderApp.
 */
angular.module('lirejarpApp').config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/'});
}]);
