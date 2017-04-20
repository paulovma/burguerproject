;
(function() {
	
	var ROUTES = ['$stateProvider', function($stateProvider) {
		$stateProvider
			.state('realizarpedido', {
				url: '/realizarpedido',
				controller: "RealizarPedidoController",
				templateUrl: "view/realizarpedido/realizarpedido.html"
			});
	}];
	
	angular.module('burguerapp').config(ROUTES);
})();