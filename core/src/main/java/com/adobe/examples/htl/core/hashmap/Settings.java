package com.adobe.examples.htl.core.hashmap;

import java.util.HashMap;
import java.util.Map;

import com.adobe.cq.sightly.WCMUsePojo;

public class Settings extends WCMUsePojo {
	
	public Map<String, Object> settings = new HashMap<String, Object>();

	@Override
	public void activate() throws Exception {
		settings.put("layout", "flex");

	}

}
