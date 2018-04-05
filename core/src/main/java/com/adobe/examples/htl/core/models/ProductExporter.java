package com.adobe.examples.htl.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.export.json.ExporterConstants;


@Model(adaptables = SlingHttpServletRequest.class)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION, selector="pageinfo")
public class ProductExporter {

	private String size;
	
	private String commerceType;
	
	private String resourcePath;
	
	@Self
	private SlingHttpServletRequest request;
	
	private Resource resource;
	
	private static Logger log = LoggerFactory.getLogger(ProductExporter.class);

	@PostConstruct
	protected void init() {
		resource = request.getResource();
		
		log.info("Product exporter {}", resource.getPath());
		
		ValueMap props = resource.getValueMap();
		
		size = props.get("size","");
		commerceType = props.get("cq:commerceType", "");
		resourcePath = resource.getPath();
	}

	public String getResourcePath() {
		return resourcePath;
	}


	public String getCommerceType() {
		return commerceType;
	}

	public String getSize() {
		return size;
	}

	
	
}
