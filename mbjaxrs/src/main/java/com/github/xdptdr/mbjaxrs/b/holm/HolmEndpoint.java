package com.github.xdptdr.mbjaxrs.b.holm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/holm")
public class HolmEndpoint {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@HOLM
	public Response get() {
		return Response.ok("\u00E9toile").build();
	}

	public void classes() {
		@SuppressWarnings({ "deprecation", "unused" })
		Class<?>[] classes = new Class<?>[] {
				org.jboss.resteasy.plugins.interceptors.encoding.ServerContentEncodingAnnotationFeature.class,
				org.jboss.resteasy.plugins.interceptors.encoding.AcceptEncodingGZIPInterceptor.class,
				org.jboss.resteasy.plugins.interceptors.encoding.GZIPDecodingInterceptor.class,
				org.jboss.resteasy.plugins.interceptors.encoding.AcceptEncodingGZIPFilter.class,
				org.jboss.resteasy.plugins.interceptors.CacheControlFeature.class,
				org.jboss.resteasy.plugins.interceptors.encoding.ClientContentEncodingAnnotationFeature.class,
				org.jboss.resteasy.plugins.interceptors.encoding.GZIPEncodingInterceptor.class,

				org.jboss.resteasy.plugins.providers.multipart.MultipartWriter.class,
				org.jboss.resteasy.plugins.providers.multipart.MapMultipartFormDataWriter.class,
				org.jboss.resteasy.plugins.providers.multipart.MultipartFormAnnotationWriter.class,
				org.jboss.resteasy.plugins.providers.multipart.MultipartFormAnnotationReader.class,
				org.jboss.resteasy.plugins.providers.FileProvider.class,
				org.jboss.resteasy.plugins.providers.FileRangeWriter.class,
				org.jboss.resteasy.plugins.providers.jackson.ResteasyJackson2Provider.class,
				org.jboss.resteasy.plugins.providers.jaxb.JAXBXmlRootElementProvider.class,
				org.jboss.resteasy.plugins.providers.StringTextStar.class,
				org.jboss.resteasy.plugins.providers.jaxb.MapProvider.class,
				org.jboss.resteasy.plugins.providers.jaxb.JAXBElementProvider.class,
				org.jboss.resteasy.plugins.providers.StreamingOutputProvider.class,
				org.jboss.resteasy.plugins.providers.jaxb.JAXBXmlSeeAlsoProvider.class,
				org.jboss.resteasy.plugins.providers.ReaderProvider.class,
				org.jboss.resteasy.plugins.providers.FormUrlEncodedProvider.class,
				org.jboss.resteasy.plugins.providers.DocumentProvider.class,
				org.jboss.resteasy.plugins.providers.YamlProvider.class,
				org.jboss.resteasy.plugins.providers.IIOImageProvider.class,
				org.jboss.resteasy.plugins.providers.multipart.XopWithMultipartRelatedReader.class,
				org.jboss.resteasy.plugins.providers.jaxb.JAXBXmlTypeProvider.class,
				org.jboss.resteasy.plugins.providers.atom.AtomEntryProvider.class,
				org.jboss.resteasy.plugins.providers.multipart.ListMultipartWriter.class,
				org.jboss.resteasy.plugins.providers.multipart.MultipartReader.class,
				org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataReader.class,
				org.jboss.resteasy.plugins.providers.DefaultTextPlain.class,
				org.jboss.resteasy.plugins.providers.jsonp.JsonArrayProvider.class,
				org.jboss.resteasy.plugins.providers.JaxrsFormProvider.class,
				org.jboss.resteasy.plugins.providers.DefaultNumberWriter.class,
				org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataWriter.class,
				org.jboss.resteasy.plugins.providers.DataSourceProvider.class,
				org.jboss.resteasy.plugins.providers.jsonp.JsonStructureProvider.class,
				org.jboss.resteasy.plugins.providers.multipart.MapMultipartFormDataReader.class,
				org.jboss.resteasy.plugins.providers.multipart.XopWithMultipartRelatedWriter.class,
				org.jboss.resteasy.plugins.providers.SourceProvider.class,
				org.jboss.resteasy.plugins.providers.jaxb.XmlJAXBContextFinder.class,
				org.jboss.resteasy.plugins.providers.multipart.MimeMultipartProvider.class,
				org.jboss.resteasy.plugins.providers.jaxb.CollectionProvider.class,
				org.jboss.resteasy.plugins.providers.multipart.MultipartRelatedReader.class,
				org.jboss.resteasy.plugins.providers.multipart.ListMultipartReader.class,
				org.jboss.resteasy.plugins.providers.jsonp.JsonObjectProvider.class,
				org.jboss.resteasy.plugins.providers.atom.AtomFeedProvider.class,
				org.jboss.resteasy.plugins.providers.ByteArrayProvider.class,
				org.jboss.resteasy.plugins.providers.InputStreamProvider.class,
				org.jboss.resteasy.plugins.providers.multipart.MultipartRelatedWriter.class,

				org.jboss.resteasy.security.doseta.DigitalVerificationInterceptor.class,
				org.jboss.resteasy.security.doseta.DigitalSigningInterceptor.class,
				org.jboss.resteasy.security.smime.MultipartSignedReader.class,
				org.jboss.resteasy.security.smime.PKCS7SignatureWriter.class,
				org.jboss.resteasy.security.doseta.DigitalSigningHeaderDecoratorClientExecutionInterceptor.class,
				org.jboss.resteasy.security.doseta.DigitalVerificationHeaderDecoratorClientExecutionInterceptor.class,
				org.jboss.resteasy.security.doseta.ServerDigitalVerificationHeaderDecoratorFeature.class,
				org.jboss.resteasy.security.smime.MultipartSignedWriter.class,
				org.jboss.resteasy.security.doseta.ClientDigitalSigningHeaderDecoratorFeature.class,
				org.jboss.resteasy.security.smime.EnvelopedReader.class,
				org.jboss.resteasy.security.smime.EnvelopedWriter.class,
				org.jboss.resteasy.security.smime.PKCS7SignatureReader.class,
				org.jboss.resteasy.security.doseta.ClientDigitalVerificationHeaderDecoratorFeature.class,
				org.jboss.resteasy.security.doseta.ServerDigitalSigningHeaderDecoratorFeature.class,
				org.jboss.resteasy.security.smime.PKCS7SignatureTextWriter.class,

				org.jboss.resteasy.plugins.validation.ValidatorContextResolverCDI.class,
				org.jboss.resteasy.plugins.validation.ValidatorContextResolver.class,
				org.jboss.resteasy.api.validation.ResteasyViolationExceptionMapper.class };

	}

}
