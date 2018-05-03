# htl-examples
AEM HTL examples

### AEM compatibility
The package is only compatible with AEM6.3 SP1 and later, this because new features are used that are only available in AEM6.3.1.0
- Exporter (sling-models)
- getInheritedPageProperties() in WCMUsePojo
- getLanguage() in Page-api
- getModelFromWrappedRequest() in ModelFactory

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
Passing in request-attributes to data-sly-resource and data-sly-include

### [OSGi annotations](/core/src/main/java/com/adobe/examples/htl/core/service/impl/MySimpleServiceImpl.java)
Example of the OSGi annotations, easy way to define OSGi properties.
Properties defined in [MyServiceConfiguration.java](/core/src/main/java/com/adobe/examples/htl/core/service/impl/MyServiceConfiguration.java), default config [here](/ui.apps/src/main/content/jcr_root/apps/aemhtlexamples/config/com.adobe.examples.htl.core.service.impl.MySimpleServiceImpl.xml)


### [Java8 Iterator](/core/src/main/java/com/adobe/examples/htl/core/java8iterator/Java8Iterator.java)
Use of a lambda expression that is supported in Java8

### [Custom Sling-Model for the Title-component](/core/src/main/java/com/adobe/examples/htl/core/models/TitleImpl.java)
Example of a custom Sling-Model implementation, that is picked up from the core components.

### [CompositeValueMap](/core/src/main/java/com/adobe/examples/htl/core/models/CompositeValueMapModel.java)
Example of using the CompositeValueMap to merge properties of two ValueMaps

### [HealthCheck](/core/src/main/java/com/adobe/examples/htl/core/hc/HealthCheckExample.java)
Example of a basic healthcheck, that can be executed from the OSGi-console

### [HealthCheck card example](/ui.apps/src/main/content/jcr_root/apps/settings/granite/operations/hc/.content.xml)
Shows how to display a healthcheck card in the operations dashboard. To extend the default collection of healthchecks you need to use sling:configCollectionInherit on the /apps/settings/granite/operations/hc node

### [Custom Polling](/core/src/main/java/com/adobe/examples/htl/core/polling/CustomPolling.java)
Example of a custom poller that gets executed based on the information in the cq:PollConfig node. 

### [Datalayer mover](/core/src/main/java/com/adobe/examples/htl/core/datalayer/DatalayerFilter.java)
Common problem when defining a datalayer is that the JS-fragments are in the body,
while some of those need to be in the head. This filter is moving JS-fragments from the body into the head.

### [Flexible adapters](/ui.apps/src/main/content/jcr_root/apps/aemhtlexamples/components/aem6.3/flexibleadaptable/example.html)
Shows how to have a flexible way of using adapters, instead of always the same resource. Available since 6.3.1.1
