/**
 * 
 */
package com.krustykrab.interceptors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CORSFilter implements Filter {
 
	Logger logger = LoggerFactory.getLogger(CORSFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		logger.info("Filtering on................"+rq.getServletPath());
		res.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
		res.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		res.setHeader("Access-Control-Max-Age", "3600");
		res.setHeader("Access-Control-Allow-Headers", "X-requested-with, Content-Type");
		chain.doFilter(request, response);
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		
	}

	@Override
	public void destroy()
	{
		
	}
 
}