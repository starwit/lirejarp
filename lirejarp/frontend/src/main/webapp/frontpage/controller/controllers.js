var controllers = {};
var context = '../../'

controllers.mainController = function($rootScope, $scope, $location, restConnectorFactory) {
	
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
		restConnectorFactory.getNewsToday($rootScope);
		restConnectorFactory.getCategories($rootScope);
	};

	//news
	function loadNewsToday() {
		$rootScope.news = [];
		restConnectorFactory.getNewsToday($rootScope);
	};
	
	//category
	function loadCategories() {
		$rootScope.categories = [];
		restConnectorFactory.getCategories($rootScope);
	};
};

controllers.newsByCategoryController = function ($rootScope, $scope, $routeParams, $location, restConnectorFactory) {
	
	console.log($routeParams.id);
	
	//init datastructures
	$rootScope.news = [];
	$rootScope.categories = [];
	$scope.id = $routeParams.id;

	init();
	
	function init() {
		//change title on view change
		if ($routeParams.id != undefined) {
			restConnectorFactory.getNewsByCategory($rootScope, $routeParams.id);
			restConnectorFactory.getCategories($rootScope);
			restConnectorFactory.loadCategory($scope, $routeParams.id);
		}
	}
	
	$scope.refresh = function() {
		restConnectorFactory.getNewsByCategory($rootScope, id);
		restConnectorFactory.getCategories($rootScope);
		restConnectorFactory.loadCategory($scope, $routeParams.id);
	};
};

