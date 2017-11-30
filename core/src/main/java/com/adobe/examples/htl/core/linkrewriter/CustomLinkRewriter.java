package com.adobe.examples.htl.core.linkrewriter;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.rewriter.Transformer;
import org.apache.sling.rewriter.TransformerFactory;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

@Component(service = TransformerFactory.class, property = { "pipeline.type=productpages", "pipeline.mode=global" })
public class CustomLinkRewriter implements Transformer, TransformerFactory {
	private ContentHandler contentHandler;
	
	private static Logger log = LoggerFactory.getLogger(CustomLinkRewriter.class);


	@Override
	public void init(org.apache.sling.rewriter.ProcessingContext context,
			org.apache.sling.rewriter.ProcessingComponentConfiguration config) throws IOException {

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		contentHandler.characters(ch, start, length);
	}

	@Override
	public void dispose() {

	}

	@Override
	public void endDocument() throws SAXException {
		contentHandler.endDocument();
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		contentHandler.endElement(uri, localName, qName);
	}

	public void endPrefixMapping(String prefix) throws SAXException {
		contentHandler.endPrefixMapping(prefix);
	}

	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		contentHandler.ignorableWhitespace(ch, start, length);
	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		contentHandler.processingInstruction(target, data);
	}

	@Override
	public void setContentHandler(ContentHandler handler) {
		this.contentHandler = handler;
	}

	@Override
	public void setDocumentLocator(Locator locator) {
		contentHandler.setDocumentLocator(locator);
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		contentHandler.skippedEntity(name);
	}

	@Override
	public void startDocument() throws SAXException {
		contentHandler.startDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		if ("a".equalsIgnoreCase(localName)) {
			contentHandler.startElement(uri, localName, qName, rewriteLink(atts));
		} else {
			contentHandler.startElement(uri, localName, qName, atts);
		}
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		contentHandler.startPrefixMapping(prefix, uri);
	}

	/**
	 * Main rewriting step Rewrites links and appends a version number if there is a
	 * version to be appended and if there are any paths to look for
	 */
	private Attributes rewriteLink(Attributes atts) {
		log.info("[CUSTOM TRANSFORMER] ************ REWRITING LINK");
		AttributesImpl newAttrs = new AttributesImpl(atts);
		int length = newAttrs.getLength();
		for (int i = 0; i < length; i++) {
			String attributeName = newAttrs.getLocalName(i);
			if ("href".equalsIgnoreCase(attributeName)) {
				String originalValue = newAttrs.getValue(i);
				if (isNotEmpty(originalValue) && originalValue.startsWith("/content/we-retail/us/en/products")) {
					
					String newValue = StringUtils.substringAfterLast(originalValue, "/");
					newValue = "/fp/" + newValue;
					
					log.info("New link {}", newValue);
					
					newAttrs.setValue(i, newValue);
					
					break;
				}

			}
		}
		return newAttrs;
	}


	/**
	 * Helper method for checking for empty and null
	 */
	private boolean isNotEmpty(String s) {
		return s != null && !s.equals("");
	}

	@Override
	public final Transformer createTransformer() {
		log.debug("[CUSTOM TRANSFORMER FACTORY] ************ CREATING THE TRANSFORMER");
		return new CustomLinkRewriter();
	}

}
