package com.adobe.examples.htl.core.service.impl;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "My Service Configuration", description = "Service Configuration")
public @interface MyServiceConfiguration {
	
	@AttributeDefinition(name = "Config Value", description = "Configuration value")
	String configValue();
	
	@AttributeDefinition(name = "Multiple-Values", description = "Multi Configuration values")
	String[] getStringValues();
	
	@AttributeDefinition(name = "NumberValue", description = "Number values", type=AttributeType.INTEGER)
	int getNumberValue();
	
	@AttributeDefinition(description = "Single Configuration value")
	String my_property_name();	

}
