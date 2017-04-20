package br.com.entelgy.burguerproject.login;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.entelgy.burguerproject.AuthenticationDTO;
import br.com.entelgy.burguerproject.entity.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
@Scope("prototype")
public class LoginService {
	
	@Value("${jwt.key}")
	private String key;
	
	@Autowired
	private LoginRepository loginDAO;

	@Transactional
	public AuthenticationDTO verificaLogin(LoginDTO loginDto) {
		AuthenticationDTO authenticationDTO = null;
		Usuario usuario = loginDAO.getUsuarioByLogin(loginDto.getUsuario(), loginDto.getSenha());
		
		if (!Objects.isNull(usuario)) {
			authenticationDTO = new AuthenticationDTO(
							 Jwts.builder()
							 .setSubject(loginDto.getUsuario())
							 .signWith(SignatureAlgorithm.HS256, this.key)
							 .compact(),
							 usuario.getId(),
							 usuario.getNome()
					);
		}
		
		return authenticationDTO;
	}

}
