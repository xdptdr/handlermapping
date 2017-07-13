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
import org.apache.cxf.annotations.Provider;
import org.apache.cxf.annotations.SchemaValidation;
import org.apache.cxf.annotations.UseAsyncMethod;
import org.apache.cxf.annotations.WSDLDocumentation;
import org.apache.cxf.annotations.WSDLDocumentationCollection;

@DataBinding(value = org.apache.cxf.databinding.DataBinding.class, ref = "")
@EndpointProperties({@EndpointProperty})
public class Abba {

	public static void main(String[] args) {
		Class<?>[] classes = new Class<?>[] { DataBinding.class, EndpointProperties.class, EndpointProperty.class,
				EvaluateAllEndpoints.class, FactoryType.class, FastInfoset.class, GZIP.class, Logging.class,
				Policies.class, Policy.class, Provider.class, SchemaValidation.class, UseAsyncMethod.class,
				WSDLDocumentation.class, WSDLDocumentationCollection.class };
	}
}
