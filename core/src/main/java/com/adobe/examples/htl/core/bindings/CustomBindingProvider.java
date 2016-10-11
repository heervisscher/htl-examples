package com.adobe.examples.htl.core.bindings;

import javax.script.Bindings;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.scripting.api.BindingsValuesProvider;

import com.adobe.cq.sightly.WCMBindings;
import com.adobe.examples.htl.core.models.MyCustomPage;
import com.day.cq.wcm.api.Page;

@Service
@Component(immediate = true)
@Properties({
    @Property(name = "javax.script.name", value = "sightly"),
    @Property(name = "service.ranking", intValue = 1001) 
    // in AEM6.2 service ranking was set to 1001
    // in AEM6.0 service ranking was set to 100
    })
public class CustomBindingProvider implements BindingsValuesProvider {

	@Override
	public void addBindings(Bindings bindings) {
		if ( bindings.containsKey(WCMBindings.CURRENT_PAGE)) {
			// there is the currentPage bindings from Sightly
			Page current = (Page) bindings.get(WCMBindings.CURRENT_PAGE);
			// adapt this to MyCustomPage, and add this to the bindings
			bindings.put("pageName", current.getName());
			bindings.put("myPage", current.adaptTo(MyCustomPage.class));
		}
	}
}
