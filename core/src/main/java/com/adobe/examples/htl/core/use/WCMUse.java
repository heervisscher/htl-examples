package com.adobe.examples.htl.core.use;

import java.util.Locale;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.commons.jcr.JcrConstants;

public class WCMUse extends WCMUsePojo {

	private String title;
	
	private Locale locale;
	
	@Override
	public void activate() throws Exception {
		// new in AEM6.3 : getInheritedPageProperties
		// replaces getInheritedProperties()-method
		title = getInheritedPageProperties().get(JcrConstants.JCR_TITLE, String.class);
		
		// also new in AEM6.3
		// shortcut method getLanguage() without parameters
		locale = getCurrentPage().getLanguage();
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getLanguage() {
		return locale.getLanguage();
	}
	
}
