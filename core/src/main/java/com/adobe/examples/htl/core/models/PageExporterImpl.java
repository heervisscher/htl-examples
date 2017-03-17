package com.adobe.examples.htl.core.models;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables=Resource.class,resourceType="weretail/components/structure/page",adapters=PageExporter.class)
@Exporter(name = "jackson", extensions = "json", selector="pageinfo")
public class PageExporterImpl implements PageExporter{
	
	@Inject @Named("jcr:title")
	private String title;
	
	@Inject @Optional @Default(values="default")
	private String name;

	public String getTitle() {
		return title;
	}

	public String getName() {
		return name;
	}
	
	
	

}
