package br.com.entelgy.burguerproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.entelgy.burguerproject.filter.RequestFilter;

import org.springframework.stereotype.Controller;

@SpringBootApplication
public class WebApplication
{
	
	/**
	 * Bean responsavel por criar o filtro de requisicoes que serao feitas a API
	 * Todas as URLs comecando com 'api/' serão filtradas
	 * 
	 * @return FilterRegistrationBean
	 */
	@Bean
	public FilterRegistrationBean getFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new RequestFilter());
		filterRegistrationBean.addUrlPatterns("/api/*");
		filterRegistrationBean.setOrder(1);
		
		return filterRegistrationBean;
	}

   public static void main(String[] args)
   {
      SpringApplication.run(WebApplication.class, args);
   }

}
