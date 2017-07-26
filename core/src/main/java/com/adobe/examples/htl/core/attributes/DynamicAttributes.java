package com.adobe.examples.htl.core.attributes;

import java.util.HashMap;
import java.util.Map;

import com.adobe.cq.sightly.WCMUsePojo;

// HTL-code
// <element data-sly-use.meta="com.adobe.examples.htl.core.attributes.DynamicAttributes" data-sly-element="${meta.elementName}" data-sly-attribute="${meta.attributes}"></element>
// if you also want to print non-whitelisted elements
// <element data-sly-use.meta="com.adobe.examples.htl.core.attributes.DynamicAttributes" data-sly-element="${meta.elementName @ context='unsafe'}" data-sly-attribute="${meta.attributes}"></element>

public class DynamicAttributes extends WCMUsePojo {
	
	private Map<String, String> attributes;
	
	private String elementName;

	@Override
	public void activate() throws Exception {
		attributes = new HashMap<>();
		attributes.put("title", "this is the title");
		attributes.put("alt", "alt text");
		
		elementName = "meta";

	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public String getElementName() {
		return elementName;
	}

	
	
}
