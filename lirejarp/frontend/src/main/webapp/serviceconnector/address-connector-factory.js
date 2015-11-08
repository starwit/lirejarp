function addressConnectorFactory ($http, $location, restConnectorFactory) {
	var factory = {};
	
	factory.getAddressAll = function($scope) {
		$http.get('api/address/query/all')
		.then(function (response) {
			content = response.data;
			$scope.addressAll = content.result;		
		});
	};
		
	factory.loadAddress = function($scope, id) {
		$http.get('api/address/query/' + id)
		.then(function (response) {
			content = response.data;
			$scope.address = content.result;		
		});
	};
		
	factory.createAddress = function($scope, successPath, errorPath) {
		$http.put('api/address/', $scope.address)
		.then(function(response) {
			restConnectorFactory.handleResponse($scope, response, successPath,  errorPath);
		});
	};
		
	factory.updateAddress = function($scope, successPath, errorPath) {
		$http.post('api/address/', $scope.address)
		.then(function(response) {
			restConnectorFactory.handleResponse($scope, response, successPath, errorPath);
		});
	};
		
	factory.deleteAddress = function($scope, id) {
		$http.delete('api/address/' + id)
		.then(function(response) {
			content = response.data;
			$scope.protocol = content.result;
			factory.getAddressAll($scope);
		});
	};
	
	factory.getAllowedFields = function($scope) {
		$http.get('api/address/query/allowedvalues')
		.then(function(response) {
			content = response.data;
			restConnectorFactory.getAllowedFields($scope, content);
		});
	};
		
	return factory;
}