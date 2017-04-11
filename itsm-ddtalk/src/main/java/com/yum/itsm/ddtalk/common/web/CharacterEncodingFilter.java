package com.yum.itsm.ddtalk.common.web;

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

public class CharacterEncodingFilter
		implements Filter {
	private static Logger logger = LoggerFactory.getLogger(CharacterEncodingFilter.class);
	
	private String encoding;

	private boolean forceEncoding = false;

	public CharacterEncodingFilter() {
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public void setForceEncoding(boolean forceEncoding) {
		this.forceEncoding = forceEncoding;
	}

	@Override
	public void init(FilterConfig filterConfig)
			throws ServletException {
		logger.debug("CharacterEncodingFilter is init......");
		
		this.encoding = filterConfig.getInitParameter("encoding");
		if (this.encoding == null || this.encoding.trim().length() == 0) {
			this.encoding = "UTF-8";
		} else {
			this.encoding = this.encoding.trim();
		}
		
		String force = filterConfig.getInitParameter("forceEncoding");
		try {
			this.forceEncoding = Boolean.getBoolean(force.trim());
		} catch (Exception e) {
			logger.error("CharacterEncodingFilter param forceEncoding is invalid.");
			this.forceEncoding = false;
		}
		
		logger.debug("CharacterEncodingFilter param encoding is " + this.encoding + ".");
		logger.debug("CharacterEncodingFilter param forceEncoding is " + this.forceEncoding + ".");
	}

	@Override
	public void doFilter(	ServletRequest servletRequest,
												ServletResponse servletResponse,
												FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		if ((this.encoding != null) && ((this.forceEncoding) || (request.getCharacterEncoding() == null))) {
			request.setCharacterEncoding(this.encoding);
			if (this.forceEncoding) {
				response.setCharacterEncoding(this.encoding);
			}
		}
		filterChain.doFilter(	request,
													response);
	}

	@Override
	public void destroy() {
		logger.debug("CharacterEncodingFilter is destroy......");
	}
}
