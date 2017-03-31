package com.adobe.examples.htl.core.use;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.commons.jcr.JcrConstants;

public class WCMUse extends WCMUsePojo {

	private String title;
	
	@Override
	public void activate() throws Exception {
		// replaces getInheritedProperties()-method
		title = getInheritedPageProperties().get(JcrConstants.JCR_TITLE, String.class);
	}
	
	public String getTitle() {
		return title;
	}
	
	

}
