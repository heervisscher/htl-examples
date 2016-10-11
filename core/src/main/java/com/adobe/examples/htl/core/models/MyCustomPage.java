package com.adobe.examples.htl.core.models;

import java.util.Iterator;

import org.apache.sling.models.annotations.Model;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageFilter;

@Model(adaptables=Page.class)
public class MyCustomPage {

	private Page page;
	
	public MyCustomPage(Page page) {
		this.page = page;
	}
	
	public String getTitle() {
		return "MyProject : " + page.getTitle();
	}
	
	public Iterator<Page> getSubpages() {
		return page.listChildren(new PageFilter());
	}
	
}
