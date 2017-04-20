package br.com.entelgy.burguerproject.realizarpedido;

import java.math.BigDecimal;
import java.util.List;

public class PedidoDTO {
	
	private TipoPaoDTO tipoPao;
	
	private QueijoDTO queijo;
	
	private RecheioDTO recheio;
	
	private SaladaDTO salada;
	
	private List<MolhoDTO> molhos;
	
	private List<TemperoDTO> temperos;
	
	private Boolean dobraTempero;
	
	private Boolean dobraMolho;
	
	private Boolean dobraSalada;
	
	
	public PedidoDTO() {
	}

	public TipoPaoDTO getTipoPao() {
		return tipoPao;
	}

	public void setTipoPao(TipoPaoDTO tipoPao) {
		this.tipoPao = tipoPao;
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

	public Boolean getDobraTempero() {
		return dobraTempero;
	}

	public void setDobraTempero(Boolean dobraTempero) {
		this.dobraTempero = dobraTempero;
	}

	public Boolean getDobraMolho() {
		return dobraMolho;
	}

	public void setDobraMolho(Boolean dobraMolho) {
		this.dobraMolho = dobraMolho;
	}

	public Boolean getDobraSalada() {
		return dobraSalada;
	}

	public void setDobraSalada(Boolean dobraSalada) {
		this.dobraSalada = dobraSalada;
	}
}
