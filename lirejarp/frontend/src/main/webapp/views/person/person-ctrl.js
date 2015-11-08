var personControllers = {};
personControllers.loadPersonController = function($rootScope, $scope, $location, personConnectorFactory, $translate, $translatePartialLoader, gotoPerson) {
	$translatePartialLoader.addPart('person-translation');
	$translatePartialLoader.addPart('global');
	$translate.refresh();	
	
	$scope.personAll = [];
	$scope.refresh = function() { personConnectorFactory.getPersonAll($scope); };
	$scope.gotoUpdatePerson = function(id) { gotoPerson.update($location, id); };
	$scope.gotoCreatePerson = function () { gotoPerson.create($location); };
	$scope.deletePerson = function(id) {	personConnectorFactory.deletePerson($scope, id);};
	$scope.setSelected = function (idSelected) { $scope.idSelected = idSelected; };
	
	init();
	function init() {
		//change title on view change
		$scope.$on('$routeChangeSuccess', function (scope, next, current) {
			$scope.title=next.title;
			$scope.subtitle=next.subtitle;
		});
		$scope.refresh();
	}
	
	$scope.doBack = function () {
		gotoPerson.back($location);
	};
};

personControllers.maintainPersonController = function ($scope, $routeParams, $location, personConnectorFactory, $translate, $translatePartialLoader, gotoPerson) {
	$translatePartialLoader.addPart('person-translation');
	$translatePartialLoader.addPart('global');
	$translate.refresh();	

	$scope.person = {};
	init();
	
	function init() {
		$scope.$on('$routeChangeSuccess', function (scope, next, current) {
			$scope.title = next.title;
			$scope.mode = next.mode;
			if ($routeParams.id != undefined) {
				personConnectorFactory.loadPerson($scope, $routeParams.id);
			}
		});
	};
	
	$scope.doMaintain = function () {
		if ($scope.mode == 'update') {
			personConnectorFactory.updatePerson($scope, function($location) {gotoPerson.all($location);}, function($location) {gotoPerson.update($location, $scope.person.id);});
		} else {
			personConnectorFactory.createPerson($scope, function($location) {gotoPerson.all($location);}, function($location) {gotoPerson.create($location);});
		}
	};
	
	$scope.doBack = function () {
		gotoPerson.all($location);
	};
};