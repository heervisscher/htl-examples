package com.adobe.examples.htl.core.models;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.wrappers.CompositeValueMap;
import org.apache.sling.api.wrappers.ValueMapDecorator;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

@Model(adaptables=SlingHttpServletRequest.class)
public class CompositeValueMapModel {
	
	// <sly data-sly-use.cvp="com.adobe.examples.htl.core.models.CompositeValueMapModel" />
    // ${cvp.properties.title}
    // ${cvp.properties.sling:resourceType}
	
	private CompositeValueMap cvp;
	
	@Self
	private SlingHttpServletRequest request;
	
	private static ValueMap DEFAULT_PROPERTIES;
	
	@PostConstruct
	protected void init() {
		cvp = new CompositeValueMap(request.getResource().getValueMap(), DEFAULT_PROPERTIES);
	}
	
	public ValueMap getProperties() {
		return cvp;
	}
	
	{
		Map<String, Object> values = new HashMap<>();
		values.put("title", "default title");
		values.put("sling:resourceType", "default");
		
		DEFAULT_PROPERTIES = new ValueMapDecorator(values);
	}

}
