# handlermapping

The properties file

org.springframework:spring-webmvc:4.3.8.RELEASE:/org/springframework/web/servlet/DispatcherServlet.properties (DSprops)

defines two org.springframework.web.servlet.HandlerMapping (HM):

* org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping (BNUHM)
* org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping (DAHM)

and three org.springframework.web.servlet.HandlerAdapter:

* org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter (HRHA)
* org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter (SCHA)
* org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter (AMHA)

/handlermapping/src/main/webapp/WEB-INF/web.xml (web.xml) maps org.springframework.web.servlet.DispatcherServlet (DS) to /ds/*

BNUHM map bean names starting with '/' to the corresponding request url fragment.

/handlermapping/src/main/webapp/WEB-INF/mvc.xml (mvc.xml) defines three such beans:

* /foo (class com.github.xdptdr.Foo (Foo)) is mapped to /ds/foo
* /bar (class com.github.xdptdr.Bar (Bar)) is mapped to /ds/bar
* /baz (class com.github.xdptdr.Baz (Baz)) is mapped to /ds/baz

When DS is initialized, the DS.initStrategies(ApplicationContext) method is executed, which implies the execution of both DS.initHandlerMappings(ApplicationContext) and DS.initHandlerAdapters(ApplicationContext).

Since no specific handler mappings or handler adapters are defined in mvc.xml, thos from DSProps are used.

Handler mappings actually build a map that assigns urls to specific beans.

BNUHM just uses the beans those names look like an URL.
DAHM inspect the beans for the presence of a org.springframework.web.bind.annotation.RequestMapping (RM) or org.springframework.stereotype.Controller (ControllerA) annotation.

The actual methods are in org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping.determineUrlsForHandler(String) and org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping.determineUrlsForHandler(String)

Handler mapper only maps urls to beans. How these beans are atually called is managed by handler adapters.

Since Foo implements org.springframework.web.HttpRequestHandler (HRH), it is handled by HRHA.

Since Bar implements org.springframework.web.servlet.mvc.Controller (ControllerI), it is handled by SCHA.

And since Baz has a RM annotation, it is handled by AMHA.

com.github.xdptdr.mvc.controllers.HelloController (HC) is annotated with ControllerA, and contains methods annotated with RM. Therefore, it is handled by AMHA.

