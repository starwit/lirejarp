var controllers = {};

controllers.mainController = function($scope, restConnectorFactory) {
	
	init();
	
	function init() {
		//change title on view change
		$scope.$on('$routeChangeSuccess', function (scope, next, current) {
			$scope.title=next.title;
			$scope.subtitle=next.subtitle;
		});
	}
};

controllers.newsController = function ($scope, restConnectorFactory) {
	
	//init datastructures
	$scope.news = [];

	init();

	function init() {
		loadAllNews();
	};

	function loadAllNews() {
		$scope.news = [];

		restConnectorFactory.getAllNews($scope);
	};

	$scope.refresh = function() {
		restConnectorFactory.getAllNews($scope);
	}
};
