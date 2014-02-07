//factory functions

function restConnectorFactory ($http, $location) {
	var factory = {};
	
	factory.getAllNews = function($scope) {
		$http.get('api/news/all')
		.then(function (data) {
			content = data.data;
			$scope.news = content.result;		
		});
	};
	
	return factory;
}