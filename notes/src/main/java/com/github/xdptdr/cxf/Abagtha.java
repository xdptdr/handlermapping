package com.github.xdptdr.cxf;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.cxf.Bus;
import org.apache.cxf.binding.BindingConfiguration;
import org.apache.cxf.binding.BindingFactory;
import org.apache.cxf.common.xmlschema.SchemaCollection;
import org.apache.cxf.databinding.DataBinding;
import org.apache.cxf.endpoint.ConduitSelector;
import org.apache.cxf.feature.Feature;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.service.model.AbstractPropertiesHolder;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.DescriptionInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.SchemaInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.service.model.ServiceSchemaInfo;
import org.apache.cxf.simple.SimpleServiceBuilder;
import org.apache.cxf.transport.DestinationFactory;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.apache.cxf.wsdl.service.factory.ReflectionServiceFactoryBean;

public class Abagtha {

	public static void main(String[] args) throws IOException {

		SimpleServiceBuilder simpleServiceBuilder = new SimpleServiceBuilder();
		simpleServiceBuilder.setServiceClass(Abagtha.class);

		if (!t()) {

			File file = simpleServiceBuilder.getOutputFile();
			simpleServiceBuilder.validate();

			ReflectionServiceFactoryBean reflectionServiceFactoryBean = simpleServiceBuilder.getServiceFactory();
			simpleServiceBuilder.setServiceFactory(reflectionServiceFactoryBean);

			String wsdlURL = simpleServiceBuilder.getWsdlURL();
			simpleServiceBuilder.setWsdlURL(wsdlURL);

			String address = simpleServiceBuilder.getAddress();
			BindingConfiguration bindingConfiguration = simpleServiceBuilder.getBindingConfig();
			BindingFactory bindingFactory = simpleServiceBuilder.getBindingFactory();
			String bindingId = simpleServiceBuilder.getBindingId();
			Bus bus = simpleServiceBuilder.getBus();
			boolean createIfNeeded = false;
			simpleServiceBuilder.getBus(createIfNeeded);
			ConduitSelector conduitSelector = simpleServiceBuilder.getConduitSelector();
			DataBinding dataBinding = simpleServiceBuilder.getDataBinding();
			DestinationFactory destinationFactory = simpleServiceBuilder.getDestinationFactory();
			QName endpointName = simpleServiceBuilder.getEndpointName();
			List<Feature> features = simpleServiceBuilder.getFeatures();
			Map<String, Object> properties = simpleServiceBuilder.getProperties();
			boolean create = false;
			simpleServiceBuilder.getProperties(create);
			String publishedEndpointUrl = simpleServiceBuilder.getPublishedEndpointUrl();
			QName serviceName = simpleServiceBuilder.getServiceName();
			String transportId = simpleServiceBuilder.getTransportId();
			simpleServiceBuilder.setAddress(address);
			simpleServiceBuilder.setBindingConfig(bindingConfiguration);
			simpleServiceBuilder.setBindingFactory(bindingFactory);
			simpleServiceBuilder.setBindingId(bindingId);
			simpleServiceBuilder.setBus(bus);
			simpleServiceBuilder.setConduitSelector(conduitSelector);
			// simpleServiceBuilder.setDataBinding(dataBinding);
			simpleServiceBuilder.setDestinationFactory(destinationFactory);
			simpleServiceBuilder.setEndpointName(endpointName);
			EndpointReferenceType enpointReferenceType = null;
			simpleServiceBuilder.setEndpointReference(enpointReferenceType);
			simpleServiceBuilder.setFeatures(features);
			simpleServiceBuilder.setProperties(properties);
			simpleServiceBuilder.setPublishedEndpointUrl(publishedEndpointUrl);
			simpleServiceBuilder.setServiceName(serviceName);
			simpleServiceBuilder.setTransportId(transportId);

			simpleServiceBuilder.getInFaultInterceptors();
			simpleServiceBuilder.getInInterceptors();
			simpleServiceBuilder.getOutFaultInterceptors();
			simpleServiceBuilder.getOutInterceptors();
			List<Interceptor<? extends Message>> interceptors = null;
			simpleServiceBuilder.setInFaultInterceptors(interceptors);
			simpleServiceBuilder.setInInterceptors(interceptors);
			simpleServiceBuilder.setOutFaultInterceptors(interceptors);
			simpleServiceBuilder.setOutInterceptors(interceptors);

		}

		ServiceInfo serviceInfo = simpleServiceBuilder.createService();

		if (!t()) {
			BindingInfo bindingInfo;
			serviceInfo.addBinding(bindingInfo);
			EndpointInfo endpointInfo;
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

	}

	private static boolean t() {
		return true;
	}

}
