package com.github.xdptdr.mbjaxrs.a.ubi;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class UbiDynamicFeature implements DynamicFeature {
	@Override
	public void configure(ResourceInfo ri, FeatureContext c) {
		if (ri.getResourceClass().isAnnotationPresent(UBI.class)) {
			c.register(UBIFeature.class);
		}
	}
}
