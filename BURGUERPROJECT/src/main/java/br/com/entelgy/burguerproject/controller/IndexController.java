package br.com.entelgy.burguerproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	/**
	 * Retorna o caminho do index da aplicação
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/")
	public String index() {
		return "view/index.html";
	}
}
