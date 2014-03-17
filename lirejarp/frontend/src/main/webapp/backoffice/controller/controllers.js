var controllers = {};

controllers.mainController = function($scope, $location, restConnectorFactory) {
	
	//init datastructures
	$scope.news = [];
	$scope.categories = [];
	
	init();
	
	function init() {
		//change title on view change
		$scope.$on('$routeChangeSuccess', function (scope, next, current) {
			$scope.title=next.title;
			$scope.subtitle=next.subtitle;
		});
		
		loadAllNews();
		loadCategories();
	}
	
	$scope.refresh = function() {
		restConnectorFactory.getAllNews($scope);
		restConnectorFactory.getCategories($scope);
	}

	//news
	function loadAllNews() {
		$scope.news = [];

		restConnectorFactory.getAllNews($scope);
	};

	$scope.gotoEditNews = function (id) {
		$location.path('/news_maintain/' + id);
	};
	
	$scope.gotoCreateNews = function () {
		$location.path('/news_maintain/');
	};
	
	//category
	function loadCategories() {
		$scope.categories = [];
		restConnectorFactory.getCategories($scope);
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
