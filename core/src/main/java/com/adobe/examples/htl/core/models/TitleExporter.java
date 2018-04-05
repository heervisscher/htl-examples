package com.adobe.examples.htl.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.adobe.cq.export.json.ExporterConstants;

@Model(adaptables = Resource.class)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION, selector="pageinfo")
public class TitleExporter {
	
	@Self
	private Resource resource;

    public String getText() {
        return resource.getValueMap().get("jcr:title", "");
    }
    
    public String getResourceType() {
    	  return resource.getResourceType();
    }
	
    public String getName() {
    	  return resource.getName();
    }

}
