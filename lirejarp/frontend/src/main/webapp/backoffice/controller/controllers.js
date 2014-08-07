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

	$scope.gotoUpdateNews = function (id) {
		$location.path('/news_maintain/update/' + id);
	};
	
	$scope.gotoCreateNews = function () {
		$location.path('/news_maintain/create/');
	};
	
	$scope.deleteNews = function(id) {
		restConnectorFactory.deleteNews($scope, id);
	};
	
	//category
	function loadCategories() {
		$rootScope.categories = [];
		restConnectorFactory.getCategories($rootScope);
	};
	
	$scope.deleteCategory = function(id) {
		restConnectorFactory.deleteCategory($scope, id);
	};
	
	$scope.gotoUpdateCategory = function (id) {
		$location.path('/category_maintain/update/' + id);
	};
	
	$scope.gotoCreateCategory = function () {
		$location.path('/category_maintain/create/');
	};
	
	$scope.importAll = function() {
		restConnectorFactory.importAll($scope);
	};
};

controllers.newsCreateController = function ($scope, $routeParams, $location, restConnectorFactory) {
	console.log($routeParams.id);
	$scope.news = {};
	
	$scope.doMaintain = function () {
		//do edit
		console.log($scope.news);
		restConnectorFactory.createNews($scope, $location);
	};
	
};

controllers.newsUpdateController = function ($scope, $routeParams, $location, restConnectorFactory) {
	
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
	
	$scope.doMaintain = function () {
		//do edit
		console.log($scope.news);
		restConnectorFactory.updateNews($scope, $location);
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

controllers.categoryCreateController = function ($scope, $routeParams, $location, restConnectorFactory) {
	
	console.log($routeParams.id);
	
	//init datastructures
	$scope.category = {};
	
	$scope.doMaintain = function () {
		//do edit
		console.log($scope.category);
		restConnectorFactory.createCategory($scope, $location);
	};
};

controllers.categoryUpdateController = function ($scope, $routeParams, $location, restConnectorFactory) {
	
	console.log($routeParams.id);
	
	//init datastructures
	$scope.category = {};

	init();

	function init() {
		restConnectorFactory.loadCategory($scope, $routeParams.id);
	};
	

	
	$scope.doMaintain = function () {
		//do edit
		console.log($scope.category);
		restConnectorFactory.updateCategory($scope, $location);
	};
};
