//factory functions

function restConnectorFactory ($http, $location) {
	var factory = {};
	
	factory.getNewsToday = function($rootScope) {
		$http.get('../../api/news/ext/today')
		.then(function (data) {
			content = data.data;
			$rootScope.news = content.result;		
		});
	};
	
	factory.getNewsByCategory = function($rootScope, id) {
		$http.get('../../api/news/ext/category/' + id)
		.then(function (data) {
			content = data.data;
			$rootScope.news = content.result;		
		});
	};
	
	factory.loadNews = function($scope, id) {
		$http.get('../../api/news/query/' + id)
		.then(function(response) {
			content = response.data;
			console.log(content);
			$scope.news = content.result;
		});
	};
	
	factory.updateNews = function($scope, $location) {
		$http.post('../../api/news/update', $scope.news)
		.then(function(response) {
			factory.handleResponse($scope, $location, response, '/', '/news_maintain/update/' + $scope.news.id);
		});
	};
	
	factory.createNews = function($scope, $location) {
		$http.put('../../api/news/create', $scope.news)
		.then(function(response) {
			factory.handleResponse($scope, $location, response, '/',  '/news_maintain/create/');
		});
	};
	
	factory.deleteNews = function($scope, id) {
		$http.delete('../../api/news/delete/' + id)
		.then(function(response) {
			content = response.data;
			console.log(content);
			$scope.protocol = content.result;
			factory.getNewsToday($scope.$root)
		}, function(response) {
			content = $q.reject(response.data);
		});
	};
	
	factory.getCategories = function($rootScope) {
		$http.get('../../api/category/query/all')
		.then(function (data) {
			content = data.data;
			$rootScope.categories = content.result;		
		});
	};
	
	factory.loadCategory = function($scope, id) {
		$http.get('../../api/category/query/' + id)
		.then(function (response) {
			content = response.data;
			$scope.category = content.result;		
		});
	};
	
	factory.updateCategory = function($scope, $location) {
		$http.post('../../api/category/update/', $scope.category)
		.then(function(response) {
			factory.handleResponse($scope, $location, response, '/', '/category_maintain/update/' + $scope.category.id);
		});
	};
	
	factory.createCategory = function($scope, $location) {
		$http.put('../../api/category/create/', $scope.category)
		.then(function(response) {
			factory.handleResponse($scope, $location, response, '/',  '/category_maintain/create/');
		});
	};
	
	factory.deleteCategory = function($scope, id) {
		$http.delete('../../api/category/delete/' + id)
		.then(function(data) {
			content = data.data;
			$scope.protocol = content.result;
			factory.getCategories($scope.$root);
		});
	};
	
	factory.importAll = function($scope) {
		$http.get('../../api/importexport/importall')	
		.then(function(response) {
			factory.getCategories($scope.$root);
			factory.getNewsToday($scope.$root);
		});
	};
	
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