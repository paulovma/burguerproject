package br.com.entelgy.burguerproject.baserepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class BaseRepository {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	/**
	 * Retorna um Objeto da classe 'classe' com ID igual ao 'id'
	 * 
	 * @param classe
	 * @param id
	 * @return Object
	 */
	public Object recuperarPeloId(Class classe, Long id) {
		return this.entityManager.find(classe, id);
	}
	
	public void inserir(Object object) {
		this.entityManager.persist(object);
	}
	
	public void atualizar(Object object) {
		this.entityManager.merge(object);
	}

}
