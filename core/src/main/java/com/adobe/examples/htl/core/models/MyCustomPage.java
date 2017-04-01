package com.adobe.examples.htl.core.models;

import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageFilter;

@Model(adaptables=Page.class)
public class MyCustomPage {

	@Self
	private Page page;
	
	private String title;
	
	@PostConstruct
	protected void init() {
		title = "MyProject : " + page.getTitle();
	}
	
	public String getTitle() {
		return title;
	}
	
	public Iterator<Page> getChildPages() {
		return page.listChildren(new PageFilter());
	}
	
}
