package com.github.xdptdr.cxf;

import javax.jws.WebMethod;

import org.apache.cxf.jaxws.JaxwsServiceBuilder;
import org.apache.cxf.service.model.ServiceInfo;

public class Abarim {

	private static JaxwsServiceBuilder jaxwsServiceBuilder;
	private static ServiceInfo serviceInfo;

	@WebMethod
	public String foo(String in) {
		return in + "!" + in;
	}

	public static void main(String[] args) {
		jaxwsServiceBuilder = new JaxwsServiceBuilder();
		jaxwsServiceBuilder.setServiceClass(Abarim.class);
		serviceInfo = jaxwsServiceBuilder.createService();
		
		
	}
}
