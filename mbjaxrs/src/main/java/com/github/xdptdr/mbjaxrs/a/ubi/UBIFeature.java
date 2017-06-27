package com.github.xdptdr.mbjaxrs.a.ubi;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

public class UBIFeature implements Feature {

	@Override
	public boolean configure(FeatureContext context) {
		context.register(new UBIFilter());
		return true;
	}

}
