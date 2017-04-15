;
(function() {
	var URL_BASE = 'api/login/{0}'
	
	var SERVICE = ['$http', function($http) {
		return {
			
			logar: function(dadosLogin) {
				var url = URL_BASE.format('verificaLogin');
				return $http.post(url, dadosLogin);
			}
		}
	}];
	
	angular.module('burguerapp').factory('LoginService', SERVICE);
})();