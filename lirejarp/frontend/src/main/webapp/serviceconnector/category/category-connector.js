function categoryConnectorFactory ($http, $location, restConnectorFactory) {
	var factory = {};
	
	factory.getCategories = function($rootScope) {
		$http.get('../api/category/query/all')
		.then(function (response) {
			content = response.data;
			$rootScope.categories = content.result;		
		});
	};
		
	factory.loadCategory = function($scope, id) {
		$http.get('../api/category/query/' + id)
		.then(function (response) {
			content = response.data;
			$scope.category = content.result;		
		});
	};
		
	factory.createCategory = function($scope, $location) {
		$http.put('../api/category/create/', $scope.category)
		.then(function(response) {
			restConnectorFactory.handleResponse($scope, $location, response, '/',  '/category_maintain/create/');
		});
	};
		
	factory.updateCategory = function($scope, $location) {
		$http.post('../api/category/update/', $scope.category)
		.then(function(response) {
			restConnectorFactory.handleResponse($scope, $location, response, '/', '/category_maintain/update/' + $scope.category.id);
		});
	};
		
	factory.deleteCategory = function($scope, id) {
		$http.delete('../api/category/delete/' + id)
		.then(function(response) {
			content = response.data;
			$scope.protocol = content.result;
			factory.getCategories($scope.$root);
		});
	};
		
	factory.getNewsByCategory = function($rootScope, id) {
		$http.get('../api/news/ext/category/' + id)
		.then(function (response) {
			content = response.data;
			$rootScope.news = content.result;		
		});
	};
	
	return factory;
}