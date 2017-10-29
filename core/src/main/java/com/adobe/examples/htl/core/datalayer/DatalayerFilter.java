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
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.acs.commons.util.BufferingResponse;


/**
 * Filter that moves JS-fragments from the datalayer from the body to the head.
 * JS-fragments that need to be moved can be wrapped with the following HTML-comments:
 * <!-- datalayer_move_to_head --> .... <!-- datalayer_move_to_head_end -->
 * In the head-element you have this placeholder where the JS-fragment should be moved to:
 * <!-- datalayer_move_code_here -->
 *
 */
@Component(service = Filter.class, 
   name = "Datalayer move filter",
   property = { "sling.filter.scope=REQUEST",
   Constants.SERVICE_RANKING + ":Integer=0" })
public class DatalayerFilter implements Filter {
	private static final Logger log = LoggerFactory.getLogger(DatalayerFilter.class);

	/**
	 * This is the begin-placeholder for a JS-fragments that needs to be moved
	 */
	public static final String BEGIN = "<!-- datalayer_move_to_head -->";

	/**
	 * This is the end-placeholder for a JS-fragments that needs to be moved
	 */
	public static final String END = "<!-- datalayer_move_to_head_end -->";

	/**
	 * This is the placeholder where the JS-fragments need to be moved to
	 */
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

		if (contents != null && StringUtils.contains(response.getContentType(), "html")
				&& contents.indexOf(BEGIN) != -1) {

			log.info("There is a datalayer_move_to_head");

			// gettng the fragments that need to be moved
			String[] jsToBeMoved = StringUtils.substringsBetween(contents, BEGIN, END);
			String modifiedContents = contents;

			if (jsToBeMoved != null && jsToBeMoved.length > 0) {

				String headCode = "";
				for (int i = 0; i < jsToBeMoved.length; i++) {
					headCode += jsToBeMoved[i];

					// remove the fragments
					modifiedContents = StringUtils.replace(modifiedContents, BEGIN + jsToBeMoved[i] + END, "");

				}

				log.info("Complete code to move {}", headCode);

				// move all the JS-fragments
				modifiedContents = StringUtils.replace(modifiedContents, REPLACE, headCode);

				response.getWriter().write(modifiedContents);
				return;

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