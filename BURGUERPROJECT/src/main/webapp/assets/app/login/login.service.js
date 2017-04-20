;
(function() {
	var URL_BASE = '/login'
	
	var SERVICE = ['$http', function($http) {
		return {
			
			logar: function(dadosLogin) {
				console.log("SIM");
				var url = URL_BASE + '/verificaLogin';
				return $http({
					url: url,
					method: "POST",
					data: dadosLogin
				});
			}
		}
	}];
	
	angular.module('burguerapp').factory('LoginService', SERVICE);
})();