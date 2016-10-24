package com.adobe.examples.htl.core.service;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Service(value=MySimpleService.class)
@Component
public class MySimpleService {
	
	
	// you can use this service directly with data-sly-use
	// like this example
	// <sly data-sly-use.service="com.adobe.examples.htl.core.service.MySimpleService"/>
	//
	// ${service.simpleValue}
	//
	// https://issues.apache.org/jira/browse/SLING-4554?
	
	public String getSimpleValue() {
		return "hello";
	}

}
