# htl-examples
AEM HTL examples

### AEM compatibility
The package is only compatible with AEM6.3, this because new features are used that are only available in AEM6.3
- Exporter (sling-models)
- getInheritedPageProperties() in WCMUsePojo
- getLanguage() in Page-api


## Included examples

### [CustomBindingProvider](/core/src/main/java/com/adobe/examples/htl/core/bindings/CustomBindingProvider.java)
Provides an example of a CustomBindingProvider, this if you want generic objects available in HTL

### [HashMapExample](/core/src/main/java/com/adobe/examples/htl/core/hashmap/HashMapExample.java)
Example on using a Map<> together with HTL

### [LinkedList](/core/src/main/java/com/adobe/examples/htl/core/linkedlist/MiniNav.java)
Code sample on using a LinkedList with HTL

### [Exporter](/core/src/main/java/com/adobe/examples/htl/core/models/PageExporterImpl.java)
Example on using Exporter-annotation with Sling-Models

### [Request parameter](/ui.apps/src/main/content/jcr_root/apps/aemhtlexamples/samplecode/request-parameter.html)
How to get a request parameter in HTL

### [htl-maven-plugin](/ui.apps/pom.xml)
Validating HTL-files during build process

### [AutoCloseable](/core/src/main/java/com/adobe/examples/htl/core/service/AutoCloseableService.java)
Example on using AutoCloseable functionality, no need to close ResourceResolvers in code

### [Date-formatting](/ui.apps/src/main/content/jcr_root/apps/aemhtlexamples/components/aem6.3/formatting/formatting.html)
Formatting your date-objects in HTL

### [Number-formatting](/ui.apps/src/main/content/jcr_root/apps/aemhtlexamples/components/aem6.3/formatting/formatting.html)
Formatting numbers in HTL

### [Resource resolution in data-sly-use](/ui.apps/src/main/content/jcr_root/apps/aemhtlexamples/components/aem6.3/button/button.html)
Example that shows the resolution of resources directly in HTL

### [RequestAttributes](/ui.apps/src/main/content/jcr_root/apps/aemhtlexamples/components/aem6.3/product/product.html)
Passing in request-attributes to data-sly-resource

### [OSGi annotations](/core/src/main/java/com/adobe/examples/htl/core/service/impl/MySimpleServiceImpl.java)
Example of the OSGi annotations, easy way to define OSGi properties.
Properties defined in [MyServiceConfiguration.java](/core/src/main/java/com/adobe/examples/htl/core/service/impl/MyServiceConfiguration.java), default config [here](/ui.apps/src/main/content/jcr_root/apps/aemhtlexamples/config/com.adobe.examples.htl.core.service.impl.MySimpleServiceImpl.xml)


### [Java8 Iterator example](/core/src/main/java/com/adobe/examples/htl/core/java8iterator/Java8Iterator.java)
Use of a lambda expression that is supported in Java8