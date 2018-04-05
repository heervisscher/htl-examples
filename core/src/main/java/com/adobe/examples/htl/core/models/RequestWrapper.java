package com.adobe.examples.htl.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.wrappers.SlingHttpServletRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestWrapper extends SlingHttpServletRequestWrapper {
	
	public Resource resource;
	
	private static Logger log = LoggerFactory.getLogger(RequestWrapper.class);

	
	public RequestWrapper(SlingHttpServletRequest req, Resource resource) {
		super(req);
		log.info("In constructor... {}", resource.getPath());
		this.resource = resource;
	}
	

	@Override
	public Resource getResource() {
		log.info("In getResource... {}", this.resource.getPath());
		return this.resource;
	}


}
