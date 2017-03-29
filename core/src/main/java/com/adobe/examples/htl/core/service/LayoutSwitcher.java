package com.adobe.examples.htl.core.service;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceDecorator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.PageManagerFactory;

@Component(service=ResourceDecorator.class)
public class LayoutSwitcher implements ResourceDecorator {

	private static final String SLING_SCRIPT_FOLDER = "sling:scriptFolder";
	
	private Logger LOG = LoggerFactory.getLogger(LayoutSwitcher.class);
	
	@Reference
	private PageManagerFactory pmf;
	
	@Override
	public Resource decorate(Resource resource) {
		
		if ( resource instanceof LayoutResource) {
			return resource;
		}
		
		String path = resource.getPath();
		
		if (path != null && ( path.startsWith("/content/theme") ) ) {
			
			LOG.info("Layout switcher for {}", path);
			String scriptFolder = getSlingScriptFolder(resource);
			
			if (scriptFolder == null ) {
				LOG.info("No scriptfolder found for {}", path);
				return resource;
			} else {
				LOG.info("Scriptfolder {} found for {}", scriptFolder, path);
			}

			String componentName = resource.getResourceType();
			if (componentName != null ) {
				componentName = StringUtils.substringAfterLast(componentName, "/");
			}
			
			if ( StringUtils.isNotBlank( scriptFolder) && StringUtils.isNotBlank(componentName)) {
				String newComponentName = scriptFolder + "/" + componentName;
				
				// check if there is a local version available, if so then use this		
				if ( resource.getResourceResolver().getResource(newComponentName) != null ) {
					LayoutResource lr = new LayoutResource(resource);
					// overriding the resource-type
					lr.setSlingResourceType(newComponentName);
					
					LOG.info("override RT {}", newComponentName );
					
					return lr;
				}
			} 
		}
		return resource;
	}

	private String getSlingScriptFolder(Resource resource) {
		
		Iterator<Resource> it = resource.getResourceResolver().getResource("/var/layoutswitcher").listChildren();
		
		while ( it.hasNext()) {
			Resource r = it.next();
			String path = r.getValueMap().get("path", String.class);
			if ( resource.getPath().startsWith(path)){
				return r.getValueMap().get(SLING_SCRIPT_FOLDER, String.class);
			}
		}
		return null;

	}

	@Override
	public Resource decorate(Resource resource, HttpServletRequest arg1) {
		return this.decorate(resource);
	}

}
