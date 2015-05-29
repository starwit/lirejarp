var newsControllers = {};

newsControllers.mainController = function($rootScope, $scope, $location, newsConnectorFactory, categoryConnectorFactory) {
	
	//init datastructures
	$rootScope.news = [];
	$rootScope.categories = [];

	
	init();
	
	function init() {
		//change title on view change
		$scope.$on('$routeChangeSuccess', function (scope, next, current) {
			$scope.title=next.title;
			$scope.subtitle=next.subtitle;
		});
		
		loadNewsToday();
		loadCategories();
	}
	
	$scope.refresh = function() {
		newsConnectorFactory.getNewsToday($rootScope);
		categoryConnectorFactory.getCategories($rootScope);
	};

	//news
	function loadNewsToday() {
		$rootScope.news = [];
		newsConnectorFactory.getNewsToday($rootScope);
	};
	
	//category
	function loadCategories() {
		$rootScope.categories = [];
		categoryConnectorFactory.getCategories($rootScope);
	};
};
