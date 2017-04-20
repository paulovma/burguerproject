package br.com.entelgy.burguerproject.realizarpedido;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RealizerPedidoServiceTest {
	
	@Mock
	private RealizarPedidoRepository realizarPedidoRepository;
	
	@InjectMocks
	private RealizarPedidoService service = new RealizarPedidoService();
	
	@Test
	public void testRecuperaValoresIniciais(){
		
		List<TipoPaoDTO> lista = new ArrayList<>();
		TipoPaoDTO build = TipoPaoDTOHelper.build();
		lista.add(build);
		
		when(realizarPedidoRepository.getAllTiposPao()).thenReturn(lista);
		
		
		
		ValoresIniciaisDTO recuperaValoresIniciais = service.recuperaValoresIniciais();
		
		TipoPaoDTO tipoPaoDTO = recuperaValoresIniciais.getTiposPao().get(0);
		
		Assert.assertEquals(build.getDescricao(), tipoPaoDTO.getDescricao());
		Matchers.anyString();
		
		
		
		
	}

}
	