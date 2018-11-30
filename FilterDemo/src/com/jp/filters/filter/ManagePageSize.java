package com.jp.filters.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ManagePageSize
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "*.do" })
public class ManagePageSize implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("In Filter MP: Before");
		chain.doFilter(request, response);
		System.out.println("In Filter MP: After");
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("In Filter MP: destroy()");
	}

	public void destroy() {
		System.out.println("In Filter MP: Init()");
	}

}
