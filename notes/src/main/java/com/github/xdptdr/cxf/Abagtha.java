package com.github.xdptdr.cxf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Executor;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.apache.cxf.Bus;
import org.apache.cxf.binding.Binding;
import org.apache.cxf.binding.BindingConfiguration;
import org.apache.cxf.binding.BindingFactory;
import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.binding.soap.SoapBinding;
import org.apache.cxf.binding.soap.SoapBindingConfiguration;
import org.apache.cxf.binding.soap.SoapBindingFactory;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.SoapTransportFactory;
import org.apache.cxf.binding.soap.SoapVersion;
import org.apache.cxf.binding.xml.wsdl11.XMLWSDLExtensionLoader;
import org.apache.cxf.bus.extension.ExtensionManager;
import org.apache.cxf.bus.extension.ExtensionManagerBus;
import org.apache.cxf.buslifecycle.BusLifeCycleManager;
import org.apache.cxf.configuration.ConfiguredBeanLocator;
import org.apache.cxf.configuration.Configurer;
import org.apache.cxf.databinding.DataBinding;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.endpoint.EndpointException;
import org.apache.cxf.endpoint.EndpointImpl;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.endpoint.ServerImpl;
import org.apache.cxf.endpoint.ServerRegistry;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.interceptor.InFaultChainInitiatorObserver;
import org.apache.cxf.interceptor.OutFaultChainInitiatorObserver;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.jaxws.context.WebServiceContextResourceResolver;
import org.apache.cxf.management.InstrumentationManager;
import org.apache.cxf.message.Message;
import org.apache.cxf.policy.PolicyDataEngine;
import org.apache.cxf.resource.ClassLoaderResolver;
import org.apache.cxf.resource.ClasspathResolver;
import org.apache.cxf.resource.ObjectTypeResolver;
import org.apache.cxf.resource.PropertiesResolver;
import org.apache.cxf.resource.ResourceManager;
import org.apache.cxf.resource.SinglePropertyResolver;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.factory.FactoryBeanListenerManager;
import org.apache.cxf.service.factory.SimpleMethodDispatcher;
import org.apache.cxf.service.invoker.FactoryInvoker;
import org.apache.cxf.service.invoker.Invoker;
import org.apache.cxf.service.invoker.MethodDispatcher;
import org.apache.cxf.service.model.AbstractMessageContainer;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.BindingMessageInfo;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.MessagePartInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.simple.SimpleServiceBuilder;
import org.apache.cxf.transport.ConduitInitiatorManager;
import org.apache.cxf.transport.DestinationFactory;
import org.apache.cxf.transport.DestinationFactoryManager;
import org.apache.cxf.transport.MessageObserver;
import org.apache.cxf.transport.http.HTTPConduitFactory;
import org.apache.cxf.transport.http.HTTPWSDLExtensionLoader;
import org.apache.cxf.transport.jms.wsdl11.JMSWSDLExtensionLoader;
import org.apache.cxf.workqueue.SynchronousExecutor;
import org.apache.cxf.ws.addressing.AttributedURIType;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.apache.cxf.ws.addressing.impl.AddressingWSDLExtensionLoader;
import org.apache.cxf.ws.policy.PolicyAnnotationListener;
import org.apache.cxf.ws.policy.PolicyEngine;
import org.apache.cxf.wsdl.WSDLManager;
import org.apache.cxf.wsdl.service.factory.AbstractServiceConfiguration;
import org.apache.cxf.wsdl.service.factory.DefaultServiceConfiguration;
import org.apache.cxf.wsdl.service.factory.ReflectionServiceFactoryBean;
import org.apache.ws.commons.schema.XmlSchemaAnnotated;
import org.jboss.wsf.stack.cxf.client.injection.JBossWSResourceInjectionResolver;
import org.w3c.dom.Node;

public class Abagtha {

	private static AbstractMessageContainer abstractMessageContainer_Input;
	private static AbstractMessageContainer abstractMessageContainerOutput;
	private static AbstractServiceConfiguration abstractServiceConfiguration1;
	private static AbstractServiceConfiguration abstractServiceConfiguration2;
	private static AttributedURIType attributedURIType;
	private static Binding binding;
	private static BindingConfiguration bindingConfig;
	private static BindingFactory bindingFactory;
	private static BindingInfo bindingInfo;
	private static BindingMessageInfo bindingMessageInfoInput;
	private static BindingMessageInfo bindingMessageInfoOutput;
	private static BindingOperationInfo bindingOperationInfo;
	private static BindingOperationInfo bindingOperationInfoUnwrapped;
	private static BindingOperationInfo bindingOperationInfoWrapped;
	private static Bus bus;
	private static DataBinding dataBinding;
	private static DefaultServiceConfiguration defaultServiceConfiguration;
	private static DestinationFactory destinationFactory;
	private static Endpoint endpoint;
	private static EndpointImpl endpointImpl;
	private static EndpointInfo endpointInfo;
	private static EndpointReferenceType endpointReferenceType;
	private static Executor executor;
	private static ExtensionManagerBus extensionManagerBus;
	private static FactoryInvoker factoryInvoker;
	private static InFaultChainInitiatorObserver inFaultChainInitiatorObserver;
	private static InterfaceInfo interfaceInfo;
	private static Invoker invoker;
	private static JAXBDataBinding jaxbDataBinding;
	private static Message message;
	private static MessageInfo messageInfoInput;
	private static MessageInfo messageInfoOutput;
	private static MessageObserver messageObserver_In;
	private static MessageObserver messageObserver_Out;
	private static MessagePartInfo messagePartInfoInput;
	private static MessagePartInfo messagePartInfoOutput;
	private static MethodDispatcher methodDispatcher;
	private static OperationInfo operationInfo;
	private static OutFaultChainInitiatorObserver outFaultChainInitiatorObserver;
	private static ReflectionServiceFactoryBean reflectionServiceFactoryBean;
	private static Service service;
	private static ServiceInfo serviceInfo;
	private static SimpleMethodDispatcher simpleMethodDispatcher;
	private static SimpleServiceBuilder simpleServiceBuilder;
	private static SoapBinding soapBinding;
	private static SoapBindingConfiguration soapBindingConfiguration;
	private static SoapBindingFactory soapBindingFactory;
	private static AbstractServiceConfiguration soapBindingServiceConfiguration;
	private static SoapMessage soapMessage;
	private static SoapTransportFactory soapTransportFactory;
	private static SynchronousExecutor synchronousExecutor;
	private static SoapVersion version;
	private static XmlSchemaAnnotated xmlSchemaAnnotatedInput;
	private static XmlSchemaAnnotated xmlSchemaAnnotatedOutput;
	private static Server server;
	private static ServerFactoryBean serverFactoryBean;
	private static ServerImpl serverImpl;

	private static void azzert(boolean b) {
		if (!b) {
			throw new RuntimeException("Assertion Error");
		}

	}

	private static void azzertAbstractMessageContainer_Input() {
		azzert(abstractMessageContainer_Input.getMessageDocumentation() == null);
		azzert(abstractMessageContainer_Input.getMessagePartsNumber() == 1);
		azzertQN(abstractMessageContainer_Input.getName(), "http://cxf.xdptdr.github.com/", "foo");

		azzert(abstractMessageContainer_Input.getOutOfBandParts().size() == 0);
		azzert(abstractMessageContainer_Input.getMessageParts().size() == 1);
		azzert(abstractMessageContainer_Input.getMessageParts().get(0) == messagePartInfoInput);

	}

	private static void azzertAbstractMessageContainer_Output() {
		azzert(abstractMessageContainerOutput.getMessageDocumentation() == null);
		azzert(abstractMessageContainerOutput.getMessagePartsNumber() == 1);
		azzertQN(abstractMessageContainerOutput.getName(), "http://cxf.xdptdr.github.com/", "fooResponse");
		azzert(abstractMessageContainerOutput.getOutOfBandParts().size() == 0);
		azzert(abstractMessageContainerOutput.getMessageParts().size() == 1);
		azzert(abstractMessageContainerOutput.getMessageParts().get(0) == messagePartInfoOutput);

	}

	private static void azzertAttributedURIType() {
		azzert(attributedURIType.getOtherAttributes().size() == 0);
		azzert(attributedURIType.getValue() == null);
	}

	private static void azzertBinding() {
		azzert(binding.getBindingInfo() == bindingInfo);
		azzert(soapBinding.getSoapVersion() == version);
	}

	private static void azzertBindingInfo() {

		azzert("http://schemas.xmlsoap.org/soap/".equals(bindingInfo.getBindingId()));

		azzert(bindingInfo.getDescription() == null);
		azzert(bindingInfo.getInterface() == interfaceInfo);

		azzertQN(bindingInfo.getName(), "http://cxf.xdptdr.github.com/", "AbagthaSoapBinding");

		azzert(bindingInfo.getService() == serviceInfo);

		azzert(bindingInfo.getOperations().size() == 1);
		bindingOperationInfo = bindingInfo.getOperations().iterator().next();

	}

	private static void azzertBindingMessageInfo_Input() {
		azzert(bindingMessageInfoInput.getBindingOperation() == bindingOperationInfo);
		messageInfoInput = bindingMessageInfoInput.getMessageInfo();
		azzert(messageInfoInput != null);
		azzert(bindingMessageInfoInput.getMessageParts().size() == 1);

		messagePartInfoInput = bindingMessageInfoInput.getMessageParts().get(0);
		azzert(messagePartInfoInput != null);

	}

	private static void azzertBindingMessageInfo_Output() {
		azzert(bindingMessageInfoOutput.getBindingOperation() == bindingOperationInfo);

		messageInfoOutput = bindingMessageInfoOutput.getMessageInfo();
		azzert(messageInfoOutput != null);

		azzert(bindingMessageInfoOutput.getMessageParts().size() == 1);
		messagePartInfoOutput = bindingMessageInfoOutput.getMessageParts().get(0);

	}

	private static void azzertBindingOperationInfo() {

		azzertQN(bindingOperationInfo.getName(), "http://cxf.xdptdr.github.com/", "foo");
		azzert(bindingOperationInfo.getBinding() == bindingInfo);
		azzert(bindingOperationInfo.getFaults().size() == 0);
		azzert(!bindingOperationInfo.isUnwrapped());
		azzert(bindingOperationInfo.isUnwrappedCapable());

		bindingMessageInfoInput = bindingOperationInfo.getInput();
		azzert(bindingMessageInfoInput != null);

		bindingMessageInfoOutput = bindingOperationInfo.getOutput();
		azzert(bindingMessageInfoOutput != null);

		operationInfo = bindingOperationInfo.getOperationInfo();
		azzert(operationInfo != null);

		bindingOperationInfoUnwrapped = bindingOperationInfo.getUnwrappedOperation();
		azzert(bindingOperationInfoUnwrapped != null);
		azzert(bindingOperationInfoUnwrapped != bindingOperationInfo);

		bindingOperationInfoWrapped = bindingOperationInfo.getWrappedOperation();
		azzert(bindingOperationInfoWrapped == bindingOperationInfoUnwrapped);

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

	private static void azzertContainsT(List<?> list, Class<?> clazz) {
		azzert(list != null);
		for (Object e : list) {
			if (e != null && e.getClass() == clazz) {
				return;
			}
		}
		throw new RuntimeException("Assertion error");
	}

	private static void azzertDataBinding() {
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

		azzert(jaxbDataBinding.getConfiguredXmlAdapters().size() == 0);
//		azzert(jaxbDataBinding.getContext() instanceof JAXBContextImpl);
		azzert(jaxbDataBinding.getContextClasses().size() == 0);
		azzert(jaxbDataBinding.getContextProperties().size() == 0);
		azzert(jaxbDataBinding.getExtraClass() == null);
		azzert(jaxbDataBinding.getMarshallerListener() == null);
		azzert(jaxbDataBinding.getUnmarshallerListener() == null);
		azzert(jaxbDataBinding.getValidationEventHandler() == null);
		azzert(jaxbDataBinding.isUnwrapJAXBElement());
	}

	private static void azzertDefaultServiceConfiguration() {

		azzertQN(defaultServiceConfiguration.getEndpointName(), "http://cxf.xdptdr.github.com/", "AbagthaPort");
		azzertQN(defaultServiceConfiguration.getInterfaceName(), "http://cxf.xdptdr.github.com/", "AbagthaPortType");

		azzert(defaultServiceConfiguration.getServiceFactory() == reflectionServiceFactoryBean);
		azzert(defaultServiceConfiguration.getStyle() == null);
		azzert(defaultServiceConfiguration.getWsdlURL() == null);
		azzert(defaultServiceConfiguration.isWrapped() == null);

		azzert("http://cxf.xdptdr.github.com/".equals(defaultServiceConfiguration.getServiceNamespace()));
		azzert("Abagtha".equals(defaultServiceConfiguration.getServiceName()));

	}

	private static void azzertEndpoint() {

		azzert(endpoint.getActiveFeatures() == null);
		azzert(endpoint.getCleanupHooks().size() == 0);
		azzert(endpoint.getEndpointInfo() == endpointInfo);

		azzert(endpoint.getService() == service);

		executor = endpoint.getExecutor();
		azzert(executor instanceof SynchronousExecutor);
		synchronousExecutor = (SynchronousExecutor) executor;

		messageObserver_In = endpoint.getInFaultObserver();
		azzert(messageObserver_In instanceof InFaultChainInitiatorObserver);
		inFaultChainInitiatorObserver = (InFaultChainInitiatorObserver) messageObserver_In;

		messageObserver_Out = endpoint.getOutFaultObserver();
		azzert(messageObserver_Out instanceof OutFaultChainInitiatorObserver);
		outFaultChainInitiatorObserver = (OutFaultChainInitiatorObserver) messageObserver_Out;

		azzert("{http://cxf.xdptdr.github.com/}AbagthaPort.endpoint".equals(endpointImpl.getBeanName()));
		azzert(endpointImpl.getBus() == bus);
	}

	private static void azzertEndpointInfo() {
		azzert(endpointInfo.getAddress() == null);
		azzert(endpointInfo.getBinding() != null);
		azzert(endpointInfo.getDescription() == null);
		azzert(endpointInfo.getInterface() != null);

		azzertQN(endpointInfo.getName(), "http://cxf.xdptdr.github.com/", "AbagthaPort");
		azzert(endpointInfo.getService() == serviceInfo);
		azzert("http://schemas.xmlsoap.org/soap/http".equals(endpointInfo.getTransportId()));

		endpointReferenceType = endpointInfo.getTarget();
		azzert(endpointReferenceType != null);

		bindingInfo = endpointInfo.getBinding();
		azzert(bindingInfo != null);

		interfaceInfo = endpointInfo.getInterface();
		azzert(interfaceInfo != null);
	}

	private static void azzertEndpointReferenceType() {
		azzert(endpointReferenceType.getAny().size() == 0);
		azzert(endpointReferenceType.getMetadata() == null);
		azzert(endpointReferenceType.getOtherAttributes().size() == 0);
		azzert(endpointReferenceType.getReferenceParameters() == null);

		azzert(endpointReferenceType.getAddress() != null);
		attributedURIType = endpointReferenceType.getAddress();
	}

	private static void azzertIinterfaceInfo() {
		azzert(interfaceInfo.getDescription() == null);
		azzertQN(interfaceInfo.getName(), "http://cxf.xdptdr.github.com/", "AbagthaPortType");
		azzert(interfaceInfo.getOperations().size() == 1); // TODO !
		azzert(interfaceInfo.getService() == serviceInfo);
		azzert(interfaceInfo == operationInfo.getInterface());
	}

	private static void azzertInvoker() {
		azzert(factoryInvoker.isSingletonFactory());
	}

	private static void azzertMessage() {
		azzert(message.getAttachments() == null);
		azzert(message.getContentFormats().size() == 0);
		azzert(message.getContextualProperty("") == null);
		azzert(message.getContextualPropertyKeys().size() > 0);
		azzert(message.getDestination() == null);
		azzert(message.getExchange() == null);
		azzert(message.getId() == null);
		azzert(message.getInterceptorChain() == null);

		azzert(soapMessage.getEnvelopeNs() == null);
		azzert(soapMessage.getHeaders().size() == 0);
		azzert(soapMessage.getVersion() == version);
		azzert(!soapMessage.hasAdditionalEnvNs());
	}

	private static void azzertMessageInfo_Input() {
		messageInfoInput = bindingMessageInfoInput.getMessageInfo();
		azzert(messageInfoInput.getType() == MessageInfo.Type.INPUT);
		azzert(messageInfoInput.getMessagePartsMap().size() == 1);

		Entry<QName, MessagePartInfo> messageInfoInputEntry = messageInfoInput.getMessagePartsMap().entrySet()
				.iterator().next();
		azzertQN(messageInfoInputEntry.getKey(), "http://cxf.xdptdr.github.com/", "parameters");
		azzert(messageInfoInputEntry.getValue() == messagePartInfoInput);

	}

	private static void azzertMessageInfo_Output() {
		azzert(messageInfoOutput.getType() == MessageInfo.Type.OUTPUT);
		azzert(messageInfoOutput.getMessagePartsMap().size() == 1);

		Entry<QName, MessagePartInfo> messageInfoOutputEntry = messageInfoOutput.getMessagePartsMap().entrySet()
				.iterator().next();
		azzertQN(messageInfoOutputEntry.getKey(), "http://cxf.xdptdr.github.com/", "parameters");

		azzert(messageInfoOutputEntry.getValue() == messagePartInfoOutput);

	}

	private static void azzertMessagePartInfo_Input() {

		azzertQN(messagePartInfoInput.getConcreteName(), "http://cxf.xdptdr.github.com/", "foo");
		azzertQN(messagePartInfoInput.getElementQName(), "http://cxf.xdptdr.github.com/", "foo");
		azzertQN(messagePartInfoInput.getName(), "http://cxf.xdptdr.github.com/", "parameters");
		azzertQN(messagePartInfoInput.getTypeQName(), "http://cxf.xdptdr.github.com/", "foo");
		azzert(messagePartInfoInput.getTypeClass() == null);
		azzert(messagePartInfoInput.isElement());

		abstractMessageContainer_Input = messagePartInfoInput.getMessageInfo();
		azzert(abstractMessageContainer_Input != null);

		xmlSchemaAnnotatedInput = messagePartInfoInput.getXmlSchema();
		azzert(xmlSchemaAnnotatedInput != null);

	}

	private static void azzertMessagePartInfo_Output() {

		azzertQN(messagePartInfoOutput.getConcreteName(), "http://cxf.xdptdr.github.com/", "fooResponse");
		azzertQN(messagePartInfoOutput.getElementQName(), "http://cxf.xdptdr.github.com/", "fooResponse");
		azzertQN(messagePartInfoOutput.getTypeQName(), "http://cxf.xdptdr.github.com/", "fooResponse");
		azzertQN(messagePartInfoOutput.getName(), "http://cxf.xdptdr.github.com/", "parameters");
		azzert(messagePartInfoOutput.getTypeClass() == null);
		azzert(messagePartInfoOutput.isElement());

		abstractMessageContainerOutput = messagePartInfoOutput.getMessageInfo();
		azzert(abstractMessageContainerOutput != null);

		xmlSchemaAnnotatedOutput = messagePartInfoOutput.getXmlSchema();
		azzert(xmlSchemaAnnotatedOutput != null);

	}

	private static void azzertOperationInfo() {
		azzert(operationInfo.getFaults().size() == 0);
		azzert(operationInfo.getInput() == messageInfoInput);
		azzert(operationInfo.getOutput() == messageInfoOutput);
		azzert("foo".equals(operationInfo.getInputName()));
		azzert("fooResponse".equals(operationInfo.getOutputName()));
		azzertQN(operationInfo.getName(), "http://cxf.xdptdr.github.com/", "foo");
		azzert(operationInfo.getParameterOrdering() == null);
		azzert(operationInfo.getInterface() != null);
		azzert(operationInfo.getUnwrappedOperation() != null);
		azzert(!operationInfo.hasFaults());
		azzert(operationInfo.hasInput());
		azzert(operationInfo.hasOutput());
		azzert(!operationInfo.isOneWay());
		azzert(!operationInfo.isUnwrapped());
		azzert(operationInfo.isUnwrappedCapable());
	}

	private static void azzertQN(QName qn, String ns, String lp) {
		if (ns == null) {
			azzert(qn.getNamespaceURI() == null);
		} else {
			azzert(ns.equals(qn.getNamespaceURI()));
		}
		if (lp == null) {
			azzert(qn.getLocalPart() == null);
		} else {
			azzert(lp.equals(qn.getLocalPart()));
		}
	}

	private static void azzertReflectionServiceFactoryBean() {

		azzert(!reflectionServiceFactoryBean.getAnonymousWrapperTypes());
		azzert(reflectionServiceFactoryBean.getExecutor() == null);
		azzert(reflectionServiceFactoryBean.getFeatures().size() == 0);

		final List<String> ignoredClasses = reflectionServiceFactoryBean.getIgnoredClasses();
		azzert(ignoredClasses.size() == 6);
		azzertContains(ignoredClasses, "java.lang.Object");
		azzertContains(ignoredClasses, "java.lang.Throwable");
		azzertContains(ignoredClasses, "org.omg.CORBA_2_3.portable.ObjectImpl");
		azzertContains(ignoredClasses, "org.omg.CORBA.portable.ObjectImpl");
		azzertContains(ignoredClasses, "javax.ejb.EJBObject");
		azzertContains(ignoredClasses, "javax.rmi.CORBA.Stub");

		azzert(reflectionServiceFactoryBean.getIgnoredMethods().size() == 0);
		azzert(reflectionServiceFactoryBean.getInvoker() == null);

		azzert(reflectionServiceFactoryBean.getProperties() == null);
		azzert(reflectionServiceFactoryBean.getQualifyWrapperSchema());
		azzert("document".equals(reflectionServiceFactoryBean.getStyle()));
		azzert(reflectionServiceFactoryBean.getWrapped() == null);
		azzert(!reflectionServiceFactoryBean.isAnonymousWrapperTypes());
		azzert(reflectionServiceFactoryBean.isPopulateFromClass());
		azzert(reflectionServiceFactoryBean.isQualifyWrapperSchema());
		azzert(reflectionServiceFactoryBean.isWrapped());
		azzert(reflectionServiceFactoryBean.getWsdlURL() == null);
		azzert(reflectionServiceFactoryBean.getSessionState().size() == 0);

		azzert(reflectionServiceFactoryBean.getBus() == bus);

		dataBinding = reflectionServiceFactoryBean.getDataBinding();
		azzert(dataBinding instanceof JAXBDataBinding);
		jaxbDataBinding = (JAXBDataBinding) dataBinding;

		service = reflectionServiceFactoryBean.getService();
		azzert(service != null);

		methodDispatcher = reflectionServiceFactoryBean.getMethodDispatcher();
		azzert(methodDispatcher instanceof SimpleMethodDispatcher);
		simpleMethodDispatcher = (SimpleMethodDispatcher) methodDispatcher;

		azzert(reflectionServiceFactoryBean.getConfigurations().size() == 2);
		abstractServiceConfiguration1 = reflectionServiceFactoryBean.getConfigurations().get(0);
		abstractServiceConfiguration2 = reflectionServiceFactoryBean.getConfigurations().get(1);
		azzert(abstractServiceConfiguration1 instanceof DefaultServiceConfiguration);
		azzert(abstractServiceConfiguration2 instanceof AbstractServiceConfiguration);
		defaultServiceConfiguration = (DefaultServiceConfiguration) abstractServiceConfiguration1;
		soapBindingServiceConfiguration = abstractServiceConfiguration2;

	}

	private static void azzertService() {

		azzert(service.getDataBinding() == dataBinding);
		azzert(service.getEndpoints().size() == 1);
		azzert(service.getExecutor() == executor);
		azzert(service.getName() != null);

		final List<ServiceInfo> serviceInfos = service.getServiceInfos();
		azzert(serviceInfos.size() == 1);
		azzert(serviceInfos.get(0) == serviceInfo);

		invoker = service.getInvoker();
		azzert(invoker instanceof FactoryInvoker);
		factoryInvoker = (FactoryInvoker) invoker;

		Endpoint serviceEndpoint = service.getEndpoints().entrySet().iterator().next().getValue();
		azzert(serviceEndpoint != endpoint); // guess : endpoint was cloned

	}

	private static void azzertSimpleServiceBuilder() {

		bus = simpleServiceBuilder.getBus(false);
		azzert(bus instanceof ExtensionManagerBus);
		extensionManagerBus = (ExtensionManagerBus) bus;

		azzert(simpleServiceBuilder.getAddress() == null);
		azzert(simpleServiceBuilder.getOutputFile() == null);
		azzert(simpleServiceBuilder.getBindingId() == null);
		azzert(simpleServiceBuilder.getConduitSelector() == null);
		azzert(simpleServiceBuilder.getDataBinding() == null);
		azzert(simpleServiceBuilder.getFeatures().size() == 0);
		azzert(simpleServiceBuilder.getProperties(false) == null);

		bindingConfig = simpleServiceBuilder.getBindingConfig();
		azzert(bindingConfig instanceof SoapBindingConfiguration);
		soapBindingConfiguration = (SoapBindingConfiguration) bindingConfig;

		bindingFactory = simpleServiceBuilder.getBindingFactory();
		azzert(bindingFactory instanceof SoapBindingFactory);
		soapBindingFactory = (SoapBindingFactory) bindingFactory;

		destinationFactory = simpleServiceBuilder.getDestinationFactory();
		azzert(destinationFactory instanceof SoapTransportFactory);
		soapTransportFactory = (SoapTransportFactory) destinationFactory;
	}

	private static void azzertSoapBindingConfiguration() {

		azzert(soapBindingConfiguration.getBindingName() == null);
		azzert("SoapBinding".equals(soapBindingConfiguration.getBindingNamePostfix()));
		azzert("document".equals(soapBindingConfiguration.getStyle()));
		azzert(soapBindingConfiguration.isMtomEnabled() == false);
		azzert(soapBindingConfiguration.getUse() == null);

		version = soapBindingConfiguration.getVersion();
		azzert(version != null);
		azzert(soapBindingConfiguration.getBindingId().equals(version.getBindingId()));

	}

	private static void azzertSoapBindingFactory() {
		azzert(soapBindingFactory.getActivationNamespaces().size() == SoapBindingFactory.DEFAULT_NAMESPACES.size());
		azzert(soapBindingFactory.getBus() == bus);
	}

	private static void azzertSoapBindingServiceConfiguration() {
		azzert(soapBindingServiceConfiguration.getEndpointName() == null);
		azzert(soapBindingServiceConfiguration.getInterfaceName() == null);
		azzert(soapBindingServiceConfiguration.getServiceName() == null);
		azzert(soapBindingServiceConfiguration.getServiceNamespace() == null);
		azzert(soapBindingServiceConfiguration.getServiceFactory() == reflectionServiceFactoryBean);
		azzert("document".equals(soapBindingServiceConfiguration.getStyle()));
		azzert(soapBindingServiceConfiguration.getWsdlURL() == null);
		azzert(soapBindingServiceConfiguration.isWrapped() == null);
	}

	private static void azzertSoapTransportFactory() {
		azzert(soapTransportFactory.getTransportIds().size() == SoapBindingFactory.DEFAULT_NAMESPACES.size() + 1);
		azzert(soapTransportFactory.getUriPrefixes().size() == 1);
		azzert("soap.udp".equals(soapTransportFactory.getUriPrefixes().iterator().next()));
	}

	private static void azzertXmlSchemaAnnotated_Input() {
		azzert(xmlSchemaAnnotatedInput.getAnnotation() == null);
		azzert(xmlSchemaAnnotatedInput.getId() == null);
		azzert(xmlSchemaAnnotatedInput.getUnhandledAttributes() == null);
	}

	private static void azzertXmlSchemaAnnotated_Output() {
		azzert(xmlSchemaAnnotatedOutput.getAnnotation() == null);
		azzert(xmlSchemaAnnotatedOutput.getId() == null);
		azzert(xmlSchemaAnnotatedOutput.getUnhandledAttributes() == null);
	}

	public static void main(String[] args) throws IOException, EndpointException {

		simpleServiceBuilder = new SimpleServiceBuilder();
		simpleServiceBuilder.setServiceClass(Abagtha.class);

		reflectionServiceFactoryBean = simpleServiceBuilder.getServiceFactory();
		azzert(reflectionServiceFactoryBean != null);

		serviceInfo = simpleServiceBuilder.createService();
		azzert(serviceInfo != null);

		endpointInfo = reflectionServiceFactoryBean.getEndpointInfo();
		azzert(endpointInfo != null);

		endpoint = reflectionServiceFactoryBean.createEndpoint(endpointInfo);
		azzert(endpoint instanceof EndpointImpl);
		endpointImpl = (EndpointImpl) endpoint;

		binding = endpoint.getBinding();
		azzert(binding instanceof SoapBinding);
		soapBinding = (SoapBinding) binding;

		message = binding.createMessage();
		azzert(message instanceof SoapMessage);
		soapMessage = (SoapMessage) message;

		serverFactoryBean = new ServerFactoryBean();
		serverFactoryBean.setServiceClass(simpleServiceBuilder.getServiceClass());
		serverFactoryBean.setAddress("http://localhost:9000/Abagtha");
		serverFactoryBean.setServiceBean(new Abagtha());

		server = serverFactoryBean.create();
		azzert(server instanceof ServerImpl);
		serverImpl = (ServerImpl) server;
		azzert(server.isStarted());

		azzertSimpleServiceBuilder();
		azzertReflectionServiceFactoryBean();
		azzertSoapBindingConfiguration();
		azzertSoapBindingFactory();
		azzertSoapTransportFactory();
		azzertDefaultServiceConfiguration();
		azzertSoapBindingServiceConfiguration();
		azzertEndpointInfo();
		azzertBindingInfo();
		azzertBindingOperationInfo();
		azzertBindingMessageInfo_Input();
		azzertMessageInfo_Input();
		azzertMessagePartInfo_Input();
		azzertAbstractMessageContainer_Input();
		azzertXmlSchemaAnnotated_Input();

		azzertBindingMessageInfo_Output();
		azzertMessageInfo_Output();
		azzertMessagePartInfo_Output();
		azzertAbstractMessageContainer_Output();
		azzertXmlSchemaAnnotated_Output();

		azzertOperationInfo();
		azzertIinterfaceInfo();

		azzertEndpointReferenceType();
		azzertAttributedURIType();
		azzertEndpoint();
		azzertBinding();
		azzertMessage();
		azzertService();
		azzertDataBinding();
		azzertInvoker();

		ServerRegistry serverRegistry = bus.getExtension(ServerRegistry.class);
		azzert(serverRegistry != null);
		azzert(serverRegistry.getServers().size() == 1);

		WSDLManager wsdlManager = bus.getExtension(WSDLManager.class);
		azzert(wsdlManager != null);
		azzert(wsdlManager.getDefinitions().size() == 0);
		azzert(wsdlManager.getWSDLFactory() != null);

		ResourceManager e = bus.getExtension(ResourceManager.class);
		azzert(e.getResourceResolvers().size() == 12);
		azzertContainsT(e.getResourceResolvers(), JBossWSResourceInjectionResolver.class);
		azzertContainsT(e.getResourceResolvers(), WebServiceContextResourceResolver.class);
		azzertContainsT(e.getResourceResolvers(), ObjectTypeResolver.class);
		azzertContainsT(e.getResourceResolvers(), SinglePropertyResolver.class);
		azzertContainsT(e.getResourceResolvers(), PropertiesResolver.class);
		azzertContainsT(e.getResourceResolvers(), ClassLoaderResolver.class);
		azzertContainsT(e.getResourceResolvers(), ClasspathResolver.class);

		PolicyEngine pe = bus.getExtension(PolicyEngine.class);
		azzert(pe != null);
		HTTPConduitFactory h = bus.getExtension(HTTPConduitFactory.class);
		azzert(h != null);
		FactoryBeanListenerManager fblm = bus.getExtension(FactoryBeanListenerManager.class);
		azzert(fblm != null);
		PolicyAnnotationListener a = bus.getExtension(PolicyAnnotationListener.class);
		azzert(a != null);
		WebServiceContextResourceResolver b = bus.getExtension(WebServiceContextResourceResolver.class);
		azzert(b != null);
		JMSWSDLExtensionLoader c = bus.getExtension(JMSWSDLExtensionLoader.class);
		azzert(c != null);
		ConfiguredBeanLocator d = bus.getExtension(ConfiguredBeanLocator.class);
		azzert(d != null);

		azzert(e != null);
		BusLifeCycleManager f = bus.getExtension(BusLifeCycleManager.class);
		azzert(f != null);
		AddressingWSDLExtensionLoader g = bus.getExtension(AddressingWSDLExtensionLoader.class);
		azzert(g != null);

		SoapTransportFactory j = bus.getExtension(SoapTransportFactory.class);
		azzert(j != null);
		DestinationFactoryManager l = bus.getExtension(DestinationFactoryManager.class);
		azzert(l != null);
		BindingFactoryManager m = bus.getExtension(BindingFactoryManager.class);
		azzert(m != null);
		PolicyDataEngine n = bus.getExtension(PolicyDataEngine.class);
		azzert(n != null);
		InstrumentationManager o = bus.getExtension(InstrumentationManager.class);
		azzert(o != null);
		HTTPWSDLExtensionLoader p = bus.getExtension(HTTPWSDLExtensionLoader.class);
		azzert(p != null);
		Configurer q = bus.getExtension(Configurer.class);
		azzert(q != null);
		SoapBindingFactory r = bus.getExtension(SoapBindingFactory.class);
		azzert(r != null);
		ExtensionManager s = bus.getExtension(ExtensionManager.class);
		azzert(s != null);
		XMLWSDLExtensionLoader t = bus.getExtension(XMLWSDLExtensionLoader.class);
		azzert(t != null);
		ConduitInitiatorManager u = bus.getExtension(ConduitInitiatorManager.class);
		azzert(u != null);

		server.stop();
		server.destroy();
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

	@SuppressWarnings("unused")
	private static boolean t() {
		return true;
	}

	public String foo(String bar) {
		return bar + "!" + bar;
	}

}
