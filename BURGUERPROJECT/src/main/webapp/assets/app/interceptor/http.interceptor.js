;
(function() {
	var SERVICE = ['$rootScope', 'UserService', function($rootScope, UserService) {
		var service = this;
		
		service.request = function(config) {
			var user = UserService.getUser();
			if (user) {
				config.headers.Authorization = user.token;
			}
			
			return config;
		}
		
		service.responseError = function(response) {
			if (response.status == 401) {
				$rootScope.$broadcast('unauthorized');
			}
			
			return response;
		}
	}];
	
	angular.module('burguerapp').service('APIInterceptor', SERVICE);
})();