package com.adobe.examples.htl.core.service;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Service(value=MySimpleService.class)
@Component
public class MySimpleService {
	
	public String getSimpleValue() {
		return "hello";
	}

}
