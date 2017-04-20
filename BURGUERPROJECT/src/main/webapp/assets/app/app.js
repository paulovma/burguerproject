(function() {
	angular
		.module('burguerapp', ['angular-storage', 'ui.router', 'ngRoute', 'checklist-model'])
		.config(['$httpProvider', function($httpProvider) {
			$httpProvider.interceptors.push('APIInterceptor');
		}])
		.config(['$stateProvider', function($stateProvider) {
			$stateProvider.
	            state('index', {
	            	url: '/',
	            	controller : 'LoginController',
	                templateUrl: '/view/login/login.html'
            });
		}]);
	
//	var CONFIG = ['$httpProvider', function($httpProvider) {
//		$httProvider.interceptors.push('APIInterceptor');
//	}];
	
//	angular.module('burguerapp').run(CONFIG);
})();