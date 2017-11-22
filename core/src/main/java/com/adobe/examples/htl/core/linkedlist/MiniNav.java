package com.adobe.examples.htl.core.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.adobe.cq.sightly.WCMUsePojo;


/**
 * Example on using a LinkedList with HTL.
 * 
 * You can put this code in your HTL-component
 * <ul data-sly-use.nav="com.adobe.examples.htl.core.linkedlist.MiniNav" 
 * data-sly-list="${nav.navList}">
 * 	<li>${item.fpath} ${item.activeAttr}</li>
 * </ul>
 * 
 *
 */
public class MiniNav extends WCMUsePojo {

	private List<MiniNavBean> navList = new LinkedList<MiniNavBean>();

	private MiniNavBean miniNav;
	
	public List<MiniNavBean> getNavList() {
		return navList;
	}

	@Override
	public void activate() {

		miniNav = new MiniNavBean("fpaths", "activeattrs");

		navList.add(miniNav);

	}

}
