package com.adobe.examples.htl.core.requestscope;

import com.adobe.cq.sightly.WCMUsePojo;

/**
 * Example on how to put/get a variable from the request.
 * 
 *
 */
public class RequestScope extends WCMUsePojo {

	@Override
	public void activate() throws Exception {
		getRequest().setAttribute("hello", "world");

	}
	
	public String getHello() {
		return (String) getRequest().getAttribute("hello");
	}

}
