package com.github.xdptdr.cxf;

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
import org.apache.cxf.annotations.Policy.Placement;
import org.apache.cxf.annotations.WSDLDocumentation.DEFAULT;
import org.apache.cxf.annotations.Provider;
import org.apache.cxf.annotations.SchemaValidation;
import org.apache.cxf.annotations.UseAsyncMethod;
import org.apache.cxf.annotations.WSDLDocumentation;
import org.apache.cxf.annotations.WSDLDocumentationCollection;
import org.apache.cxf.interceptor.AbstractLoggingInterceptor;

@DataBinding(value = org.apache.cxf.databinding.DataBinding.class, ref = "")
@EndpointProperties({ @EndpointProperty(value = { "" }, key = "", ref = "") })
@EvaluateAllEndpoints
@FactoryType(value = FactoryType.Type.Singleton, args = { "" }, factoryClass = FactoryType.DEFAULT.class)
@FastInfoset(force = false, serializerAttributeValueMapMemoryLimit = -1, serializerCharacterContentChunkMapMemoryLimit = -1, serializerMaxAttributeValueSize = -1, serializerMaxCharacterContentChunkSize = -1, serializerMinAttributeValueSize = -1, serializerMinCharacterContentChunkSize = -1)
@GZIP(force = false, threshold = -1)
@Logging(inLocation = "<logging>", outLocation = "<logging>", limit = AbstractLoggingInterceptor.DEFAULT_LIMIT, pretty = false, showBinary = false)
@Policies({
		@Policy(uri = "", placement = Policy.Placement.DEFAULT, faultClass = Policy.DEFAULT.class, includeInWSDL = true) })
@Provider(value = Provider.Type.Feature, scope = Provider.Scope.All)
@SchemaValidation(type = SchemaValidation.SchemaValidationType.BOTH, schemas = { "" })
@WSDLDocumentationCollection({
		@WSDLDocumentation(value = "", placement = WSDLDocumentation.Placement.DEFAULT, faultClass = WSDLDocumentation.DEFAULT.class) })
public class Abba {

	@Policies({ @Policy(uri = "") })
	@SchemaValidation
	@UseAsyncMethod(always = false)
	@WSDLDocumentationCollection({ @WSDLDocumentation("") })
	public void foo() {

	}

	public static void main(String[] args) {

		Class<?>[] classes = new Class<?>[] { DataBinding.class, EndpointProperties.class, EndpointProperty.class,
				EvaluateAllEndpoints.class, FactoryType.class, FastInfoset.class, GZIP.class, Logging.class,
				Policies.class, Policy.class, Provider.class, SchemaValidation.class, UseAsyncMethod.class,
				WSDLDocumentation.class, WSDLDocumentationCollection.class };
	}
}
