(function() {
	angular
		.module('burguerapp', ['angular-storage', 'ui.router', 'ngRoute', 'checklist-model'])
		.config(['$httpProvider', function($httpProvider) {
			$httpProvider.interceptors.push('APIInterceptor');
		}]);
})();