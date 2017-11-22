package com.adobe.examples.htl.core.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.factory.ModelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = SlingHttpServletRequest.class, resourceType = "weretail/components/structure/page", adapters = PageExporter.class)
@Exporter(name = "jackson", extensions = "json", selector = "pageinfo")
public class PageExporterImpl implements PageExporter {

	// you can now call the following url
	// /content/we-retail/us/en/products/women/_jcr_content.pageinfo.json
	//

	@Inject
	private ModelFactory mf;

	@Self
	private SlingHttpServletRequest request;

	private Resource resource;

	private String title;

	private List<PageExporter> childPages = new ArrayList<>();

	private List<Object> children = new ArrayList<>();

	@PostConstruct
	protected void init() {
		resource = request.getResource();

		resource.getParent().listChildren().forEachRemaining(child -> processChildPages(child));

		processChildren(resource.listChildren());
	}

	private void processChildren(Iterator<Resource> children) {

		children.forEachRemaining(resource -> processResource(resource));

	}

	private static Logger log = LoggerFactory.getLogger(PageExporterImpl.class);

	private void processResource(Resource r) {

		if ("weretail/components/structure/product".equals(r.getResourceType())) {

			String productPath = r.getValueMap().get("productData", String.class);
			Resource product = r.getResourceResolver().getResource(productPath);
			log.info("Sling RequestWrapper {}", product.getPath());
			children.add(mf.getModelFromWrappedRequest(request, product, ProductExporter.class));
		}
		processChildren(r.listChildren());
	}

	private void processChildPages(Resource r) {
		Resource jcrContent = r.getChild("jcr:content");
		if (jcrContent != null) {
			childPages.add(jcrContent.adaptTo(PageExporter.class));
		}
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String getPath() {
		return resource.getPath();
	}

	public String getName() {
		return resource.getParent().getName();
	}

	@Override
	public List<PageExporter> getChildPages() {
		return childPages;
	}

	public List<Object> getChildren() {
		return children;
	}

}
