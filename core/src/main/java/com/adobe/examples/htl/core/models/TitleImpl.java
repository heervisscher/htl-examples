package com.adobe.examples.htl.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;

import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.models.Title;

/**
 * This is an implementation of the Title-model.
 * Because we can now link the model to the resourceType,
 * this model will be used by the component.
 * See that no extra changes are needed in the proxy component
 * (/apps/aemhtlexamples/components/content/title).
 */
@Model(adaptables = SlingHttpServletRequest.class, adapters = Title.class, resourceType = TitleImpl.RESOURCE_TYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class TitleImpl implements Title {

    protected static final String RESOURCE_TYPE = "aemhtlexamples/components/content/title";

    @Override
    public String getText() {
        return "This is the title from the new implementation";
    }

    @Override
    public String getType() {
        return null;
    }
}
