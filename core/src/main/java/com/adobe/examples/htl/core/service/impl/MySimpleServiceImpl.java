package com.adobe.examples.htl.core.service.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import com.adobe.examples.htl.core.service.MySimpleService;

@Component(service = MySimpleService.class)
@Designate(ocd = MyServiceConfiguration.class)
public class MySimpleServiceImpl implements MySimpleService {

	private MyServiceConfiguration config;

	@Activate
	public void activate(MyServiceConfiguration config) {
		this.config = config;
	}

	public String getSimpleValue() {
		return "hello " + config.configValue();
	}

}
