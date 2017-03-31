package com.adobe.examples.htl.core.java8iterator;

import java.util.Iterator;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.api.Page;

public class Java8Iterator extends WCMUsePojo {
	
	public void activate() {
		Iterator<Page> children = getCurrentPage().listChildren();
		children.forEachRemaining(page -> System.out.println(page.getTitle()));
	}

}
