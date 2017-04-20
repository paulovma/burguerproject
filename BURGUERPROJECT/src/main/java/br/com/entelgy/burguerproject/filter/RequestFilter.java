package br.com.entelgy.burguerproject.filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.JwtException;

public class RequestFilter extends GenericFilterBean {

	/**
	 * 
	 * 
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String token = httpRequest.getHeader("Authorization");
		
		if (Objects.isNull(token)) {
			throw new JwtException("Você não tem autorização para essa url.");
		}
		
		filterChain.doFilter(httpRequest, response);
	}
}
