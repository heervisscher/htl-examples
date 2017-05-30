package com.adobe.examples.htl.core.hc;

import org.apache.sling.hc.api.HealthCheck;
import org.apache.sling.hc.api.Result;
import org.apache.sling.hc.util.FormattingResultLog;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.adobe.examples.htl.core.service.MySimpleService;

@Component(service = HealthCheck.class, 
property = { HealthCheck.NAME + "=HCExample",
		     HealthCheck.TAGS + "=hcexample", 
		     HealthCheck.MBEAN_NAME + "=Example health check" })
public class HealthCheckExample implements HealthCheck {
	
	// use this url to execute it in the console
	// /system/console/healthcheck?tags=hcexample&debug=true&overrideGlobalTimeout=

	@Reference
	private MySimpleService mySimpleService;
	
	@Override
	public Result execute() {
		final FormattingResultLog resultLog = new FormattingResultLog();
		
		resultLog.debug("Starting with the healthcheck");
		if (mySimpleService != null) {
			resultLog.info("MySimpleService is available {}", mySimpleService);
			if (mySimpleService.isAuthor()) {
				resultLog.info("Code is executed on author {}", mySimpleService.isAuthor());
			} else {
				resultLog.critical("Code is executed on author {}", mySimpleService.isAuthor());
			}
		} else {
			resultLog.critical("Not able to inject MySimpleService");
		}
		
		return new Result(resultLog);
	}
}
