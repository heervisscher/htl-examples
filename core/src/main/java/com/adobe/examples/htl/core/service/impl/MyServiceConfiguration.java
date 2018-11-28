package com.adobe.examples.htl.core.service.impl;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@ObjectClassDefinition(name = "My Service Configuration", description = "Service Configuration")
public @interface MyServiceConfiguration {
	
	@AttributeDefinition(name = "Config Value", description = "Configuration value")
	String configValue();
	
	@AttributeDefinition(name = "Multiple-Values", 
			description = "Multi Configuration values, max 4",
			cardinality = 4)
	String[] getStringValues();
	
	@AttributeDefinition(name = "NumberValue", description = "Number values", type=AttributeType.INTEGER)
	int getNumberValue();
	
	@AttributeDefinition(description = "Single Configuration value")
	String my_property_name(); // gets to my.property.name
	
	@AttributeDefinition(description = "Used method",
    options = {
             @Option(label = "GET", value = "GET"),
             @Option(label = "POST", value = "POST"),
             @Option(label = "PUT", value = "PUT"),
             @Option(label = "PATCH", value = "PATCH"),
             @Option(label = "DELETE", value = "DELETE")
     })
     String method();

}
