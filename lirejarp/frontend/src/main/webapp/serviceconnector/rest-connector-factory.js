//factory functions

function restConnectorFactory ($http, $location) {
	var factory = {};
	
	factory.getAllNews = function($scope) {
		$http.get('../../api/news/all')
		.then(function (data) {
			content = data.data;
			$scope.news = content.result;		
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
	
	factory.getCategories = function($scope) {
		$http.get('../../api/category/all')
		.then(function (data) {
			content = data.data;
			$scope.categories = content.result;		
		});
	};
	
	factory.loadCategory = function($scope, id) {
		$http.get('../../api/category/' + id)
		.then(function (data) {
			content = data.data;
			$scope.categories = content.result;		
		});
	};
	
	factory.updateOrCreateCategory = function(category, $location) {
		$http.post('../../api/category/', category)
		.then(function(data) {
			$location.path('/');
		});
	};
	
	
	return factory;
}