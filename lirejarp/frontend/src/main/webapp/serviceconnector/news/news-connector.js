function newsConnectorFactory ($http, $location, restConnectorFactory, categoryConnectorFactory) {
	var factory = {};
	
	factory.importAll = function($scope) {
		$http.get('../api/importexport/importall')	
		.then(function(response) {
			categoryConnectorFactory.getCategories($scope.$root);
			factory.getNewsToday($scope.$root);
		});
	};
	
	factory.getNewsToday = function($rootScope) {
		$http.get('../api/news/ext/today')
		.then(function (data) {
			content = data.data;
			$rootScope.news = content.result;		
		});
	};

	factory.loadNews = function($scope, id) {
		$http.get('../api/news/query/' + id)
		.then(function(response) {
			content = response.data;
			console.log(content);
			$scope.news = content.result;
		});
	};
	
	factory.updateNews = function($scope, $location) {
		$http.post('../api/news/update', $scope.news)
		.then(function(response) {
			restConnectorFactory.handleResponse($scope, $location, response, '/', '/news_maintain/update/' + $scope.news.id);
		});
	};
	
	factory.createNews = function($scope, $location) {
		$http.put('../api/news/create', $scope.news)
		.then(function(response) {
			restConnectorFactory.handleResponse($scope, $location, response, '/',  '/news_maintain/create/');
		});
	};
	
	factory.deleteNews = function($scope, id) {
		$http.delete('../api/news/delete/' + id)
		.then(function(response) {
			content = response.data;
			console.log(content);
			$scope.protocol = content.result;
			factory.getNewsToday($scope.$root)
		}, function(response) {
			content = $q.reject(response.data);
		});
	};
	
	return factory;
}