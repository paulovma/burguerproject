;
(function() {
	var CONTROLLER = ['$scope', 'RealizarPedidoService', function($scope, RealizarPedidoService) {
		$scope.pedidos = [];
		_preencheCamposIniciais();
		_criaObjetoModelo();
		$scope.valorLanche = 0;
		$scope.pedidoRealizado = false;
		
		$scope.checkItem = function(item, checked) {
			item.checked = checked;
			_somatorioLanche();
		}
		
		$scope.checkSalada = function(item) {
			_checkSalada(item);
			_somatorioLanche();
		}
		
		$scope.setLancheNaTela = function() {
			$scope.pedido =null;
			$scope.pedido = angular.copy($scope.lanche);
			console.log($scope.lanche);
			console.log($scope.pedido);
//			console.log($scope.listMolho);
//			console.log($scope.lanche.molhos);
//			$scope.pedido.molhos.push($scope.lanche.molhos[0]);
//			_checkItens($scope.lanche.molhos, $scope.pedido.molhos);
//			_checkItens($scope.lanche.temperos, $scope.pedido.temperos);
			if ($scope.pedido) {
				_checkSalada($scope.lanche.salada);
				_somatorioLanche();
			} else {
				$scope.valorLanche = 0;
			}
		}
		
		$scope.somatorioLanche = function() {
			_somatorioLanche();
		}
		
		$scope.adicionarPedido = function() {
			$scope.pedido.valor 		    = $scope.valorLanche;
			$scope.pedido.dobraSalada  = $scope.dobraSalada;
			$scope.pedido.dobraMolho   = $scope.dobraTempero;
			$scope.pedido.dobraTempero = $scope.dobraMolho;
			$scope.valorLanche 				= 0;
			$scope.pedidos.push($scope.pedido);
			_criaObjetoModelo();
			_somaValorTotalPedido();
		}
		
		$scope.dobrarMolho = function() {
			var arrMolhos = angular.copy($scope.pedido.molhos);
			_dobrarValorArray(arrMolhos, $scope.dobraMolho);
		}
		
		$scope.dobrarTempero = function() {
			var arrTemperos = $scope.pedido.temperos;
			_dobrarValorArray(arrTemperos, $scope.dobraTempero);
		}
		
		$scope.dobrarSalada = function() {
			angular.forEach($scope.listSalada, function(value, index) {
				if (value.checked) {
					if ($scope.dobraSalada) {
						$scope.valorLanche += value.valor;
					} else {
						$scope.valorLanche -= value.valor;
					}
				}
			});
//			var salada = angular.copy($scope.pedido.salada);
//			console.log(salada);
//			if (salada) {
//				if ($scope.dobraSalada) {
//					$scope.valorLanche += salada.valor;
//				} else {
//					$scope.valorLanche -= salada.valor;
//				}
//			}
		}
		
		$scope.retirarPedido = function(item) {
			$scope.pedidos.pop(item);
			_somaValorTotalPedido();
		}
		
		$scope.finalizarPedido = function() {
			if (_validaCamposObrigatorios()) {
				$scope.camposObrigatoriosNaoPreenchidos = false;
				var pedidoFinalizado = {
						pedidos: angular.copy($scope.pedidos),
						valorTotal: angular.copy($scope.valorTotal),
						nomePedido: angular.copy($scope.nomeCliente),
						enderecoPedido: angular.copy($scope.enderecoCliente)
				}
				
				console.log(pedidoFinalizado);
				
				RealizarPedidoService.finalizarPedido(pedidoFinalizado).then(function(response) {
					$scope.pedidoRealizado = true;
					$scope.pedidos = [];
					$scope.valorTotal = 0;
				});
			} else {
				$scope.camposObrigatoriosNaoPreenchidos = true;
			}
		}
		
		function _validaCamposObrigatorios() {
			console.log($scope.nomeCliente && $scope.enderecoCliente);
			return $scope.nomeCliente && $scope.enderecoCliente; 
		}
		
		
		function _dobrarValorArray(array, modelo) {
			if (array.length > 0) {
				angular.forEach(array, function(value, index) {
					if (modelo) {
						$scope.valorLanche += value.valor;
					} else {
						$scope.valorLanche -= value.valor;
					}
				})
			}
		}
		
		function _somaValorTotalPedido() {
			var valorTotal = 0;
			
			angular.forEach($scope.pedidos, function(value, index) {
				valorTotal += value.valor;
			})
			
			$scope.valorTotal = valorTotal;
		}
		
		function _checkSalada(item) {
			$scope.saladaChecked = false;
			angular.forEach($scope.listSalada, function(value, index) {
				value.checked = false;
				if (item.id == value.id) {
					$scope.saladaChecked = true;
					value.checked = true;
				}
			});
		}
		
		function _checkItens(arrayLanche, array) {
			angular.forEach(arrayLanche, function(value, index) {
				array.push(value);
			})
		}
		
		function _somatorioLanche() {
			$scope.valorLanche = (
					  ($scope.pedido.recheio ? $scope.pedido.recheio.valor : 0) + 
					  ($scope.pedido.tipoPao ? $scope.pedido.tipoPao.valor : 0) + 
					  ($scope.pedido.queijo  ? $scope.pedido.queijo.valor  : 0) +
					  (_somaValoresSalada($scope.listSalada)) +
					  (_somaValoresArrayMolho($scope.pedido.molhos)) +
					  (_somaValoresArrayTempero($scope.pedido.temperos))
			);
		}
		
		function _somaValoresSalada(array) {
			var soma = 0;
			angular.forEach(array, function(value, index) {
				if (value.checked) {
					soma += $scope.dobraSalada ? value.valor * 2 : value.valor;
				}
			})
			return soma;
		}
		
		function _somaValoresArrayMolho(array) {
			var soma = 0;
			angular.forEach(array, function(value, index) {
				soma += $scope.dobraMolho ? value.valor * 2 : value.valor;
			})
			return soma;
		}
		
		function _somaValoresArrayTempero(array) {
			var soma = 0;
			angular.forEach(array, function(value, index) {
				soma += $scope.dobraTempero ? value.valor * 2 : value.valor;
			})
			return soma;
		}
		
		function _preencheCamposIniciais() {
			RealizarPedidoService.recuperaValoresIniciais().then(function(response) {
				$scope.listLanche   = response.data.lanches;
				$scope.listTipoPao  = response.data.tiposPao;
				$scope.listQueijo   = response.data.queijos;
				$scope.listRecheio  = response.data.recheios;
				$scope.listSalada   = response.data.saladas;
				$scope.listTempero  = response.data.temperos;
				$scope.listMolho	= response.data.molhos;
				
			});
		}
		
		
		function _criaObjetoModelo() {
			$scope.dobraMolho   = false;
			$scope.dobraTempero = false;
			$scope.dobraSalada  = false;
			$scope.pedido = {
				descricao: "",
				tipoPao: "",
				queijo: "",
				recheio: "",
				salada: null,
				temperos: [],
				molhos: [],
			}
		}
	}];
	
	angular.module('burguerapp').controller('RealizarPedidoController', CONTROLLER);
})();