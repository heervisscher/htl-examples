package com.adobe.examples.htl.core.bindings;

import javax.script.Bindings;

import org.apache.sling.scripting.api.BindingsValuesProvider;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import com.adobe.cq.sightly.WCMBindings;
import com.adobe.examples.htl.core.models.MyCustomPage;
import com.day.cq.wcm.api.Page;

@Component(immediate = true, service=BindingsValuesProvider.class, 
    property={"javax.script.name=sightly", Constants.SERVICE_RANKING +":Integer=1001"})
    // in AEM6.2 service ranking was set to 1001
    // in AEM6.0 service ranking was set to 100
public class CustomBindingProvider implements BindingsValuesProvider {
	
	@Override
	public void addBindings(Bindings bindings) {
		if ( bindings.containsKey(WCMBindings.CURRENT_PAGE)) {
			// there is the currentPage bindings from Sightly
			Page current = (Page) bindings.get(WCMBindings.CURRENT_PAGE);
			// adapt this to MyCustomPage, and add this to the bindings
			bindings.put("pageName", current.getName());
			bindings.put("myPage", current.adaptTo(MyCustomPage.class));
			// you can now refer to pageName and myPage in every HTML file
			// example ${pageName} ${myPage.title}
		}
	}
}
