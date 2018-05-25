package com.adobe.examples.htl.core.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Filter.class, name = "My Sample Filter", 
        property = { "sling.filter.scope=REQUEST",
		             Constants.SERVICE_RANKING + ":Integer=0"})
public class MySampleFilter implements Filter {
	private static final Logger log = LoggerFactory.getLogger(MySampleFilter.class);

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public final void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse,
			final FilterChain filterChain) throws IOException, ServletException {

		log.info("In the doFilter");

		if (!(servletRequest instanceof HttpServletRequest) || !(servletResponse instanceof HttpServletResponse)) {
			filterChain.doFilter(servletRequest, servletResponse);
			return;
		}

		final SlingHttpServletResponse slingResponse = (SlingHttpServletResponse) servletResponse;
		final SlingHttpServletRequest slingRequest = (SlingHttpServletRequest) servletRequest;
		final Resource resource = slingRequest.getResource();

		log.info("for path {}", resource.getPath());

		if (resource.getPath().startsWith("/content/dam/")) {
			log.info("path starts with /content/dam");

			if (!"admin".equals(resource.getResourceResolver().getUserID())) {
				log.info("image should not be displayed...");
				slingResponse.setContentType("text/plain");
				PrintWriter pw = slingResponse.getWriter();
				pw.println("sorry....");
				pw.flush();
				return;
			}
		}
		log.info("continue with the doFilter-chain");

		filterChain.doFilter(servletRequest, servletResponse);

	}

	@Override
	public void destroy() {

	}

}
