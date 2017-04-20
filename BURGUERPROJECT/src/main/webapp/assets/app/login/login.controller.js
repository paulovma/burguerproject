(function() {
	var CONTROLLER = ['$scope', 'LoginService', 'UserService', '$state', '$location', function($scope, LoginService, UserService, $state, $location) {
		console.log('oi');
		$scope.isRotaLogin = true;
		var dados = {
			usuario: "TESTE",
			senha: "123"
		}

		$scope.logar = function() {
			console.log("OI");
			LoginService.logar(dados).then(function(response) {
				console.log(response);
				if (response.data) {
					console.log(response.data.token);
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