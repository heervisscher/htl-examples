/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.adobe.examples.htl.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.settings.SlingSettingsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables=Resource.class)
public class HelloWorldModel {
	
	private static Logger log = LoggerFactory.getLogger(HelloWorldModel.class);

    @OSGiService
    private SlingSettingsService settings;
    
    @SlingObject
    private ResourceResolver resourceResolver;

    @ValueMapValue(name = "sling:resourceType", injectionStrategy=InjectionStrategy.OPTIONAL) @Default(values="No resourceType")
    private String resourceType;
    
    private String message;

    @PostConstruct
    protected void init() {
    	log.info("Reached init of HelloWorldModel");
        message = "\tHello World!\n";
        message += "\tThis is instance: " + settings.getSlingId() + "\n";
        message += "\tResource type is: " + resourceType + "\n";
        message += "\tUser id is " + resourceResolver.getUserID() + "\n";
    }

    public String getMessage() {
    	log.info("Inside getMessage() method");
        return message;
    }
    
    public String getResourceType() {
    	   return resourceType;
    }

}
