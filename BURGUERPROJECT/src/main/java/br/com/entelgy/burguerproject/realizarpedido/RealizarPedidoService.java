package br.com.entelgy.burguerproject.realizarpedido;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.entelgy.burguerproject.entity.Lanche;
import br.com.entelgy.burguerproject.entity.Molho;
import br.com.entelgy.burguerproject.entity.Pedido;
import br.com.entelgy.burguerproject.entity.Queijo;
import br.com.entelgy.burguerproject.entity.Recheio;
import br.com.entelgy.burguerproject.entity.Salada;
import br.com.entelgy.burguerproject.entity.Tempero;
import br.com.entelgy.burguerproject.entity.TipoPao;
import br.com.entelgy.burguerproject.entity.Usuario;

@Service
@Scope("prototype")
public class RealizarPedidoService {

	
	@Autowired
	private RealizarPedidoRepository realizarPedidoRepository;
	
	/**
	 * Montagem dos DTOs que serão exibidos na tela de Realização de Pedido
	 * 
	 * @return ValoresIniciaisDTO
	 */
	@Transactional
	public ValoresIniciaisDTO recuperaValoresIniciais() {
		ValoresIniciaisDTO dtoInicial = new ValoresIniciaisDTO();
		
		dtoInicial.setLanches(this.retornaLanchesDTO());
		dtoInicial.setTiposPao(this.realizarPedidoRepository.getAllTiposPao());
		dtoInicial.setQueijos(this.realizarPedidoRepository.getAllQueijos());
		dtoInicial.setRecheios(this.realizarPedidoRepository.getAllRecheios());
		dtoInicial.setSaladas(this.realizarPedidoRepository.getAllSaladas());
		dtoInicial.setTemperos(this.realizarPedidoRepository.getAllTemperos());
		dtoInicial.setMolhos(this.realizarPedidoRepository.getAllMolhos());
		
		return dtoInicial;
	}

	/**
	 * Busca no Banco todos os Lanches existentes.
	 * Monta uma Lista de DTO para cada Lanche existente.
	 * 
	 * @return List<LancheDTO>
	 */
	private List<LancheDTO> retornaLanchesDTO() {
		List<Lanche> lanches = this.realizarPedidoRepository.getAllLanches();
		List<LancheDTO> dtos = new ArrayList<>();
		
		if (!lanches.isEmpty()) {
			lanches.forEach(lanche -> {
				LancheDTO dto = new LancheDTO(
						lanche.getId(), 
						lanche.getDescricao(), 
						new QueijoDTO(lanche.getQueijo().getId(), lanche.getQueijo().getDescricao(), lanche.getQueijo().getValor()), 
						new RecheioDTO(lanche.getRecheio().getId(), lanche.getRecheio().getDescricao(), lanche.getRecheio().getValor()),
						new SaladaDTO(lanche.getSalada().getId(), lanche.getSalada().getDescricao(), lanche.getSalada().getValor()),
						this.montaDTOsTemperos(lanche.getTemperos()), 
						new TipoPaoDTO(lanche.getTipoPao().getId(), lanche.getTipoPao().getDescricao(), lanche.getTipoPao().getValor()),
						this.montaDTOsMolho(lanche.getMolhos())
				);
				dtos.add(dto);
			});
		}
		
		return dtos;
	}
	
	/**
	 * Monta uma lista de MolhoDTO a partir dos Molhos passados
	 * 
	 * @param molhos
	 * @return List<MolhoDTO>
	 */
	private List<MolhoDTO> montaDTOsMolho(List<Molho> molhos) {
		List<MolhoDTO> dtos = new ArrayList<>();
		
		molhos.forEach(molho -> {
			dtos.add(new MolhoDTO(molho.getId(), molho.getDescricao(), molho.getValor()));
		});
		
		return dtos;
	}
	
	/**
	 * Monta uma lista de TemperoDTO a partir dos Temperos passados
	 * 
	 * @param temperos
	 * @return List<TemperoDTO>
	 */
	private List<TemperoDTO> montaDTOsTemperos(List<Tempero> temperos) {
		List<TemperoDTO> dtos = new ArrayList<>();
		
		temperos.forEach(tempero -> {
			dtos.add(new TemperoDTO(tempero.getId(), tempero.getDescricao(), tempero.getValor()));
		});
		
		return dtos;
	}

	/**
	 * Método responsável pela finalização do pedido.
	 * Monta o Pedido com todos os Lanches escolhidos pelo usuário.
	 * Insere o Pedido no BD.
	 * 
	 * @param pedidoFinalizadoDTO
	 */
	@Transactional
	public synchronized void finalizarPedido(PedidoFinalizadoDTO pedidoFinalizadoDTO) {
		
		Pedido pedido = new Pedido();
		
		pedido.setLanches(this.retornaLanchesPedido(pedidoFinalizadoDTO.getPedidos()));
		pedido.setEnderecoPedido(pedidoFinalizadoDTO.getEnderecoPedido());
		pedido.setNomePedido(pedidoFinalizadoDTO.getNomePedido());
		pedido.setValor(pedidoFinalizadoDTO.getValorTotal());
		//alterar, criar dinamico
		pedido.setUsuario((Usuario) this.realizarPedidoRepository.recuperarPeloId(Usuario.class, Long.valueOf(1)));
		
		this.realizarPedidoRepository.inserir(pedido);
		
	}

	/**
	 * Para cada Lanche montado pelo Usuário é criado uma Entidade Lanche
	 * Com os itens escolhidos pelo usuário.
	 * 
	 * @param pedidos
	 * @return List<Lanche>
	 */
	private List<Lanche> retornaLanchesPedido(List<PedidoDTO> pedidos) {
		List<Lanche> lanches = new ArrayList<>();

		pedidos.forEach(pedido -> {
			
			Lanche lanche = new Lanche();
			lanche.setIsLanchePadrao(false);
			lanche.setMolhos(this.recuperaMolhos(pedido.getMolhos()));
			lanche.setTemperos(this.recuperaTemperos(pedido.getTemperos()));
			lanche.setTipoPao((TipoPao) this.realizarPedidoRepository.recuperarPeloId(TipoPao.class, pedido.getTipoPao().getId()));
			lanche.setQueijo((Queijo) this.realizarPedidoRepository.recuperarPeloId(Queijo.class, pedido.getQueijo().getId()));
			lanche.setRecheio((Recheio) this.realizarPedidoRepository.recuperarPeloId(Recheio.class, pedido.getRecheio().getId()));
			lanche.setSalada((Salada) this.realizarPedidoRepository.recuperarPeloId(Salada.class, pedido.getSalada().getId()));
			lanche.setDobraMolho(pedido.getDobraMolho());
			lanche.setDobraSalada(pedido.getDobraSalada());
			lanche.setDobraTempero(pedido.getDobraTempero());
			
			lanches.add(lanche);
		});
		
		return lanches;
	}

	/**
	 * Realiza a busca das Entidades, por ID, a partir dos DTOs passados.
	 * 
	 * @param dtos
	 * @return List<Tempero>
	 */
	private List<Tempero> recuperaTemperos(List<TemperoDTO> dtos) {
		List<Tempero> temperos = new ArrayList<>();
		
		dtos.forEach(dto -> {
			Tempero tempero = (Tempero) this.realizarPedidoRepository.recuperarPeloId(Tempero.class, dto.getId());
			temperos.add(tempero);
		});
		
		return temperos;
	}

	/**
	 * Realiza a busca das Entidades, por ID, a partir dos DTOs passados.
	 * 
	 * @param dtos
	 * @return List<Molho>
	 */
	private List<Molho> recuperaMolhos(List<MolhoDTO> dtos) {
		List<Molho> molhos = new ArrayList<>();
		
		dtos.forEach(dto -> {
			Molho molho = (Molho) this.realizarPedidoRepository.recuperarPeloId(Molho.class, dto.getId());
			molhos.add(molho);
		});
		
		return molhos;
	}

}
