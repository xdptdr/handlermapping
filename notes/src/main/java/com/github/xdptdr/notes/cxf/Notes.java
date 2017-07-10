package com.github.xdptdr.notes.cxf;

import org.apache.cxf.wsdl.AbstractWSDLPlugin;
import org.apache.cxf.wsdl.JAXBExtensibilityElement;
import org.apache.cxf.wsdl.JAXBExtensionHelper;
import org.apache.cxf.wsdl.TExtensibilityElementImpl;
import org.apache.cxf.wsdl.WSAEndpointReferenceUtils;
import org.apache.cxf.wsdl.WSDLBuilder;
import org.apache.cxf.wsdl.WSDLConstants;
import org.apache.cxf.wsdl.WSDLExtensibilityPlugin;
import org.apache.cxf.wsdl.WSDLExtensionLoader;
import org.apache.cxf.wsdl.WSDLHelper;
import org.apache.cxf.wsdl.WSDLLibrary;
import org.apache.cxf.wsdl.WSDLManager;
import org.apache.cxf.wsdl.binding.AbstractWSDLBindingFactory;
import org.apache.cxf.wsdl.binding.WSDLBindingFactory;
import org.apache.cxf.wsdl.interceptors.AbstractEndpointSelectionInterceptor;
import org.apache.cxf.wsdl.interceptors.BareInInterceptor;
import org.apache.cxf.wsdl.interceptors.BareOutInterceptor;
import org.apache.cxf.wsdl.interceptors.DocLiteralInInterceptor;
import org.apache.cxf.wsdl.interceptors.WrappedOutInterceptor;
import org.apache.cxf.wsdl.service.factory.AbstractServiceConfiguration;
import org.apache.cxf.wsdl.service.factory.DefaultServiceConfiguration;
import org.apache.cxf.wsdl.service.factory.MethodNameSoapActionServiceConfiguration;
import org.apache.cxf.wsdl.service.factory.ReflectionServiceFactoryBean;
import org.apache.cxf.wsdl.service.factory.WSDLBasedServiceConfiguration;
import org.apache.cxf.wsdl11.AbstractWrapperWSDLLocator;
import org.apache.cxf.wsdl11.CatalogWSDLLocator;
import org.apache.cxf.wsdl11.PartialWSDLProcessor;
import org.apache.cxf.wsdl11.ResourceManagerWSDLLocator;
import org.apache.cxf.wsdl11.SOAPBindingUtil;
import org.apache.cxf.wsdl11.SchemaSerializer;
import org.apache.cxf.wsdl11.SchemaUtil;
import org.apache.cxf.wsdl11.ServiceWSDLBuilder;
import org.apache.cxf.wsdl11.WSDLEndpointFactory;
import org.apache.cxf.wsdl11.WSDLManagerImpl;
import org.apache.cxf.wsdl11.WSDLRuntimeException;
import org.apache.cxf.wsdl11.WSDLServiceBuilder;
import org.apache.cxf.wsdl11.WSDLServiceFactory;
import org.apache.cxf.wsdl11.WSDLServiceUtils;

import com.github.xdptdr.notes.N;

public class Notes {
	/*-
		( ) cxf-services-sts-core
		( ) cxf-services-ws-discovery-api
		( ) cxf-xjc-boolean
		( ) cxf-xjc-bug986
		( ) cxf-xjc-dv
		( ) cxf-xjc-ts
		( ) cxf-xjc-runtime
		( ) cxf-core
		( ) cxf-rt-bindings-coloc
		( ) cxf-rt-bindings-object
		( ) cxf-rt-bindings-soap
		( ) cxf-rt-bindings-xml
		( ) cxf-rt-databinding-aegis
		( ) cxf-rt-databinding-jaxb
		( ) cxf-rt-features-clustering
		( ) cxf-rt-frontend-jaxws
		( ) cxf-rt-frontend-simple
		( ) cxf-rt-management
		( ) cxf-rt-security
		( ) cxf-rt-security-saml
		( ) cxf-rt-transports-http
		( ) cxf-rt-transports-http-hc
		( ) cxf-rt-transports-jms
		( ) cxf-rt-transports-local
		( ) cxf-rt-ws-addr
		(x) cxf-rt-wsdl
		( ) cxf-rt-ws-mex
		( ) cxf-rt-ws-policy
		( ) cxf-rt-ws-rm
		( ) cxf-rt-ws-security
		( ) cxf-tools-common
		( ) cxf-tools-java2ws
		( ) cxf-tools-validator
		( ) cxf-tools-wsdlto-core
		( ) cxf-tools-wsdlto-databinding-jaxb
		( ) cxf-tools-wsdlto-frontend-jaxws
	 */

	/*-
	 * https://en.wikipedia.org/wiki/List_of_biblical_names_starting_with_A
	 */

	private static void notes(N n) {
		
		
		
		todoWsdl(n);
	}

	private static void todoWsdl(N n) {

		n.todo(AbstractWSDLPlugin.class, JAXBExtensibilityElement.class, JAXBExtensionHelper.class,
				TExtensibilityElementImpl.class, WSAEndpointReferenceUtils.class, WSDLBuilder.class,
				WSDLConstants.class, WSDLExtensibilityPlugin.class, WSDLExtensionLoader.class, WSDLHelper.class,
				WSDLLibrary.class, WSDLManager.class);

		n.todo(AbstractWSDLBindingFactory.class, WSDLBindingFactory.class);

		n.todo(AbstractEndpointSelectionInterceptor.class, BareInInterceptor.class, BareOutInterceptor.class,
				DocLiteralInInterceptor.class, WrappedOutInterceptor.class);

		n.todo(AbstractServiceConfiguration.class, DefaultServiceConfiguration.class,
				MethodNameSoapActionServiceConfiguration.class, ReflectionServiceFactoryBean.class,
				WSDLBasedServiceConfiguration.class);

		n.todo(AbstractWrapperWSDLLocator.class, CatalogWSDLLocator.class, PartialWSDLProcessor.class,
				ResourceManagerWSDLLocator.class, SchemaSerializer.class, SchemaUtil.class, ServiceWSDLBuilder.class,
				SOAPBindingUtil.class, WSDLEndpointFactory.class, WSDLManagerImpl.class, WSDLRuntimeException.class,
				WSDLServiceBuilder.class, WSDLServiceFactory.class, WSDLServiceUtils.class

		);
	}

	public static void main(String[] args) {
		N n = new N();
		notes(n);
		n.sumUp(true);
	}

}
