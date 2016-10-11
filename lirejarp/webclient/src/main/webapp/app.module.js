(function() {
	'use strict';
	/**
	 *  Declare app level module which depends on views, and components.
	 */
	angular.module('lirejarpApp', [
	    'pascalprecht.translate',
	    //DO NOT DELETE ###BEGIN### include generated files
		//DO NOT DELETE ###END### include generated files
		'ngRoute'
	]);
	
	/**
	 * Language Configuration via module pascalprecht.translate.
	 */
	angular.module('lirejarpApp').config(['$translateProvider', function($translateProvider) {
		$translateProvider
		.useStaticFilesLoader({
			prefix: 'localization/translations-',
			suffix: '.json'
		}).preferredLanguage('de-DE')
			.useSanitizeValueStrategy('escaped') // Security for escaping variables
			.usePostCompiling(true); // Post compiling angular filters
	}]);
	
	angular.module('lirejarpApp').controller('appController', appController);
	
	/**
	 * Controller for global behavior when changing the view (routeChange).
	 * @param $scope
	 * @returns
	 */
	function appController($scope) {
		$scope.$on('$routeChangeSuccess', function (scope, next, current) {
			$scope.title=next.title;
			$scope.subtitle=next.subtitle;
		});
	}

	/**
	 * Factories used globally in lirejarpApp. 
	 * To keep the scope as small as possible, add factories only used by submodules in the submodule itself.
	 */		
	angular.module('lirejarpApp').factory('restConnectorFactory', restConnectorFactory);
})();
