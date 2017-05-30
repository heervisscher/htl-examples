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

		// Auto-closing ResourceResolvers were made available in Sling 8 (and thus AEM 6.2)
		// If your code made be run on older Sling/AEM stacks, ensure you manually close any ResourceResolver you open.
		try (ResourceResolver rr = repo.getAdministrativeResourceResolver(null)) {
			return rr.getUserID();
		} catch (LoginException e) {
			e.printStackTrace();
		}
		return StringUtils.EMPTY;
	}

}
