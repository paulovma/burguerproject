(function() {
	var CONTROLLER = ['$scope', 'LoginService', 'UserService', '$state', '$location', function($scope, LoginService, UserService, $state, $location) {
		$scope.isRotaLogin = true;
		
		$scope.logar = function() {
			var dados = angular.copy($scope.login);
			LoginService.logar(dados).then(function(response) {
				console.log(response);
				if (response.status == 200) {
					UserService.setUser(response.data);
					$scope.isRotaLogin = false;
					$state.go('realizarpedido');
				} else {
					$scope.notLogged = true;
				}
			});
		}

	}];
	
	angular.module('burguerapp').controller('LoginController', CONTROLLER);
})();