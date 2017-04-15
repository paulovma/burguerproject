(function() {
	var CONTROLLER = ['$scope', 'LoginService', function($scope, LoginService) {
		console.log('oi');
		var dados = {
			usuario: "TESTE",
			senha: "123"
		}

		LoginService.login(dados).then(function(response) {
			console.log(response.data);
		});

	}];
	
	angular.module('burguerapp').controller('LoginController', CONTROLLER);
})();