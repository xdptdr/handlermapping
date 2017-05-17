package com.github.xdptdr.jca;

import javax.resource.spi.ConfigProperty;

public class MyConfigPropertyAnnotatedClass {

	private String dynamicProp;

	@ConfigProperty(supportsDynamicUpdates = true, confidential = true)
	public String getProp() {
		return dynamicProp;
	}

	public void setProp(String prop) {
		this.dynamicProp = prop;
	}

}
