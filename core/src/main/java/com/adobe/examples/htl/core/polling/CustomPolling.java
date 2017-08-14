package com.adobe.examples.htl.core.polling;

import org.apache.sling.api.resource.Resource;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.polling.importer.ImportException;
import com.day.cq.polling.importer.Importer;

@Component(service=Importer.class,property={Importer.SCHEME_PROPERTY + "=myimporter"})
public class CustomPolling implements Importer, Runnable {
	
	// add the following to your content-node
	// mixin -> cq:PollConfig
	// interval (long) -> 600 (seconds)
	// source -> myimporter:myDataSource

	private static Logger log = LoggerFactory.getLogger(CustomPolling.class);
	
	@Override
	public void run() {
		log.info("In run-method");
		
	}

	@Override
	public void importData(String scheme, String dataSource, Resource target, String login, String password) throws ImportException {
		log.info("In importData1-method");
		
	}

	@Override
	public void importData(String scheme, String dataSource, Resource target) throws ImportException {
		log.info("In importData2-method");
	}
}
