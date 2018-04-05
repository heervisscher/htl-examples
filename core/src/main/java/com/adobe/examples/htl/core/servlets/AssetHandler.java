package com.adobe.examples.htl.core.servlets;

import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_EXTENSIONS;
import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_METHODS;
import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_PATHS;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.examples.htl.core.bindings.CustomBindingProvider;

@Component(service = Servlet.class, property = { SLING_SERVLET_PATHS + "=/bin/wcm/contentfinder/asset/view",
		SLING_SERVLET_METHODS + "=GET", SLING_SERVLET_EXTENSIONS + "=html" })
public class AssetHandler extends SlingSafeMethodsServlet {

	private static Logger logger = LoggerFactory.getLogger(CustomBindingProvider.class);

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();

		pw.println(getRemoteAssets(request));

		pw.flush();
	}

	private String getRemoteAssets(SlingHttpServletRequest request) {

		try {
			CloseableHttpClient client = HttpClients.createDefault();

			HttpGet get = new HttpGet(
					"http://localhost:4503/" + request.getRequestURI() + "?" + request.getQueryString());
			get.addHeader("Cache-Control", "no-cache");
			get.addHeader("Content-Type", "application/x-www-form-urlencoded");

			logger.info("URL : " + get.getURI());

			HttpResponse response = client.execute(get);

			if (response.getStatusLine().getStatusCode() != 200) {
				logger.info("response code {} ", response.getStatusLine().getStatusCode());
			}

			String result = IOUtils.toString(response.getEntity().getContent());

			result = StringUtils.replace(result, "/content/dam/", "http://localhost:4503/content/dam/");

			logger.info("JSON Response : {}", result);

			return result;

		} catch (Exception e) {
			logger.error("Error in getRemoteAssets ", e);
		}

		return "";
	}

}
