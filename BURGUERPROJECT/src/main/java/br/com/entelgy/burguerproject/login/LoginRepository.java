package br.com.entelgy.burguerproject.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.entelgy.burguerproject.entity.Usuario;

@Repository
public interface LoginRepository extends JpaRepository<Usuario, Long> {

	@Query("SELECT U FROM Usuario U WHERE U.login = :login AND U.senha = :senha")
	public Usuario getUsuarioByLogin(@Param("login") String login, @Param("senha") String senha);
}
