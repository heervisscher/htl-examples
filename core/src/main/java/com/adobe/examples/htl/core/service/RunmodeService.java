package com.adobe.examples.htl.core.service;

import java.util.Set;

public interface RunmodeService {
	
	boolean isAuthor();
	
	boolean isPublish();
	
	public Set<String> getRunmodes();

}
