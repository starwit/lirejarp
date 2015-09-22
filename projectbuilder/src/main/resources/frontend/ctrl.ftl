var ${domainLower}Controllers = {};

${domainLower}Controllers.load${domain}Controller = function($rootScope, $scope, $location, ${domainLower}ConnectorFactory, goto${domainLower}) {
	
	//init datastructures
	$rootScope.${domainLower} = [];
	
	init();
	
	function init() {
		//change title on view change
		$scope.$on('$routeChangeSuccess', function (scope, next, current) {
			$scope.title=next.title;
			$scope.subtitle=next.subtitle;
		});
		
		load${domain}();
	}
	
	$scope.refresh = function() {
		${domainLower}ConnectorFactory.load${domain}($scope);
	};

	//news
	function load${domain}() {
		${domainLower}ConnectorFactory.load${domain}($scope);
	};

	$scope.gotoUpdate${domain} = function(id) { goto${domainLower}.update($location, id); };
	
	$scope.gotoCreate${domain} = function () { goto${domainLower}.create($location); };
	
	$scope.delete${domain} = function(id) {
		newsConnectorFactory.delete${domain}($scope, id);
	};
	
};

${domainLower}Controllers.create${domain}Controller = function ($scope, $routeParams, $location, ${domainLower}ConnectorFactory) {
	console.log($routeParams.id);
	$scope.${domain} = {};
	
	$scope.doMaintain = function () {
		//do edit
		console.log($scope.news);
		${domainLower}ConnectorFactory.create${domain}($scope, $location, function() {goto${domainLower}.create($location);});
	};
	
};

${domainLower}Controllers.update${domain}Controller = function ($scope, $routeParams, $location, ${domainLower}ConnectorFactory) {
	
	console.log($routeParams.id);
	
	//init datastructures
	$scope.${domain} = {};
	init();

	function init() {
		//load news for provided route param
		if ($routeParams.id != undefined) {
			${domainLower}ConnectorFactory.load${domain}($scope, $routeParams.id);
		}	
	};
	

	
	$scope.doMaintain = function () {
		//do edit
		console.log($scope.news);
		${domainLower}ConnectorFactory.update${domain}($scope, $location, function() {goto${domainLower}.update($location, $routeParams.id);} );
		
	};
	
};