package com.github.xdptdr.mbjaxrs.basics.foo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;

import com.github.xdptdr.mbjaxrs.utils.Infos;


@Provider
@Path("/foo")
public class FooEndpoint {
	@GET
	@Path("/get/context/application")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getContextApplication(@Context Application application) {

		Map<String, Object> infos = new HashMap<>();

		List<String> classes = new ArrayList<>();
		for (Class<?> clazz : application.getClasses()) {
			classes.add(clazz.getName());
		}
		infos.put("classes", classes);

		Map<String, String> propertiesMap = new HashMap<>();
		for (Entry<String, Object> entry : application.getProperties().entrySet()) {
			propertiesMap.put(entry.getKey(), Infos.stringify(entry.getValue()));

		}
		infos.put("properties", propertiesMap);

		List<String> singletons = new ArrayList<>();
		for (Object singleton : application.getSingletons()) {
			singletons.add(Infos.stringify(singleton));
		}
		infos.put("singletons", singletons);

		Map<String, Object> map = new HashMap<>();
		map.put("application", infos);
		return Response.ok(map).build();
	}

	@GET
	@Path("/get/context/uriinfo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getContextUriInfo(@Context UriInfo uriInfo) {

		Map<String, Object> UriInfoMap = new HashMap<>();
		Map<String, Object> infos = new HashMap<>();

		{
			List<Object> matchedResources = uriInfo.getMatchedResources();
			List<String> list = new ArrayList<>();
			for (Object r : matchedResources) {
				list.add(Infos.stringify(r));
			}
		}

		{
			List<String> matchedURIs = uriInfo.getMatchedURIs();
			infos.put("matchedURIs", matchedURIs);
		}

		{
			String path = uriInfo.getPath();
			infos.put("path", path);
		}

		{
			MultivaluedMap<String, String> pathParameters = uriInfo.getPathParameters();
			Map<String, List<String>> map = new HashMap<>();
			for (Entry<String, List<String>> entry : pathParameters.entrySet()) {
				String key = entry.getKey();
				for (String value : entry.getValue()) {
					if (!map.containsKey(key)) {
						map.put(key, new ArrayList<>());
					}
					map.get(key).add(value);
				}
			}
			infos.put("pathParameters", map);
		}

		{
			List<PathSegment> pathSegments = uriInfo.getPathSegments();
			List<Map<String, Object>> list = new ArrayList<>();
			for (PathSegment pathSegment : pathSegments) {
				Map<String, Object> map = new HashMap<>();
				map.put("path", pathSegment.getPath());

				Map<String, List<String>> mmap = new HashMap<>();
				for (Entry<String, List<String>> entry : pathSegment.getMatrixParameters().entrySet()) {
					for (String value : entry.getValue()) {
						String key = entry.getKey();
						if (!mmap.containsKey(key)) {
							mmap.put(key, new ArrayList<>());
						}
						mmap.get(key).add(value);
					}
				}
				map.put("matriParameters", mmap);
				list.add(map);
			}
			infos.put("pathSegments", list);
		}

		{
			MultivaluedMap<String, String> queryParameters = uriInfo.getQueryParameters();
			Map<String, List<String>> map = new HashMap<>();
			for (Entry<String, List<String>> entry : queryParameters.entrySet()) {
				String key = entry.getKey();
				for (String value : entry.getValue()) {
					if (!map.containsKey(key)) {
						map.put(key, new ArrayList<>());
					}
					map.get(key).add(value);
				}
			}
			infos.put("queryParameters", map);
		}

		infos.put("absolutePath", Infos.get(uriInfo.getAbsolutePath()));
		infos.put("baseUri", Infos.get(uriInfo.getBaseUri()));
		infos.put("requestUri", Infos.get(uriInfo.getRequestUri()));

		UriInfoMap.put("uriInfo", infos);
		return Response.ok(UriInfoMap).build();

	}

	@GET
	@Path("/get/context/httpheaders")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextHttpHeaders(@Context HttpHeaders httpHeaders) {
		return Response.ok("something").build();
	}

	@GET
	@Path("/get/context/request")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextRequest(@Context Request request) {
		return Response.ok("something").build();
	}

	@GET
	@Path("/get/context/securitycontext")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getContextSecurityContext(@Context SecurityContext securityContext) {
		Map<String, Object> securityContextMap = new HashMap<>();
		Map<String, Object> infos = new HashMap<>();
		infos.put("authenticationScheme", securityContext.getAuthenticationScheme());
		infos.put("isSecure", securityContext.isSecure());
		infos.put("principalName", securityContext.getUserPrincipal().getName());
		securityContextMap.put("securityContext", infos);
		return Response.ok(securityContextMap).build();
	}

	@GET
	@Path("/get/context/providers")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextProviders(@Context Providers providers) {
		return Response.ok(providers.getClass().getName()).build();
	}

	@GET
	@Path("/get/context/resourcecontext")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextResourceContext(@Context ResourceContext resourceContext) {
		return Response.ok(resourceContext.getClass().getName()).build();
	}

	@GET
	@Path("/get/context/configuration")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextConfiguration(@Context Configuration configuration) {
		Map<String, Object> map = new HashMap<>();
		map.put("configuration", Infos.get(configuration));
		return Response.ok(map).build();
	}

	@GET
	@Path("/get/context/servletconfig")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextServletConfig(@Context ServletConfig servletConfig) {
		return Response.ok(servletConfig.getServletName()).build();
	}

	@GET
	@Path("/get/context/servletcontext")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextServletContext(@Context ServletContext servletContext) {
		return Response.ok(servletContext.getContextPath()).build();
	}

	@GET
	@Path("/get/context/httpservletrequest")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getContextHttpServletRequest(@Context HttpServletRequest httpServletRequest) {

		Map<String, Object> infos = new HashMap<>();
		{
			Map<String, List<String>> headers = new HashMap<>();
			Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String headerName = headerNames.nextElement();
				Enumeration<String> headerValues = httpServletRequest.getHeaders(headerName);
				while (headerValues.hasMoreElements()) {
					String headerValue = headerValues.nextElement();
					if (!headers.containsKey(headerName)) {
						headers.put(headerName, new ArrayList<>());
					}
					headers.get(headerName).add(headerValue);
				}
			}
			infos.put("headers", headers);
		}

		{
			Map<String, String> attributes = new HashMap<>();
			Enumeration<String> attributeNames = httpServletRequest.getAttributeNames();
			while (attributeNames.hasMoreElements()) {
				String name = attributeNames.nextElement();
				Object value = httpServletRequest.getAttribute(name);
				attributes.put(name, Infos.stringify(value));
			}
			infos.put("attributes", attributes);
		}

		{
			Map<String, List<String>> parameters = new HashMap<>();
			Enumeration<String> parameterNames = httpServletRequest.getParameterNames();
			while (parameterNames.hasMoreElements()) {
				String parameterName = parameterNames.nextElement();
				for (String parameterValue : httpServletRequest.getParameterValues(parameterName)) {
					if (!parameters.containsKey(parameterName)) {
						parameters.put(parameterName, new ArrayList<>());
					}
					parameters.get(parameterName).add(parameterValue);
				}
			}
			infos.put("parameters", parameters);
		}

		infos.put("authType", httpServletRequest.getAuthType());
		infos.put("characterEncoding", httpServletRequest.getCharacterEncoding());
		infos.put("contentLength", httpServletRequest.getContentLength());
		infos.put("contentLengthLong", httpServletRequest.getContentLength());
		infos.put("contentType", httpServletRequest.getContentType());
		infos.put("contextPath", httpServletRequest.getContextPath());

		Map<String, Object> hsr = new HashMap<>();
		hsr.put("httpServletRequest", infos);

		return Response.ok(hsr).build();
	}

	@GET
	@Path("/get/context/httpservletresponse")
	@Produces(MediaType.TEXT_PLAIN)
	public void getContextHttpServletResponse(@Context HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setContentType(MediaType.TEXT_PLAIN);
		httpServletResponse.getWriter()
				.print("This response was generated directly with javax.servlet.http.HttpServletResponse");
	}
}
