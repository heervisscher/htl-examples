package com.adobe.examples.htl.core.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service=AutoCloseableService.class)
public class AutoCloseableService {
	
	@Reference
	private ResourceResolverFactory repo;
	
	@SuppressWarnings("deprecation")
	public String getValue() {
		
		try (ResourceResolver rr = repo.getAdministrativeResourceResolver(null)) {
			return rr.getUserID();
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return StringUtils.EMPTY;
	}

}
