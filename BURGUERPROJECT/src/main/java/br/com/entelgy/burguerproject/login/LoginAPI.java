package br.com.entelgy.burguerproject.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.entelgy.burguerproject.AuthenticationDTO;

@RestController
@RequestMapping(value = "/login")
public class LoginAPI {
	
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/verificaLogin", method = RequestMethod.POST)
	public AuthenticationDTO verificaLogin(@RequestBody LoginDTO loginDto) {
		return this.loginService.verificaLogin(loginDto);
	}
}
