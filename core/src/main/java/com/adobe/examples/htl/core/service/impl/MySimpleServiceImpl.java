package com.adobe.examples.htl.core.service.impl;

import org.apache.sling.settings.SlingSettingsService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.osgi.service.metatype.annotations.Designate;

import com.adobe.examples.htl.core.service.MySimpleService;

@Component(service = MySimpleService.class,configurationPolicy=ConfigurationPolicy.REQUIRE)
@Designate(ocd = MyServiceConfiguration.class)
@ServiceDescription("My simple service")
public class MySimpleServiceImpl implements MySimpleService {
	
	// to use the r7 OSGi annotations
	// use version 4.1.0 of maven-bundle-plugin
	// use version 1.4.0 of org.osgi.service.component.annotations

	@Activate
	private MyServiceConfiguration config;
	
	private boolean author;
	
	@Reference
	private SlingSettingsService settings;

	@Activate
	public void activate(MyServiceConfiguration config) {
		author = settings.getRunModes().contains("author");
	}

	public String getSimpleValue() {
		return "hello " + config.configValue();
	}
	
	public boolean isAuthor() {
		return author;
	}

}
