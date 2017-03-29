package com.adobe.examples.htl.core.formatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;

/**
 * Example to show formatting
 * HTL-code: 
 * <sly data-sly-use.date="${'com.adobe.examples.htl.core.formatter.DateFormatter' @ date=currentPage.lastModified,
     format='dd/MM/yyyy'}">${date.value}</sly>
 * 
 * NOTE: In AEM6.3 you have native support for number/date formatting
 */
@Model(adaptables=SlingHttpServletRequest.class)
public class DateFormatter {
	
    @Inject
    private Calendar date;

    @Inject
    private String format;

    public String value;

    @PostConstruct
    protected void init() {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        value = formatter.format(date.getTime());
    }

}
