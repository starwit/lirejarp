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

	$scope.gotoUpdateNews = function (id) {
		$location.path('/news_maintain/update/' + id);
	};
	
	$scope.gotoCreateNews = function () {
		$location.path('/news_maintain/create/');
	};
	
	$scope.deleteNews = function(id) {
		newsConnectorFactory.deleteNews($scope, id);
	};
	
	//category
	function loadCategories() {
		$rootScope.categories = [];
		categoryConnectorFactory.getCategories($rootScope);
	};
	
	$scope.deleteCategory = function(id) {
		categoryConnectorFactory.deleteCategory($scope, id);
	};
	
	$scope.gotoUpdateCategory = function (id) {
		$location.path('/category_maintain/update/' + id);
	};
	
	$scope.gotoCreateCategory = function () {
		$location.path('/category_maintain/create/');
	};
	
	$scope.importAll = function() {
		newsConnectorFactory.importAll($scope);
	};
};

newsControllers.newsCreateController = function ($scope, $routeParams, $location, newsConnectorFactory) {
	console.log($routeParams.id);
	$scope.news = {};
	
	$scope.doMaintain = function () {
		//do edit
		console.log($scope.news);
		newsConnectorFactory.createNews($scope, $location);
	};
	
};

newsControllers.newsUpdateController = function ($scope, $routeParams, $location, newsConnectorFactory) {
	
	console.log($routeParams.id);
	
	//init datastructures
	$scope.news = {};
	init();

	function init() {
		//load news for provided route param
		if ($routeParams.id != undefined) {
			newsConnectorFactory.loadNews($scope, $routeParams.id);
		}	
	};
	
	$scope.doMaintain = function () {
		//do edit
		console.log($scope.news);
		newsConnectorFactory.updateNews($scope, $location);
	};
	
};