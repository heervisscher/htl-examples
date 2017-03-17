package com.adobe.examples.htl.core.models;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;

@Model(adaptables=Resource.class,resourceType="weretail/components/structure/page",adapters=PageExporter.class)
@Exporter(name = "jackson", extensions = "json", selector="pageinfo")
public class PageExporterImpl implements PageExporter{
	
	@Inject @Named("jcr:title")
	private String title;
	
	@Inject
	private String name;

	public String getTitle() {
		return title;
	}

	public String getName() {
		return name;
	}
	
	
	

}
