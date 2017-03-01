package com.adobe.examples.htl.core.service;

import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service=MySimpleService.class)
public class MySimpleService {
	
	
	// you can use this service directly with data-sly-use
	// like this example
	// <sly data-sly-use.service="com.adobe.examples.htl.core.service.MySimpleService"/>
	//
	// ${service.simpleValue}
	//
	// https://issues.apache.org/jira/browse/SLING-4554
	
	@Reference
	private ResourceResolverFactory resourceResolverFactory;
	
	public String getSimpleValue() {
		return "hello " + resourceResolverFactory.getThreadResourceResolver().getUserID();
	}

}
