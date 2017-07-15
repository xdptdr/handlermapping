package com.github.xdptdr.cxf;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapBindingConfiguration;
import org.apache.cxf.binding.soap.SoapBindingFactory;
import org.apache.cxf.binding.soap.SoapTransportFactory;
import org.apache.cxf.binding.soap.SoapVersion;
import org.apache.cxf.bus.extension.ExtensionManagerBus;
import org.apache.cxf.common.xmlschema.SchemaCollection;
import org.apache.cxf.endpoint.EndpointException;
import org.apache.cxf.feature.Feature;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.service.invoker.Invoker;
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
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.apache.cxf.wsdl.service.factory.AbstractServiceConfiguration;
import org.apache.cxf.wsdl.service.factory.ReflectionServiceFactoryBean;

public class Abagtha {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException, EndpointException {

		SimpleServiceBuilder ssb = new SimpleServiceBuilder();

		azzert(ssb.getBindingConfig() == null);
		azzert(ssb.getBindingFactory() == null);
		azzert(ssb.getBus(false) == null);
		azzert(ssb.getDestinationFactory() == null);
		azzert(ssb.getFeatures().size() == 0);
		azzert(ssb.getProperties(false) == null);

		ReflectionServiceFactoryBean rsfb = ssb.getServiceFactory();
		azzert(rsfb.getClass() == ReflectionServiceFactoryBean.class);

		ssb.setServiceClass(Abagtha.class);

		ServiceInfo si = ssb.createService();

		rsfb.validateServiceModel();

		azzert(ssb.getAddress() == null);
		azzert(ssb.getOutputFile() == null);
		azzert(ssb.getBindingId() == null);
		azzert(ssb.getConduitSelector() == null);
		azzert(ssb.getDataBinding() == null);
		azzert(ssb.getFeatures().size() == 0);
		azzert(ssb.getProperties(false) == null);

		azzert(ssb.getBindingConfig() instanceof SoapBindingConfiguration);
		azzert(ssb.getBindingFactory() instanceof SoapBindingFactory);
		azzert(ssb.getBus(false) instanceof ExtensionManagerBus);
		azzert(ssb.getDestinationFactory() instanceof SoapTransportFactory);

		ExtensionManagerBus bus = (ExtensionManagerBus) ssb.getBus();

		SoapBindingConfiguration soapBindingConfiguration = (SoapBindingConfiguration) ssb.getBindingConfig();

		SoapVersion version = soapBindingConfiguration.getVersion();
		azzert(version != null);

		azzert(version.getBindingId().equals(soapBindingConfiguration.getBindingId()));

		azzert(soapBindingConfiguration.getBindingName() == null);
		azzert("SoapBinding".equals(soapBindingConfiguration.getBindingNamePostfix()));

		azzert("document".equals(soapBindingConfiguration.getStyle()));
		azzert(soapBindingConfiguration.getUse() == null);

		azzert(soapBindingConfiguration.isMtomEnabled() == false);

		SoapBindingFactory soapBindingFactory = (SoapBindingFactory) ssb.getBindingFactory();
		azzert(soapBindingFactory.getActivationNamespaces() != null);
		azzert(soapBindingFactory.getActivationNamespaces().size() == SoapBindingFactory.DEFAULT_NAMESPACES.size());
		azzert(soapBindingFactory.getBus() == bus);

		SoapTransportFactory soapTransportFactory = (SoapTransportFactory) ssb.getDestinationFactory();

		azzert(soapTransportFactory.getTransportIds().size() == SoapBindingFactory.DEFAULT_NAMESPACES.size() + 1);

		azzert(soapTransportFactory.getUriPrefixes().size() == 1);
		azzert("soap.udp".equals(soapTransportFactory.getUriPrefixes().iterator().next()));

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
		reflectionServiceFactoryBean.getAnonymousWrapperTypes();
		reflectionServiceFactoryBean.getConfigurations();
		reflectionServiceFactoryBean.getEndpointInfo();
		reflectionServiceFactoryBean.getEndpointName();
		boolean lookup = false;
		reflectionServiceFactoryBean.getEndpointName(lookup);
		reflectionServiceFactoryBean.getExecutor();
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

}
