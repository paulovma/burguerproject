;
(function() {
	var ROUTES = ['$stateProvider', function($stateProvider) {
		$stateProvider.state('login', {
			url: '/',
			controller: "LoginController",
			template: "<ui-view/>"
		})
		.state('login.index', {
			url: '/login',
			controller: "LoginController",
			templateUrl: "view/login/login.html"
		});;
	}];
	
	angular.module('burguerapp').config(ROUTES);
})();