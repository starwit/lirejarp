function ${domainLower}ConnectorFactory ($http, $location, restConnectorFactory) {
	var factory = {};
	
	factory.get${domain}All = function($rootScope) {
		$http.get('api/${domainLower}/query/all')
		.then(function (response) {
			content = response.data;
			$rootScope.${domainLower}All = content.result;		
		});
	};
		
	factory.load${domain} = function($scope, id) {
		$http.get('api/${domainLower}/query/' + id)
		.then(function (response) {
			content = response.data;
			$scope.${domainLower} = content.result;		
		});
	};
		
	factory.create${domain} = function($scope, $location, gotoPath) {
		$http.put('api/${domainLower}/', $scope.${domainLower})
		.then(function(response) {
			restConnectorFactory.handleResponse($scope, $location, response, '/',  gotoPath);
		});
	};
		
	factory.update${domain} = function($scope, $location, gotoPath) {
		$http.post('api/${domainLower}/', $scope.${domainLower})
		.then(function(response) {
			restConnectorFactory.handleResponse($scope, $location, response, '/', gotoPath);
		});
	};
		
	factory.delete${domain} = function($scope, id) {
		$http.delete('api/${domainLower}/' + id)
		.then(function(response) {
			content = response.data;
			$scope.protocol = content.result;
			factory.get${domain}All($scope.$root);
		});
	};
	
	factory.getAllowedFields = function($scope) {
		$http.get('api/${domainLower}/query/allowedvalues')
		.then(function(response) {
			content = response.data;
			restConnectorFactory.getAllowedFields($scope, content);
		});
	};
		
	return factory;
}