package com.adobe.examples.htl.core.linkedlist;

public class MiniNavBean {
	
	private String fpath;

	private String activeAttr;

	public MiniNavBean(String fPath, String activeAttr) {

		this.fpath = fPath;
		this.activeAttr = activeAttr;
	}

	public String getFpath() {
		return fpath;
	}

	public String getActiveAttr() {
		return activeAttr;
	}

}
