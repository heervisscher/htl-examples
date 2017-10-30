package com.adobe.examples.htl.core.service.impl;

import java.util.Set;

import org.apache.sling.settings.SlingSettingsService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.adobe.examples.htl.core.service.RunmodeService;

@Component(service=RunmodeService.class)
public class RunmodeServiceImpl implements RunmodeService {

	@Reference
	private SlingSettingsService slingSettingsService;
	
	private boolean author = false;
	
	private boolean publish = false;
	
	private Set<String> runmodes;
	
	
	@Activate
	public void activate() {
		runmodes = slingSettingsService.getRunModes();
		author = runmodes.contains("author");
		publish = runmodes.contains("publish");
	}
	
	
	@Override
	public boolean isAuthor() {
		return author;
	}

	@Override
	public boolean isPublish() {
		return publish;
	}
	
	@Override
	public Set<String> getRunmodes() {
		return runmodes;
	}

}
