//factory functions

function restConnectorFactory ($http, $location) {
	var factory = {};
	
	factory.getAllNews = function($rootScope) {
		$http.get('../../api/news/all')
		.then(function (data) {
			content = data.data;
			$rootScope.news = content.result;		
		});
	};
	
	factory.loadNews = function($scope, id) {
		$http.get('../../api/news/' + id)
		.then(function(data) {
			content = data.data;
			console.log(content);
			$scope.news = content.result;
		});
	};
	
	factory.updateOrCreateNews = function(news, $location) {
		$http.post('../../api/news/', news)
		.then(function(data) {
			//lsdkndskgf
			$location.path('/');
		});
	};
	
	factory.deleteNews = function($scope, id) {
		$http.delete('../../api/news/' + id)
		.then(function(data) {
			content = data.data;
			console.log(content);
			$scope.protocol = content.result;
		});
	};
	
	factory.getCategories = function($rootScope) {
		$http.get('../../api/category/all')
		.then(function (data) {
			content = data.data;
			$rootScope.categories = content.result;		
		});
	};
	
	factory.loadCategory = function($scope, id) {
		$http.get('../../api/category/' + id)
		.then(function (data) {
			content = data.data;
			$scope.category = content.result;		
		});
	};
	
	factory.updateOrCreateCategory = function(category, $location) {
		$http.post('../../api/category/', category)
		.then(function(data) {
			$location.path('/');
		});
	};
	
	factory.deleteCategory = function($scope, id) {
		$http.delete('../../api/category/' + id)
		.then(function(data) {
			content = data.data;
			$scope.protocol = content.result;
		});
	};
	
	
	return factory;
}