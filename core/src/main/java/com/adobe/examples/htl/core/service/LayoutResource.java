package com.adobe.examples.htl.core.service;

import java.util.Iterator;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;

public class LayoutResource implements Resource {
	
	private Resource resource;
	
	private String slingResourceType;
	
	public LayoutResource(Resource r) {
		this.resource = r;
	}

	@Override
	public <AdapterType> AdapterType adaptTo(Class<AdapterType> arg0) {
		return resource.adaptTo(arg0);
	}

	@Override
	public Resource getChild(String arg0) {
		return resource.getChild(arg0);
	}

	@Override
	public Iterable<Resource> getChildren() {
		return resource.getChildren();
	}

	@Override
	public String getName() {
		return resource.getName();
	}

	@Override
	public Resource getParent() {
		return resource.getParent();
	}

	@Override
	public String getPath() {
		return resource.getPath();
	}

	@Override
	public ResourceMetadata getResourceMetadata() {
		return resource.getResourceMetadata();
	}

	@Override
	public ResourceResolver getResourceResolver() {
		return resource.getResourceResolver();
	}

	@Override
	public String getResourceSuperType() {
		return resource.getResourceSuperType();
	}

	@Override
	public String getResourceType() {
		if ( slingResourceType != null ) {
			return slingResourceType;
		}
		return resource.getResourceType();
	}

	public String getSlingResourceType() {
		return slingResourceType;
	}

	public void setSlingResourceType(String slingResourceType) {
		this.slingResourceType = slingResourceType;
	}

	@Override
	public ValueMap getValueMap() {
		return resource.getValueMap();
	}

	@Override
	public boolean hasChildren() {
		return resource.hasChildren();
	}

	@Override
	public boolean isResourceType(String arg0) {
		return resource.isResourceType(arg0);
	}

	@Override
	public Iterator<Resource> listChildren() {
		return resource.listChildren();
	}

}
