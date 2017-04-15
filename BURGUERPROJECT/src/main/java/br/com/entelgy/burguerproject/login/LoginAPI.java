package br.com.entelgy.burguerproject.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "api/login")
public class LoginAPI {
	
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/verificaLogin", method = RequestMethod.POST)
	public ResponseEntity<Boolean> verificaLogin(@RequestBody LoginDTO loginDto) {
		return new ResponseEntity<>(this.loginService.verificaLogin(loginDto), HttpStatus.OK);
	}
}
