package com.github.xdptdr.notes.jee.jaxrs;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.github.xdptdr.mbwar.jaxrs.bar.BAR;
import com.github.xdptdr.mbwar.jaxrs.bar.BarBean;
import com.github.xdptdr.mbwar.jaxrs.bar.BarEndpoint;
import com.github.xdptdr.mbwar.jaxrs.clients.aze.AzeCLI;
import com.github.xdptdr.mbwar.jaxrs.clients.bar.BarCLI;
import com.github.xdptdr.mbwar.jaxrs.clients.cuk.CukCLI;
import com.github.xdptdr.mbwar.jaxrs.clients.gok.GokCLI;
import com.github.xdptdr.mbwar.jaxrs.clients.hej.HejCLI;
import com.github.xdptdr.mbwar.jaxrs.clients.iao.IaoCLI;
import com.github.xdptdr.mbwar.jaxrs.clients.jey.JeyCLI;
import com.github.xdptdr.mbwar.jaxrs.clients.kol.KolCLI;
import com.github.xdptdr.mbwar.jaxrs.clients.lim.LimCLI;
import com.github.xdptdr.mbwar.jaxrs.clients.mux.MuxCLI;
import com.github.xdptdr.mbwar.jaxrs.clients.nak.NakCLI;
import com.github.xdptdr.mbwar.jaxrs.clients.ort.OrtCLI;
import com.github.xdptdr.mbwar.jaxrs.clients.pif.PifCLI;
import com.github.xdptdr.mbwar.jaxrs.clients.qux.QuxCLI;
import com.github.xdptdr.mbwar.jaxrs.clients.reb.RebCLI;
import com.github.xdptdr.mbwar.jaxrs.clients.sog.SogCLI;
import com.github.xdptdr.mbwar.jaxrs.clients.sog.TadCLI;
import com.github.xdptdr.mbwar.jaxrs.clients.ubi.UbiCLI;
import com.github.xdptdr.mbwar.jaxrs.clients.vej.VejCLI;
import com.github.xdptdr.mbwar.jaxrs.clients.vej.WuxCLI;
import com.github.xdptdr.mbwar.jaxrs.cuk.CukEndpoint;
import com.github.xdptdr.mbwar.jaxrs.dal.DalEndpoint;
import com.github.xdptdr.mbwar.jaxrs.eta.EtaEndpoint;
import com.github.xdptdr.mbwar.jaxrs.foo.FooEndpoint;
import com.github.xdptdr.mbwar.jaxrs.gok.GokEndpoint;
import com.github.xdptdr.mbwar.jaxrs.gok.HejEndpoint;
import com.github.xdptdr.mbwar.jaxrs.iao.IaoEndpoint;
import com.github.xdptdr.mbwar.jaxrs.jey.JeyEndpoint;
import com.github.xdptdr.mbwar.jaxrs.kol.KolEndpoint;
import com.github.xdptdr.mbwar.jaxrs.lim.LimEndpoint;
import com.github.xdptdr.mbwar.jaxrs.mux.MuxEndpoint;
import com.github.xdptdr.mbwar.jaxrs.nak.NakEndpoint;
import com.github.xdptdr.mbwar.jaxrs.ort.OrtEndpoint;
import com.github.xdptdr.mbwar.jaxrs.pif.PifEndpoint;
import com.github.xdptdr.mbwar.jaxrs.qux.QuxEndpoint;
import com.github.xdptdr.mbwar.jaxrs.reb.RebEndpoint;
import com.github.xdptdr.mbwar.jaxrs.sog.SogEndpoint;
import com.github.xdptdr.mbwar.jaxrs.tad.TadEndpoint;
import com.github.xdptdr.mbwar.jaxrs.ubi.UBIFeature;
import com.github.xdptdr.mbwar.jaxrs.ubi.UbiDynamicFeature;
import com.github.xdptdr.mbwar.jaxrs.ubi.UbiEndpoint;
import com.github.xdptdr.mbwar.jaxrs.vej.VejEndpoint;
import com.github.xdptdr.mbwar.jaxrs.wux.WuxEndpoint;
import com.github.xdptdr.notes.N;
import com.sun.mail.imap.protocol.Status;

public class Notes {

	public static void notes(N n) {

		/* 1 Set up */

		/* 1.1 JAX-RS application */

		n.s("There are several ways to set up a JAX-RS application, which are described in Chapter 2 of the JSR 339 JAX-RS specification.");

		n.s("In these examples, we will define everything JAX-RS related with annotations.");

		n.s("To define the servlet mapping of JAX-RS endpoints to /rs, we use the ").k(ApplicationPath.class)
				.s(" annotation on the class ").k(MyJAXRSApplication.class).s(" which extends ").k(Application.class);

		/* 1.2 Very simple JAX-RS endpoint */

		n.s("Our first JAX-RS endpoint is ").k(AzeEndpoint.class);

		n.s("It is accessible at /rs/aze/get, and will respond to GET HTTP requests.");

		n.s("To create such an endpoint with annotations, we only need to use the ")
				.k(Provider.class, Path.class, GET.class).s(" annotations");

		n.k(Provider.class)
				.s(" is used for autodiscovery, so that the JAX-RS framework can find the class automatically");

		n.k(Path.class).s("is used to specify the path, both at the class and at the method level");

		n.k(GET.class).s("is used to introduce a GET HTTP method");

		/* 1.3 JAX-RS client */

		n.s("The JAX-RS specification also defines a client API, which we will use in small programs to interact with our endpoints.");

		n.s("Because these programs require an actual implementation of JAX-RS, and not only the JAX-RS API, they are located in the 'standalones' maven module.");

		n.k(AzeCLI.class).s(" is the client for this section.");

		n.s("It uses ").k(ClientBuilder.class).s(" to obtain an instance of ").k(Client.class);

		/* 2 REST Endpoint */

		n.s("JAX-RS is the Java API for RESTful Web Services.");

		n.s("Unfortunately, no specification defines what a RESTful web service actually is, but some guidelines are outlined in the wikipedia article about Representational state transfer.");

		n.s("https://en.wikipedia.org/wiki/Representational_state_transfer#Applied_to_Web_services");

		n.s("We will follow these guidelines in this section, and create a 'bar' manager ").k(BarEndpoint.class);

		n.s("A bar ").k(BarBean.class).s(" is a simple entity which contains a single string property.");

		n.s("Methods are defined at two level : the root level defines GET, PUT, POST and DELETE methods, and the entity level defines only GET, PUT and DELETE");

		n.s("HTTP methods are specified with the ").k(GET.class, PUT.class, POST.class, DELETE.class).s(" annotations");

		/* 3. RESTfulness */

		/* 3.1 RESTful endpoint */

		n.s("In this section, will create a REST client as prescribed by Wikipedia, to manage things called cuks.");

		n.s("This will make us use most of the HTTP methods annotations, ie ").k(GET.class, POST.class, PUT.class,
				DELETE.class, HEAD.class);

		n.s("We also use the ").k(PathParam.class).s(" annotation to match part of the request url, and the ")
				.k(Response.class).s(" class for the responses");

		n.k(BarEndpoint.class).s(" is the endpoint, and the test program is a little CLI called ").k(BarCLI.class);

		n.k(Produces.class, Consumes.class)
				.s(" are used to specify the mediatypes for requests and/or responses which have a body");

		n.k(MediaType.class)
				.s(" is used to reference the media types, but in most cases, using plain strings would work equally");

		n.s("All methods return an instance of ").k(Response.class);

		n.k(PathParam.class).s(" is used to get the id of entity-level methods");

		n.k(Status.class).s(" is used when setting HTTP statuses on responses");

		n.s("Input is plain text, and output is JSON");

		n.s("Besides standard methods, the endpoint defines a custom HTTP 'BAR' method, which is introduced with the help of the ")
				.k(HttpMethod.class).s(" annotation in ").k(BAR.class);

		/* 3.2 RESTful client */

		n.k(BarCLI.class).s(" is a CLI that can interact with ").k(BarEndpoint.class);

		n.s("It's a simple read-eval-print loop which expects its arguments to conform to some very precise and simple syntax.");

		n.s("Besides the use of ").k(Entity.class).s(", it does not introduce new JAX-RS objects");

		/* 4. Misc */

		n.k(CukEndpoint.class).s(" illustrates the uses of ").k(QueryParam.class, PathParam.class, MatrixParam.class,
				CookieParam.class, FormParam.class, HeaderParam.class);

		n.k(CukCLI.class).s(" is the CLI to ").k(CukEndpoint.class);

		n.k(DalEndpoint.class).s(" illustrates the use of ").k(Encoded.class).s(" for ").k(QueryParam.class,
				PathParam.class, MatrixParam.class);

		n.k(EtaEndpoint.class).s("illustrates the use of ").k(DefaultValue.class).s(" for ").k(QueryParam.class,
				MatrixParam.class, CookieParam.class, FormParam.class, HeaderParam.class);

		n.k(FooEndpoint.class).s(" illustrate the use of ").k(Context.class).s(" to retrieved ")
				.k(Application.class, UriInfo.class, HttpHeaders.class, Request.class, SecurityContext.class,
						Providers.class, ResourceContext.class, Configuration.class, ServletConfig.class,
						ServletContext.class, HttpServletRequest.class, HttpServletResponse.class)
				.s(" and dumps some information about these objects");

		n.k(GokEndpoint.class, GokCLI.class).s(" illustrates the use of ").k(Link.class);

		n.k(HejEndpoint.class, HejCLI.class).s(" illustrates the use of ").k(Form.class);

		n.k(IaoEndpoint.class, IaoCLI.class).s(" illustrates the use of ").k(Variant.class);

		n.k(JeyEndpoint.class, JeyCLI.class).s(" illustrates the use of ").k(NewCookie.class);

		n.k(KolEndpoint.class, KolCLI.class).s(" illustrates how to use ").k(EntityTag.class)
				.s(" with versioning, which is the simplest way of implementing etags.");

		n.k(LimEndpoint.class, LimCLI.class).s(" illustrates how to use ").k(CacheControl.class);

		n.k(MuxEndpoint.class, MuxCLI.class).s(" illustrates how to use ").k(BeanParam.class);

		n.k(NakEndpoint.class, NakCLI.class).s(" illustrates how to use ").k(PathSegment.class);

		n.k(OrtEndpoint.class, OrtCLI.class).s(" illustrates how to use ").k(ClientRequestFilter.class,
				ClientResponseFilter.class, ClientRequestContext.class, ClientResponseContext.class,
				ContainerRequestFilter.class, ContainerResponseFilter.class, ContainerRequestContext.class,
				ContainerResponseContext.class, PreMatching.class, ReaderInterceptor.class, WriterInterceptor.class,
				WriterInterceptorContext.class, ReaderInterceptorContext.class, InterceptorContext.class);

		n.k(BadRequestException.class, ClientErrorException.class, ForbiddenException.class,
				InternalServerErrorException.class, NotAcceptableException.class, NotAllowedException.class,
				NotAuthorizedException.class, NotFoundException.class, NotSupportedException.class,
				ProcessingException.class, RedirectionException.class, ServerErrorException.class,
				ServiceUnavailableException.class, WebApplicationException.class, ResponseProcessingException.class,
				NoContentException.class, UriBuilderException.class).s(" will are not covered here");

		n.k(PifEndpoint.class, PifCLI.class).s(" illustrates how to use ").k(MessageBodyReader.class,
				MessageBodyWriter.class);

		n.k(QuxEndpoint.class, QuxCLI.class).s(" illustrates how to use ").k(OPTIONS.class);

		n.k(RebEndpoint.class, RebCLI.class).s(" illustrates how to use ").k(Cookie.class);

		n.k(SogEndpoint.class, SogCLI.class).s(" illustrates how to use ").k(Invocation.class);

		n.k(TadEndpoint.class, TadCLI.class).s(" illustrates how to use ").k(Suspended.class, AsyncResponse.class,
				TimeoutHandler.class, WebTarget.class, AsyncInvoker.class, InvocationCallback.class,
				CompletionCallback.class, ConnectionCallback.class);

		n.k(SyncInvoker.class).s("is already covered, because implemented by ").k(Invocation.Builder.class)
				.s(" which is returned by the request() method of ").k(WebTarget.class)
				.s(" which is itself returned by the target(...) method of ").k(Client.class);

		n.k(UbiEndpoint.class, UbiCLI.class, UbiDynamicFeature.class, UBIFeature.class).s(" illustrates how to use ").k(
				DynamicFeature.class, ResourceInfo.class, FeatureContext.class, Feature.class, Configurable.class,
				Configuration.class);

		n.k(VejEndpoint.class, VejCLI.class).s(" illustrates how to use ").k(NameBinding.class);

		n.k(WuxEndpoint.class, WuxCLI.class).s(" illustrates how to use ").k(ParamConverter.class,
				ParamConverterProvider.class);

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
