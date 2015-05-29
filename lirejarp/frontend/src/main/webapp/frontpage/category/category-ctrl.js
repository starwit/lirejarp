var categoryControllers = {};

categoryControllers.newsByCategoryController = function ($rootScope, $scope, $routeParams, $location, categoryConnectorFactory) {
	
	console.log($routeParams.id);
	
	//init datastructures
	$rootScope.news = [];
	$rootScope.categories = [];
	$scope.id = $routeParams.id;

	init();
	
	function init() {
		//change title on view change
		if ($routeParams.id != undefined) {
			categoryConnectorFactory.getNewsByCategory($rootScope, $routeParams.id);
			categoryConnectorFactory.getCategories($rootScope);
			categoryConnectorFactory.loadCategory($scope, $routeParams.id);
		}
	}
	
	$scope.refresh = function() {
		categoryConnectorFactory.getNewsByCategory($rootScope, id);
		categoryConnectorFactory.getCategories($rootScope);
		categoryConnectorFactory.loadCategory($scope, $routeParams.id);
	};
};