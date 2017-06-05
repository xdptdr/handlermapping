package com.github.xdptdr.mbwar.jaxrs.servlet;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Encoded;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Link.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Variant;
import javax.ws.rs.core.Variant.VariantListBuilder;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.RuntimeDelegate;
import javax.ws.rs.ext.RuntimeDelegate.HeaderDelegate;
import javax.xml.ws.Provider;

public class JAXRSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Application application;
	private Set<Class<?>> classes;
	private Map<String, Object> properties;
	private Set<Object> singletons;
	private RuntimeDelegate runtimeDelegate;
	private Class<?> clazz;
	private HeaderDelegate<?> headerDelegate;
	private Builder builder;
	private ResponseBuilder responseBuilder;
	private UriBuilder uriBuilder;
	private VariantListBuilder variantListBuilder;
	private Provider<Object> provider;
	private Object request;
	private ApplicationPath applicationPath;
	private Path path;
	private ParamConverter<Object> paramConverter;
	private ParamConverterProvider paramConverterProvider;
	private String string;
	private Object object;
	private Type type;
	private Annotation[] annotations;
	private DefaultValue defaultValue;
	private Encoded encoded;
	private HttpMethod httpMethod;
	private FormParam formParam;
	private Response response;
	private Map context;
	private String methods;
	private String method1;
	private String method2;
	private CacheControl cacheControl;
	private URI uri;
	private NewCookie cookie1;
	private NewCookie cookie2;
	private String encoding;
	private Object entity;
	private Date date;
	private String headerName;
	private Object headerValue;
	private String language;
	private Locale locale;
	private String uriString;
	private String relString;
	private Link link1;
	private Link link2;
	private MultivaluedMap<String, Object> multivaluedMap;
	private int statusInt;
	private Status status;
	private StatusType statusType;
	private String tagString;
	private EntityTag entityTag;
	private String typeString;
	private MediaType mediaType;
	private Variant variant;
	private List<Variant> variants;
	private Variant variant1;
	private Variant variant2;
	private GenericType<Object> genericType;
	private boolean b;
	private Set<String> allowedMethods;
	private Map<String, NewCookie> cookies;
	private MultivaluedMap<String, Object> headers;
	private int length;
	private Link link;
	private Builder linkBuilder;
	private Set<Link> links;
	private MultivaluedMap<String, Object> metadata;
	private MultivaluedMap<String, String> headersString;
	private GenericEntity<Object> genericEntity;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req == null) {
			doStuff(req, resp);
		}
	}

	private void doStuff(HttpServletRequest req, HttpServletResponse resp) {

		application = new Application();
		classes = application.getClasses();
		properties = application.getProperties();
		singletons = application.getSingletons();

		runtimeDelegate = RuntimeDelegate.getInstance();
		RuntimeDelegate.setInstance(runtimeDelegate);
		Object endPoint = runtimeDelegate.createEndpoint(application, clazz);
		headerDelegate = runtimeDelegate.createHeaderDelegate(clazz);
		builder = runtimeDelegate.createLinkBuilder();
		responseBuilder = runtimeDelegate.createResponseBuilder();
		uriBuilder = runtimeDelegate.createUriBuilder();
		variantListBuilder = runtimeDelegate.createVariantListBuilder();

		provider.invoke(request);

		/* servlet whose name is javax.ws.rs.core.Application */

		applicationPath.value();

		path.value();

		paramConverter.fromString(string);
		paramConverter.toString(object);

		paramConverterProvider.getConverter(clazz, type, annotations);

		defaultValue.value();

		Encoded.class.isAnnotation();

		httpMethod.value();

		GET.class.isAnnotation();
		POST.class.isAnnotation();
		PUT.class.isAnnotation();
		DELETE.class.isAnnotation();
		HEAD.class.isAnnotation();
		OPTIONS.class.isAnnotation();

		formParam.value();

		responseBuilder = Response.accepted();
		responseBuilder = Response.accepted(entity);
		responseBuilder = Response.created(uri);
		responseBuilder = Response.fromResponse(response);
		responseBuilder = Response.noContent();
		responseBuilder = Response.notAcceptable(variants);
		responseBuilder = Response.notModified();
		responseBuilder = Response.notModified(tagString);
		responseBuilder = Response.notModified(entityTag);
		responseBuilder = Response.ok();
		responseBuilder = Response.ok(entity);
		responseBuilder = Response.ok(entity, typeString);
		responseBuilder = Response.ok(entity, mediaType);
		responseBuilder = Response.ok(entity, variant);
		responseBuilder = Response.seeOther(uri);
		responseBuilder = Response.serverError();
		responseBuilder = Response.status(statusInt);
		responseBuilder = Response.status(status);
		responseBuilder = Response.status(statusType);
		responseBuilder = Response.temporaryRedirect(uri);
		b = response.bufferEntity();
		response.close();
		allowedMethods = response.getAllowedMethods();
		cookies = response.getCookies();
		date = response.getDate();
		entity = response.getEntity();
		entityTag = response.getEntityTag();
		headers = response.getHeaders();
		headerValue = response.getHeaderString(headerName);
		locale = response.getLanguage();
		date = response.getLastModified();
		length = response.getLength();
		link = response.getLink(relString);
		linkBuilder = response.getLinkBuilder(relString);
		links = response.getLinks();
		uri = response.getLocation();
		mediaType = response.getMediaType();
		metadata = response.getMetadata();
		statusInt = response.getStatus();
		statusType = response.getStatusInfo();
		headersString = response.getStringHeaders();
		b = response.hasEntity();
		b = response.hasLink(relString);
		entity = response.readEntity(clazz);
		entity = response.readEntity(clazz, annotations);
		entity = response.readEntity(genericType);
		entity = response.readEntity(genericType, annotations);

		responseBuilder = responseBuilder.allow(methods);
		responseBuilder = responseBuilder.allow(method1, method2);
		response = responseBuilder.build();
		responseBuilder = responseBuilder.cacheControl(cacheControl);
		responseBuilder = responseBuilder.contentLocation(uri);
		responseBuilder = responseBuilder.cookie(cookie1, cookie2);
		responseBuilder = responseBuilder.encoding(encoding);
		responseBuilder = responseBuilder.entity(entity);
		responseBuilder = responseBuilder.entity(entity, annotations);
		responseBuilder = responseBuilder.expires(date);
		responseBuilder = responseBuilder.header(headerName, headerValue);
		responseBuilder = responseBuilder.language(language);
		responseBuilder = responseBuilder.language(locale);
		responseBuilder = responseBuilder.lastModified(date);
		responseBuilder = responseBuilder.link(uriString, relString);
		responseBuilder = responseBuilder.link(uri, relString);
		responseBuilder = responseBuilder.links(link1, link2);
		responseBuilder = responseBuilder.location(uri);
		responseBuilder = responseBuilder.replaceAll(multivaluedMap);
		responseBuilder = responseBuilder.status(statusInt);
		responseBuilder = responseBuilder.status(status);
		responseBuilder = responseBuilder.status(statusType);
		responseBuilder = responseBuilder.tag(tagString);
		responseBuilder = responseBuilder.tag(entityTag);
		responseBuilder = responseBuilder.type(typeString);
		responseBuilder = responseBuilder.type(mediaType);
		responseBuilder = responseBuilder.variant(variant);
		responseBuilder = responseBuilder.variants(variants);
		responseBuilder = responseBuilder.variants(variant1, variant2);

		genericEntity = new GenericEntity<Object>(entity, type);
		entity = genericEntity.getEntity();
		clazz = genericEntity.getRawType();
		type = genericEntity.getType();
	}
}
