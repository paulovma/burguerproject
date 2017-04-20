package br.com.entelgy.burguerproject.realizarpedido;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.entelgy.burguerproject.baserepository.BaseRepository;
import br.com.entelgy.burguerproject.entity.Lanche;

@Repository
public class RealizarPedidoRepository extends BaseRepository {
	
	/**
	 * Retorna Todos os Lanches PADRAO (Que não foram montados pelo Usuario) do Sistema
	 * 
	 * 
	 * @return List<Lanche>
	 */
	public List<Lanche> getAllLanches() {
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT l FROM Lanche l WHERE l.isLanchePadrao = true ");

		Query query = this.entityManager.createQuery(hql.toString());
		
		return query.getResultList();
		
	}
	
	/**
	 * Retorna Todos os Recheios em uma lista de DTO
	 * 
	 * @return List<RecheioDTO>
	 */
	public List<RecheioDTO> getAllRecheios() {
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT new br.com.entelgy.burguerproject.realizarpedido.RecheioDTO( ")
		   .append(" r.id, ")
		   .append(" r.descricao, ")
		   .append(" r.valor ")
		   .append(") ")
		   .append(" FROM Recheio r");
		
		Query query = this.entityManager.createQuery(hql.toString());
		
		return query.getResultList();
	}

	/**
	 * Retorna Todos os Tipos de Pao em uma lista de DTO
	 * 
	 * @return List<TipoPaoDTO>
	 */
	public List<TipoPaoDTO> getAllTiposPao() {
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT new br.com.entelgy.burguerproject.realizarpedido.TipoPaoDTO( ")
		   .append(" t.id, ")
		   .append(" t.descricao, ")
		   .append(" t.valor ")
		   .append(") ")
		   .append(" FROM TipoPao t");
		
		Query query = this.entityManager.createQuery(hql.toString());
		
		return query.getResultList();
	}
	
	/**
	 * Retorna Todos os Queijos em uma Lista de DTO
	 * 
	 * @return List<QueijoDTO>
	 */
	public List<QueijoDTO> getAllQueijos() {
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT new br.com.entelgy.burguerproject.realizarpedido.QueijoDTO( ")
		   .append(" q.id, ")
		   .append(" q.descricao, ")
		   .append(" q.valor ")
		   .append(") ")
		   .append(" FROM Queijo q");
		
		Query query = this.entityManager.createQuery(hql.toString());
		
		return query.getResultList();
	}
	
	/**
	 * Retorna Todos os Temperos em uma lista de DTO
	 * 
	 * @return List<TemperoDTO>
	 */
	public List<TemperoDTO> getAllTemperos() {
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT new br.com.entelgy.burguerproject.realizarpedido.TemperoDTO( ")
		   .append(" t.id, ")
		   .append(" t.descricao, ")
		   .append(" t.valor ")
		   .append(") ")
		   .append(" FROM Tempero t");
		
		Query query = this.entityManager.createQuery(hql.toString());
		
		return query.getResultList();
	}
	
	/**
	 * Retorna Todas as Saladas em uma Lista de DTO
	 * 
	 * @return List<SaladaDTO>
	 */
	public List<SaladaDTO> getAllSaladas() {
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT new br.com.entelgy.burguerproject.realizarpedido.SaladaDTO( ")
		   .append(" s.id, ")
		   .append(" s.descricao, ")
		   .append(" s.valor ")
		   .append(") ")
		   .append(" FROM Salada s");
		
		Query query = this.entityManager.createQuery(hql.toString());
		
		return query.getResultList();
	}
	
	/**
	 * Retorna Todos os Molhos em uma lista de DTO
	 * 
	 * @return List<MolhoDTO>
	 */
	public List<MolhoDTO> getAllMolhos() {
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT new br.com.entelgy.burguerproject.realizarpedido.MolhoDTO( ")
		   .append(" m.id, ")
		   .append(" m.descricao, ")
		   .append(" m.valor ")
		   .append(") ")
		   .append(" FROM Molho m");
		
		Query query = this.entityManager.createQuery(hql.toString());
		
		return query.getResultList();
	}
	
}
