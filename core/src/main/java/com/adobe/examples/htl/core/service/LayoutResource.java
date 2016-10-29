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
		// TODO Auto-generated method stub
		return resource.getChild(arg0);
	}

	@Override
	public Iterable<Resource> getChildren() {
		// TODO Auto-generated method stub
		return resource.getChildren();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return resource.getName();
	}

	@Override
	public Resource getParent() {
		// TODO Auto-generated method stub
		return resource.getParent();
	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return resource.getPath();
	}

	@Override
	public ResourceMetadata getResourceMetadata() {
		// TODO Auto-generated method stub
		return resource.getResourceMetadata();
	}

	@Override
	public ResourceResolver getResourceResolver() {
		// TODO Auto-generated method stub
		return resource.getResourceResolver();
	}

	@Override
	public String getResourceSuperType() {
		// TODO Auto-generated method stub
		return resource.getResourceSuperType();
	}

	@Override
	public String getResourceType() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return resource.getValueMap();
	}

	@Override
	public boolean hasChildren() {
		// TODO Auto-generated method stub
		return resource.hasChildren();
	}

	@Override
	public boolean isResourceType(String arg0) {
		// TODO Auto-generated method stub
		return resource.isResourceType(arg0);
	}

	@Override
	public Iterator<Resource> listChildren() {
		// TODO Auto-generated method stub
		return resource.listChildren();
	}

}
