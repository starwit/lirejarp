function personConnectorFactory ($http, $location, restConnectorFactory) {
	var factory = {};
	
	factory.getPersonAll = function($scope) {
		$http.get('api/person/query/all')
		.then(function (response) {
			content = response.data;
			$scope.personAll = content.result;		
		});
	};
		
	factory.loadPerson = function($scope, id) {
		$http.get('api/person/query/' + id)
		.then(function (response) {
			content = response.data;
			$scope.person = content.result;		
		});
	};
		
	factory.createPerson = function($scope, successPath, errorPath) {
		$http.put('api/person/', $scope.person)
		.then(function(response) {
			restConnectorFactory.handleResponse($scope, response, successPath,  errorPath);
		});
	};
		
	factory.updatePerson = function($scope, successPath, errorPath) {
		$http.post('api/person/', $scope.person)
		.then(function(response) {
			restConnectorFactory.handleResponse($scope, response, successPath, errorPath);
		});
	};
		
	factory.deletePerson = function($scope, id) {
		$http.delete('api/person/' + id)
		.then(function(response) {
			content = response.data;
			$scope.protocol = content.result;
			factory.getPersonAll($scope);
		});
	};
	
	factory.getAllowedFields = function($scope) {
		$http.get('api/person/query/allowedvalues')
		.then(function(response) {
			content = response.data;
			restConnectorFactory.getAllowedFields($scope, content);
		});
	};
		
	return factory;
}