;
(function() {
	var URL_BASE = 'api/realizarpedido'
	
	var SERVICE = ['$http', function($http) {
		return {
			recuperaValoresIniciais: function(){
				var url = URL_BASE + '/recuperavaloresiniciais';
				return $http.get(url);
			},
			
			finalizarPedido: function(pedidoFinalizado) {
				var url = URL_BASE + '/finalizarpedido';
				return $http.post(url, pedidoFinalizado)
			}
		}
	}];
	
	angular.module('burguerapp').factory('RealizarPedidoService', SERVICE);
})();