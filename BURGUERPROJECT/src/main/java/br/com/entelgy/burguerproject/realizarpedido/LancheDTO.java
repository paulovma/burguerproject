package br.com.entelgy.burguerproject.realizarpedido;

import java.math.BigDecimal;
import java.util.List;

public class LancheDTO {
	
	private Long id;
	
	private String descricao;
	
	private QueijoDTO queijo;
	
	private List<MolhoDTO> molhos;
	
	private RecheioDTO recheio;
	
	private SaladaDTO salada;
	
	private List<TemperoDTO> temperos;
	
	private TipoPaoDTO tipoPao;
	
	public LancheDTO(Long id, String descricao, QueijoDTO queijoDTO, RecheioDTO recheioDTO, SaladaDTO saladaDTO, List<TemperoDTO> temperosDTO, TipoPaoDTO tipoPaoDTO, List<MolhoDTO> molhosDTO) {
		this.id = id;
		this.descricao = descricao;
		queijo = queijoDTO;
		recheio = recheioDTO;
		salada = saladaDTO;
		temperos = temperosDTO;
		tipoPao = tipoPaoDTO;
		molhos = molhosDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public QueijoDTO getQueijo() {
		return queijo;
	}

	public void setQueijo(QueijoDTO queijo) {
		this.queijo = queijo;
	}

	public RecheioDTO getRecheio() {
		return recheio;
	}

	public void setRecheio(RecheioDTO recheio) {
		this.recheio = recheio;
	}

	public SaladaDTO getSalada() {
		return salada;
	}

	public void setSalada(SaladaDTO salada) {
		this.salada = salada;
	}

	public TipoPaoDTO getTipoPao() {
		return tipoPao;
	}

	public void setTipoPao(TipoPaoDTO tipoPao) {
		this.tipoPao = tipoPao;
	}

	public List<MolhoDTO> getMolhos() {
		return molhos;
	}

	public void setMolhos(List<MolhoDTO> molhos) {
		this.molhos = molhos;
	}

	public List<TemperoDTO> getTemperos() {
		return temperos;
	}

	public void setTemperos(List<TemperoDTO> temperos) {
		this.temperos = temperos;
	}

}
