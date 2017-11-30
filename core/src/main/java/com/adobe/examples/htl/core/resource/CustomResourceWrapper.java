package com.adobe.examples.htl.core.resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomResourceWrapper extends ResourceWrapper {

	private Resource resource;
	private String path;
	
	private static Logger log = LoggerFactory.getLogger(CustomResourceWrapper.class);


	public CustomResourceWrapper(Resource resource, String path) {
		super(resource);
		this.path = path;
		this.resource = resource;

	}
	
	@Override
	public ResourceMetadata getResourceMetadata() {
		
		ResourceMetadata metadata = new ResourceMetadata();
		metadata.setCharacterEncoding(resource.getResourceMetadata().getCharacterEncoding());
		metadata.setContentType(resource.getResourceMetadata().getContentType());
		metadata.setContentLength(resource.getResourceMetadata().getContentLength());
		metadata.setCreationTime(resource.getResourceMetadata().getCreationTime());
		metadata.setModificationTime(resource.getResourceMetadata().getModificationTime());
		metadata.setResolutionPath(path);

		log.info("resolution path : {} ",  StringUtils.substringAfter(path, "."));
		metadata.setResolutionPathInfo("." + StringUtils.substringAfter(path, "."));

		return metadata;
	}
	

}
