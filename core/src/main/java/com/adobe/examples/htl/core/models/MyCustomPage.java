package com.adobe.examples.htl.core.models;

import java.util.Iterator;

import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageFilter;

@Model(adaptables=Page.class)
public class MyCustomPage {

	@Self
	private Page page;
	
	public String getTitle() {
		return "MyProject : " + page.getTitle();
	}
	
	public Iterator<Page> getChildPages() {
		return page.listChildren(new PageFilter());
	}
	
}
