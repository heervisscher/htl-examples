package com.adobe.examples.htl.core.hashmap;

import java.util.HashMap;

import com.adobe.cq.sightly.WCMUsePojo;

@SuppressWarnings("rawtypes")
public class HashMapExample extends WCMUsePojo {

	// here the sightly code to loop through the map
	//<div data-sly-use.hashmap="com.adobe.examples.htl.core.hashmap.HashMapExample"
	//	     data-sly-list="${hashmap.map.keySet.iterator}">
	//	     ${item}
	//	     <ul data-sly-list.aem="${hashmap.map[item].keySet.iterator}">
	//	     	<li>${aem} ${hashmap.map[item][aem]}</li>
	//	     </ul>
	//	</div>
	
	
	public HashMap<String, HashMap> map = new HashMap<String, HashMap>();
	
	
	@Override
	public void activate() {
		HashMap m1 = new HashMap<>();
		m1.put("aem", "6.1");
		m1.put("aem6", "6.2");
		map.put("a", m1 );
		HashMap m2 = new HashMap<>();
		m2.put("cq", "5.5");
		m2.put("cq5", "5.4");
		map.put("b", m2);
	}

}
