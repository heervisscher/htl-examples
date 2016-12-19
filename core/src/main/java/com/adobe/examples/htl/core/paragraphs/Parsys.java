package com.adobe.examples.htl.core.paragraphs;

import java.util.List;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.foundation.Paragraph;
import com.day.cq.wcm.foundation.ParagraphSystem;

/**
 * Example on how to use the ParagraphSystem in Sightly/HTL
 * 
 * HTL code
 * <div data-sly-use.parsys="com.adobe.examples.htl.core.paragraphs.Parsys" 
 *       data-sly-list="${parsys.paragraphs}">
 *   ${item.path}
 * </div>
 *
 */
public class Parsys extends WCMUsePojo {

	private ParagraphSystem parSys;
	
	public List<Paragraph> getParagraphs() {
		return parSys.paragraphs();
	}
	
	
	@Override
	public void activate() {
		parSys = ParagraphSystem.create(getResource(), getRequest());
	}

}
