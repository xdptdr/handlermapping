package com.github.xdptdr.cxf;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executor;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.apache.cxf.binding.Binding;
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
import org.apache.cxf.common.xmlschema.SchemaCollection;
import org.apache.cxf.configuration.ConfiguredBeanLocator;
import org.apache.cxf.configuration.Configurer;
import org.apache.cxf.databinding.DataBinding;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.endpoint.EndpointException;
import org.apache.cxf.endpoint.EndpointImpl;
import org.apache.cxf.endpoint.ServerRegistry;
import org.apache.cxf.feature.Feature;
import org.apache.cxf.interceptor.InFaultChainInitiatorObserver;
import org.apache.cxf.interceptor.Interceptor;
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
import org.apache.cxf.service.ServiceImpl;
import org.apache.cxf.service.factory.FactoryBeanListenerManager;
import org.apache.cxf.service.factory.SimpleMethodDispatcher;
import org.apache.cxf.service.invoker.FactoryInvoker;
import org.apache.cxf.service.invoker.Invoker;
import org.apache.cxf.service.invoker.MethodDispatcher;
import org.apache.cxf.service.model.AbstractMessageContainer;
import org.apache.cxf.service.model.AbstractPropertiesHolder;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.BindingMessageInfo;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.service.model.DescriptionInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.MessagePartInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.cxf.service.model.SchemaInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.service.model.ServiceSchemaInfo;
import org.apache.cxf.simple.SimpleServiceBuilder;
import org.apache.cxf.transport.ConduitInitiatorManager;
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

import com.sun.xml.bind.v2.runtime.JAXBContextImpl;

public class Abagtha {

	public String foo(String bar) {
		return bar + "!" + bar;
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
		azzert(bindingInfo.getOperations().size() == 1); // TODO !
		azzert(bindingInfo.getService() == si);

		BindingOperationInfo bindingOperationInfo = bindingInfo.getOperations().iterator().next();
		azzert("http://cxf.xdptdr.github.com/".equals(bindingOperationInfo.getName().getNamespaceURI()));
		azzert("foo".equals(bindingOperationInfo.getName().getLocalPart()));
		azzert(bindingOperationInfo.getBinding() == bindingInfo);
		azzert(bindingOperationInfo.getFaults().size() == 0);
		azzert(bindingOperationInfo.getInput() != null);
		azzert(bindingOperationInfo.getOutput() != null);
		azzert(bindingOperationInfo.getOperationInfo() != null);
		azzert(bindingOperationInfo.getUnwrappedOperation() != null);
		azzert(bindingOperationInfo.getWrappedOperation() != null);
		azzert(!bindingOperationInfo.isUnwrapped());
		azzert(bindingOperationInfo.isUnwrappedCapable());

		BindingMessageInfo bindingMessageInfoInput = bindingOperationInfo.getInput();
		azzert(bindingMessageInfoInput.getBindingOperation() == bindingOperationInfo);
		azzert(bindingMessageInfoInput.getMessageInfo() != null);
		azzert(bindingMessageInfoInput.getMessageParts().size() == 1);

		MessageInfo messageInfoInput = bindingMessageInfoInput.getMessageInfo();
		azzert(messageInfoInput.getType() == MessageInfo.Type.INPUT);
		azzert(messageInfoInput.getMessagePartsMap().size() == 1);

		Entry<QName, MessagePartInfo> messageInfoInputEntry = messageInfoInput.getMessagePartsMap().entrySet()
				.iterator().next();
		azzert("http://cxf.xdptdr.github.com/".equals(messageInfoInputEntry.getKey().getNamespaceURI()));
		azzert("parameters".equals(messageInfoInputEntry.getKey().getLocalPart()));
		azzert(messageInfoInputEntry.getValue() != null);

		MessagePartInfo messagePartInfoInput = messageInfoInputEntry.getValue();
		azzert("http://cxf.xdptdr.github.com/".equals(messagePartInfoInput.getConcreteName().getNamespaceURI()));
		azzert("foo".equals(messagePartInfoInput.getConcreteName().getLocalPart()));
		azzert("http://cxf.xdptdr.github.com/".equals(messagePartInfoInput.getElementQName().getNamespaceURI()));
		azzert("foo".equals(messagePartInfoInput.getElementQName().getLocalPart()));
		azzert("http://cxf.xdptdr.github.com/".equals(messagePartInfoInput.getName().getNamespaceURI()));
		azzert("parameters".equals(messagePartInfoInput.getName().getLocalPart()));
		azzert("http://cxf.xdptdr.github.com/".equals(messagePartInfoInput.getTypeQName().getNamespaceURI()));
		azzert("foo".equals(messagePartInfoInput.getTypeQName().getLocalPart()));
		azzert(messagePartInfoInput.getTypeClass() == null);
		azzert(messagePartInfoInput.isElement());
		azzert(messagePartInfoInput.getMessageInfo() != null);
		azzert(messagePartInfoInput.getXmlSchema() != null);

		AbstractMessageContainer abstractMessageContainerInput = messagePartInfoInput.getMessageInfo();
		azzert(abstractMessageContainerInput.getMessageDocumentation() == null);
		azzert(abstractMessageContainerInput.getMessagePartsNumber() == 1);
		azzert("http://cxf.xdptdr.github.com/".equals(abstractMessageContainerInput.getName().getNamespaceURI()));
		azzert("foo".equals(abstractMessageContainerInput.getName().getLocalPart()));
		azzert(abstractMessageContainerInput.getOutOfBandParts().size() == 0);
		azzert(abstractMessageContainerInput.getMessageParts().size() == 1);
		azzert(abstractMessageContainerInput.getMessageParts().get(0) == messagePartInfoInput);

		XmlSchemaAnnotated xmlSchemaAnnotatedInput = messagePartInfoInput.getXmlSchema();
		azzert(xmlSchemaAnnotatedInput.getAnnotation() == null);
		azzert(xmlSchemaAnnotatedInput.getId() == null);
		azzert(xmlSchemaAnnotatedInput.getUnhandledAttributes() == null);

		azzert(bindingMessageInfoInput.getMessageParts().get(0) == messagePartInfoInput);

		BindingMessageInfo bindingMessageInfoOutput = bindingOperationInfo.getOutput();
		azzert(bindingMessageInfoOutput.getBindingOperation() == bindingOperationInfo);
		azzert(bindingMessageInfoOutput.getMessageInfo() != null);
		azzert(bindingMessageInfoOutput.getMessageParts().size() == 1);

		MessageInfo messageInfoOutput = bindingMessageInfoOutput.getMessageInfo();
		azzert(messageInfoOutput.getType() == MessageInfo.Type.OUTPUT);
		azzert(messageInfoOutput.getMessagePartsMap().size() == 1);

		Entry<QName, MessagePartInfo> messageInfoOutputEntry = messageInfoOutput.getMessagePartsMap().entrySet()
				.iterator().next();
		azzert("http://cxf.xdptdr.github.com/".equals(messageInfoOutputEntry.getKey().getNamespaceURI()));
		azzert("parameters".equals(messageInfoOutputEntry.getKey().getLocalPart()));
		azzert(messageInfoOutputEntry.getValue() != null);

		MessagePartInfo messagePartInfoOutput = messageInfoOutputEntry.getValue();

		azzert("http://cxf.xdptdr.github.com/".equals(messagePartInfoOutput.getConcreteName().getNamespaceURI()));
		azzert("fooResponse".equals(messagePartInfoOutput.getConcreteName().getLocalPart()));
		azzert("http://cxf.xdptdr.github.com/".equals(messagePartInfoOutput.getElementQName().getNamespaceURI()));
		azzert("fooResponse".equals(messagePartInfoOutput.getElementQName().getLocalPart()));
		azzert("http://cxf.xdptdr.github.com/".equals(messagePartInfoOutput.getName().getNamespaceURI()));
		azzert("parameters".equals(messagePartInfoOutput.getName().getLocalPart()));
		azzert("http://cxf.xdptdr.github.com/".equals(messagePartInfoOutput.getTypeQName().getNamespaceURI()));
		azzert("fooResponse".equals(messagePartInfoOutput.getTypeQName().getLocalPart()));
		azzert(messagePartInfoOutput.getTypeClass() == null);
		azzert(messagePartInfoOutput.isElement());
		azzert(messagePartInfoOutput.getMessageInfo() != null);
		azzert(messagePartInfoOutput.getXmlSchema() != null);

		AbstractMessageContainer abstractMessageContainerOutput = messagePartInfoOutput.getMessageInfo();
		azzert(abstractMessageContainerOutput.getMessageDocumentation() == null);
		azzert(abstractMessageContainerOutput.getMessagePartsNumber() == 1);
		azzert("http://cxf.xdptdr.github.com/".equals(abstractMessageContainerOutput.getName().getNamespaceURI()));
		azzert("fooResponse".equals(abstractMessageContainerOutput.getName().getLocalPart()));
		azzert(abstractMessageContainerOutput.getOutOfBandParts().size() == 0);
		azzert(abstractMessageContainerOutput.getMessageParts().size() == 1);
		azzert(abstractMessageContainerOutput.getMessageParts().get(0) == messagePartInfoOutput);

		XmlSchemaAnnotated xmlSchemaAnnotatedOutput = messagePartInfoOutput.getXmlSchema();
		azzert(xmlSchemaAnnotatedOutput.getAnnotation() == null);
		azzert(xmlSchemaAnnotatedOutput.getId() == null);
		azzert(xmlSchemaAnnotatedOutput.getUnhandledAttributes() == null);

		azzert(bindingMessageInfoOutput.getMessageParts().get(0) == messagePartInfoOutput);

		OperationInfo operationInfo = bindingOperationInfo.getOperationInfo();
		azzert(operationInfo.getFaults().size() == 0);
		azzert(operationInfo.getInput() == messageInfoInput);
		azzert(operationInfo.getOutput() == messageInfoOutput);
		azzert("foo".equals(operationInfo.getInputName()));
		azzert("fooResponse".equals(operationInfo.getOutputName()));
		azzert("http://cxf.xdptdr.github.com/".equals(operationInfo.getName().getNamespaceURI()));
		azzert("foo".equals(operationInfo.getName().getLocalPart()));
		azzert(operationInfo.getParameterOrdering() == null);
		azzert(operationInfo.getInterface() != null);
		azzert(operationInfo.getUnwrappedOperation() != null);
		azzert(!operationInfo.hasFaults());
		azzert(operationInfo.hasInput());
		azzert(operationInfo.hasOutput());
		azzert(!operationInfo.isOneWay());
		azzert(!operationInfo.isUnwrapped());
		azzert(operationInfo.isUnwrappedCapable());

		InterfaceInfo interfaceInfo = endpointInfo.getInterface();
		azzert(interfaceInfo.getDescription() == null);
		azzert("http://cxf.xdptdr.github.com/".equals(interfaceInfo.getName().getNamespaceURI()));
		azzert("AbagthaPortType".equals(interfaceInfo.getName().getLocalPart()));
		azzert(interfaceInfo.getOperations().size() == 1); // TODO !
		azzert(interfaceInfo.getService() == si);
		azzert(interfaceInfo == operationInfo.getInterface());

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

		ServerRegistry serverRegistry = bus.getExtension(ServerRegistry.class);
		azzert(serverRegistry != null);
		azzert(serverRegistry.getServers().size() == 0);

		WSDLManager wsdlManager = bus.getExtension(WSDLManager.class);
		azzert(wsdlManager != null);
		azzert(wsdlManager.getDefinitions().size() == 0);
		azzert(wsdlManager.getWSDLFactory() != null);

		ResourceManager e = bus.getExtension(ResourceManager.class);
		azzert(e.getResourceResolvers().size() == 12);
		System.out.println(e.getResourceResolvers());
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
