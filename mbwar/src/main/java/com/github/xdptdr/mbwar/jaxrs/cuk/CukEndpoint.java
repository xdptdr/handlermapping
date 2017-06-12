package com.github.xdptdr.mbwar.jaxrs.cuk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Encoded;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;

@Provider
@Path("/cuk")
public class CukEndpoint {

	@GET
	@Path("/get/queryparam")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getQueryParam(@QueryParam("p") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/queryparam/encoded")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getQueryParamEncoded(@QueryParam("p") @Encoded String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/queryparam/defaultvalue")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getQueryParamDefaultValue(@QueryParam("p") @DefaultValue("cuk") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/pathparam/{p}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPathParam(@PathParam("p") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/pathparam/{p}/encoded")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPathParamEncoded(@PathParam("p") @Encoded String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/matrixparam")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMatrixParam(@MatrixParam("p") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/matrixparam/encoded")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMatrixParamEncoded(@MatrixParam("p") @Encoded String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/matrixparam/defaultvalue")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMatrixParamDefaultValue(@MatrixParam("p") @DefaultValue("cuk") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/cookieparam")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getCookieParam(@CookieParam("p") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/cookieparam/defaultvalue")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getCookieParamDefaultValue(@CookieParam("p") @DefaultValue("cuk") String p) {
		return Response.ok(p).build();
	}

	@POST
	@Path("/post/formparam")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response getFormParam(@FormParam("p") String p) {
		return Response.ok(p).build();
	}

	@POST
	@Path("/post/formparam/defaultValue")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response getFormParamDefaultValue(@FormParam("p") @DefaultValue("cuk") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/headerparam")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getHeaderParam(@HeaderParam("p") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/headerparam/defaultValue")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getHeaderParamDefaultValue(@HeaderParam("p") @DefaultValue("cuk") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/context/application")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextApplication(@Context Application application) {
		return Response.ok("something").build();
	}

	@GET
	@Path("/get/context/uriinfo")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextUriInfo(@Context UriInfo uriInfo) {
		return Response.ok("something").build();
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
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextSecurityContext(@Context SecurityContext securityContext) {
		return Response.ok(securityContext.getAuthenticationScheme()).build();
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

		Map<String, Object> configurationMap = new HashMap<>();
		Map<String, Object> infos = new HashMap<>();
		List<String> configurationClasses = new ArrayList<>();
		List<String> configurationInstances = new ArrayList<>();

		Set<Class<?>> classes = configuration.getClasses();
		for (Class<?> clazz : classes) {
			configurationClasses.add(clazz.getName());
		}
		Set<Object> instances = configuration.getInstances();
		for (Object instance : instances) {
			configurationInstances.add(instance.getClass().getName());
		}
		Map<String, Object> properties = configuration.getProperties();
		Map<String, String> configurationProperties = new HashMap<>();
		for (Entry<String, Object> entry : properties.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value == null) {
				configurationProperties.put(key, "n$");

			} else if (value instanceof String) {
				configurationProperties.put(key, "s$" + value);
			} else {
				configurationProperties.put(key, "c$" + value.getClass().getName());
			}
		}
		RuntimeType runtimeType = configuration.getRuntimeType();

		infos.put("classes", configurationClasses);
		infos.put("instances", configurationInstances);
		infos.put("runtimeType", runtimeType);
		infos.put("clazz", configuration.getClass().getName());
		configurationMap.put("configuration", infos);
		return Response.ok(configurationMap).build();
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
				String attributeName = attributeNames.nextElement();
				Object attributeValue = httpServletRequest.getAttribute(attributeName);
				if (attributeValue == null) {
					attributes.put(attributeName, "n$");
				} else if (attributeValue instanceof String) {
					attributes.put(attributeName, "s$" + (String) attributeValue);
				} else {
					attributes.put(attributeName, "c$" + attributeValue.getClass().getName());
				}
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
		infos.put("contentLengthLong", httpServletRequest.getContentLengthLong());
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

	// Accept
	// Accept-Charset
	// Accept-Encoding
	// Accept-Language
	// Allow
	// Authorization
	// Cache-Control
	// Content-Encoding
	// Content-Language
	// Content-Length
	// Content-Type
	// Cookie
	// Date
	// ETag
	// Expect
	// Expires
	// If-Match
	// If-Modified-Since
	// If-Unmodified-Since
	// Last-Modified
	// Location
	// Set-Cookie
	// Transfer-Encoding
	// Vary
	// WWW-Authenticate

}
