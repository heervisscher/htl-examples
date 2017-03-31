package com.adobe.examples.htl.core.service;

public interface MySimpleService {
	
	
	// you can use this service directly with data-sly-use
	// like this example
	// <sly data-sly-use.service="com.adobe.examples.htl.core.service.MySimpleService"/>
	//
	// ${service.simpleValue}
	//
	// https://issues.apache.org/jira/browse/SLING-4554
		
	String getSimpleValue();
	
	boolean isAuthor();
}
