;
(function() {
	var ROUTES = ['$stateProvider', function($stateProvider) {
		$stateProvider.
	        state('index', {
	        	url: '/',
	        	controller : 'LoginController',
	            templateUrl: '/view/login/login.html'
	        });
	}];
	
	angular.module('burguerapp').config(ROUTES);
})();