package com.adobe.examples.htl.core.models;

import java.util.List;

public interface PageExporter {

	String getTitle();

	String getName();
	
	List<PageExporter> getChildren();
	
	String getPath();
	
}
