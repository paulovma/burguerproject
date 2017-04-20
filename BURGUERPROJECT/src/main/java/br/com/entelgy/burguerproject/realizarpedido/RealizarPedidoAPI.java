package br.com.entelgy.burguerproject.realizarpedido;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/realizarpedido")
public class RealizarPedidoAPI {
	
	@Autowired
	private RealizarPedidoService realizarPedidoService;

	@RequestMapping(value = "/recuperavaloresiniciais", method = RequestMethod.GET)
	public ValoresIniciaisDTO getTipoPao() {
		return this.realizarPedidoService.recuperaValoresIniciais();
	}
	
	@RequestMapping(value = "/finalizarpedido", method = RequestMethod.POST)
	public void finalizarPedido(@Valid @RequestBody PedidoFinalizadoDTO pedidoFinalizadoDTO, BindingResult bindingResults) throws BindException {
		if (bindingResults.hasErrors()) {
			throw new BindException(bindingResults);
		}
		
		this.realizarPedidoService.finalizarPedido(pedidoFinalizadoDTO);
	}
}
