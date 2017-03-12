package com.adobe.examples.htl.core.models;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables=SlingHttpServletRequest.class)
public class ProductSettings {

	@Inject @Optional @Default(values="empty")
	public String layout;
	
}
