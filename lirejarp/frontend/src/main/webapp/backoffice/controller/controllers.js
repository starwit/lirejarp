var controllers = {};

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

	$scope.gotoEditNews = function (id) {
		$location.path('/news_maintain/' + id);
	};
	
	$scope.gotoCreateNews = function () {
		$location.path('/news_maintain/');
	};
	
	$scope.deleteNews = function(id) {
		restConnectorFactory.deleteNews($scope, id);
		loadNewsToday();
	};
	
	//category
	function loadCategories() {
		$rootScope.categories = [];
		restConnectorFactory.getCategories($rootScope);
	};
	
	$scope.deleteCategory = function(id) {
		restConnectorFactory.deleteCategory($scope, id);
		loadCategories();
		loadNewsToday();
	};
	
	$scope.gotoEditCategory = function (id) {
		$location.path('/category_maintain/' + id);
	};
	
	$scope.gotoCreateCategory = function () {
		$location.path('/category_maintain/');
	};
};

controllers.newsMaintainController = function ($scope, $routeParams, $location, restConnectorFactory) {
	
	console.log($routeParams.id);
	
	//init datastructures
	$scope.news = {};
	init();

	function init() {
		//load news for provided route param
		if ($routeParams.id != undefined) {
			restConnectorFactory.loadNews($scope, $routeParams.id);
		}	
	};
	
	$scope.doEdit = function () {
		//do edit
		console.log($scope.news);
		restConnectorFactory.updateOrCreateNews($scope.news, $location);
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

controllers.categoryMaintainController = function ($scope, $routeParams, $location, restConnectorFactory) {
	
	console.log($routeParams.id);
	
	//init datastructures
	$scope.category = {};

	init();

	function init() {
		//load news for provided route param
		if ($routeParams.id != undefined) {
			restConnectorFactory.loadCategory($scope, $routeParams.id);
		}	
	};
	
	$scope.doEdit = function () {
		//do edit
		console.log($scope.category);
		restConnectorFactory.updateOrCreateCategory($scope.category, $location);
	};
};
