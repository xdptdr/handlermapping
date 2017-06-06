package com.github.xdptdr.mbwar.jaxrs.notes;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.BeanParam;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.ConstrainedTo;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Encoded;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.NameBinding;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.NotSupportedException;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Priorities;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.RedirectionException;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.ServiceUnavailableException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.ResponseProcessingException;
import javax.ws.rs.client.SyncInvoker;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.CompletionCallback;
import javax.ws.rs.container.ConnectionCallback;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.container.TimeoutHandler;
import javax.ws.rs.core.AbstractMultivaluedMap;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Configurable;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.NoContentException;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriBuilderException;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Variant;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.InterceptorContext;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.RuntimeDelegate;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

import com.github.xdptdr.mbwar.jaxrs.MyJAXRSApplication;
import com.github.xdptdr.mbwar.jaxrs.aze.AzeEndpoint;
import com.github.xdptdr.mbwar.jaxrs.bar.BarBean;
import com.github.xdptdr.mbwar.jaxrs.bar.BarEndpoint;
import com.github.xdptdr.mbwar.jaxrs.bar.BarReader;
import com.github.xdptdr.mbwar.jaxrs.bar.BarWriter;
import com.github.xdptdr.mbwar.jaxrs.clients.aze.InvokeAze;
import com.github.xdptdr.mbwar.jaxrs.clients.bar.InvokeBarGet;
import com.github.xdptdr.mbwar.jaxrs.clients.bar.InvokeBarPost;

public class Notes {

	public static void notes(N n) {

		/* 1.1 Set up */

		n.s("Our first goal is to make a call to /rs/aze/get working");

		n.s("One way of doing this is to extend ").k(Application.class).s(" and annotate it with ")
				.k(ApplicationPath.class).s(", setting its value to /rs");

		n.s("This is done in ").k(MyJAXRSApplication.class).s(" for this project");

		n.s("The next things is to set up an endpoint, such as ").k(AzeEndpoint.class);

		n.s("At the class level, the endpoint has the ").k(Provider.class)
				.s(" annotation, to advertise it for autodiscovery, and a ").k(Path.class)
				.s(" annotation, set to /foo");

		n.s("There's a single method 'get', which is annotated with ").k(GET.class)
				.s(" so that it can answers HTTP GET requests, and a ").k(Path.class).s(" annotation, set to /get");

		n.s("This method only returns a string, which will be transmitted as such in the response");

		/* 1.2 Test */

		n.s("GET requests are easy to test with a standard browser. Other types of requests are not so easy to test."
				+ " Besides, JAX-RS also defines a client API that we will cover here too.");

		n.s("In this project, testing the examples is done with small Java programs that have been bundled in the 'standalones' subproject, "
				+ "because a dependency on 'jersey' must be introduced");

		n.k(InvokeAze.class).s(" invokes ").k(AzeEndpoint.class);

		n.s("Just open it and run it's main method");

		n.s("It uses ").k(ClientBuilder.class).s(" to get a new instance of ").k(Client.class)
				.s(", then it targets the full URL and retrieves an instance of ").k(Response.class)
				.s(" which is then read as a String and dumped to the console");

		n.k(InvokeAze.class).s(" requires a running server to work successfully");

		/* 2 MessageBodyWriters and MessageBodyReaders */

		n.s("In this second example, we will use message body writers and readers to transmit data in a custom way.");

		n.k(BarBean.class).s(
				" has a firstname and a lastname, and we want them to be transmitted in plain text firstname first, then a space, then lastname");

		n.s("This is a terrible idea in practice, but good for an example");

		/* 2.1 Writer */

		n.s("We define the writer first, since it will be used with GET request.");

		n.k(BarWriter.class).s(" implements ").k(MessageBodyWriter.class).s(" and targets instances of ")
				.k(BarBean.class);

		n.s("It checks that the given object is of the correct type, and also that the ").k(MediaType.class)
				.s(" is text/plain");

		n.s("The getSize function is deprecated, and should always return -1 in new developments");

		n.s("Then writing is a matter of piping strings into an OutputStream");

		n.s("Last but not least, ").k(BarWriter.class).s(" is annotated with ").k(Provider.class)
				.s(" for automatic discovery");

		/* 2.2 Writer endpoint */

		n.k(BarEndpoint.class).s(" is the endpoint associated with this example.");

		n.s("The first difference here is that the get method returns an instance of ").k(BarBean.class);

		n.s("The second difference is that the method is annotated with ").k(Produces.class)
				.s(" so that it is configured to send back text/plain data");

		n.s("The test program is ").k(InvokeBarGet.class);

		/* 2.3 Reader */

		n.s("Creating a reader is similar to creating a reader, but implements ").k(MessageBodyReader.class)
				.s(" instead.");

		n.s("The difficulty is more about parsing the content, but this is not the topic here");

		n.k(BarReader.class).s(" is the reader for ").k(BarBean.class).s(" in this example.");

		n.s("It takes as input two words separated by a space, and produces the corresponding instance of ")
				.k(BarBean.class);

		n.s("It is also annotated with ").k(Provider.class).s(" for automatic discovery");

		/* 2.4 Reader endpoint */

		n.k(BarEndpoint.class).s(" defines a read method, which is annoated with ").k(POST.class)
				.s(" to accept post requests, and with ").k(Consumes.class)
				.s(" to specify it accepts only text/plain as input");

		n.s("The read method sets the instance of the endpoint to what was given, so that we can check that the input has been correctly by running ")
				.k(InvokeBarGet.class);

		n.s("The test program is ").k(InvokeBarPost.class).s(". Nothing fancy there, except the use of ")
				.k(Entity.class).s(" to set the post data.");

		n.todo(Provider.class);
		n.todo(ApplicationPath.class);
		n.todo(BadRequestException.class);
		n.todo(BeanParam.class);
		n.todo(ClientErrorException.class);
		n.todo(ConstrainedTo.class);
		n.todo(Consumes.class);
		n.todo(CookieParam.class);
		n.todo(DefaultValue.class);
		n.todo(DELETE.class);
		n.todo(Encoded.class);
		n.todo(ForbiddenException.class);
		n.todo(FormParam.class);
		n.todo(GET.class);
		n.todo(HEAD.class);
		n.todo(HeaderParam.class);
		n.todo(HttpMethod.class);
		n.todo(InternalServerErrorException.class);
		n.todo(MatrixParam.class);
		n.todo(NameBinding.class);
		n.todo(NotAcceptableException.class);
		n.todo(NotAllowedException.class);
		n.todo(NotAuthorizedException.class);
		n.todo(NotFoundException.class);
		n.todo(NotSupportedException.class);
		n.todo(OPTIONS.class);
		n.todo(Path.class);
		n.todo(PathParam.class);
		n.todo(POST.class);
		n.todo(Priorities.class);
		n.todo(ProcessingException.class);
		n.todo(Produces.class);
		n.todo(PUT.class);
		n.todo(QueryParam.class);
		n.todo(RedirectionException.class);
		n.todo(RuntimeType.class);
		n.todo(ServerErrorException.class);
		n.todo(ServiceUnavailableException.class);
		n.todo(WebApplicationException.class);

		n.todo(AsyncInvoker.class);
		n.todo(Client.class);
		n.todo(ClientBuilder.class);
		n.todo(ClientRequestContext.class);
		n.todo(ClientRequestFilter.class);
		n.todo(ClientResponseContext.class);
		n.todo(ClientResponseFilter.class);
		n.todo(Entity.class);
		n.todo(Invocation.class);
		n.todo(InvocationCallback.class);
		n.todo(ResponseProcessingException.class);
		n.todo(SyncInvoker.class);
		n.todo(WebTarget.class);

		n.todo(AsyncResponse.class);
		n.todo(CompletionCallback.class);
		n.todo(ConnectionCallback.class);
		n.todo(ContainerRequestContext.class);
		n.todo(ContainerRequestFilter.class);
		n.todo(ContainerResponseContext.class);
		n.todo(ContainerResponseFilter.class);
		n.todo(DynamicFeature.class);
		n.todo(PreMatching.class);
		n.todo(ResourceContext.class);
		n.todo(ResourceInfo.class);
		n.todo(Suspended.class);
		n.todo(TimeoutHandler.class);

		n.todo(AbstractMultivaluedMap.class);
		n.todo(Application.class);
		n.todo(CacheControl.class);
		n.todo(Configurable.class);
		n.todo(Configuration.class);
		n.todo(Context.class);
		n.todo(Cookie.class);
		n.todo(EntityTag.class);
		n.todo(Feature.class);
		n.todo(FeatureContext.class);
		n.todo(Form.class);
		n.todo(GenericEntity.class);
		n.todo(GenericType.class);
		n.todo(HttpHeaders.class);
		n.todo(Link.class);
		n.todo(MediaType.class);
		n.todo(MultivaluedHashMap.class);
		n.todo(MultivaluedMap.class);
		n.todo(NewCookie.class);
		n.todo(NoContentException.class);
		n.todo(PathSegment.class);
		n.todo(Request.class);
		n.todo(Response.class);
		n.todo(SecurityContext.class);
		n.todo(StreamingOutput.class);
		n.todo(UriBuilder.class);
		n.todo(UriBuilderException.class);
		n.todo(UriInfo.class);
		n.todo(Variant.class);

		n.todo(ContextResolver.class);
		n.todo(ExceptionMapper.class);
		n.todo(InterceptorContext.class);
		n.todo(MessageBodyReader.class);
		n.todo(MessageBodyWriter.class);
		n.todo(ParamConverter.class);
		n.todo(ParamConverterProvider.class);
		n.todo(Provider.class);
		n.todo(Providers.class);
		n.todo(ReaderInterceptor.class);
		n.todo(ReaderInterceptorContext.class);
		n.todo(RuntimeDelegate.class);
		n.todo(WriterInterceptor.class);
		n.todo(WriterInterceptorContext.class);
	}

	public static void main(String[] args) {
		N n = new N();
		notes(n);
		n.sumUp();
	}
}
