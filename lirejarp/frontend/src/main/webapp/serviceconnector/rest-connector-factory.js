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
	
	factory.getAllowedFields = function($scope, allowedFields) {
		$scope.allowedfields = {};
		var i = 0;
		var len = allowedFields.length;
		var text = "";
		for (; i < len; i++) {
			var key = allowedFields[i].fieldname;
			var obj = {};
			$scope.allowedfields[key] = allowedFields[i].values;
		}
	}
	return factory;
}