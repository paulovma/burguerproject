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
	
	@Bean
	public FilterRegistrationBean getFilter() {
		FilterRegistrationBean FilterRegistrationBean = new FilterRegistrationBean();
		FilterRegistrationBean.setFilter(new RequestFilter());
		FilterRegistrationBean.addUrlPatterns("/api/*");
		FilterRegistrationBean.setOrder(1);
		
		return FilterRegistrationBean;
	}

   public static void main(String[] args)
   {
      SpringApplication.run(WebApplication.class, args);
   }

}
