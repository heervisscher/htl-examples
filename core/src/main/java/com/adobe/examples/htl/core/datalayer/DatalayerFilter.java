package com.adobe.examples.htl.core.datalayer;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.annotations.sling.SlingFilter;
import org.apache.felix.scr.annotations.sling.SlingFilterScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.acs.commons.util.BufferingResponse;

@SlingFilter(label = "ACS AEM Samples - Sling REQUEST Filter",
description = "Sample implementation of a Sling Filter",
generateComponent = true, // True if you want to leverage activate/deactivate or manage its OSGi life-cycle
generateService = true, // True; required for Sling Filters
order = 0, // The smaller the number, the earlier in the Filter chain (can go negative);
            // Defaults to Integer.MAX_VALUE which push it at the end of the chain
scope = SlingFilterScope.REQUEST)
public class DatalayerFilter implements Filter {
	private static final Logger log = LoggerFactory.getLogger(DatalayerFilter.class);

	public static final String BEGIN = "<!-- datalayer_move_to_head -->";

	public static final String END = "<!-- datalayer_move_to_head_end -->";
	
	public static final String REPLACE = "<!-- datalayer_move_code_here -->";

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public final void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse,
			final FilterChain filterChain) throws IOException, ServletException {
		

		
		if (!(servletRequest instanceof HttpServletRequest) || !(servletResponse instanceof HttpServletResponse)) {
			filterChain.doFilter(servletRequest, servletResponse);
			return;
		}
		
	
		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final HttpServletResponse response = (HttpServletResponse) servletResponse;

		
		final BufferingResponse capturedResponse = new BufferingResponse(response);

		filterChain.doFilter(request, capturedResponse);


		// Get contents
		final String contents = capturedResponse.getContents();

		if (contents != null && StringUtils.contains(response.getContentType(), "html")) {

			final int bodyIndex = contents.indexOf(BEGIN);

			if (bodyIndex != -1) {
				
				log.info("There is datalayer_move_to_head");

				String[] jsToBeMoved = StringUtils.substringsBetween(contents, BEGIN, END);
				String modifiedContents = contents;

				if (jsToBeMoved != null && jsToBeMoved.length > 0) {

					String headCode = "";
					for (int i = 0; i < jsToBeMoved.length; i++) {
						headCode += jsToBeMoved[i];
						modifiedContents = StringUtils.replace(modifiedContents, BEGIN + jsToBeMoved[i] + END, "");
						
					}
					
					log.info("Complete code to move {}", headCode);

					modifiedContents = StringUtils.replace(modifiedContents, REPLACE, headCode);

					response.getWriter().write(modifiedContents);
					return;

				}

			}
		}

		if (contents != null) {
			response.getWriter().write(contents);
		}
	}

	@Override
	public void destroy() {

	}

}