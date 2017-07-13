package com.github.xdptdr.notes.cxf;

import org.apache.cxf.Bus;
import org.apache.cxf.BusException;
import org.apache.cxf.BusFactory;
import org.apache.cxf.annotations.DataBinding;
import org.apache.cxf.annotations.EndpointProperties;
import org.apache.cxf.annotations.EndpointProperty;
import org.apache.cxf.annotations.EvaluateAllEndpoints;
import org.apache.cxf.annotations.FactoryType;
import org.apache.cxf.annotations.FastInfoset;
import org.apache.cxf.annotations.GZIP;
import org.apache.cxf.annotations.Logging;
import org.apache.cxf.annotations.Policies;
import org.apache.cxf.annotations.Policy;
import org.apache.cxf.annotations.Provider;
import org.apache.cxf.annotations.SchemaValidation;
import org.apache.cxf.annotations.UseAsyncMethod;
import org.apache.cxf.annotations.WSDLDocumentation;
import org.apache.cxf.annotations.WSDLDocumentationCollection;
import org.apache.cxf.attachment.AttachmentDataSource;
import org.apache.cxf.attachment.AttachmentDeserializer;
import org.apache.cxf.attachment.AttachmentImpl;
import org.apache.cxf.attachment.AttachmentSerializer;
import org.apache.cxf.attachment.AttachmentUtil;
import org.apache.cxf.attachment.Base64DecoderStream;
import org.apache.cxf.attachment.ByteDataSource;
import org.apache.cxf.attachment.ContentDisposition;
import org.apache.cxf.attachment.DelegatingInputStream;
import org.apache.cxf.attachment.ImageDataContentHandler;
import org.apache.cxf.attachment.LazyAttachmentCollection;
import org.apache.cxf.attachment.LazyDataSource;
import org.apache.cxf.attachment.MimeBodyPartInputStream;
import org.apache.cxf.attachment.QuotedPrintableDecoderStream;
import org.apache.cxf.attachment.Rfc5987Util;
import org.apache.cxf.binding.AbstractBindingFactory;
import org.apache.cxf.binding.Binding;
import org.apache.cxf.binding.BindingConfiguration;
import org.apache.cxf.binding.BindingFactory;
import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.bus.CXFBusFactory;
import org.apache.cxf.bus.ManagedBus;
import org.apache.cxf.bus.blueprint.BlueprintBeanLocator;
import org.apache.cxf.bus.blueprint.BlueprintBus;
import org.apache.cxf.bus.blueprint.BlueprintNameSpaceHandlerFactory;
import org.apache.cxf.bus.blueprint.BundleDelegatingClassLoader;
import org.apache.cxf.bus.blueprint.BusDefinitionParser;
import org.apache.cxf.bus.blueprint.ConfigurerImpl;
import org.apache.cxf.bus.blueprint.NamespaceHandlerRegisterer;
import org.apache.cxf.bus.extension.Extension;
import org.apache.cxf.bus.extension.ExtensionException;
import org.apache.cxf.bus.extension.ExtensionManager;
import org.apache.cxf.bus.extension.ExtensionManagerBus;
import org.apache.cxf.bus.extension.ExtensionManagerImpl;
import org.apache.cxf.bus.extension.ExtensionRegistry;
import org.apache.cxf.bus.extension.TextExtensionFragmentParser;
import org.apache.cxf.bus.managers.BindingFactoryManagerImpl;
import org.apache.cxf.bus.managers.CXFBusLifeCycleManager;
import org.apache.cxf.bus.managers.ClientLifeCycleManagerImpl;
import org.apache.cxf.bus.managers.ConduitInitiatorManagerImpl;
import org.apache.cxf.bus.managers.DestinationFactoryManagerImpl;
import org.apache.cxf.bus.managers.EndpointResolverRegistryImpl;
import org.apache.cxf.bus.managers.HeaderManagerImpl;
import org.apache.cxf.bus.managers.PhaseManagerImpl;
import org.apache.cxf.bus.managers.ServerLifeCycleManagerImpl;
import org.apache.cxf.bus.managers.ServerRegistryImpl;
import org.apache.cxf.bus.managers.ServiceContractResolverRegistryImpl;
import org.apache.cxf.bus.managers.WorkQueueImplMBeanWrapper;
import org.apache.cxf.bus.managers.WorkQueueManagerImpl;
import org.apache.cxf.bus.managers.WorkQueueManagerImplMBeanWrapper;
import org.apache.cxf.bus.osgi.CXFActivator;
import org.apache.cxf.bus.osgi.CXFExtensionBundleListener;
import org.apache.cxf.bus.osgi.ManagedWorkQueueList;
import org.apache.cxf.bus.osgi.OSGIBusListener;
import org.apache.cxf.bus.osgi.OSGiBeanLocator;
import org.apache.cxf.bus.resource.ResourceManagerImpl;
import org.apache.cxf.bus.spring.BusApplicationContext;
import org.apache.cxf.bus.spring.BusApplicationContextResourceResolver;
import org.apache.cxf.bus.spring.BusEntityResolver;
import org.apache.cxf.bus.spring.BusExtensionPostProcessor;
import org.apache.cxf.bus.spring.BusWiringBeanFactoryPostProcessor;
import org.apache.cxf.bus.spring.ControlledValidationXmlBeanDefinitionReader;
import org.apache.cxf.bus.spring.Jsr250BeanPostProcessor;
import org.apache.cxf.bus.spring.NamespaceHandler;
import org.apache.cxf.bus.spring.SpringBeanLocator;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.bus.spring.SpringBusFactory;
import org.apache.cxf.buslifecycle.BusCreationListener;
import org.apache.cxf.buslifecycle.BusLifeCycleListener;
import org.apache.cxf.buslifecycle.BusLifeCycleManager;
import org.apache.cxf.catalog.CatalogXmlSchemaURIResolver;
import org.apache.cxf.catalog.OASISCatalogManager;
import org.apache.cxf.catalog.OASISCatalogManagerHelper;
import org.apache.cxf.common.CXFPermissions;
import org.apache.cxf.common.annotation.AbstractAnnotationVisitor;
import org.apache.cxf.common.annotation.AnnotationProcessor;
import org.apache.cxf.common.annotation.AnnotationVisitor;
import org.apache.cxf.common.classloader.ClassLoaderUtils;
import org.apache.cxf.common.i18n.BundleUtils;
import org.apache.cxf.common.i18n.Message;
import org.apache.cxf.common.i18n.UncheckedException;
import org.apache.cxf.common.injection.NoJSR250Annotations;
import org.apache.cxf.common.injection.ResourceInjector;
import org.apache.cxf.common.jaxb.JAXBBeanInfo;
import org.apache.cxf.common.jaxb.JAXBContextCache;
import org.apache.cxf.common.jaxb.JAXBContextProxy;
import org.apache.cxf.common.jaxb.JAXBUtils;
import org.apache.cxf.common.jaxb.NamespaceMapper;
import org.apache.cxf.common.jaxb.SchemaCollectionContextProxy;
import org.apache.cxf.common.logging.AbstractDelegatingLogger;
import org.apache.cxf.common.logging.Log4jLogger;
import org.apache.cxf.common.logging.LogUtils;
import org.apache.cxf.common.logging.Slf4jLogger;
import org.apache.cxf.common.security.SecurityToken;
import org.apache.cxf.common.security.SimpleGroup;
import org.apache.cxf.common.security.SimplePrincipal;
import org.apache.cxf.common.security.SimpleSecurityContext;
import org.apache.cxf.common.security.TokenType;
import org.apache.cxf.common.security.UsernameToken;
import org.apache.cxf.common.util.ASMHelper;
import org.apache.cxf.common.util.Base64Exception;
import org.apache.cxf.common.util.Base64OutputStream;
import org.apache.cxf.common.util.Base64UrlOutputStream;
import org.apache.cxf.common.util.Base64UrlUtility;
import org.apache.cxf.common.util.Base64Utility;
import org.apache.cxf.common.util.CacheMap;
import org.apache.cxf.common.util.CachedClass;
import org.apache.cxf.common.util.ClassHelper;
import org.apache.cxf.common.util.ClassUnwrapper;
import org.apache.cxf.common.util.ClasspathScanner;
import org.apache.cxf.common.util.CollectionUtils;
import org.apache.cxf.common.util.CompressionUtils;
import org.apache.cxf.common.util.ExtensionInvocationHandler;
import org.apache.cxf.common.util.MessageDigestInputStream;
import org.apache.cxf.common.util.ModCountCopyOnWriteArrayList;
import org.apache.cxf.common.util.PackageUtils;
import org.apache.cxf.common.util.PrimitiveUtils;
import org.apache.cxf.common.util.PropertiesLoaderUtils;
import org.apache.cxf.common.util.PropertyUtils;
import org.apache.cxf.common.util.ProxyClassLoader;
import org.apache.cxf.common.util.ProxyHelper;
import org.apache.cxf.common.util.ReflectionInvokationHandler;
import org.apache.cxf.common.util.ReflectionUtil;
import org.apache.cxf.common.util.SortedArraySet;
import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.common.util.SystemPropertyAction;
import org.apache.cxf.common.util.URIParserUtil;
import org.apache.cxf.common.util.UrlUtils;
import org.apache.cxf.common.util.WeakIdentityHashMap;
import org.apache.cxf.common.util.XmlSchemaPrimitiveUtils;
import org.apache.cxf.common.xmlschema.InvalidXmlSchemaReferenceException;
import org.apache.cxf.common.xmlschema.LSInputImpl;
import org.apache.cxf.common.xmlschema.SchemaCollection;
import org.apache.cxf.common.xmlschema.XmlSchemaInvalidOperation;
import org.apache.cxf.common.xmlschema.XmlSchemaUtils;
import org.apache.cxf.configuration.Configurable;
import org.apache.cxf.configuration.ConfigurationException;
import org.apache.cxf.configuration.ConfiguredBeanLocator;
import org.apache.cxf.configuration.Configurer;
import org.apache.cxf.configuration.NullConfigurer;
import org.apache.cxf.configuration.blueprint.AbstractBPBeanDefinitionParser;
import org.apache.cxf.configuration.blueprint.InterceptorTypeConverter;
import org.apache.cxf.configuration.blueprint.SimpleBPBeanDefinitionParser;
import org.apache.cxf.configuration.jsse.SSLUtils;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.configuration.jsse.TLSClientParametersConfig;
import org.apache.cxf.configuration.jsse.TLSParameterBase;
import org.apache.cxf.configuration.jsse.TLSParameterJaxBUtils;
import org.apache.cxf.configuration.jsse.TLSServerParameters;
import org.apache.cxf.configuration.jsse.TLSServerParametersConfig;
import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.configuration.security.CertStoreType;
import org.apache.cxf.configuration.security.CertificateConstraintsType;
import org.apache.cxf.configuration.security.CipherSuites;
import org.apache.cxf.configuration.security.ClientAuthentication;
import org.apache.cxf.configuration.security.CombinatorType;
import org.apache.cxf.configuration.security.DNConstraintsType;
import org.apache.cxf.configuration.security.ExcludeProtocols;
import org.apache.cxf.configuration.security.FiltersType;
import org.apache.cxf.configuration.security.IncludeProtocols;
import org.apache.cxf.configuration.security.KeyManagersType;
import org.apache.cxf.configuration.security.KeyStoreType;
import org.apache.cxf.configuration.security.ObjectFactory;
import org.apache.cxf.configuration.security.ProxyAuthorizationPolicy;
import org.apache.cxf.configuration.security.SecureRandomParameters;
import org.apache.cxf.configuration.security.TLSClientParametersType;
import org.apache.cxf.configuration.security.TLSServerParametersType;
import org.apache.cxf.configuration.security.TrustManagersType;
import org.apache.cxf.configuration.spring.AbstractBeanDefinitionParser;
import org.apache.cxf.configuration.spring.AbstractFactoryBeanDefinitionParser;
import org.apache.cxf.configuration.spring.BusWiringType;
import org.apache.cxf.configuration.spring.JAXBBeanFactory;
import org.apache.cxf.configuration.spring.MappingBeanDefinitionParser;
import org.apache.cxf.configuration.spring.SimpleBeanDefinitionParser;
import org.apache.cxf.configuration.spring.StringBeanDefinitionParser;
import org.apache.cxf.continuations.Continuation;
import org.apache.cxf.continuations.ContinuationCallback;
import org.apache.cxf.continuations.ContinuationProvider;
import org.apache.cxf.continuations.SuspendedInvocationException;
import org.apache.cxf.databinding.AbstractDataBinding;
import org.apache.cxf.databinding.AbstractInterceptorProvidingDataBinding;
import org.apache.cxf.databinding.AbstractWrapperHelper;
import org.apache.cxf.databinding.DataReader;
import org.apache.cxf.databinding.DataWriter;
import org.apache.cxf.databinding.WrapperCapableDatabinding;
import org.apache.cxf.databinding.WrapperHelper;
import org.apache.cxf.databinding.source.NodeDataReader;
import org.apache.cxf.databinding.source.NodeDataWriter;
import org.apache.cxf.databinding.source.SourceDataBinding;
import org.apache.cxf.databinding.source.XMLStreamDataReader;
import org.apache.cxf.databinding.source.XMLStreamDataWriter;
import org.apache.cxf.databinding.source.mime.CustomExtensionRegistry;
import org.apache.cxf.databinding.source.mime.MimeAttribute;
import org.apache.cxf.databinding.source.mime.MimeSerializer;
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
		(x) cxf-core
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

		todoCore(n);

		todoWsdl(n);
	}

	private static void todoCore(N n) {

		Class<?>[] classes = new Class<?>[] {

				Bus.class, BusException.class, BusFactory.class,

				DataBinding.class, EndpointProperties.class, EndpointProperty.class, EvaluateAllEndpoints.class,
				FactoryType.class, FastInfoset.class, GZIP.class, Logging.class, Policies.class, Policy.class,
				Provider.class, SchemaValidation.class, UseAsyncMethod.class, WSDLDocumentation.class,
				WSDLDocumentationCollection.class,

				AttachmentDataSource.class, AttachmentDeserializer.class, AttachmentImpl.class,
				AttachmentSerializer.class, AttachmentUtil.class, Base64DecoderStream.class, ByteDataSource.class,
				ContentDisposition.class, DelegatingInputStream.class, ImageDataContentHandler.class,
				LazyAttachmentCollection.class, LazyDataSource.class, MimeBodyPartInputStream.class,
				QuotedPrintableDecoderStream.class, Rfc5987Util.class,

				AbstractBindingFactory.class, Binding.class, BindingConfiguration.class, BindingFactory.class,
				BindingFactoryManager.class,

				CXFBusFactory.class, ManagedBus.class,

				BlueprintBeanLocator.class, BlueprintBus.class, BlueprintNameSpaceHandlerFactory.class,
				BundleDelegatingClassLoader.class, BusDefinitionParser.class, ConfigurerImpl.class,
				NamespaceHandlerRegisterer.class,

				Extension.class, ExtensionException.class, ExtensionManager.class, ExtensionManagerBus.class,
				ExtensionManagerImpl.class, ExtensionRegistry.class, TextExtensionFragmentParser.class,

				BindingFactoryManagerImpl.class, ClientLifeCycleManagerImpl.class, ConduitInitiatorManagerImpl.class,
				CXFBusLifeCycleManager.class, DestinationFactoryManagerImpl.class, EndpointResolverRegistryImpl.class,
				HeaderManagerImpl.class, PhaseManagerImpl.class, ServerLifeCycleManagerImpl.class,
				ServerRegistryImpl.class, ServiceContractResolverRegistryImpl.class, WorkQueueImplMBeanWrapper.class,
				WorkQueueManagerImpl.class, WorkQueueManagerImplMBeanWrapper.class,

				CXFActivator.class, CXFExtensionBundleListener.class, ManagedWorkQueueList.class, OSGiBeanLocator.class,
				OSGIBusListener.class,

				ResourceManagerImpl.class,

				BusApplicationContext.class, BusApplicationContextResourceResolver.class, BusDefinitionParser.class,
				BusEntityResolver.class, BusExtensionPostProcessor.class, BusWiringBeanFactoryPostProcessor.class,
				ControlledValidationXmlBeanDefinitionReader.class, Jsr250BeanPostProcessor.class,
				NamespaceHandler.class, SpringBeanLocator.class, SpringBus.class, SpringBusFactory.class,

				BusCreationListener.class, BusLifeCycleListener.class, BusLifeCycleManager.class,

				CatalogXmlSchemaURIResolver.class, OASISCatalogManager.class, OASISCatalogManagerHelper.class,

				CXFPermissions.class,

				AbstractAnnotationVisitor.class, AnnotationProcessor.class, AnnotationVisitor.class,

				ClassLoaderUtils.class,

				BundleUtils.class, Exception.class, Message.class, UncheckedException.class,

				NoJSR250Annotations.class, ResourceInjector.class,

				JAXBBeanInfo.class, JAXBContextCache.class, JAXBContextProxy.class, JAXBUtils.class,
				NamespaceMapper.class, SchemaCollectionContextProxy.class,

				AbstractDelegatingLogger.class, Log4jLogger.class, LogUtils.class, Slf4jLogger.class,

				SecurityToken.class, SimpleGroup.class, SimplePrincipal.class, SimpleSecurityContext.class,
				TokenType.class, UsernameToken.class,

				ASMHelper.class, Base64Exception.class, Base64OutputStream.class, Base64UrlOutputStream.class,
				Base64UrlUtility.class, Base64Utility.class, CachedClass.class, CacheMap.class, ClassHelper.class,
				ClasspathScanner.class, ClassUnwrapper.class, CollectionUtils.class, Compiler.class,
				CompressionUtils.class, ExtensionInvocationHandler.class, MessageDigestInputStream.class,
				ModCountCopyOnWriteArrayList.class, PackageUtils.class, PrimitiveUtils.class,
				PropertiesLoaderUtils.class, PropertyUtils.class, ProxyClassLoader.class, ProxyHelper.class,
				ReflectionInvokationHandler.class, ReflectionUtil.class, SortedArraySet.class, StringUtils.class,
				SystemPropertyAction.class, URIParserUtil.class, UrlUtils.class, WeakIdentityHashMap.class,
				XmlSchemaPrimitiveUtils.class,

				InvalidXmlSchemaReferenceException.class, LSInputImpl.class, SchemaCollection.class,
				XmlSchemaInvalidOperation.class, XmlSchemaUtils.class,

				Configurable.class, ConfigurationException.class, ConfiguredBeanLocator.class, Configurer.class,
				NullConfigurer.class,

				AbstractBPBeanDefinitionParser.class, InterceptorTypeConverter.class,
				SimpleBPBeanDefinitionParser.class,

				SSLUtils.class, TLSClientParameters.class, TLSClientParametersConfig.class, TLSParameterBase.class,
				TLSParameterJaxBUtils.class, TLSServerParameters.class, TLSServerParametersConfig.class,

				AuthorizationPolicy.class, CertificateConstraintsType.class, CertStoreType.class, CipherSuites.class,
				ClientAuthentication.class, CombinatorType.class, DNConstraintsType.class, ExcludeProtocols.class,
				FiltersType.class, IncludeProtocols.class, KeyManagersType.class, KeyStoreType.class,
				ObjectFactory.class, ProxyAuthorizationPolicy.class, SecureRandomParameters.class,
				TLSClientParametersType.class, TLSServerParametersType.class, TrustManagersType.class,

				AbstractBeanDefinitionParser.class, AbstractFactoryBeanDefinitionParser.class, BusWiringType.class,
				ConfigurerImpl.class, JAXBBeanFactory.class, MappingBeanDefinitionParser.class,
				SimpleBeanDefinitionParser.class, StringBeanDefinitionParser.class,

				Continuation.class, ContinuationCallback.class, ContinuationProvider.class,
				SuspendedInvocationException.class,

				AbstractDataBinding.class, AbstractInterceptorProvidingDataBinding.class, AbstractWrapperHelper.class,
				DataBinding.class, DataReader.class, DataWriter.class, WrapperCapableDatabinding.class,
				WrapperHelper.class,

				NodeDataReader.class, NodeDataWriter.class, SourceDataBinding.class, XMLStreamDataReader.class,
				XMLStreamDataWriter.class,

				CustomExtensionRegistry.class, MimeAttribute.class, MimeSerializer.class,

				Object.class

		};

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
