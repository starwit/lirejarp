var controllers = {};
var context = '../../';

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

controllers.newsController = function ($scope, $location, restConnectorFactory) {
	
	//init datastructures
	$scope.news = [];

	init();

	function init() {
		loadAllNews();
	};

	function loadAllNews() {
		$scope.news = [];

		restConnectorFactory.getAllNews($scope, context);
	};

	$scope.refresh = function() {
		restConnectorFactory.getAllNews($scope, context);
	}
	
	// edit stuff
	
	$scope.gotoEdit = function (id) {
		$location.path('/news_maintain/' + id);
	};
	
};

controllers.newsMaintainController = function ($scope, $routeParams, $location, restConnectorFactory) {
	
	console.log($routeParams.id);
	
	//init datastructures
	$scope.news = [];

	init();

	function init() {
		//load news for provided route param
		restConnectorFactory.loadNews($scope, $routeParams.id);
	};
	
	$scope.doEdit = function () {
		//do edit
		console.log('TODO');
		restConnectorFactory.updateOrCreate($scope.news, $location);
	};
};
