package com.adobe.examples.htl.core.resource;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jcr.Session;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceProvider;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.framework.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.SearchResult;

@SuppressWarnings("deprecation")
@Component( immediate = true)
@Properties({
		@Property(label = "Root paths", description = "Root paths this Sling Resource Provider will respond to", name = ResourceProvider.ROOTS, value = {
				"/fp" }),
		@Property(name = Constants.SERVICE_RANKING, intValue = 10)

})
@Service
public class CustomResourceProvider implements ResourceProvider {

	private static Logger log = LoggerFactory.getLogger(CustomResourceProvider.class);

	private List<String> roots;

	@Reference
	private QueryBuilder builder;

	@Override
	public Resource getResource(ResourceResolver resourceResolver, HttpServletRequest request, String path) {
		
		SlingHttpServletRequest slingHttp = (SlingHttpServletRequest) request;
		
		log.info("Selectors : {}", slingHttp.getRequestPathInfo().getSelectors().length );

		return getResource(resourceResolver, path);
		
	}

	@Override
	public Resource getResource(ResourceResolver resourceResolver, String path) {
		log.info("In getResource {}", path);

		String productId = StringUtils.substringBetween(path, "fp/", ".");

		if (StringUtils.isNotBlank(productId)) {

			log.info("Product id {}", productId);

			Map<String, String> map = new HashMap<String, String>();

			// create query description as hash map (simplest way, same as form post)

			map.put("path", "/content/we-retail/us/en/products");
			map.put("type", "cq:Page");
			map.put("nodename", productId);

			Query query = builder.createQuery(PredicateGroup.create(map), resourceResolver.adaptTo(Session.class));

			query.setStart(0);
			query.setHitsPerPage(1);

			SearchResult result = query.getResult();

			log.info("Query {}", result.getQueryStatement());

			Iterator<Resource> it = result.getResources();

			if (it != null && it.hasNext()) {
				CustomResourceWrapper rw = new CustomResourceWrapper(it.next(), path);

				log.info("In getResource, returning {}", rw.getPath());

				return rw;

			}

		}

		return null;

	}

	@Override
	public Iterator<Resource> listChildren(Resource parent) {
		return null;
	}

	/**
	 * Checks if the provided path is a defined Root path
	 *
	 * @param path
	 * @return
	 */
	protected boolean isRoot(String path) {
		for (String root : this.roots) {
			if (path.equals(root)) {
				return true;
			}
		}

		return false;
	}

}