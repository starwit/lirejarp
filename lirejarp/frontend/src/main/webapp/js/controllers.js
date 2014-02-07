var controllers = {};

controllers.mainController = function($scope, serviceConnector) {
	
	init();
	
	function init() {
		//change title on view change
		$scope.$on('$routeChangeSuccess', function (scope, next, current) {
			$scope.title=next.title;
			$scope.subtitle=next.subtitle;
		});
	}
};

controllers.newsController = function ($scope, serviceConnector) {
	
	//init datastructures
	$scope.news = [];

	init();

	function init() {
		loadAllNews();
	};

	function loadAllNews() {
		$scope.news = [];

		serviceConnector.getAllNews($scope);
	};

	$scope.refresh = function() {
		serviceConnector.getAllNews($scope);
	}
};
