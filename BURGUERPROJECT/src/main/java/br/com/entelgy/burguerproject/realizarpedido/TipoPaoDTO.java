package br.com.entelgy.burguerproject.realizarpedido;

import java.math.BigDecimal;

public class TipoPaoDTO {
	
	private Long id;
	
	private String descricao;
	
	private BigDecimal valor;
	
	public TipoPaoDTO() {
	}
	
	public TipoPaoDTO(Long id, String descricao, BigDecimal valor) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	

}
