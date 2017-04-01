package com.adobe.examples.htl.core.service.impl;

import org.apache.sling.settings.SlingSettingsService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;

import com.adobe.examples.htl.core.service.MySimpleService;

@Component(service = MySimpleService.class,configurationPolicy=ConfigurationPolicy.REQUIRE)
@Designate(ocd = MyServiceConfiguration.class)
public class MySimpleServiceImpl implements MySimpleService {
	
	// to use the OSGi annotations
	// use version 3.2.0 of maven-bundle-plugin

	private MyServiceConfiguration config;
	
	private boolean author;
	
	@Reference
	private SlingSettingsService settings;

	@Activate
	public void activate(MyServiceConfiguration config) {
		this.config = config;
		author = settings.getRunModes().contains("author");
	}

	public String getSimpleValue() {
		return "hello " + config.configValue();
	}
	
	public boolean isAuthor() {
		return author;
	}

}
