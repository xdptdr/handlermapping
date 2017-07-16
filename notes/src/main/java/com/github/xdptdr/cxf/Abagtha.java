package com.github.xdptdr.cxf;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.apache.cxf.binding.Binding;
import org.apache.cxf.binding.soap.SoapBinding;
import org.apache.cxf.binding.soap.SoapBindingConfiguration;
import org.apache.cxf.binding.soap.SoapBindingFactory;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.SoapTransportFactory;
import org.apache.cxf.binding.soap.SoapVersion;
import org.apache.cxf.bus.extension.ExtensionManagerBus;
import org.apache.cxf.common.xmlschema.SchemaCollection;
import org.apache.cxf.databinding.DataBinding;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.endpoint.EndpointException;
import org.apache.cxf.endpoint.EndpointImpl;
import org.apache.cxf.feature.Feature;
import org.apache.cxf.interceptor.InFaultChainInitiatorObserver;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.OutFaultChainInitiatorObserver;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.message.Message;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.ServiceImpl;
import org.apache.cxf.service.factory.FactoryBeanListener.Event;
import org.apache.cxf.service.factory.SimpleMethodDispatcher;
import org.apache.cxf.service.invoker.FactoryInvoker;
import org.apache.cxf.service.invoker.Invoker;
import org.apache.cxf.service.invoker.MethodDispatcher;
import org.apache.cxf.service.model.AbstractPropertiesHolder;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.service.model.DescriptionInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.MessagePartInfo;
import org.apache.cxf.service.model.SchemaInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.service.model.ServiceSchemaInfo;
import org.apache.cxf.simple.SimpleServiceBuilder;
import org.apache.cxf.transport.MessageObserver;
import org.apache.cxf.workqueue.SynchronousExecutor;
import org.apache.cxf.ws.addressing.AttributedURIType;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.apache.cxf.wsdl.service.factory.AbstractServiceConfiguration;
import org.apache.cxf.wsdl.service.factory.DefaultServiceConfiguration;
import org.apache.cxf.wsdl.service.factory.ReflectionServiceFactoryBean;
import org.w3c.dom.Node;

import com.sun.xml.bind.v2.runtime.JAXBContextImpl;

public class Abagtha {

	public void foo() {
	}

	public static void main(String[] args) throws IOException, EndpointException {

		SimpleServiceBuilder simpleServiceBuilder = new SimpleServiceBuilder();
		azzert(simpleServiceBuilder.getServiceFactory() != null);
		azzert(simpleServiceBuilder.getBindingConfig() == null);
		azzert(simpleServiceBuilder.getBindingFactory() == null);
		azzert(simpleServiceBuilder.getBus(false) == null);
		azzert(simpleServiceBuilder.getDestinationFactory() == null);
		azzert(simpleServiceBuilder.getFeatures().size() == 0);
		azzert(simpleServiceBuilder.getProperties(false) == null);

		ReflectionServiceFactoryBean rsfb = simpleServiceBuilder.getServiceFactory();

		azzert(rsfb.getConfigurations().size() == 2);

		simpleServiceBuilder.setServiceClass(Abagtha.class);
		ServiceInfo si = simpleServiceBuilder.createService();
		rsfb.validateServiceModel();

		azzert(simpleServiceBuilder.getAddress() == null);
		azzert(simpleServiceBuilder.getOutputFile() == null);
		azzert(simpleServiceBuilder.getBindingId() == null);
		azzert(simpleServiceBuilder.getConduitSelector() == null);
		azzert(simpleServiceBuilder.getDataBinding() == null);
		azzert(simpleServiceBuilder.getFeatures().size() == 0);
		azzert(simpleServiceBuilder.getProperties(false) == null);

		azzert(simpleServiceBuilder.getBindingConfig() instanceof SoapBindingConfiguration);
		azzert(simpleServiceBuilder.getBindingFactory() instanceof SoapBindingFactory);
		azzert(simpleServiceBuilder.getBus(false) instanceof ExtensionManagerBus);
		azzert(simpleServiceBuilder.getDestinationFactory() instanceof SoapTransportFactory);

		azzert(rsfb.getConfigurations().size() == 2);

		ExtensionManagerBus bus = (ExtensionManagerBus) simpleServiceBuilder.getBus();

		SoapBindingConfiguration soapBindingConfiguration = (SoapBindingConfiguration) simpleServiceBuilder
				.getBindingConfig();

		SoapVersion version = soapBindingConfiguration.getVersion();
		azzert(version != null);

		azzert(version.getBindingId().equals(soapBindingConfiguration.getBindingId()));

		azzert(soapBindingConfiguration.getBindingName() == null);
		azzert("SoapBinding".equals(soapBindingConfiguration.getBindingNamePostfix()));

		azzert("document".equals(soapBindingConfiguration.getStyle()));
		azzert(soapBindingConfiguration.getUse() == null);

		azzert(soapBindingConfiguration.isMtomEnabled() == false);

		SoapBindingFactory soapBindingFactory = (SoapBindingFactory) simpleServiceBuilder.getBindingFactory();
		azzert(soapBindingFactory.getActivationNamespaces() != null);
		azzert(soapBindingFactory.getActivationNamespaces().size() == SoapBindingFactory.DEFAULT_NAMESPACES.size());
		azzert(soapBindingFactory.getBus() == bus);

		SoapTransportFactory soapTransportFactory = (SoapTransportFactory) simpleServiceBuilder.getDestinationFactory();

		azzert(soapTransportFactory.getTransportIds().size() == SoapBindingFactory.DEFAULT_NAMESPACES.size() + 1);

		azzert(soapTransportFactory.getUriPrefixes().size() == 1);
		azzert("soap.udp".equals(soapTransportFactory.getUriPrefixes().iterator().next()));

		azzert(rsfb.getConfigurations().get(0) instanceof DefaultServiceConfiguration);
		azzert(rsfb.getConfigurations().get(1) instanceof AbstractServiceConfiguration);

		DefaultServiceConfiguration defaultServiceConfiguration = (DefaultServiceConfiguration) rsfb.getConfigurations()
				.get(0);
		AbstractServiceConfiguration soapBindingServiceConfiguration = rsfb.getConfigurations().get(1);

		azzert("http://cxf.xdptdr.github.com/".equals(defaultServiceConfiguration.getEndpointName().getNamespaceURI()));
		azzert("AbagthaPort".equals(defaultServiceConfiguration.getEndpointName().getLocalPart()));

		azzert("http://cxf.xdptdr.github.com/"
				.equals(defaultServiceConfiguration.getInterfaceName().getNamespaceURI()));
		azzert("AbagthaPortType".equals(defaultServiceConfiguration.getInterfaceName().getLocalPart()));

		azzert("Abagtha".equals(defaultServiceConfiguration.getServiceName()));
		azzert("http://cxf.xdptdr.github.com/".equals(defaultServiceConfiguration.getServiceNamespace()));
		azzert(defaultServiceConfiguration.getServiceFactory() == rsfb);
		azzert(defaultServiceConfiguration.getStyle() == null);
		azzert(defaultServiceConfiguration.getWsdlURL() == null);
		azzert(defaultServiceConfiguration.isWrapped() == null);

		azzert(soapBindingServiceConfiguration.getEndpointName() == null);
		azzert(soapBindingServiceConfiguration.getInterfaceName() == null);
		azzert(soapBindingServiceConfiguration.getServiceName() == null);
		azzert(soapBindingServiceConfiguration.getServiceNamespace() == null);
		azzert(soapBindingServiceConfiguration.getServiceFactory() == rsfb);
		azzert("document".equals(soapBindingServiceConfiguration.getStyle()));
		azzert(soapBindingServiceConfiguration.getWsdlURL() == null);
		azzert(soapBindingServiceConfiguration.isWrapped() == null);

		azzert(rsfb.getEndpointInfo() != null);
		EndpointInfo endpointInfo = rsfb.getEndpointInfo();

		azzert(endpointInfo.getAddress() == null);
		azzert(endpointInfo.getBinding() != null);
		azzert(endpointInfo.getDescription() == null);
		azzert(endpointInfo.getInterface() != null);
		azzert("http://cxf.xdptdr.github.com/".equals(endpointInfo.getName().getNamespaceURI()));
		azzert("AbagthaPort".equals(endpointInfo.getName().getLocalPart()));
		azzert(endpointInfo.getService() == si);
		azzert(endpointInfo.getTarget() != null);
		azzert("http://schemas.xmlsoap.org/soap/http".equals(endpointInfo.getTransportId()));

		BindingInfo bindingInfo = endpointInfo.getBinding();
		azzert("http://schemas.xmlsoap.org/soap/".equals(bindingInfo.getBindingId()));
		azzert(bindingInfo.getDescription() == null);
		azzert(bindingInfo.getInterface() == endpointInfo.getInterface());
		azzert("http://cxf.xdptdr.github.com/".equals(bindingInfo.getName().getNamespaceURI()));
		azzert("AbagthaSoapBinding".equals(bindingInfo.getName().getLocalPart()));
		azzert(bindingInfo.getOperations().size() == 0);
		azzert(bindingInfo.getService() == si);

		InterfaceInfo interfaceInfo = endpointInfo.getInterface();
		azzert(interfaceInfo.getDescription() == null);
		azzert("http://cxf.xdptdr.github.com/".equals(interfaceInfo.getName().getNamespaceURI()));
		azzert("AbagthaPortType".equals(interfaceInfo.getName().getLocalPart()));
		azzert(interfaceInfo.getOperations().size() == 0);
		azzert(interfaceInfo.getService() == si);

		EndpointReferenceType endpointReferenceType = endpointInfo.getTarget();
		azzert(endpointReferenceType.getAddress() != null);
		azzert(endpointReferenceType.getAny().size() == 0);
		azzert(endpointReferenceType.getMetadata() == null);
		azzert(endpointReferenceType.getOtherAttributes().size() == 0);
		azzert(endpointReferenceType.getReferenceParameters() == null);

		AttributedURIType attributedURIType = endpointReferenceType.getAddress();
		azzert(attributedURIType.getOtherAttributes().size() == 0);
		azzert(attributedURIType.getValue() == null);

		Endpoint endpoint = rsfb.createEndpoint(endpointInfo);
		azzert(endpoint instanceof EndpointImpl);

		azzert(endpoint.getActiveFeatures() == null);
		azzert(endpoint.getBinding() != null);
		azzert(endpoint.getCleanupHooks().size() == 0);
		azzert(endpoint.getEndpointInfo() == endpointInfo);
		azzert(endpoint.getExecutor() != null);
		azzert(endpoint.getInFaultObserver() != null);
		azzert(endpoint.getOutFaultObserver() != null);
		azzert(endpoint.getService() != null);

		EndpointImpl endpointImpl = (EndpointImpl) endpoint;
		azzert("{http://cxf.xdptdr.github.com/}AbagthaPort.endpoint".equals(endpointImpl.getBeanName()));
		azzert(endpointImpl.getBus() == bus);

		Binding binding = endpoint.getBinding();
		azzert(binding instanceof SoapBinding);
		azzert(binding.getBindingInfo() == bindingInfo);
		azzert(((SoapBinding) binding).getSoapVersion() == version);

		Message message = binding.createMessage();
		azzert(message instanceof SoapMessage);

		azzert(message.getAttachments() == null);
		azzert(message.getContentFormats().size() == 0);
		azzert(message.getContextualProperty("") == null);
		azzert(message.getContextualPropertyKeys().size() > 0);
		azzert(message.getDestination() == null);
		azzert(message.getExchange() == null);
		azzert(message.getId() == null);
		azzert(message.getInterceptorChain() == null);

		SoapMessage soapMessage = (SoapMessage) message;
		azzert(soapMessage.getEnvelopeNs() == null);
		azzert(soapMessage.getHeaders().size() == 0);
		azzert(soapMessage.getVersion() == version);
		azzert(!soapMessage.hasAdditionalEnvNs());

		Executor executor = endpoint.getExecutor();
		azzert(executor instanceof SynchronousExecutor);

		MessageObserver inFaultObserver = endpoint.getInFaultObserver();
		azzert(inFaultObserver instanceof InFaultChainInitiatorObserver);

		MessageObserver outFaultObserver = endpoint.getOutFaultObserver();
		azzert(outFaultObserver instanceof OutFaultChainInitiatorObserver);

		Service service = endpoint.getService();
		azzert(service instanceof ServiceImpl);

		azzert(service.getDataBinding() != null);
		azzert(service.getEndpoints().size() == 1);
		azzert(service.getEndpoints().entrySet().iterator().next().getValue() != endpoint);
		// guess : endpoint was cloned
		azzert(service.getExecutor() == executor);
		azzert(service.getInvoker() != null);
		azzert(service.getName() != null);
		azzert(service.getServiceInfos().size() > 0);

		DataBinding dataBinding = service.getDataBinding();
		assert (dataBinding instanceof JAXBDataBinding);

		azzert(dataBinding.getDeclaredNamespaceMappings() == null);
		azzert(dataBinding.getMtomThreshold() == 0);
		azzert(!dataBinding.isMtomEnabled());

		azzert(dataBinding.getSupportedReaderFormats().length == 3);
		azzertContains(dataBinding.getSupportedReaderFormats(), Node.class);
		azzertContains(dataBinding.getSupportedReaderFormats(), XMLEventReader.class);
		azzertContains(dataBinding.getSupportedReaderFormats(), XMLStreamReader.class);

		azzert(dataBinding.getSupportedWriterFormats().length == 4);
		azzertContains(dataBinding.getSupportedWriterFormats(), OutputStream.class);
		azzertContains(dataBinding.getSupportedWriterFormats(), Node.class);
		azzertContains(dataBinding.getSupportedWriterFormats(), XMLEventWriter.class);
		azzertContains(dataBinding.getSupportedWriterFormats(), XMLStreamWriter.class);

		JAXBDataBinding jaxbDataBinding = (JAXBDataBinding) dataBinding;
		azzert(jaxbDataBinding.getConfiguredXmlAdapters().size() == 0);
		azzert(jaxbDataBinding.getContext() instanceof JAXBContextImpl);
		azzert(jaxbDataBinding.getContextClasses().size() == 0);
		azzert(jaxbDataBinding.getContextProperties().size() == 0);
		azzert(jaxbDataBinding.getExtraClass() == null);
		azzert(jaxbDataBinding.getMarshallerListener() == null);
		azzert(jaxbDataBinding.getUnmarshallerListener() == null);
		azzert(jaxbDataBinding.getValidationEventHandler() == null);
		azzert(jaxbDataBinding.isUnwrapJAXBElement());

		Invoker invoker = service.getInvoker();
		azzert(invoker instanceof FactoryInvoker);

		FactoryInvoker factoryInvoker = (FactoryInvoker) invoker;
		azzert(factoryInvoker.isSingletonFactory());

		List<ServiceInfo> serviceInfos = service.getServiceInfos();
		azzert(serviceInfos.size() == 1);
		azzert(serviceInfos.get(0) == si);

		azzert(!rsfb.getAnonymousWrapperTypes());

		azzert(rsfb.getExecutor() == null);

		azzert(rsfb.getFeatures().size() == 0);

		azzert(rsfb.getIgnoredClasses().size() == 6);
		azzertContains(rsfb.getIgnoredClasses(), "java.lang.Object");
		azzertContains(rsfb.getIgnoredClasses(), "java.lang.Throwable");
		azzertContains(rsfb.getIgnoredClasses(), "org.omg.CORBA_2_3.portable.ObjectImpl");
		azzertContains(rsfb.getIgnoredClasses(), "org.omg.CORBA.portable.ObjectImpl");
		azzertContains(rsfb.getIgnoredClasses(), "javax.ejb.EJBObject");
		azzertContains(rsfb.getIgnoredClasses(), "javax.rmi.CORBA.Stub");

		azzert(rsfb.getIgnoredMethods().size() == 0);

		azzert(rsfb.getInvoker() == null);

		azzert(rsfb.getMethodDispatcher() instanceof SimpleMethodDispatcher);

		MethodDispatcher methodDispatcher = rsfb.getMethodDispatcher();
		SimpleMethodDispatcher simpleMethodDispatcher = (SimpleMethodDispatcher) methodDispatcher;

		azzert(rsfb.getProperties() == null);

		azzert(rsfb.getQualifyWrapperSchema());

		azzert("document".equals(rsfb.getStyle()));
		azzert(rsfb.getWrapped() == null);
		azzert(!rsfb.isAnonymousWrapperTypes());
		azzert(rsfb.isPopulateFromClass());
		azzert(rsfb.isQualifyWrapperSchema());
		azzert(rsfb.isWrapped());

		azzert(rsfb.getWsdlURL() == null);

		azzert(rsfb.getBus() == bus);
		azzert(rsfb.getDataBinding() == dataBinding);
		azzert(rsfb.getService() == service);
		azzert(rsfb.getSessionState().size() == 0);

	}

	private static <T> void azzertContains(List<T> list, T element) {
		azzert(list != null);
		for (T e : list) {
			if (e == element) {
				return;
			}
		}
		throw new RuntimeException("Assertion error");
	}

	private static <T> void azzertContains(T[] array, T element) {
		azzert(array != null);
		for (T e : array) {
			if (e == element) {
				return;
			}
		}
		throw new RuntimeException("Assertion error");
	}

	@SuppressWarnings("unused")
	private static void dumpRSFBConstants() {
		System.out.println("ReflectionServiceFactoryBean.ELEMENT_NAME : " + ReflectionServiceFactoryBean.ELEMENT_NAME);
		System.out.println(
				"ReflectionServiceFactoryBean.ENDPOINT_CLASS : " + ReflectionServiceFactoryBean.ENDPOINT_CLASS);
		System.out.println("ReflectionServiceFactoryBean.EXTRA_CLASS : " + ReflectionServiceFactoryBean.EXTRA_CLASS);
		System.out.println("ReflectionServiceFactoryBean.FORCE_TYPES : " + ReflectionServiceFactoryBean.FORCE_TYPES);
		System.out.println("ReflectionServiceFactoryBean.GENERIC_TYPE : " + ReflectionServiceFactoryBean.GENERIC_TYPE);
		System.out.println("ReflectionServiceFactoryBean.HEADER : " + ReflectionServiceFactoryBean.HEADER);
		System.out.println("ReflectionServiceFactoryBean.HOLDER : " + ReflectionServiceFactoryBean.HOLDER);
		System.out.println("ReflectionServiceFactoryBean.METHOD : " + ReflectionServiceFactoryBean.METHOD);
		System.out.println(
				"ReflectionServiceFactoryBean.METHOD_ANNOTATIONS : " + ReflectionServiceFactoryBean.METHOD_ANNOTATIONS);
		System.out.println("ReflectionServiceFactoryBean.METHOD_PARAM_ANNOTATIONS : "
				+ ReflectionServiceFactoryBean.METHOD_PARAM_ANNOTATIONS);
		System.out.println("ReflectionServiceFactoryBean.MODE_INOUT : " + ReflectionServiceFactoryBean.MODE_INOUT);
		System.out.println("ReflectionServiceFactoryBean.MODE_OUT : " + ReflectionServiceFactoryBean.MODE_OUT);
		System.out.println(
				"ReflectionServiceFactoryBean.PARAM_ANNOTATION : " + ReflectionServiceFactoryBean.PARAM_ANNOTATION);
		System.out.println("ReflectionServiceFactoryBean.RAW_CLASS : " + ReflectionServiceFactoryBean.RAW_CLASS);
		System.out.println(
				"ReflectionServiceFactoryBean.WRAPPERGEN_NEEDED : " + ReflectionServiceFactoryBean.WRAPPERGEN_NEEDED);

	}

	@SuppressWarnings("unused")
	private static void rsfb(ReflectionServiceFactoryBean reflectionServiceFactoryBean) throws EndpointException {
		reflectionServiceFactoryBean.create();
		EndpointInfo endpointInfo = null;
		reflectionServiceFactoryBean.createEndpoint(endpointInfo);
		reflectionServiceFactoryBean.getEndpointInfo();
		reflectionServiceFactoryBean.getEndpointName();
		boolean lookup = false;
		reflectionServiceFactoryBean.getEndpointName(lookup);
		reflectionServiceFactoryBean.getFeatures();
		Type type = null;
		reflectionServiceFactoryBean.getHolderType(Object.class, type);
		reflectionServiceFactoryBean.getIgnoredClasses();
		reflectionServiceFactoryBean.getIgnoredMethods();
		reflectionServiceFactoryBean.getInterfaceName();
		reflectionServiceFactoryBean.getInvoker();
		reflectionServiceFactoryBean.getMethodDispatcher();
		reflectionServiceFactoryBean.getProperties();
		reflectionServiceFactoryBean.getQualifyWrapperSchema();
		reflectionServiceFactoryBean.getServiceClass();
		reflectionServiceFactoryBean.getServiceConfigurations();
		reflectionServiceFactoryBean.getServiceQName();
		reflectionServiceFactoryBean.getServiceQName(lookup);
		reflectionServiceFactoryBean.getStyle();
		reflectionServiceFactoryBean.getWrapped();
		MessagePartInfo mpi = null;
		reflectionServiceFactoryBean.getWrapperPartMaxOccurs(mpi);
		reflectionServiceFactoryBean.getWrapperPartMinOccurs(mpi);
		reflectionServiceFactoryBean.getWsdlURL();
		InterfaceInfo interfaceInfo = null;
		reflectionServiceFactoryBean.hasWrappedMethods(interfaceInfo);
		reflectionServiceFactoryBean.isAnonymousWrapperTypes();
		Method method = null;
		int j = 0;
		reflectionServiceFactoryBean.isHeader(method, j);
		reflectionServiceFactoryBean.isHolder(Object.class, type);
		reflectionServiceFactoryBean.isPopulateFromClass();
		reflectionServiceFactoryBean.isQualifyWrapperSchema();
		reflectionServiceFactoryBean.isRPC(method);
		reflectionServiceFactoryBean.isWrapped();
		reflectionServiceFactoryBean.isWrapperPartNillable(mpi);
		reflectionServiceFactoryBean.isWrapperPartQualified(mpi);
		reflectionServiceFactoryBean.reset();
		boolean b = false;
		reflectionServiceFactoryBean.setAnonymousWrapperTypes(b);
		List<AbstractServiceConfiguration> configurations = null;
		reflectionServiceFactoryBean.setConfigurations(configurations);
		QName qn = null;
		reflectionServiceFactoryBean.setEndpointName(qn);
		Executor executor = null;
		reflectionServiceFactoryBean.setExecutor(executor);
		List<? extends Feature> features = null;
		reflectionServiceFactoryBean.setFeatures(features);
		List<String> ignoredClasses = null;
		reflectionServiceFactoryBean.setIgnoredClasses(ignoredClasses);
		List<Method> ignoredMethods = null;
		reflectionServiceFactoryBean.setIgnoredMethods(ignoredMethods);
		Invoker invoker = null;
		reflectionServiceFactoryBean.setInvoker(invoker);
		boolean fomClass = false;
		reflectionServiceFactoryBean.setPopulateFromClass(fomClass);
		Map<String, Object> properties = null;
		reflectionServiceFactoryBean.setProperties(properties);
		reflectionServiceFactoryBean.setQualifyWrapperSchema(b);
		List<String> schemaLocations = null;
		reflectionServiceFactoryBean.setSchemaLocations(schemaLocations);
		Class<?> serviceClass = null;
		reflectionServiceFactoryBean.setServiceClass(serviceClass);
		List<AbstractServiceConfiguration> serviceConfigurations = null;
		reflectionServiceFactoryBean.setServiceConfigurations(serviceConfigurations);
		QName serviceName = null;
		reflectionServiceFactoryBean.setServiceName(serviceName);
		ParameterizedType servicetype = null;
		reflectionServiceFactoryBean.setServiceType(servicetype);
		boolean validate = false;
		reflectionServiceFactoryBean.setValidate(validate);
		boolean style = false;
		reflectionServiceFactoryBean.setWrapped(style);
		String wsdlURL = null;
		reflectionServiceFactoryBean.setWsdlURL(wsdlURL);
		URL url = null;
		reflectionServiceFactoryBean.setWsdlURL(url);
		BindingOperationInfo boi = null;
		reflectionServiceFactoryBean.updateBindingOperation(boi);

	}

	@SuppressWarnings("unused")
	private static void si(ServiceInfo serviceInfo) {
		BindingInfo bindingInfo = null;
		serviceInfo.addBinding(bindingInfo);
		EndpointInfo endpointInfo = null;
		serviceInfo.addEndpoint(endpointInfo);
		String schemaNamespaceURI = null;
		serviceInfo.addNewSchema(schemaNamespaceURI);
		SchemaInfo schemaInfo = null;
		serviceInfo.addSchema(schemaInfo);
		QName qn = null;
		serviceInfo.createInterface(qn);
		serviceInfo.getBinding(qn);
		serviceInfo.getBindings();
		serviceInfo.getDescription();
		serviceInfo.getEndpoint(qn);
		serviceInfo.getEndpoints();
		serviceInfo.getInterface();
		serviceInfo.getMessage(qn);
		serviceInfo.getMessages();
		serviceInfo.getName();
		serviceInfo.getSchema(schemaNamespaceURI);
		serviceInfo.getSchemas();
		serviceInfo.getTargetNamespace();
		serviceInfo.getTopLevelDoc();
		serviceInfo.getXmlSchemaCollection();
		serviceInfo.refresh();
		DescriptionInfo descriptionInfo = null;
		serviceInfo.setDescription(descriptionInfo);
		InterfaceInfo interfaceInfo = null;
		serviceInfo.setInterface(interfaceInfo);
		Map<QName, MessageInfo> messageInfos = null;
		serviceInfo.setMessages(messageInfos);
		serviceInfo.setName(qn);
		SchemaCollection cachedXmlSchemaCollection = null;
		List<SchemaInfo> cachedSchemas = null;
		serviceInfo.setSchemas(cachedXmlSchemaCollection, cachedSchemas);
		ServiceSchemaInfo serviceSchemaInfo = null;
		serviceInfo.setServiceSchemaInfo(serviceSchemaInfo);
		String targetNamespace = null;
		serviceInfo.setTargetNamespace(targetNamespace);
		String topLevelDoc = null;
		serviceInfo.setTopLevelDoc(topLevelDoc);

		Object o = null;
		serviceInfo.addExtensionAttribute(qn, o);
		serviceInfo.addExtensor(o);
		serviceInfo.containsExtensor(o);
		serviceInfo.getDocumentation();
		serviceInfo.getExtensionAttribute(qn);
		serviceInfo.getExtensionAttributes();
		serviceInfo.getExtensor(Object.class);
		serviceInfo.getExtensors();
		serviceInfo.getProperties();
		String name = null;
		serviceInfo.getProperty(name);
		Class<?> clazz = null;
		serviceInfo.getProperty(name, clazz);
		serviceInfo.getTraversedExtensor(o, Object.class);
		serviceInfo.hasProperty(name);
		serviceInfo.removeProperty(name);
		AbstractPropertiesHolder p = null;
		boolean props = false;
		serviceInfo.setDelegate(p, props);
		String documentation = null;
		serviceInfo.setDocumentation(documentation);
		Map<QName, Object> qnmap = null;
		serviceInfo.setExtensionAttributes(qnmap);
		serviceInfo.setProperty(name, o);

	}

	@SuppressWarnings("unused")
	private static void ssb(SimpleServiceBuilder ssb) {

		ssb.getWsdlURL();

		boolean createIfNeeded = false;
		QName endpointName = ssb.getEndpointName();
		boolean create = false;
		ssb.getProperties(create);
		String publishedEndpointUrl = ssb.getPublishedEndpointUrl();
		QName serviceName = ssb.getServiceName();
		String transportId = ssb.getTransportId();
		ssb.setEndpointName(endpointName);
		EndpointReferenceType enpointReferenceType = null;
		ssb.setEndpointReference(enpointReferenceType);
		ssb.setPublishedEndpointUrl(publishedEndpointUrl);
		ssb.setServiceName(serviceName);
		ssb.setTransportId(transportId);

		ssb.getInFaultInterceptors();
		ssb.getInInterceptors();
		ssb.getOutFaultInterceptors();
		ssb.getOutInterceptors();
		List<Interceptor<? extends Message>> interceptors = null;
		ssb.setInFaultInterceptors(interceptors);
		ssb.setInInterceptors(interceptors);
		ssb.setOutFaultInterceptors(interceptors);
		ssb.setOutInterceptors(interceptors);

	}

	private static void azzert(boolean b) {
		if (!b) {
			throw new RuntimeException("Assertion Error");
		}

	}

	@SuppressWarnings("unused")
	private static boolean t() {
		return true;
	}

	@SuppressWarnings("unused")
	private static String qns(QName qn) {
		StringBuffer buf = new StringBuffer();
		if (qn != null) {
			buf.append(qn.getNamespaceURI());
			buf.append(" ");
			buf.append(qn.getPrefix());
			buf.append(" ");
			buf.append(qn.getLocalPart());
		}
		return buf.toString();
	}

}
