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
@Table(name = "TB_LANCHE")
public class Lanche {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CO_LANCHE")
	private Long id;
	
	@Column(name = "DE_DESCRICAO")
	private String descricao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_TIPO_PAO", nullable = false)
	private TipoPao tipoPao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_QUEIJO", nullable = false)
	private Queijo queijo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_RECHEIO", nullable = false)
	private Recheio recheio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_SALADA", nullable = false)
	private Salada salada;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "TB_LANCHE_MOLHO", joinColumns = @JoinColumn(name = "CO_LANCHE", foreignKey = @ForeignKey(name = "FK_LANCHE")), inverseJoinColumns = @JoinColumn(name = "CO_MOLHO", foreignKey = @ForeignKey(name = "FK_MOLHO")), uniqueConstraints = @UniqueConstraint(columnNames = {"CO_LANCHE", "CO_MOLHO"}))
	private List<Molho> molhos;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "TB_LANCHE_MOLHO", joinColumns = @JoinColumn(name = "CO_LANCHE", foreignKey = @ForeignKey(name = "FK_LANCHE")), inverseJoinColumns = @JoinColumn(name = "CO_TEMPERO", foreignKey = @ForeignKey(name = "FK_TEMPERO")), uniqueConstraints = @UniqueConstraint(columnNames = {"CO_LANCHE", "CO_TEMPERO"}))
	private List<Tempero> temperos;
	
	@Column(name = "BO_LANCHE_PADRAO")
	private Boolean isLanchePadrao;
	
	@Column(name = "BO_DOBRA_MOLHO")
	private Boolean dobraMolho;
	
	@Column(name = "BO_DOBRA_TEMPERO")
	private Boolean dobraTempero;
	
	@Column(name = "BO_DOBRA_SALADA")
	private Boolean dobraSalada;

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

	public TipoPao getTipoPao() {
		return tipoPao;
	}

	public void setTipoPao(TipoPao tipoPao) {
		this.tipoPao = tipoPao;
	}

	public Queijo getQueijo() {
		return queijo;
	}

	public void setQueijo(Queijo queijo) {
		this.queijo = queijo;
	}

	public Recheio getRecheio() {
		return recheio;
	}

	public void setRecheio(Recheio recheio) {
		this.recheio = recheio;
	}

	public Salada getSalada() {
		return salada;
	}

	public void setSalada(Salada salada) {
		this.salada = salada;
	}

	public List<Molho> getMolhos() {
		return molhos;
	}

	public void setMolhos(List<Molho> molhos) {
		this.molhos = molhos;
	}

	public List<Tempero> getTemperos() {
		return temperos;
	}

	public void setTemperos(List<Tempero> temperos) {
		this.temperos = temperos;
	}

	public Boolean getIsLanchePadrao() {
		return isLanchePadrao;
	}

	public void setIsLanchePadrao(Boolean isLanchePadrao) {
		this.isLanchePadrao = isLanchePadrao;
	}

	public Boolean getDobraMolho() {
		return dobraMolho;
	}

	public void setDobraMolho(Boolean dobraMolho) {
		this.dobraMolho = dobraMolho;
	}

	public Boolean getDobraTempero() {
		return dobraTempero;
	}

	public void setDobraTempero(Boolean dobraTempero) {
		this.dobraTempero = dobraTempero;
	}

	public Boolean getDobraSalada() {
		return dobraSalada;
	}

	public void setDobraSalada(Boolean dobraSalada) {
		this.dobraSalada = dobraSalada;
	}

	
}
