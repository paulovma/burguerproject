package br.com.entelgy.burguerproject.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TB_PEDIDO")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CO_PEDIDO")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_USUARIO", nullable = true)
	private Usuario usuario;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "TB_PEDIDO_LANCHE", joinColumns = @JoinColumn(name = "CO_PEDIDO", foreignKey = @ForeignKey(name = "FK_PEDIDO")), inverseJoinColumns = @JoinColumn(name = "CO_LANCHE", foreignKey = @ForeignKey(name = "FK_LANCHE")), uniqueConstraints = @UniqueConstraint(columnNames = {"CO_PEDIDO", "CO_LANCHE"}))
	private List<Lanche> lanches;
	
	@Column(name = "DE_NOME_PEDIDO")
	private String nomePedido;
	
	@Column(name = "DE_ENDERECO_PEDIDO")
	private String enderecoPedido;
	
	@Column(name = "VR_VALOR")
	private BigDecimal valor;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Lanche> getLanches() {
		return lanches;
	}

	public void setLanches(List<Lanche> lanches) {
		this.lanches = lanches;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
}
