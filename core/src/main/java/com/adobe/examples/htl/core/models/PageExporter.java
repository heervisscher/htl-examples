package com.adobe.examples.htl.core.models;

import java.util.List;

public interface PageExporter {

	String getTitle();

	String getName();
	
	List<PageExporter> getChildPages();
	
	List<Object> getChildren();
	
	String getPath();
	
}
