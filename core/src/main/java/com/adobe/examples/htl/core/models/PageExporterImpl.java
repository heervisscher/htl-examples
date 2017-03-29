package com.adobe.examples.htl.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

@Model(adaptables=Resource.class,resourceType="weretail/components/structure/page",adapters=PageExporter.class)
@Exporter(name = "jackson", extensions = "json", selector="pageinfo")
public class PageExporterImpl implements PageExporter{
	
	// you can now call the following url
	// /content/we-retail/us/en/products/women/_jcr_content.pageinfo.json
	//
	
	@Self
	private Resource resource;
	
	@Inject @Named("jcr:title")
	private String title;
		
	private List<PageExporter> children = new ArrayList<>();

	@PostConstruct
	protected void init() {
		resource.getParent().listChildren().forEachRemaining(resource -> processChild(resource) );
	}
	
	private void processChild(Resource r) {
		Resource jcrContent = r.getChild("jcr:content");
		if ( jcrContent != null) {
			children.add(jcrContent.adaptTo(PageExporter.class));
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
	public List<PageExporter> getChildren() {
		return children;
	}
	
}
