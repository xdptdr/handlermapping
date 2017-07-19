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
import org.apache.cxf.binding.object.LocalServerListener;
import org.apache.cxf.binding.object.ObjectBinding;
import org.apache.cxf.binding.object.ObjectBindingConfiguration;
import org.apache.cxf.binding.object.ObjectBindingFactory;
import org.apache.cxf.binding.object.ObjectDispatchInInterceptor;
import org.apache.cxf.binding.object.ObjectDispatchOutInterceptor;
import org.apache.cxf.binding.object.blueprint.ObjectBindingBPHandler;
import org.apache.cxf.binding.soap.HeaderUtil;
import org.apache.cxf.binding.soap.Soap11;
import org.apache.cxf.binding.soap.Soap12;
import org.apache.cxf.binding.soap.SoapBinding;
import org.apache.cxf.binding.soap.SoapBindingConfiguration;
import org.apache.cxf.binding.soap.SoapBindingConstants;
import org.apache.cxf.binding.soap.SoapBindingFactory;
import org.apache.cxf.binding.soap.SoapFault;
import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.SoapTransportFactory;
import org.apache.cxf.binding.soap.SoapVersion;
import org.apache.cxf.binding.soap.SoapVersionEditor;
import org.apache.cxf.binding.soap.SoapVersionFactory;
import org.apache.cxf.binding.soap.blueprint.SoapBindingBPHandler;
import org.apache.cxf.binding.soap.blueprint.SoapBindingBPInfoConfigDefinitionParser;
import org.apache.cxf.binding.soap.blueprint.SoapVersionTypeConverter;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.binding.soap.interceptor.CheckFaultInterceptor;
import org.apache.cxf.binding.soap.interceptor.EndpointSelectionInterceptor;
import org.apache.cxf.binding.soap.interceptor.MustUnderstandInterceptor;
import org.apache.cxf.binding.soap.interceptor.RPCInInterceptor;
import org.apache.cxf.binding.soap.interceptor.RPCOutInterceptor;
import org.apache.cxf.binding.soap.interceptor.ReadHeadersInterceptor;
import org.apache.cxf.binding.soap.interceptor.Soap11FaultInInterceptor;
import org.apache.cxf.binding.soap.interceptor.Soap11FaultOutInterceptor;
import org.apache.cxf.binding.soap.interceptor.Soap12FaultInInterceptor;
import org.apache.cxf.binding.soap.interceptor.Soap12FaultOutInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapActionInInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapHeaderInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapHeaderOutFilterInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapOutInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapPreProtocolOutInterceptor;
import org.apache.cxf.binding.soap.interceptor.StartBodyInterceptor;
import org.apache.cxf.binding.soap.interceptor.TibcoSoapActionInterceptor;
import org.apache.cxf.binding.soap.jms.interceptor.JMSFault;
import org.apache.cxf.binding.soap.jms.interceptor.JMSFaultFactory;
import org.apache.cxf.binding.soap.jms.interceptor.JMSFaultType;
import org.apache.cxf.binding.soap.jms.interceptor.SoapFaultFactory;
import org.apache.cxf.binding.soap.jms.interceptor.SoapJMSConstants;
import org.apache.cxf.binding.soap.jms.interceptor.SoapJMSInInterceptor;
import org.apache.cxf.binding.soap.model.SoapBindingInfo;
import org.apache.cxf.binding.soap.model.SoapBodyInfo;
import org.apache.cxf.binding.soap.model.SoapHeaderInfo;
import org.apache.cxf.binding.soap.model.SoapOperationInfo;
import org.apache.cxf.binding.soap.saaj.SAAJFactoryResolver;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.binding.soap.saaj.SAAJOutInterceptor;
import org.apache.cxf.binding.soap.saaj.SAAJStreamWriter;
import org.apache.cxf.binding.soap.saaj.SAAJUtils;
import org.apache.cxf.binding.soap.spring.SoapBindingInfoConfigBeanDefinitionParser;
import org.apache.cxf.binding.soap.spring.SoapVersionRegistrar;
import org.apache.cxf.binding.soap.wsdl.extensions.SoapAddress;
import org.apache.cxf.binding.soap.wsdl.extensions.SoapBody;
import org.apache.cxf.binding.soap.wsdl.extensions.SoapHeaderFault;
import org.apache.cxf.binding.soap.wsdl.extensions.SoapOperation;
import org.apache.cxf.binding.soap.wsdl11.SoapAddressPlugin;
import org.apache.cxf.binding.xml.XMLBinding;
import org.apache.cxf.binding.xml.XMLBindingFactory;
import org.apache.cxf.binding.xml.XMLConstants;
import org.apache.cxf.binding.xml.XMLFault;
import org.apache.cxf.binding.xml.XMLFormatValidator;
import org.apache.cxf.binding.xml.interceptor.XMLFaultInInterceptor;
import org.apache.cxf.binding.xml.interceptor.XMLFaultOutInterceptor;
import org.apache.cxf.binding.xml.interceptor.XMLMessageInInterceptor;
import org.apache.cxf.binding.xml.interceptor.XMLMessageOutInterceptor;
import org.apache.cxf.binding.xml.wsdl11.HttpAddressPlugin;
import org.apache.cxf.binding.xml.wsdl11.XMLWSDLExtensionLoader;
import org.apache.cxf.binding.xml.wsdl11.XmlBindingPlugin;
import org.apache.cxf.binding.xml.wsdl11.XmlIoPlugin;
import org.apache.cxf.bindings.xformat.XMLBindingMessageFormat;
import org.apache.cxf.bindings.xformat.XMLFormatBinding;
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
import org.apache.cxf.bus.resource.ResourceManagerImpl;
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
import org.apache.cxf.databinding.stax.StaxDataBinding;
import org.apache.cxf.databinding.stax.StaxDataBindingFeature;
import org.apache.cxf.databinding.stax.StaxDataBindingInterceptor;
import org.apache.cxf.databinding.stax.XMLStreamWriterCallback;
import org.apache.cxf.endpoint.AbstractConduitSelector;
import org.apache.cxf.endpoint.AbstractEndpointFactory;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.ClientCallback;
import org.apache.cxf.endpoint.ClientImpl;
import org.apache.cxf.endpoint.ClientLifeCycleListener;
import org.apache.cxf.endpoint.ClientLifeCycleManager;
import org.apache.cxf.endpoint.ConduitSelector;
import org.apache.cxf.endpoint.ConduitSelectorHolder;
import org.apache.cxf.endpoint.DeferredConduitSelector;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.endpoint.EndpointException;
import org.apache.cxf.endpoint.EndpointImpl;
import org.apache.cxf.endpoint.EndpointImplFactory;
import org.apache.cxf.endpoint.EndpointResolver;
import org.apache.cxf.endpoint.EndpointResolverRegistry;
import org.apache.cxf.endpoint.ManagedEndpoint;
import org.apache.cxf.endpoint.NullConduitSelector;
import org.apache.cxf.endpoint.PreexistingConduitSelector;
import org.apache.cxf.endpoint.Retryable;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.endpoint.ServerImpl;
import org.apache.cxf.endpoint.ServerLifeCycleListener;
import org.apache.cxf.endpoint.ServerLifeCycleManager;
import org.apache.cxf.endpoint.ServerRegistry;
import org.apache.cxf.endpoint.ServiceContractResolver;
import org.apache.cxf.endpoint.ServiceContractResolverRegistry;
import org.apache.cxf.endpoint.SimpleEndpointImplFactory;
import org.apache.cxf.endpoint.UpfrontConduitSelector;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;
import org.apache.cxf.endpoint.dynamic.TypeClassInitializer;
import org.apache.cxf.extension.BusExtension;
import org.apache.cxf.extension.Registry;
import org.apache.cxf.extension.RegistryImpl;
import org.apache.cxf.feature.AbstractFeature;
import org.apache.cxf.feature.FastInfosetFeature;
import org.apache.cxf.feature.Feature;
import org.apache.cxf.feature.Features;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.feature.StaxTransformFeature;
import org.apache.cxf.feature.WrappedFeature;
import org.apache.cxf.feature.transform.AbstractXSLTInterceptor;
import org.apache.cxf.feature.transform.XSLTFeature;
import org.apache.cxf.feature.transform.XSLTInInterceptor;
import org.apache.cxf.feature.transform.XSLTOutInterceptor;
import org.apache.cxf.feature.transform.XSLTUtils;
import org.apache.cxf.feature.validation.DefaultSchemaValidationTypeProvider;
import org.apache.cxf.feature.validation.SchemaValidationFeature;
import org.apache.cxf.feature.validation.SchemaValidationTypeProvider;
import org.apache.cxf.frontend.AbstractServiceFactory;
import org.apache.cxf.frontend.AbstractWSDLBasedEndpointFactory;
import org.apache.cxf.frontend.ClientFactoryBean;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.apache.cxf.frontend.FaultInfoException;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.frontend.WSDLGetInterceptor;
import org.apache.cxf.frontend.WSDLGetOutInterceptor;
import org.apache.cxf.frontend.WSDLGetUtils;
import org.apache.cxf.frontend.WSDLQueryException;
import org.apache.cxf.frontend.blueprint.Activator;
import org.apache.cxf.frontend.blueprint.ClientProxyFactoryBeanDefinitionParser;
import org.apache.cxf.frontend.blueprint.ServerFactoryBeanDefinitionParser;
import org.apache.cxf.frontend.blueprint.SimpleBPNamespaceHandler;
import org.apache.cxf.frontend.spring.NamespaceHandler;
import org.apache.cxf.headers.Header;
import org.apache.cxf.headers.HeaderManager;
import org.apache.cxf.headers.HeaderProcessor;
import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.helpers.FileUtils;
import org.apache.cxf.helpers.HttpHeaderHelper;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.helpers.JavaUtils;
import org.apache.cxf.helpers.LoadingByteArrayOutputStream;
import org.apache.cxf.helpers.MapNamespaceContext;
import org.apache.cxf.helpers.NSDecl;
import org.apache.cxf.helpers.NSStack;
import org.apache.cxf.helpers.ServiceUtils;
import org.apache.cxf.helpers.XPathUtils;
import org.apache.cxf.interceptor.AbstractAttributedInterceptorProvider;
import org.apache.cxf.interceptor.AbstractBasicInterceptorProvider;
import org.apache.cxf.interceptor.AbstractFaultChainInitiatorObserver;
import org.apache.cxf.interceptor.AbstractInDatabindingInterceptor;
import org.apache.cxf.interceptor.AbstractLoggingInterceptor;
import org.apache.cxf.interceptor.AbstractOutDatabindingInterceptor;
import org.apache.cxf.interceptor.AnnotationInterceptors;
import org.apache.cxf.interceptor.AttachmentInInterceptor;
import org.apache.cxf.interceptor.AttachmentOutInterceptor;
import org.apache.cxf.interceptor.ClientFaultConverter;
import org.apache.cxf.interceptor.ClientOutFaultObserver;
import org.apache.cxf.interceptor.FIStaxInInterceptor;
import org.apache.cxf.interceptor.FIStaxOutInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.FaultOutInterceptor;
import org.apache.cxf.interceptor.InFaultChainInitiatorObserver;
import org.apache.cxf.interceptor.InFaultInterceptors;
import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.InterceptorChain;
import org.apache.cxf.interceptor.InterceptorProvider;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.interceptor.MessageSenderInterceptor;
import org.apache.cxf.interceptor.OneWayProcessorInterceptor;
import org.apache.cxf.interceptor.OutFaultChainInitiatorObserver;
import org.apache.cxf.interceptor.OutFaultInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;
import org.apache.cxf.interceptor.OutgoingChainInterceptor;
import org.apache.cxf.interceptor.ServiceInvokerInterceptor;
import org.apache.cxf.interceptor.StaxInEndingInterceptor;
import org.apache.cxf.interceptor.StaxInInterceptor;
import org.apache.cxf.interceptor.StaxOutEndingInterceptor;
import org.apache.cxf.interceptor.StaxOutInterceptor;
import org.apache.cxf.interceptor.security.AbstractAuthorizingInInterceptor;
import org.apache.cxf.interceptor.security.AbstractSecurityContextInInterceptor;
import org.apache.cxf.interceptor.security.AbstractUsernameTokenInInterceptor;
import org.apache.cxf.interceptor.security.AccessDeniedException;
import org.apache.cxf.interceptor.security.AuthenticationException;
import org.apache.cxf.interceptor.security.DefaultSecurityContext;
import org.apache.cxf.interceptor.security.DelegatingAuthenticationInterceptor;
import org.apache.cxf.interceptor.security.DepthRestrictingStreamInterceptor;
import org.apache.cxf.interceptor.security.JAASAuthenticationFeature;
import org.apache.cxf.interceptor.security.JAASLoginInterceptor;
import org.apache.cxf.interceptor.security.NamePasswordCallbackHandler;
import org.apache.cxf.interceptor.security.OperationInfoAuthorizingInterceptor;
import org.apache.cxf.interceptor.security.RolePrefixSecurityContextImpl;
import org.apache.cxf.interceptor.security.SecureAnnotationsInterceptor;
import org.apache.cxf.interceptor.security.SimpleAuthorizingInterceptor;
import org.apache.cxf.interceptor.security.callback.CallbackHandlerProvider;
import org.apache.cxf.interceptor.security.callback.CallbackHandlerProviderAuthPol;
import org.apache.cxf.interceptor.security.callback.CallbackHandlerProviderUsernameToken;
import org.apache.cxf.interceptor.security.callback.CallbackHandlerTlsCert;
import org.apache.cxf.interceptor.security.callback.CertKeyToUserNameMapper;
import org.apache.cxf.interceptor.security.callback.CertificateToNameMapper;
import org.apache.cxf.interceptor.security.callback.NameToPasswordMapper;
import org.apache.cxf.interceptor.transform.TransformInInterceptor;
import org.apache.cxf.interceptor.transform.TransformOutInterceptor;
import org.apache.cxf.io.AbstractThresholdOutputStream;
import org.apache.cxf.io.AbstractWrappedOutputStream;
import org.apache.cxf.io.CacheAndWriteOutputStream;
import org.apache.cxf.io.CacheSizeExceededException;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.io.CachedOutputStreamCallback;
import org.apache.cxf.io.CachedWriter;
import org.apache.cxf.io.CachedWriterCallback;
import org.apache.cxf.io.CipherPair;
import org.apache.cxf.io.CopyingOutputStream;
import org.apache.cxf.io.Transferable;
import org.apache.cxf.io.WriteOnCloseOutputStream;
import org.apache.cxf.jaxb.DatatypeFactory;
import org.apache.cxf.jaxb.JAXBDataBase;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.jaxb.JAXBEncoderDecoder;
import org.apache.cxf.jaxb.JAXBWrapperHelper;
import org.apache.cxf.jaxb.MarshallerAwareXMLWriter;
import org.apache.cxf.jaxb.MarshallerEventHandler;
import org.apache.cxf.jaxb.UnmarshallerAwareXMLReader;
import org.apache.cxf.jaxb.UnmarshallerEventHandler;
import org.apache.cxf.jaxb.attachment.JAXBAttachmentMarshaller;
import org.apache.cxf.jaxb.attachment.JAXBAttachmentSchemaValidationHack;
import org.apache.cxf.jaxb.attachment.JAXBAttachmentUnmarshaller;
import org.apache.cxf.jaxb.io.DataReaderImpl;
import org.apache.cxf.jaxb.io.DataWriterImpl;
import org.apache.cxf.logging.FaultListener;
import org.apache.cxf.logging.NoOpFaultListener;
import org.apache.cxf.management.InstrumentationManager;
import org.apache.cxf.management.ManagedComponent;
import org.apache.cxf.management.ManagementConstants;
import org.apache.cxf.management.annotation.ManagedAttribute;
import org.apache.cxf.management.annotation.ManagedNotification;
import org.apache.cxf.management.annotation.ManagedNotifications;
import org.apache.cxf.management.annotation.ManagedOperation;
import org.apache.cxf.management.annotation.ManagedOperationParameter;
import org.apache.cxf.management.annotation.ManagedOperationParameters;
import org.apache.cxf.management.annotation.ManagedResource;
import org.apache.cxf.message.AbstractWrappedMessage;
import org.apache.cxf.message.Attachment;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.ExchangeImpl;
import org.apache.cxf.message.FaultMode;
import org.apache.cxf.message.MessageContentsList;
import org.apache.cxf.message.MessageImpl;
import org.apache.cxf.message.MessageUtils;
import org.apache.cxf.message.StringMap;
import org.apache.cxf.message.StringMapImpl;
import org.apache.cxf.message.XMLMessage;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.phase.PhaseChainCache;
import org.apache.cxf.phase.PhaseComparator;
import org.apache.cxf.phase.PhaseInterceptor;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.phase.PhaseManager;
import org.apache.cxf.policy.PolicyCalculator;
import org.apache.cxf.policy.PolicyDataEngine;
import org.apache.cxf.resource.ClassLoaderResolver;
import org.apache.cxf.resource.ClasspathResolver;
import org.apache.cxf.resource.DefaultResourceManager;
import org.apache.cxf.resource.ExtendedURIResolver;
import org.apache.cxf.resource.ObjectTypeResolver;
import org.apache.cxf.resource.PropertiesResolver;
import org.apache.cxf.resource.ResourceManager;
import org.apache.cxf.resource.ResourceResolver;
import org.apache.cxf.resource.SinglePropertyResolver;
import org.apache.cxf.resource.URIResolver;
import org.apache.cxf.rt.security.claims.ClaimCollection;
import org.apache.cxf.rt.security.claims.ClaimsSecurityContext;
import org.apache.cxf.rt.security.crypto.BouncyCastleInstaller;
import org.apache.cxf.rt.security.crypto.CryptoUtils;
import org.apache.cxf.rt.security.crypto.HmacUtils;
import org.apache.cxf.rt.security.crypto.KeyProperties;
import org.apache.cxf.rt.security.crypto.MessageDigestUtils;
import org.apache.cxf.rt.security.saml.claims.ClaimBean;
import org.apache.cxf.rt.security.saml.claims.SAMLClaim;
import org.apache.cxf.rt.security.saml.claims.SAMLSecurityContext;
import org.apache.cxf.rt.security.saml.interceptor.ClaimsAuthorizingInterceptor;
import org.apache.cxf.rt.security.saml.interceptor.WSS4JBasicAuthValidator;
import org.apache.cxf.rt.security.saml.utils.SAMLUtils;
import org.apache.cxf.rt.security.saml.xacml.CXFMessageParser;
import org.apache.cxf.rt.security.saml.xacml.XACMLConstants;
import org.apache.cxf.rt.security.saml.xacml2.AbstractXACMLAuthorizingInterceptor;
import org.apache.cxf.rt.security.saml.xacml2.DefaultXACMLRequestBuilder;
import org.apache.cxf.rt.security.saml.xacml2.PolicyDecisionPoint;
import org.apache.cxf.rt.security.saml.xacml2.RequestComponentBuilder;
import org.apache.cxf.rt.security.saml.xacml2.SamlRequestComponentBuilder;
import org.apache.cxf.rt.security.saml.xacml2.XACMLAuthorizingInterceptor;
import org.apache.cxf.rt.security.saml.xacml2.XACMLRequestBuilder;
import org.apache.cxf.rt.security.utils.SecurityUtils;
import org.apache.cxf.security.LoginSecurityContext;
import org.apache.cxf.security.SecurityContext;
import org.apache.cxf.security.claims.authorization.Claim;
import org.apache.cxf.security.claims.authorization.ClaimMode;
import org.apache.cxf.security.claims.authorization.Claims;
import org.apache.cxf.security.transport.TLSSessionInfo;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.ServiceBuilder;
import org.apache.cxf.service.ServiceImpl;
import org.apache.cxf.service.ServiceModelSchemaValidator;
import org.apache.cxf.service.ServiceModelVisitor;
import org.apache.cxf.service.factory.AbstractServiceFactoryBean;
import org.apache.cxf.service.factory.AnnotationsFactoryBeanListener;
import org.apache.cxf.service.factory.FactoryBeanListener;
import org.apache.cxf.service.factory.FactoryBeanListenerManager;
import org.apache.cxf.service.factory.ServiceConstructionException;
import org.apache.cxf.service.factory.SimpleMethodDispatcher;
import org.apache.cxf.service.invoker.AbstractInvoker;
import org.apache.cxf.service.invoker.BeanInvoker;
import org.apache.cxf.service.invoker.Factory;
import org.apache.cxf.service.invoker.FactoryInvoker;
import org.apache.cxf.service.invoker.Invoker;
import org.apache.cxf.service.invoker.MethodDispatcher;
import org.apache.cxf.service.invoker.PerRequestFactory;
import org.apache.cxf.service.invoker.PooledFactory;
import org.apache.cxf.service.invoker.SessionFactory;
import org.apache.cxf.service.invoker.SingletonFactory;
import org.apache.cxf.service.model.AbstractDescriptionElement;
import org.apache.cxf.service.model.AbstractMessageContainer;
import org.apache.cxf.service.model.AbstractPropertiesHolder;
import org.apache.cxf.service.model.BindingFaultInfo;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.BindingMessageInfo;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.service.model.DescriptionInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.Extensible;
import org.apache.cxf.service.model.FaultInfo;
import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.MessagePartInfo;
import org.apache.cxf.service.model.NamedItem;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.cxf.service.model.SchemaInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.service.model.ServiceModelUtil;
import org.apache.cxf.service.model.ServiceSchemaInfo;
import org.apache.cxf.service.model.UnwrappedOperationInfo;
import org.apache.cxf.simple.SimpleServiceBuilder;
import org.apache.cxf.staxutils.AbstractDOMStreamReader;
import org.apache.cxf.staxutils.CachingXmlEventWriter;
import org.apache.cxf.staxutils.DelegatingXMLStreamWriter;
import org.apache.cxf.staxutils.DepthExceededStaxException;
import org.apache.cxf.staxutils.DepthRestrictingStreamReader;
import org.apache.cxf.staxutils.DepthXMLStreamReader;
import org.apache.cxf.staxutils.DocumentDepthProperties;
import org.apache.cxf.staxutils.FastStack;
import org.apache.cxf.staxutils.FragmentStreamReader;
import org.apache.cxf.staxutils.OverlayW3CDOMStreamWriter;
import org.apache.cxf.staxutils.PartialXMLStreamReader;
import org.apache.cxf.staxutils.PrettyPrintXMLStreamWriter;
import org.apache.cxf.staxutils.PropertiesExpandingStreamReader;
import org.apache.cxf.staxutils.StaxSource;
import org.apache.cxf.staxutils.StaxStreamFilter;
import org.apache.cxf.staxutils.StaxUtils;
import org.apache.cxf.staxutils.StreamWriterContentHandler;
import org.apache.cxf.staxutils.W3CDOMStreamReader;
import org.apache.cxf.staxutils.W3CDOMStreamWriter;
import org.apache.cxf.staxutils.W3CNamespaceContext;
import org.apache.cxf.staxutils.XMLStreamReaderWrapper;
import org.apache.cxf.staxutils.transform.DelegatingNamespaceContext;
import org.apache.cxf.staxutils.transform.IgnoreNamespacesWriter;
import org.apache.cxf.staxutils.transform.InTransformReader;
import org.apache.cxf.staxutils.transform.OutTransformWriter;
import org.apache.cxf.staxutils.transform.TransformUtils;
import org.apache.cxf.transport.AbstractConduit;
import org.apache.cxf.transport.AbstractDestination;
import org.apache.cxf.transport.AbstractMultiplexDestination;
import org.apache.cxf.transport.AbstractObservable;
import org.apache.cxf.transport.AbstractTransportFactory;
import org.apache.cxf.transport.Assertor;
import org.apache.cxf.transport.ChainInitiationObserver;
import org.apache.cxf.transport.Conduit;
import org.apache.cxf.transport.ConduitInitiator;
import org.apache.cxf.transport.ConduitInitiatorManager;
import org.apache.cxf.transport.Destination;
import org.apache.cxf.transport.DestinationFactory;
import org.apache.cxf.transport.DestinationFactoryManager;
import org.apache.cxf.transport.DestinationWithEndpoint;
import org.apache.cxf.transport.HttpUriMapper;
import org.apache.cxf.transport.MessageObserver;
import org.apache.cxf.transport.MultipleEndpointObserver;
import org.apache.cxf.transport.MultiplexDestination;
import org.apache.cxf.transport.Observable;
import org.apache.cxf.transport.Session;
import org.apache.cxf.transport.TransportFinder;
import org.apache.cxf.transport.TransportURIResolver;
import org.apache.cxf.transport.common.gzip.GZIPFeature;
import org.apache.cxf.transport.common.gzip.GZIPInInterceptor;
import org.apache.cxf.transport.common.gzip.GZIPOutInterceptor;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.cxf.transport.http.Address;
import org.apache.cxf.transport.http.CXFAuthenticator;
import org.apache.cxf.transport.http.ContinuationProviderFactory;
import org.apache.cxf.transport.http.Cookie;
import org.apache.cxf.transport.http.Cookies;
import org.apache.cxf.transport.http.DestinationRegistry;
import org.apache.cxf.transport.http.DestinationRegistryImpl;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transport.http.HTTPConduitConfigurer;
import org.apache.cxf.transport.http.HTTPConduitFactory;
import org.apache.cxf.transport.http.HTTPException;
import org.apache.cxf.transport.http.HTTPSession;
import org.apache.cxf.transport.http.HTTPTransportFactory;
import org.apache.cxf.transport.http.HTTPWSDLExtensionLoader;
import org.apache.cxf.transport.http.Headers;
import org.apache.cxf.transport.http.HttpAuthenticationFaultHandler;
import org.apache.cxf.transport.http.HttpDestinationFactory;
import org.apache.cxf.transport.http.HttpServletRequestSnapshot;
import org.apache.cxf.transport.http.HttpURLConnectionInfo;
import org.apache.cxf.transport.http.HttpUrlUtil;
import org.apache.cxf.transport.http.MessageTrustDecider;
import org.apache.cxf.transport.http.PatternBuilder;
import org.apache.cxf.transport.http.ProxyFactory;
import org.apache.cxf.transport.http.ReferencingAuthenticator;
import org.apache.cxf.transport.http.Servlet3ContinuationProvider;
import org.apache.cxf.transport.http.URLConnectionHTTPConduit;
import org.apache.cxf.transport.http.URLConnectionInfo;
import org.apache.cxf.transport.http.UntrustedURLConnectionIOException;
import org.apache.cxf.transport.http.auth.AbstractSpnegoAuthSupplier;
import org.apache.cxf.transport.http.auth.DefaultBasicAuthSupplier;
import org.apache.cxf.transport.http.auth.DigestAuthSupplier;
import org.apache.cxf.transport.http.auth.HttpAuthHeader;
import org.apache.cxf.transport.http.auth.HttpAuthSupplier;
import org.apache.cxf.transport.http.auth.SpnegoAuthSupplier;
import org.apache.cxf.transport.http.auth.WSDLGetAuthenticatorInterceptor;
import org.apache.cxf.transport.http.blueprint.HttpBPHandler;
import org.apache.cxf.transport.http.blueprint.HttpConduitBPBeanDefinitionParser;
import org.apache.cxf.transport.http.blueprint.HttpDestinationBPBeanDefinitionParser;
import org.apache.cxf.transport.http.osgi.HTTPTransportActivator;
import org.apache.cxf.transport.http.policy.HTTPClientAssertionBuilder;
import org.apache.cxf.transport.http.policy.HTTPServerAssertionBuilder;
import org.apache.cxf.transport.http.policy.NoOpPolicyInterceptorProvider;
import org.apache.cxf.transport.http.policy.impl.ClientPolicyCalculator;
import org.apache.cxf.transport.http.policy.impl.ServerPolicyCalculator;
import org.apache.cxf.transport.http.spring.HttpAuthSupplierBeanDefinitionParser;
import org.apache.cxf.transport.http.spring.HttpConduitBeanDefinitionParser;
import org.apache.cxf.transport.http.spring.HttpDestinationBeanDefinitionParser;
import org.apache.cxf.transport.http.spring.MessageTrustDeciderBeanDefinitionParser;
import org.apache.cxf.transport.https.AliasedX509ExtendedKeyManager;
import org.apache.cxf.transport.https.CertConstraints;
import org.apache.cxf.transport.https.CertConstraintsFeature;
import org.apache.cxf.transport.https.CertConstraintsInterceptor;
import org.apache.cxf.transport.https.CertConstraintsJaxBUtils;
import org.apache.cxf.transport.https.HttpsURLConnectionFactory;
import org.apache.cxf.transport.https.HttpsURLConnectionInfo;
import org.apache.cxf.transport.https.httpclient.DefaultHostnameVerifier;
import org.apache.cxf.transport.https.httpclient.DomainType;
import org.apache.cxf.transport.https.httpclient.InetAddressUtils;
import org.apache.cxf.transport.https.httpclient.PublicSuffixList;
import org.apache.cxf.transport.https.httpclient.PublicSuffixListParser;
import org.apache.cxf.transport.https.httpclient.PublicSuffixMatcher;
import org.apache.cxf.transport.https.httpclient.PublicSuffixMatcherLoader;
import org.apache.cxf.transport.local.LocalConduit;
import org.apache.cxf.transport.local.LocalDestination;
import org.apache.cxf.transport.local.LocalTransportFactory;
import org.apache.cxf.transport.servlet.AbstractHTTPServlet;
import org.apache.cxf.transport.servlet.BaseUrlHelper;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.apache.cxf.transport.servlet.ServletContextResourceResolver;
import org.apache.cxf.transport.servlet.ServletController;
import org.apache.cxf.transport.servlet.ServletDestination;
import org.apache.cxf.transport.servlet.ServletDestinationFactory;
import org.apache.cxf.transport.servlet.blueprint.CXFBlueprintServlet;
import org.apache.cxf.transport.servlet.servicelist.FormattedServiceListWriter;
import org.apache.cxf.transport.servlet.servicelist.ServiceListGeneratorServlet;
import org.apache.cxf.transport.servlet.servicelist.ServiceListJAASAuthenticator;
import org.apache.cxf.transport.servlet.servicelist.ServiceListWriter;
import org.apache.cxf.transport.servlet.servicelist.UnformattedServiceListWriter;
import org.apache.cxf.transports.http.configuration.ConnectionType;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.transports.http.configuration.HTTPServerPolicy;
import org.apache.cxf.transports.http.configuration.ProxyServerType;
import org.apache.cxf.validation.AbstractValidationInterceptor;
import org.apache.cxf.validation.BeanValidationFeature;
import org.apache.cxf.validation.BeanValidationInInterceptor;
import org.apache.cxf.validation.BeanValidationOutInterceptor;
import org.apache.cxf.validation.BeanValidationProvider;
import org.apache.cxf.validation.ResponseConstraintViolationException;
import org.apache.cxf.validation.ValidationConfiguration;
import org.apache.cxf.version.Version;
import org.apache.cxf.workqueue.AutomaticWorkQueue;
import org.apache.cxf.workqueue.AutomaticWorkQueueImpl;
import org.apache.cxf.workqueue.OneShotAsyncExecutor;
import org.apache.cxf.workqueue.SynchronousExecutor;
import org.apache.cxf.workqueue.WorkQueue;
import org.apache.cxf.workqueue.WorkQueueManager;
import org.apache.cxf.ws.addressing.AddressingConstants;
import org.apache.cxf.ws.addressing.AddressingProperties;
import org.apache.cxf.ws.addressing.AttributedAnyType;
import org.apache.cxf.ws.addressing.AttributedQNameType;
import org.apache.cxf.ws.addressing.AttributedURIType;
import org.apache.cxf.ws.addressing.AttributedUnsignedLongType;
import org.apache.cxf.ws.addressing.ContextUtils;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.apache.cxf.ws.addressing.EndpointReferenceUtils;
import org.apache.cxf.ws.addressing.EndpointUtilsException;
import org.apache.cxf.ws.addressing.FaultAction;
import org.apache.cxf.ws.addressing.JAXWSAConstants;
import org.apache.cxf.ws.addressing.MAPAggregator;
import org.apache.cxf.ws.addressing.MessageIdCache;
import org.apache.cxf.ws.addressing.MetadataType;
import org.apache.cxf.ws.addressing.Names;
import org.apache.cxf.ws.addressing.ProblemActionType;
import org.apache.cxf.ws.addressing.ReferenceParametersType;
import org.apache.cxf.ws.addressing.RelatesToType;
import org.apache.cxf.ws.addressing.VersionTransformer;
import org.apache.cxf.ws.addressing.WSAContextUtils;
import org.apache.cxf.ws.addressing.WSAddressingFeature;
import org.apache.cxf.ws.addressing.blueprint.WsBPHandler;
import org.apache.cxf.ws.addressing.impl.AddressingFeatureApplier;
import org.apache.cxf.ws.addressing.impl.AddressingWSDLExtensionLoader;
import org.apache.cxf.ws.addressing.impl.DefaultMessageIdCache;
import org.apache.cxf.ws.addressing.impl.MAPAggregatorImpl;
import org.apache.cxf.ws.addressing.impl.MAPAggregatorImplLoader;
import org.apache.cxf.ws.addressing.policy.AddressingAssertionBuilder;
import org.apache.cxf.ws.addressing.policy.AddressingPolicyInterceptorProvider;
import org.apache.cxf.ws.addressing.policy.MetadataConstants;
import org.apache.cxf.ws.addressing.policy.UsingAddressingAssertionBuilder;
import org.apache.cxf.ws.addressing.soap.DecoupledFaultHandler;
import org.apache.cxf.ws.addressing.soap.MAPCodec;
import org.apache.cxf.ws.addressing.spring.AddressingBeanDefinitionParser;
import org.apache.cxf.ws.addressing.v200403.AttributedQName;
import org.apache.cxf.ws.addressing.v200403.AttributedURI;
import org.apache.cxf.ws.addressing.v200403.ReferencePropertiesType;
import org.apache.cxf.ws.addressing.v200403.Relationship;
import org.apache.cxf.ws.addressing.v200403.ReplyAfterType;
import org.apache.cxf.ws.addressing.v200403.ServiceNameType;
import org.apache.cxf.ws.addressing.wsdl.Anonymous;
import org.apache.cxf.ws.addressing.wsdl.AnonymousType;
import org.apache.cxf.ws.addressing.wsdl.UsingAddressing;
import org.apache.cxf.ws.security.SecurityConstants;
import org.apache.cxf.ws.security.cache.CXFEHCacheReplayCache;
import org.apache.cxf.ws.security.cache.CacheCleanupListener;
import org.apache.cxf.ws.security.cache.EHCacheUtils;
import org.apache.cxf.ws.security.kerberos.KerberosClient;
import org.apache.cxf.ws.security.kerberos.KerberosUtils;
import org.apache.cxf.ws.security.policy.PolicyUtils;
import org.apache.cxf.ws.security.policy.WSSecurityPolicyLoader;
import org.apache.cxf.ws.security.policy.custom.AlgorithmSuiteBuilder;
import org.apache.cxf.ws.security.policy.custom.AlgorithmSuiteLoader;
import org.apache.cxf.ws.security.policy.custom.DefaultAlgorithmSuiteLoader;
import org.apache.cxf.ws.security.policy.interceptors.HttpsTokenInterceptorProvider;
import org.apache.cxf.ws.security.policy.interceptors.IssuedTokenInterceptorProvider;
import org.apache.cxf.ws.security.policy.interceptors.KerberosTokenInterceptorProvider;
import org.apache.cxf.ws.security.policy.interceptors.STSTokenOutInterceptor;
import org.apache.cxf.ws.security.policy.interceptors.SamlTokenInterceptorProvider;
import org.apache.cxf.ws.security.policy.interceptors.SecureConversationTokenInterceptorProvider;
import org.apache.cxf.ws.security.policy.interceptors.SecurityVerificationOutInterceptor;
import org.apache.cxf.ws.security.policy.interceptors.SpnegoTokenInterceptorProvider;
import org.apache.cxf.ws.security.policy.interceptors.UsernameTokenInterceptorProvider;
import org.apache.cxf.ws.security.policy.interceptors.WSSecurityInterceptorProvider;
import org.apache.cxf.ws.security.policy.interceptors.WSSecurityPolicyInterceptorProvider;
import org.apache.cxf.ws.security.sts.provider.STSException;
import org.apache.cxf.ws.security.sts.provider.SecurityTokenService;
import org.apache.cxf.ws.security.sts.provider.SecurityTokenServiceImpl;
import org.apache.cxf.ws.security.sts.provider.SecurityTokenServiceProvider;
import org.apache.cxf.ws.security.sts.provider.model.AllowPostdatingType;
import org.apache.cxf.ws.security.sts.provider.model.AuthenticatorType;
import org.apache.cxf.ws.security.sts.provider.model.BinaryExchangeType;
import org.apache.cxf.ws.security.sts.provider.model.BinarySecretType;
import org.apache.cxf.ws.security.sts.provider.model.CancelTargetType;
import org.apache.cxf.ws.security.sts.provider.model.ClaimsType;
import org.apache.cxf.ws.security.sts.provider.model.DelegateToType;
import org.apache.cxf.ws.security.sts.provider.model.EncryptionType;
import org.apache.cxf.ws.security.sts.provider.model.EntropyType;
import org.apache.cxf.ws.security.sts.provider.model.KeyExchangeTokenType;
import org.apache.cxf.ws.security.sts.provider.model.LifetimeType;
import org.apache.cxf.ws.security.sts.provider.model.OnBehalfOfType;
import org.apache.cxf.ws.security.sts.provider.model.ParticipantType;
import org.apache.cxf.ws.security.sts.provider.model.ParticipantsType;
import org.apache.cxf.ws.security.sts.provider.model.ProofEncryptionType;
import org.apache.cxf.ws.security.sts.provider.model.RenewTargetType;
import org.apache.cxf.ws.security.sts.provider.model.RenewingType;
import org.apache.cxf.ws.security.sts.provider.model.RequestKETType;
import org.apache.cxf.ws.security.sts.provider.model.RequestSecurityTokenCollectionType;
import org.apache.cxf.ws.security.sts.provider.model.RequestSecurityTokenResponseCollectionType;
import org.apache.cxf.ws.security.sts.provider.model.RequestSecurityTokenResponseType;
import org.apache.cxf.ws.security.sts.provider.model.RequestSecurityTokenType;
import org.apache.cxf.ws.security.sts.provider.model.RequestedProofTokenType;
import org.apache.cxf.ws.security.sts.provider.model.RequestedReferenceType;
import org.apache.cxf.ws.security.sts.provider.model.RequestedSecurityTokenType;
import org.apache.cxf.ws.security.sts.provider.model.RequestedTokenCancelledType;
import org.apache.cxf.ws.security.sts.provider.model.SignChallengeType;
import org.apache.cxf.ws.security.sts.provider.model.StatusType;
import org.apache.cxf.ws.security.sts.provider.model.UseKeyType;
import org.apache.cxf.ws.security.sts.provider.model.ValidateTargetType;
import org.apache.cxf.ws.security.sts.provider.model.secext.AttributedString;
import org.apache.cxf.ws.security.sts.provider.model.secext.BinarySecurityTokenType;
import org.apache.cxf.ws.security.sts.provider.model.secext.EmbeddedType;
import org.apache.cxf.ws.security.sts.provider.model.secext.EncodedString;
import org.apache.cxf.ws.security.sts.provider.model.secext.KeyIdentifierType;
import org.apache.cxf.ws.security.sts.provider.model.secext.PasswordString;
import org.apache.cxf.ws.security.sts.provider.model.secext.ReferenceType;
import org.apache.cxf.ws.security.sts.provider.model.secext.SecurityHeaderType;
import org.apache.cxf.ws.security.sts.provider.model.secext.SecurityTokenReferenceType;
import org.apache.cxf.ws.security.sts.provider.model.secext.TransformationParametersType;
import org.apache.cxf.ws.security.sts.provider.model.secext.UsernameTokenType;
import org.apache.cxf.ws.security.sts.provider.model.utility.AttributedDateTime;
import org.apache.cxf.ws.security.sts.provider.model.utility.TimestampType;
import org.apache.cxf.ws.security.sts.provider.model.wstrust14.ActAsType;
import org.apache.cxf.ws.security.sts.provider.model.wstrust14.ChoiceChallengeResponseType;
import org.apache.cxf.ws.security.sts.provider.model.wstrust14.ChoiceChallengeType;
import org.apache.cxf.ws.security.sts.provider.model.wstrust14.ChoiceSelectedType;
import org.apache.cxf.ws.security.sts.provider.model.wstrust14.ChoiceType;
import org.apache.cxf.ws.security.sts.provider.model.wstrust14.ContextDataType;
import org.apache.cxf.ws.security.sts.provider.model.wstrust14.ImageType;
import org.apache.cxf.ws.security.sts.provider.model.wstrust14.InteractiveChallengeResponseType;
import org.apache.cxf.ws.security.sts.provider.model.wstrust14.InteractiveChallengeType;
import org.apache.cxf.ws.security.sts.provider.model.wstrust14.TextChallengeResponseType;
import org.apache.cxf.ws.security.sts.provider.model.wstrust14.TextChallengeType;
import org.apache.cxf.ws.security.sts.provider.model.wstrust14.TitleType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.CanonicalizationMethodType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.DSAKeyValueType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.DigestMethodType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.KeyInfoType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.KeyValueType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.ManifestType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.ObjectType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.PGPDataType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.RSAKeyValueType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.RetrievalMethodType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.SPKIDataType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.SignatureMethodType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.SignaturePropertiesType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.SignaturePropertyType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.SignatureType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.SignatureValueType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.SignedInfoType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.TransformType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.TransformsType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.X509DataType;
import org.apache.cxf.ws.security.sts.provider.model.xmldsig.X509IssuerSerialType;
import org.apache.cxf.ws.security.sts.provider.operation.CancelOperation;
import org.apache.cxf.ws.security.sts.provider.operation.IssueOperation;
import org.apache.cxf.ws.security.sts.provider.operation.IssueSingleOperation;
import org.apache.cxf.ws.security.sts.provider.operation.KeyExchangeTokenOperation;
import org.apache.cxf.ws.security.sts.provider.operation.RenewOperation;
import org.apache.cxf.ws.security.sts.provider.operation.RequestCollectionOperation;
import org.apache.cxf.ws.security.sts.provider.operation.ValidateOperation;
import org.apache.cxf.ws.security.tokenstore.EHCacheTokenStore;
import org.apache.cxf.ws.security.tokenstore.EHCacheTokenStoreFactory;
import org.apache.cxf.ws.security.tokenstore.MemoryTokenStore;
import org.apache.cxf.ws.security.tokenstore.MemoryTokenStoreFactory;
import org.apache.cxf.ws.security.tokenstore.TokenStore;
import org.apache.cxf.ws.security.tokenstore.TokenStoreFactory;
import org.apache.cxf.ws.security.tokenstore.TokenStoreUtils;
import org.apache.cxf.ws.security.trust.AbstractSTSClient;
import org.apache.cxf.ws.security.trust.AuthPolicyValidatingInterceptor;
import org.apache.cxf.ws.security.trust.DefaultSymmetricBinding;
import org.apache.cxf.ws.security.trust.STSClient;
import org.apache.cxf.ws.security.trust.STSLoginModule;
import org.apache.cxf.ws.security.trust.STSSamlAssertionValidator;
import org.apache.cxf.ws.security.trust.STSStaxTokenValidator;
import org.apache.cxf.ws.security.trust.STSTokenRetriever;
import org.apache.cxf.ws.security.trust.STSTokenValidator;
import org.apache.cxf.ws.security.trust.STSUtils;
import org.apache.cxf.ws.security.trust.TrustException;
import org.apache.cxf.ws.security.trust.claims.ClaimsCallback;
import org.apache.cxf.ws.security.trust.claims.RoleClaimsCallbackHandler;
import org.apache.cxf.ws.security.trust.delegation.DelegationCallback;
import org.apache.cxf.ws.security.trust.delegation.ReceivedTokenCallbackHandler;
import org.apache.cxf.ws.security.trust.delegation.WSSUsernameCallbackHandler;
import org.apache.cxf.ws.security.wss4j.AbstractTokenInterceptor;
import org.apache.cxf.ws.security.wss4j.AbstractUsernameTokenAuthenticatingInterceptor;
import org.apache.cxf.ws.security.wss4j.AbstractWSS4JInterceptor;
import org.apache.cxf.ws.security.wss4j.AbstractWSS4JStaxInterceptor;
import org.apache.cxf.ws.security.wss4j.AlgorithmSuiteTranslater;
import org.apache.cxf.ws.security.wss4j.AttachmentCallbackHandler;
import org.apache.cxf.ws.security.wss4j.BinarySecurityTokenInterceptor;
import org.apache.cxf.ws.security.wss4j.CXFCallbackLookup;
import org.apache.cxf.ws.security.wss4j.CXFRequestData;
import org.apache.cxf.ws.security.wss4j.CryptoCoverageChecker;
import org.apache.cxf.ws.security.wss4j.CryptoCoverageUtil;
import org.apache.cxf.ws.security.wss4j.DefaultCryptoCoverageChecker;
import org.apache.cxf.ws.security.wss4j.DefaultWSS4JSecurityContextCreator;
import org.apache.cxf.ws.security.wss4j.DelegatingCallbackHandler;
import org.apache.cxf.ws.security.wss4j.KerberosTokenInterceptor;
import org.apache.cxf.ws.security.wss4j.PolicyBasedWSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.PolicyBasedWSS4JOutInterceptor;
import org.apache.cxf.ws.security.wss4j.PolicyBasedWSS4JStaxInInterceptor;
import org.apache.cxf.ws.security.wss4j.PolicyBasedWSS4JStaxOutInterceptor;
import org.apache.cxf.ws.security.wss4j.SamlTokenInterceptor;
import org.apache.cxf.ws.security.wss4j.StaxActionInInterceptor;
import org.apache.cxf.ws.security.wss4j.StaxCryptoCoverageChecker;
import org.apache.cxf.ws.security.wss4j.StaxSecurityContextInInterceptor;
import org.apache.cxf.ws.security.wss4j.TokenStoreCallbackHandler;
import org.apache.cxf.ws.security.wss4j.UsernameTokenInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JPolicyAsserter;
import org.apache.cxf.ws.security.wss4j.WSS4JSecurityContextCreator;
import org.apache.cxf.ws.security.wss4j.WSS4JStaxInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JStaxOutInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JTokenConverter;
import org.apache.cxf.ws.security.wss4j.WSS4JUtils;
import org.apache.cxf.ws.security.wss4j.policyhandlers.AbstractBindingBuilder;
import org.apache.cxf.ws.security.wss4j.policyhandlers.AbstractCommonBindingHandler;
import org.apache.cxf.ws.security.wss4j.policyhandlers.AbstractStaxBindingHandler;
import org.apache.cxf.ws.security.wss4j.policyhandlers.AsymmetricBindingHandler;
import org.apache.cxf.ws.security.wss4j.policyhandlers.StaxAsymmetricBindingHandler;
import org.apache.cxf.ws.security.wss4j.policyhandlers.StaxSymmetricBindingHandler;
import org.apache.cxf.ws.security.wss4j.policyhandlers.StaxTransportBindingHandler;
import org.apache.cxf.ws.security.wss4j.policyhandlers.SymmetricBindingHandler;
import org.apache.cxf.ws.security.wss4j.policyhandlers.TransportBindingHandler;
import org.apache.cxf.ws.security.wss4j.policyhandlers.WSSecurityTokenHolder;
import org.apache.cxf.ws.security.wss4j.policyvalidators.AbstractBindingPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.AbstractSamlPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.AbstractSecurityPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.AbstractSupportingTokenPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.AlgorithmSuitePolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.AsymmetricBindingPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.ClaimsPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.ConcreteSupportingTokenPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.DefaultClaimsPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.EncryptedTokenPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.EndorsingEncryptedTokenPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.EndorsingTokenPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.IssuedTokenPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.KerberosTokenPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.LayoutPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.PolicyValidatorParameters;
import org.apache.cxf.ws.security.wss4j.policyvalidators.RequiredElementsPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.RequiredPartsPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.SamlTokenPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.SecuredElementsPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.SecuredPartsPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.SecurityContextTokenPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.SecurityPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.SignedEncryptedTokenPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.SignedEndorsingEncryptedTokenPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.SignedEndorsingTokenPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.SignedTokenPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.SymmetricBindingPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.TransportBindingPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.UsernameTokenPolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.ValidatorUtils;
import org.apache.cxf.ws.security.wss4j.policyvalidators.WSS11PolicyValidator;
import org.apache.cxf.ws.security.wss4j.policyvalidators.X509TokenPolicyValidator;
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
import org.apache.cxf.wsdl.http.AddressType;
import org.apache.cxf.wsdl.http.BindingType;
import org.apache.cxf.wsdl.http.OperationType;
import org.apache.cxf.wsdl.http.UrlEncoded;
import org.apache.cxf.wsdl.http.UrlReplacement;
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

public class Todos {

	public static void todoCore(N n) {

		Class<?>[] classes = new Class<?>[] {
				//
				Bus.class, BusException.class, BusFactory.class,
				//
				DataBinding.class, EndpointProperties.class, EndpointProperty.class, EvaluateAllEndpoints.class,
				FactoryType.class, FastInfoset.class, GZIP.class, Logging.class, Policies.class, Policy.class,
				Provider.class, SchemaValidation.class, UseAsyncMethod.class, WSDLDocumentation.class,
				WSDLDocumentationCollection.class,
				//
				AttachmentDataSource.class, AttachmentDeserializer.class, AttachmentImpl.class,
				AttachmentSerializer.class, AttachmentUtil.class, Base64DecoderStream.class, ByteDataSource.class,
				ContentDisposition.class, DelegatingInputStream.class, ImageDataContentHandler.class,
				LazyAttachmentCollection.class, LazyDataSource.class, MimeBodyPartInputStream.class,
				QuotedPrintableDecoderStream.class, Rfc5987Util.class,
				//
				AbstractBindingFactory.class, Binding.class, BindingConfiguration.class, BindingFactory.class,
				BindingFactoryManager.class,
				//
				CXFBusFactory.class, ManagedBus.class,
				//
				BlueprintBeanLocator.class, BlueprintBus.class, BlueprintNameSpaceHandlerFactory.class,
				BundleDelegatingClassLoader.class, BusDefinitionParser.class, ConfigurerImpl.class,
				NamespaceHandlerRegisterer.class,
				//
				Extension.class, ExtensionException.class, ExtensionManager.class, ExtensionManagerBus.class,
				ExtensionManagerImpl.class, ExtensionRegistry.class, TextExtensionFragmentParser.class,
				//
				BindingFactoryManagerImpl.class, ClientLifeCycleManagerImpl.class, ConduitInitiatorManagerImpl.class,
				CXFBusLifeCycleManager.class, DestinationFactoryManagerImpl.class, EndpointResolverRegistryImpl.class,
				HeaderManagerImpl.class, PhaseManagerImpl.class, ServerLifeCycleManagerImpl.class,
				ServerRegistryImpl.class, ServiceContractResolverRegistryImpl.class, WorkQueueImplMBeanWrapper.class,
				WorkQueueManagerImpl.class, WorkQueueManagerImplMBeanWrapper.class,
				//
				// CXFActivator.class, CXFExtensionBundleListener.class,
				// ManagedWorkQueueList.class, OSGiBeanLocator.class,
				// OSGIBusListener.class,
				//
				ResourceManagerImpl.class,
				//
				// BusApplicationContext.class,
				// BusApplicationContextResourceResolver.class,
				// BusDefinitionParser.class,
				// BusEntityResolver.class, BusExtensionPostProcessor.class,
				// BusWiringBeanFactoryPostProcessor.class,
				// ControlledValidationXmlBeanDefinitionReader.class,
				// Jsr250BeanPostProcessor.class,
				// NamespaceHandler.class, SpringBeanLocator.class,
				// SpringBus.class, SpringBusFactory.class,
				//
				BusCreationListener.class, BusLifeCycleListener.class, BusLifeCycleManager.class,
				//
				CatalogXmlSchemaURIResolver.class, OASISCatalogManager.class, OASISCatalogManagerHelper.class,
				//
				CXFPermissions.class,
				//
				AbstractAnnotationVisitor.class, AnnotationProcessor.class, AnnotationVisitor.class,
				//
				ClassLoaderUtils.class,
				//
				BundleUtils.class, Exception.class, Message.class, UncheckedException.class,
				//
				NoJSR250Annotations.class, ResourceInjector.class,
				//
				JAXBBeanInfo.class, JAXBContextCache.class, JAXBContextProxy.class, JAXBUtils.class,
				NamespaceMapper.class, SchemaCollectionContextProxy.class,
				//
				AbstractDelegatingLogger.class, Log4jLogger.class, LogUtils.class, Slf4jLogger.class,
				//
				SecurityToken.class, SimpleGroup.class, SimplePrincipal.class, SimpleSecurityContext.class,
				TokenType.class, UsernameToken.class,
				//
				ASMHelper.class, Base64Exception.class, Base64OutputStream.class, Base64UrlOutputStream.class,
				Base64UrlUtility.class, Base64Utility.class, CachedClass.class, CacheMap.class, ClassHelper.class,
				ClasspathScanner.class, ClassUnwrapper.class, CollectionUtils.class, Compiler.class,
				CompressionUtils.class, ExtensionInvocationHandler.class, MessageDigestInputStream.class,
				ModCountCopyOnWriteArrayList.class, PackageUtils.class, PrimitiveUtils.class,
				PropertiesLoaderUtils.class, PropertyUtils.class, ProxyClassLoader.class, ProxyHelper.class,
				ReflectionInvokationHandler.class, ReflectionUtil.class, SortedArraySet.class, StringUtils.class,
				SystemPropertyAction.class, URIParserUtil.class, UrlUtils.class, WeakIdentityHashMap.class,
				XmlSchemaPrimitiveUtils.class,
				//
				InvalidXmlSchemaReferenceException.class, LSInputImpl.class, SchemaCollection.class,
				XmlSchemaInvalidOperation.class, XmlSchemaUtils.class,
				//
				Configurable.class, ConfigurationException.class, ConfiguredBeanLocator.class, Configurer.class,
				NullConfigurer.class,
				//
				// AbstractBPBeanDefinitionParser.class,
				// InterceptorTypeConverter.class,
				// SimpleBPBeanDefinitionParser.class,
				//
				SSLUtils.class, TLSClientParameters.class, TLSClientParametersConfig.class, TLSParameterBase.class,
				TLSParameterJaxBUtils.class, TLSServerParameters.class, TLSServerParametersConfig.class,
				//
				AuthorizationPolicy.class, CertificateConstraintsType.class, CertStoreType.class, CipherSuites.class,
				ClientAuthentication.class, CombinatorType.class, DNConstraintsType.class, ExcludeProtocols.class,
				FiltersType.class, IncludeProtocols.class, KeyManagersType.class, KeyStoreType.class,
				ObjectFactory.class, ProxyAuthorizationPolicy.class, SecureRandomParameters.class,
				TLSClientParametersType.class, TLSServerParametersType.class, TrustManagersType.class,
				//
				// AbstractBeanDefinitionParser.class,
				// AbstractFactoryBeanDefinitionParser.class,
				// BusWiringType.class,
				// ConfigurerImpl.class, JAXBBeanFactory.class,
				// MappingBeanDefinitionParser.class,
				// SimpleBeanDefinitionParser.class,
				// StringBeanDefinitionParser.class,
				//
				Continuation.class, ContinuationCallback.class, ContinuationProvider.class,
				SuspendedInvocationException.class,
				//
				AbstractDataBinding.class, AbstractInterceptorProvidingDataBinding.class, AbstractWrapperHelper.class,
				org.apache.cxf.databinding.DataBinding.class, DataReader.class, DataWriter.class,
				WrapperCapableDatabinding.class, WrapperHelper.class,
				//
				NodeDataReader.class, NodeDataWriter.class, SourceDataBinding.class, XMLStreamDataReader.class,
				XMLStreamDataWriter.class,
				//
				CustomExtensionRegistry.class, MimeAttribute.class, MimeSerializer.class,
				//
				StaxDataBinding.class, StaxDataBindingFeature.class, StaxDataBindingInterceptor.class,
				XMLStreamWriterCallback.class,
				//
				AbstractConduitSelector.class, AbstractEndpointFactory.class, Client.class, ClientCallback.class,
				ClientImpl.class, ClientLifeCycleListener.class, ClientLifeCycleManager.class, ConduitSelector.class,
				ConduitSelectorHolder.class, DeferredConduitSelector.class, Endpoint.class, EndpointException.class,
				EndpointImpl.class, EndpointImplFactory.class, EndpointResolver.class, EndpointResolverRegistry.class,
				ManagedEndpoint.class, NullConduitSelector.class, PreexistingConduitSelector.class, Retryable.class,
				Server.class, ServerImpl.class, ServerLifeCycleListener.class, ServerLifeCycleManager.class,
				ServerRegistry.class, ServiceContractResolver.class, ServiceContractResolverRegistry.class,
				SimpleEndpointImplFactory.class, UpfrontConduitSelector.class,
				//
				BusExtension.class, Registry.class, RegistryImpl.class,
				//
				AbstractFeature.class, FastInfosetFeature.class, Feature.class, Features.class, LoggingFeature.class,
				StaxTransformFeature.class, WrappedFeature.class,
				//
				AbstractXSLTInterceptor.class, XSLTFeature.class, XSLTInInterceptor.class, XSLTOutInterceptor.class,
				XSLTUtils.class,
				//
				DefaultSchemaValidationTypeProvider.class, SchemaValidationFeature.class,
				SchemaValidationTypeProvider.class,
				//
				Header.class, HeaderManager.class, HeaderProcessor.class,
				//
				CastUtils.class, DOMUtils.class, FileUtils.class, HttpHeaderHelper.class, IOUtils.class,
				JavaUtils.class, LoadingByteArrayOutputStream.class, MapNamespaceContext.class, NSDecl.class,
				NSStack.class, ServiceUtils.class, XPathUtils.class,
				//
				AbstractAttributedInterceptorProvider.class, AbstractBasicInterceptorProvider.class,
				AbstractFaultChainInitiatorObserver.class, AbstractInDatabindingInterceptor.class,
				AbstractLoggingInterceptor.class, AbstractOutDatabindingInterceptor.class, AnnotationInterceptors.class,
				AttachmentInInterceptor.class, AttachmentOutInterceptor.class, ClientFaultConverter.class,
				ClientOutFaultObserver.class, Fault.class, FaultOutInterceptor.class, FIStaxInInterceptor.class,
				FIStaxOutInterceptor.class, InFaultChainInitiatorObserver.class, InFaultInterceptors.class,
				InInterceptors.class, Interceptor.class, InterceptorChain.class, InterceptorProvider.class,
				LoggingInInterceptor.class, LoggingMessage.class, LoggingOutInterceptor.class,
				MessageSenderInterceptor.class, OneWayProcessorInterceptor.class, OutFaultChainInitiatorObserver.class,
				OutFaultInterceptors.class, OutgoingChainInterceptor.class, OutInterceptors.class,
				ServiceInvokerInterceptor.class, StaxInEndingInterceptor.class, StaxInInterceptor.class,
				StaxOutEndingInterceptor.class, StaxOutInterceptor.class,
				//
				AbstractAuthorizingInInterceptor.class, AbstractSecurityContextInInterceptor.class,
				AbstractUsernameTokenInInterceptor.class, AccessDeniedException.class, AuthenticationException.class,
				DefaultSecurityContext.class, DelegatingAuthenticationInterceptor.class,
				DepthRestrictingStreamInterceptor.class, JAASAuthenticationFeature.class, JAASLoginInterceptor.class,
				NamePasswordCallbackHandler.class, OperationInfoAuthorizingInterceptor.class,
				RolePrefixSecurityContextImpl.class, SecureAnnotationsInterceptor.class,
				SimpleAuthorizingInterceptor.class,
				//
				CallbackHandlerProvider.class, CallbackHandlerProviderAuthPol.class,
				CallbackHandlerProviderUsernameToken.class, CallbackHandlerTlsCert.class, CertificateToNameMapper.class,
				CertKeyToUserNameMapper.class, NameToPasswordMapper.class,
				//
				TransformInInterceptor.class, TransformOutInterceptor.class,
				//
				// CXFAPINamespaceHandler.class,
				//
				AbstractThresholdOutputStream.class, AbstractWrappedOutputStream.class, CacheAndWriteOutputStream.class,
				CachedOutputStream.class, CachedOutputStreamCallback.class, CachedWriter.class,
				CachedWriterCallback.class, CacheSizeExceededException.class, CipherPair.class,
				CopyingOutputStream.class, org.apache.cxf.io.DelegatingInputStream.class, Transferable.class,
				WriteOnCloseOutputStream.class,
				//
				FaultListener.class, NoOpFaultListener.class,
				//
				InstrumentationManager.class, ManagedComponent.class, ManagementConstants.class,
				//
				ManagedAttribute.class, ManagedNotification.class, ManagedNotifications.class, ManagedOperation.class,
				ManagedOperationParameter.class, ManagedOperationParameters.class, ManagedResource.class,
				//
				AbstractWrappedMessage.class, Attachment.class, Exchange.class, ExchangeImpl.class, FaultMode.class,
				org.apache.cxf.message.Message.class, MessageContentsList.class, MessageImpl.class, MessageUtils.class,
				StringMap.class, StringMapImpl.class, XMLMessage.class,
				//
				AbstractPhaseInterceptor.class, Phase.class, PhaseChainCache.class, PhaseComparator.class,
				PhaseInterceptor.class, PhaseInterceptorChain.class, PhaseManager.class,
				//
				PolicyCalculator.class, PolicyDataEngine.class,
				//
				ClassLoaderResolver.class, ClasspathResolver.class, DefaultResourceManager.class,
				ExtendedURIResolver.class, ObjectTypeResolver.class, PropertiesResolver.class, ResourceManager.class,
				ResourceResolver.class, SinglePropertyResolver.class, URIResolver.class,
				//
				LoginSecurityContext.class, SecurityContext.class,
				//
				Claim.class, ClaimMode.class, Claims.class,
				//
				TLSSessionInfo.class,
				//
				Service.class, ServiceBuilder.class, ServiceImpl.class, ServiceModelSchemaValidator.class,
				ServiceModelVisitor.class,
				//
				AbstractServiceFactoryBean.class, AnnotationsFactoryBeanListener.class, FactoryBeanListener.class,
				FactoryBeanListenerManager.class, ServiceConstructionException.class, SimpleMethodDispatcher.class,
				//
				AbstractInvoker.class, BeanInvoker.class, Factory.class, FactoryInvoker.class, Invoker.class,
				MethodDispatcher.class, PerRequestFactory.class, PooledFactory.class, SessionFactory.class,
				SingletonFactory.class,
				//
				// SpringBeanFactory.class,
				//
				AbstractDescriptionElement.class, AbstractMessageContainer.class, AbstractPropertiesHolder.class,
				BindingFaultInfo.class, BindingInfo.class, BindingMessageInfo.class, BindingOperationInfo.class,
				DescriptionInfo.class, EndpointInfo.class, Extensible.class, FaultInfo.class, InterfaceInfo.class,
				MessageInfo.class, MessagePartInfo.class, NamedItem.class, OperationInfo.class, SchemaInfo.class,
				ServiceInfo.class, ServiceModelUtil.class, ServiceSchemaInfo.class, UnwrappedOperationInfo.class,
				//
				AbstractDOMStreamReader.class, CachingXmlEventWriter.class, DelegatingXMLStreamWriter.class,
				DepthExceededStaxException.class, DepthRestrictingStreamReader.class, DepthXMLStreamReader.class,
				DocumentDepthProperties.class, FastStack.class, FragmentStreamReader.class,
				OverlayW3CDOMStreamWriter.class, PartialXMLStreamReader.class, PrettyPrintXMLStreamWriter.class,
				PropertiesExpandingStreamReader.class, StaxSource.class, StaxStreamFilter.class, StaxUtils.class,
				StreamWriterContentHandler.class, W3CDOMStreamReader.class, W3CDOMStreamWriter.class,
				W3CNamespaceContext.class, XMLStreamReaderWrapper.class,
				//
				DelegatingNamespaceContext.class, IgnoreNamespacesWriter.class, InTransformReader.class,
				OutTransformWriter.class, TransformUtils.class,
				//
				// EmbeddedSchema.class, ResolvingGrammarReaderController.class,
				// StaxSchemaValidationInInterceptor.class,
				// StaxSchemaValidationOutInterceptor.class,
				// W3CMultiSchemaFactory.class, WoodstoxValidationImpl.class,
				//
				AbstractConduit.class, AbstractDestination.class, AbstractMultiplexDestination.class,
				AbstractObservable.class, AbstractTransportFactory.class, Assertor.class, ChainInitiationObserver.class,
				Conduit.class, ConduitInitiator.class, ConduitInitiatorManager.class, Destination.class,
				DestinationFactory.class, DestinationFactoryManager.class, DestinationWithEndpoint.class,
				HttpUriMapper.class, MessageObserver.class, MultipleEndpointObserver.class, MultiplexDestination.class,
				Observable.class, Session.class, TransportFinder.class, TransportURIResolver.class,
				//
				GZIPFeature.class, GZIPInInterceptor.class, GZIPOutInterceptor.class,
				//
				AbstractValidationInterceptor.class, BeanValidationFeature.class, BeanValidationInInterceptor.class,
				BeanValidationOutInterceptor.class, BeanValidationProvider.class,
				ResponseConstraintViolationException.class, ValidationConfiguration.class,
				//
				Version.class,
				//
				AutomaticWorkQueue.class, AutomaticWorkQueueImpl.class, OneShotAsyncExecutor.class,
				SynchronousExecutor.class, WorkQueue.class, WorkQueueManager.class,
				//
				AddressingConstants.class, AddressingProperties.class, AttributedAnyType.class,
				AttributedQNameType.class, AttributedUnsignedLongType.class, AttributedURIType.class,
				ContextUtils.class, EndpointReferenceType.class, EndpointReferenceUtils.class,
				EndpointUtilsException.class, FaultAction.class, JAXWSAConstants.class, MAPAggregator.class,
				MessageIdCache.class, MetadataType.class, Names.class, org.apache.cxf.ws.addressing.ObjectFactory.class,
				ProblemActionType.class, ReferenceParametersType.class, RelatesToType.class, VersionTransformer.class,
				WSAContextUtils.class, WSAddressingFeature.class,
				//
				AttributedQName.class, AttributedURI.class,
				org.apache.cxf.ws.addressing.v200403.EndpointReferenceType.class,
				org.apache.cxf.ws.addressing.v200403.ObjectFactory.class, ReferencePropertiesType.class,
				Relationship.class, ReplyAfterType.class, ServiceNameType.class,
				//
				org.apache.cxf.ws.addressing.v200408.AttributedQName.class,
				org.apache.cxf.ws.addressing.v200408.AttributedURI.class,
				org.apache.cxf.ws.addressing.v200408.EndpointReferenceType.class,
				org.apache.cxf.ws.addressing.v200408.ObjectFactory.class,
				org.apache.cxf.ws.addressing.v200408.ReferenceParametersType.class,
				org.apache.cxf.ws.addressing.v200408.ReferencePropertiesType.class,
				org.apache.cxf.ws.addressing.v200408.Relationship.class,
				org.apache.cxf.ws.addressing.v200408.ReplyAfterType.class,
				org.apache.cxf.ws.addressing.v200408.ServiceNameType.class,
				//
				Anonymous.class, AnonymousType.class, org.apache.cxf.ws.addressing.wsdl.AttributedQNameType.class,
				org.apache.cxf.ws.addressing.wsdl.ObjectFactory.class,
				org.apache.cxf.ws.addressing.wsdl.ServiceNameType.class, UsingAddressing.class,
				//
				AddressType.class, BindingType.class, org.apache.cxf.wsdl.http.ObjectFactory.class, OperationType.class,
				UrlEncoded.class, UrlReplacement.class
				//
		};

		for (Class<?> clazz : classes) {
			n.todo(clazz);
		}

	}

	public static void todoFrontendSimple(N n) {

		Class<?>[] classes = new Class<?>[] {

				DynamicClientFactory.class, TypeClassInitializer.class,

				AbstractServiceFactory.class, AbstractWSDLBasedEndpointFactory.class, ClientFactoryBean.class,
				ClientProxy.class, ClientProxyFactoryBean.class, FaultInfoException.class, ServerFactoryBean.class,
				WSDLGetInterceptor.class, WSDLGetOutInterceptor.class, WSDLGetUtils.class, WSDLQueryException.class,

				Activator.class, ClientProxyFactoryBeanDefinitionParser.class, ServerFactoryBeanDefinitionParser.class,
				SimpleBPNamespaceHandler.class,

				org.apache.cxf.frontend.spring.ClientProxyFactoryBeanDefinitionParser.class, NamespaceHandler.class,
				org.apache.cxf.frontend.spring.ServerFactoryBeanDefinitionParser.class,

				SimpleServiceBuilder.class

		};

		n.todo(classes);
	}

	public static void todoSecurity(N n) {
		Class<?>[] classes = new Class<?>[] {

				org.apache.cxf.rt.security.SecurityConstants.class,

				org.apache.cxf.rt.security.claims.Claim.class, ClaimCollection.class, ClaimsSecurityContext.class,

				BouncyCastleInstaller.class, CryptoUtils.class, HmacUtils.class, KeyProperties.class,
				MessageDigestUtils.class,

				SecurityUtils.class,

		};

		n.todo(classes);
	}

	public static void todoSecuritySaml(N n) {
		Class<?>[] classes = new Class<?>[] {

				ClaimBean.class, SAMLClaim.class, SAMLSecurityContext.class,

				ClaimsAuthorizingInterceptor.class, WSS4JBasicAuthValidator.class,

				SAMLUtils.class,

				CXFMessageParser.class, XACMLConstants.class,

				AbstractXACMLAuthorizingInterceptor.class, DefaultXACMLRequestBuilder.class, PolicyDecisionPoint.class,
				RequestComponentBuilder.class, SamlRequestComponentBuilder.class, XACMLAuthorizingInterceptor.class,
				XACMLRequestBuilder.class

		};

		n.todo(classes);
	}

	public static void todoWsdl(N n) {

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

	public static void todoWsAddr(N n) {
		Class<?>[] classes = new Class<?>[] {

				org.apache.cxf.ws.addressing.blueprint.Activator.class, WsBPHandler.class,

				AddressingFeatureApplier.class, AddressingWSDLExtensionLoader.class, DefaultMessageIdCache.class,
				MAPAggregatorImpl.class, MAPAggregatorImplLoader.class,

				AddressingAssertionBuilder.class, AddressingPolicyInterceptorProvider.class, MetadataConstants.class,
				UsingAddressingAssertionBuilder.class,

				DecoupledFaultHandler.class, MAPCodec.class, org.apache.cxf.ws.addressing.soap.VersionTransformer.class,

				AddressingBeanDefinitionParser.class, org.apache.cxf.ws.addressing.spring.NamespaceHandler.class,

		};

		n.todo(classes);
	}

	public static void todoWsSecurity(N n) {

		Class<?>[] classes = new Class<?>[] {

				SecurityConstants.class,

				CacheCleanupListener.class, CXFEHCacheReplayCache.class, EHCacheUtils.class,

				KerberosClient.class, KerberosUtils.class,

				PolicyUtils.class, WSSecurityPolicyLoader.class,

				AlgorithmSuiteBuilder.class, AlgorithmSuiteLoader.class, DefaultAlgorithmSuiteLoader.class,

				HttpsTokenInterceptorProvider.class, IssuedTokenInterceptorProvider.class,
				KerberosTokenInterceptorProvider.class, SamlTokenInterceptorProvider.class,
				SecureConversationTokenInterceptorProvider.class, SecurityVerificationOutInterceptor.class,
				SpnegoTokenInterceptorProvider.class, STSTokenOutInterceptor.class,
				UsernameTokenInterceptorProvider.class, WSSecurityInterceptorProvider.class,
				WSSecurityPolicyInterceptorProvider.class,

				SecurityTokenService.class, SecurityTokenServiceImpl.class, SecurityTokenServiceProvider.class,
				STSException.class,

				AllowPostdatingType.class, AuthenticatorType.class, BinaryExchangeType.class, BinarySecretType.class,
				CancelTargetType.class, ClaimsType.class, DelegateToType.class, EncryptionType.class, EntropyType.class,
				KeyExchangeTokenType.class, LifetimeType.class,
				org.apache.cxf.ws.security.sts.provider.model.ObjectFactory.class, OnBehalfOfType.class,
				ParticipantsType.class, ParticipantType.class, ProofEncryptionType.class, RenewingType.class,
				RenewTargetType.class, RequestedProofTokenType.class, RequestedReferenceType.class,
				RequestedSecurityTokenType.class, RequestedTokenCancelledType.class, RequestKETType.class,
				RequestSecurityTokenCollectionType.class, RequestSecurityTokenResponseCollectionType.class,
				RequestSecurityTokenResponseType.class, RequestSecurityTokenType.class, SignChallengeType.class,
				StatusType.class, UseKeyType.class, ValidateTargetType.class,

				AttributedString.class, BinarySecurityTokenType.class, EmbeddedType.class, EncodedString.class,
				KeyIdentifierType.class, org.apache.cxf.ws.security.sts.provider.model.secext.ObjectFactory.class,
				PasswordString.class, ReferenceType.class, SecurityHeaderType.class, SecurityTokenReferenceType.class,
				TransformationParametersType.class, UsernameTokenType.class,

				AttributedDateTime.class, org.apache.cxf.ws.security.sts.provider.model.utility.AttributedURI.class,
				org.apache.cxf.ws.security.sts.provider.model.utility.ObjectFactory.class, TimestampType.class,

				ActAsType.class, ChoiceChallengeResponseType.class, ChoiceChallengeType.class, ChoiceSelectedType.class,
				ChoiceType.class, ContextDataType.class, ImageType.class, InteractiveChallengeResponseType.class,
				InteractiveChallengeType.class,
				org.apache.cxf.ws.security.sts.provider.model.wstrust14.ObjectFactory.class,
				TextChallengeResponseType.class, TextChallengeType.class, TitleType.class,

				CanonicalizationMethodType.class, DigestMethodType.class, DSAKeyValueType.class, KeyInfoType.class,
				KeyValueType.class, ManifestType.class,
				org.apache.cxf.ws.security.sts.provider.model.xmldsig.ObjectFactory.class, ObjectType.class,
				PGPDataType.class, org.apache.cxf.ws.security.sts.provider.model.xmldsig.ReferenceType.class,
				RetrievalMethodType.class, RSAKeyValueType.class, SignatureMethodType.class,
				SignaturePropertiesType.class, SignaturePropertyType.class, SignatureType.class,
				SignatureValueType.class, SignedInfoType.class, SPKIDataType.class, TransformsType.class,
				TransformType.class, X509DataType.class, X509IssuerSerialType.class,

				CancelOperation.class, IssueOperation.class, IssueSingleOperation.class,
				KeyExchangeTokenOperation.class, RenewOperation.class, RequestCollectionOperation.class,
				ValidateOperation.class,

				EHCacheTokenStore.class, EHCacheTokenStoreFactory.class, MemoryTokenStore.class,
				MemoryTokenStoreFactory.class, org.apache.cxf.ws.security.tokenstore.SecurityToken.class,
				TokenStore.class, TokenStoreFactory.class, TokenStoreUtils.class,

				AbstractSTSClient.class, AuthPolicyValidatingInterceptor.class, DefaultSymmetricBinding.class,
				STSClient.class, STSLoginModule.class, STSSamlAssertionValidator.class, STSStaxTokenValidator.class,
				STSTokenRetriever.class, STSTokenValidator.class, STSUtils.class, TrustException.class,

				ClaimsCallback.class, RoleClaimsCallbackHandler.class,

				DelegationCallback.class, ReceivedTokenCallbackHandler.class, WSSUsernameCallbackHandler.class,

				AbstractTokenInterceptor.class, AbstractUsernameTokenAuthenticatingInterceptor.class,
				AbstractWSS4JInterceptor.class, AbstractWSS4JStaxInterceptor.class, AlgorithmSuiteTranslater.class,
				AttachmentCallbackHandler.class, BinarySecurityTokenInterceptor.class, CryptoCoverageChecker.class,
				CryptoCoverageUtil.class, CXFCallbackLookup.class, CXFRequestData.class,
				DefaultCryptoCoverageChecker.class, DefaultWSS4JSecurityContextCreator.class,
				DelegatingCallbackHandler.class, KerberosTokenInterceptor.class, PolicyBasedWSS4JInInterceptor.class,
				PolicyBasedWSS4JOutInterceptor.class, PolicyBasedWSS4JStaxInInterceptor.class,
				PolicyBasedWSS4JStaxOutInterceptor.class, SamlTokenInterceptor.class, StaxActionInInterceptor.class,
				StaxCryptoCoverageChecker.class, StaxSecurityContextInInterceptor.class,
				TokenStoreCallbackHandler.class, UsernameTokenInterceptor.class, WSS4JInInterceptor.class,
				WSS4JOutInterceptor.class, WSS4JPolicyAsserter.class, WSS4JSecurityContextCreator.class,
				WSS4JStaxInInterceptor.class, WSS4JStaxOutInterceptor.class, WSS4JTokenConverter.class,
				WSS4JUtils.class,

				AbstractBindingBuilder.class, AbstractCommonBindingHandler.class, AbstractStaxBindingHandler.class,
				AsymmetricBindingHandler.class, StaxAsymmetricBindingHandler.class, StaxSymmetricBindingHandler.class,
				StaxTransportBindingHandler.class, SymmetricBindingHandler.class, TransportBindingHandler.class,
				WSSecurityTokenHolder.class,

				AbstractBindingPolicyValidator.class, AbstractSamlPolicyValidator.class,
				AbstractSecurityPolicyValidator.class, AbstractSupportingTokenPolicyValidator.class,
				AlgorithmSuitePolicyValidator.class, AsymmetricBindingPolicyValidator.class,
				ClaimsPolicyValidator.class, ConcreteSupportingTokenPolicyValidator.class,
				DefaultClaimsPolicyValidator.class, EncryptedTokenPolicyValidator.class,
				EndorsingEncryptedTokenPolicyValidator.class, EndorsingTokenPolicyValidator.class,
				IssuedTokenPolicyValidator.class, KerberosTokenPolicyValidator.class, LayoutPolicyValidator.class,
				PolicyValidatorParameters.class, RequiredElementsPolicyValidator.class,
				RequiredPartsPolicyValidator.class, SamlTokenPolicyValidator.class,
				SecuredElementsPolicyValidator.class, SecuredPartsPolicyValidator.class,
				SecurityContextTokenPolicyValidator.class, SecurityPolicyValidator.class,
				SignedEncryptedTokenPolicyValidator.class, SignedEndorsingEncryptedTokenPolicyValidator.class,
				SignedEndorsingTokenPolicyValidator.class, SignedTokenPolicyValidator.class,
				SymmetricBindingPolicyValidator.class, TransportBindingPolicyValidator.class,
				UsernameTokenPolicyValidator.class, ValidatorUtils.class, WSS11PolicyValidator.class,
				X509TokenPolicyValidator.class,

				Object.class

		};

		n.todo(classes);
	}

	public static void todoTransportHttp(N n) {

		Class<?>[] classes = new Class<?>[] {

				AbstractHTTPDestination.class, Address.class, ContinuationProviderFactory.class, Cookie.class,
				Cookies.class, CXFAuthenticator.class, DestinationRegistry.class, DestinationRegistryImpl.class,
				Headers.class, HttpAuthenticationFaultHandler.class, HTTPConduit.class, HTTPConduitConfigurer.class,
				HTTPConduitFactory.class, HttpDestinationFactory.class, HTTPException.class,
				HttpServletRequestSnapshot.class, HTTPSession.class, HTTPTransportFactory.class,
				HttpURLConnectionInfo.class, HttpUrlUtil.class, HTTPWSDLExtensionLoader.class,
				MessageTrustDecider.class, PatternBuilder.class, ProxyFactory.class, ReferencingAuthenticator.class,
				Servlet3ContinuationProvider.class, UntrustedURLConnectionIOException.class,
				URLConnectionHTTPConduit.class, URLConnectionInfo.class,

				AbstractSpnegoAuthSupplier.class, DefaultBasicAuthSupplier.class, DigestAuthSupplier.class,
				HttpAuthHeader.class, HttpAuthSupplier.class, SpnegoAuthSupplier.class,
				WSDLGetAuthenticatorInterceptor.class,

				HttpBPHandler.class, HttpConduitBPBeanDefinitionParser.class,
				HttpDestinationBPBeanDefinitionParser.class,

				HTTPTransportActivator.class,

				HTTPClientAssertionBuilder.class, HTTPServerAssertionBuilder.class, NoOpPolicyInterceptorProvider.class,

				ClientPolicyCalculator.class, ServerPolicyCalculator.class,
				org.apache.cxf.transport.http.policy.impl.StringUtils.class,

				HttpAuthSupplierBeanDefinitionParser.class, HttpConduitBeanDefinitionParser.class,
				HttpDestinationBeanDefinitionParser.class, MessageTrustDeciderBeanDefinitionParser.class,
				NamespaceHandler.class,

				AliasedX509ExtendedKeyManager.class, CertConstraints.class, CertConstraintsFeature.class,
				CertConstraintsInterceptor.class, CertConstraintsJaxBUtils.class, HttpsURLConnectionFactory.class,
				HttpsURLConnectionInfo.class, org.apache.cxf.transport.https.SSLUtils.class,

				DefaultHostnameVerifier.class, DomainType.class, InetAddressUtils.class, PublicSuffixList.class,
				PublicSuffixListParser.class, PublicSuffixMatcher.class, PublicSuffixMatcherLoader.class,

				AbstractHTTPServlet.class, BaseUrlHelper.class, CXFNonSpringServlet.class, CXFServlet.class,
				ServletContextResourceResolver.class, ServletController.class, ServletDestination.class,
				ServletDestinationFactory.class,

				CXFBlueprintServlet.class,

				FormattedServiceListWriter.class, ServiceListGeneratorServlet.class, ServiceListJAASAuthenticator.class,
				ServiceListWriter.class, UnformattedServiceListWriter.class,

				ConnectionType.class, HTTPClientPolicy.class, HTTPServerPolicy.class,
				org.apache.cxf.transports.http.configuration.ObjectFactory.class, ProxyServerType.class

		};

		for (Class<?> clazz : classes) {
			n.todo(clazz);
		}

	}

	public static void todoTransportLocal(N n) {

		Class<?>[] classes = new Class<?>[] {

				LocalConduit.class, LocalDestination.class, LocalTransportFactory.class

		};

		for (Class<?> clazz : classes) {
			n.todo(clazz);
		}

	}

	public static void todoBindingsObject(N n) {

		Class<?>[] classes = new Class<?>[] {

				LocalServerListener.class, ObjectBinding.class, ObjectBindingConfiguration.class,
				ObjectBindingFactory.class, ObjectDispatchInInterceptor.class, ObjectDispatchOutInterceptor.class,

				org.apache.cxf.binding.object.blueprint.Activator.class, ObjectBindingBPHandler.class,

				org.apache.cxf.binding.object.spring.NamespaceHandler.class

		};
		n.todo(classes);
	}

	public static void todoBindingsSoap(N n) {

		Class<?>[] classes = new Class<?>[] {

				HeaderUtil.class, Soap11.class, Soap12.class, SoapBinding.class, SoapBindingConfiguration.class,
				SoapBindingConstants.class, SoapBindingFactory.class, org.apache.cxf.binding.soap.SOAPBindingUtil.class,
				SoapFault.class, SoapHeader.class, SoapMessage.class, SoapTransportFactory.class, SoapVersion.class,
				SoapVersionEditor.class, SoapVersionFactory.class,

				org.apache.cxf.binding.soap.blueprint.Activator.class, SoapBindingBPHandler.class,
				SoapBindingBPInfoConfigDefinitionParser.class, SoapVersionTypeConverter.class,

				AbstractSoapInterceptor.class, CheckFaultInterceptor.class, EndpointSelectionInterceptor.class,
				MustUnderstandInterceptor.class, ReadHeadersInterceptor.class, RPCInInterceptor.class,
				RPCOutInterceptor.class, Soap11FaultInInterceptor.class, Soap11FaultOutInterceptor.class,
				Soap12FaultInInterceptor.class, Soap12FaultOutInterceptor.class, SoapActionInInterceptor.class,
				SoapHeaderInterceptor.class, SoapHeaderOutFilterInterceptor.class, SoapInterceptor.class,
				SoapOutInterceptor.class, SoapPreProtocolOutInterceptor.class, StartBodyInterceptor.class,
				TibcoSoapActionInterceptor.class,

				JMSFault.class, JMSFaultFactory.class, JMSFaultType.class, SoapFaultFactory.class,
				SoapJMSConstants.class, SoapJMSInInterceptor.class,

				SoapBindingInfo.class, SoapBodyInfo.class, SoapHeaderInfo.class, SoapOperationInfo.class,

				SAAJFactoryResolver.class, SAAJInInterceptor.class, SAAJOutInterceptor.class, SAAJStreamWriter.class,
				SAAJUtils.class,

				org.apache.cxf.binding.soap.spring.NamespaceHandler.class,
				SoapBindingInfoConfigBeanDefinitionParser.class, SoapVersionRegistrar.class,

				SoapAddress.class, org.apache.cxf.binding.soap.wsdl.extensions.SoapBinding.class, SoapBody.class,
				org.apache.cxf.binding.soap.wsdl.extensions.SoapFault.class,
				org.apache.cxf.binding.soap.wsdl.extensions.SoapHeader.class, SoapHeaderFault.class,
				SoapOperation.class,

				SoapAddressPlugin.class,

				Object.class

		};

		n.todo(classes);

	}

	public static void todoBindingsXml(N n) {
		Class<?>[] classes = new Class<?>[] {

				XMLBinding.class, XMLBindingFactory.class, XMLConstants.class, XMLFault.class, XMLFormatValidator.class,
				org.apache.cxf.binding.xml.XMLMessage.class,

				XMLFaultInInterceptor.class, XMLFaultOutInterceptor.class, XMLMessageInInterceptor.class,
				XMLMessageOutInterceptor.class,

				HttpAddressPlugin.class, XmlBindingPlugin.class, XmlIoPlugin.class, XMLWSDLExtensionLoader.class,

				org.apache.cxf.bindings.xformat.ObjectFactory.class, XMLBindingMessageFormat.class,
				XMLFormatBinding.class,

				Object.class

		};

		n.todo(classes);
	}

	public static void todoDataBindingsJaxb(N n) {
		Class<?>[] classes = new Class<?>[] {

				DatatypeFactory.class, JAXBDataBase.class, JAXBDataBinding.class, JAXBEncoderDecoder.class,
				JAXBWrapperHelper.class, MarshallerAwareXMLWriter.class, MarshallerEventHandler.class,
				UnmarshallerAwareXMLReader.class, UnmarshallerEventHandler.class,

				JAXBAttachmentMarshaller.class, JAXBAttachmentSchemaValidationHack.class,
				JAXBAttachmentUnmarshaller.class,

				DataReaderImpl.class, DataWriterImpl.class

		};

		n.todo(classes);
	}

}
