package br.com.entelgy.burguerproject.realizarpedido;

import java.math.BigDecimal;
import java.util.List;

public class PedidoFinalizadoDTO {

	private List<PedidoDTO> pedidos;
	
	private BigDecimal valorTotal;
	
	private String nomePedido;
	
	private String enderecoPedido;
	
	public PedidoFinalizadoDTO() {
	}
	
	public List<PedidoDTO> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getNomePedido() {
		return nomePedido;
	}

	public void setNomePedido(String nomePedido) {
		this.nomePedido = nomePedido;
	}

	public String getEnderecoPedido() {
		return enderecoPedido;
	}

	public void setEnderecoPedido(String enderecoPedido) {
		this.enderecoPedido = enderecoPedido;
	}
	
}
