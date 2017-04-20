package br.com.entelgy.burguerproject.realizarpedido;

import java.util.List;


public class ValoresIniciaisDTO {
	
	private List<TipoPaoDTO> tiposPao;
	
	private List<LancheDTO> lanches;
	
	private List<QueijoDTO> queijos;
	
	private List<RecheioDTO> recheios;
	
	private List<SaladaDTO> saladas;
	
	private List<TemperoDTO> temperos;
	
	private List<MolhoDTO> molhos;

	public List<TipoPaoDTO> getTiposPao() {
		return tiposPao;
	}

	public void setTiposPao(List<TipoPaoDTO> tiposPao) {
		this.tiposPao = tiposPao;
	}

	public List<LancheDTO> getLanches() {
		return lanches;
	}

	public void setLanches(List<LancheDTO> lanches) {
		this.lanches = lanches;
	}

	public List<QueijoDTO> getQueijos() {
		return queijos;
	}

	public void setQueijos(List<QueijoDTO> queijos) {
		this.queijos = queijos;
	}

	public List<RecheioDTO> getRecheios() {
		return recheios;
	}

	public void setRecheios(List<RecheioDTO> recheios) {
		this.recheios = recheios;
	}

	public List<SaladaDTO> getSaladas() {
		return saladas;
	}

	public void setSaladas(List<SaladaDTO> saladas) {
		this.saladas = saladas;
	}

	public List<TemperoDTO> getTemperos() {
		return temperos;
	}

	public void setTemperos(List<TemperoDTO> temperos) {
		this.temperos = temperos;
	}

	public List<MolhoDTO> getMolhos() {
		return molhos;
	}

	public void setMolhos(List<MolhoDTO> molhos) {
		this.molhos = molhos;
	}
}
