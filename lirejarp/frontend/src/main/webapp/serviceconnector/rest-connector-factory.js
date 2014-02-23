//factory functions

function restConnectorFactory ($http, $location) {
	var factory = {};
	
	factory.getAllNews = function($scope, context) {
		$http.get(context+'api/news/all')
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
	
	factory.updateOrCreate = function(news, $location) {
		$http.post('../../api/news/', news)
		.then(function(data) {
			//lsdkndskgf
			$location.path('/');
		});
	};
	
	return factory;
}