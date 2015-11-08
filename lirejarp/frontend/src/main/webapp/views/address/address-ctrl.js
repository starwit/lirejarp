var addressControllers = {};
addressControllers.loadAddressController = function($rootScope, $scope, $location, addressConnectorFactory, $translate, $translatePartialLoader, gotoAddress) {
	$translatePartialLoader.addPart('address-translation');
	$translatePartialLoader.addPart('global');
	$translate.refresh();	
	
	$scope.addressAll = [];
	$scope.refresh = function() { addressConnectorFactory.getAddressAll($scope); };
	$scope.gotoUpdateAddress = function(id) { gotoAddress.update($location, id); };
	$scope.gotoCreateAddress = function () { gotoAddress.create($location); };
	$scope.deleteAddress = function(id) {	addressConnectorFactory.deleteAddress($scope, id);};
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
		gotoAddress.back($location);
	};
};

addressControllers.maintainAddressController = function ($scope, $routeParams, $location, addressConnectorFactory, $translate, $translatePartialLoader, gotoAddress) {
	$translatePartialLoader.addPart('address-translation');
	$translatePartialLoader.addPart('global');
	$translate.refresh();	

	$scope.address = {};
	init();
	
	function init() {
		$scope.$on('$routeChangeSuccess', function (scope, next, current) {
			$scope.title = next.title;
			$scope.mode = next.mode;
			if ($routeParams.id != undefined) {
				addressConnectorFactory.loadAddress($scope, $routeParams.id);
			}
		});
	};
	
	$scope.doMaintain = function () {
		if ($scope.mode == 'update') {
			addressConnectorFactory.updateAddress($scope, function($location) {gotoAddress.all($location);}, function($location) {gotoAddress.update($location, $scope.address.id);});
		} else {
			addressConnectorFactory.createAddress($scope, function($location) {gotoAddress.all($location);}, function($location) {gotoAddress.create($location);});
		}
	};
	
	$scope.doBack = function () {
		gotoAddress.all($location);
	};
};