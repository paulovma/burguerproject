package br.com.entelgy.burguerproject.login;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {

	@Transactional
	public Boolean verificaLogin(LoginDTO loginDto) {
		return true;
	}

}
