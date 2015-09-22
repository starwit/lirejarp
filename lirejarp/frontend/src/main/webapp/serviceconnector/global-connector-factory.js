//factory functions

function restConnectorFactory ($http, $location) {
	var factory = {};
	
	factory.handleResponse = function($scope, $location, response, successPath, errorPath) {
		content = response.data;
		// promise fulfilled
        if (content.metadata.responseCode === 'OK') {
        	$location.path(successPath);
        } else {
        	$scope.message = content.metadata.message;		
        	$scope.validationErrors = content.metadata.validationErrors;	
        	$location.path(errorPath);
        }
	};
	return factory;
}
