package com.github.xdptdr.cxf;

import javax.jws.WebMethod;

import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.endpoint.EndpointException;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.jaxws.JaxwsServiceBuilder;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.wsdl.service.factory.ReflectionServiceFactoryBean;

public class Abarim {

	private static JaxwsServiceBuilder jaxwsServiceBuilder;
	private static ServiceInfo serviceInfo;
	private static ReflectionServiceFactoryBean reflectionServiceFactoryBean;
	private static EndpointInfo endpointInfo;
	private static Endpoint endpoint;
	private static JaxWsServerFactoryBean jaxWsServerFactoryBean;
	private static Server server;

	@WebMethod
	public String foo(String in) {
		return in + "!" + in;
	}

	public static void main(String[] args) throws EndpointException {
		jaxwsServiceBuilder = new JaxwsServiceBuilder();
		reflectionServiceFactoryBean = jaxwsServiceBuilder.getServiceFactory();
		jaxwsServiceBuilder.setServiceClass(Abarim.class);
		serviceInfo = jaxwsServiceBuilder.createService();
		endpointInfo = reflectionServiceFactoryBean.getEndpointInfo();
		endpoint = reflectionServiceFactoryBean.createEndpoint(endpointInfo);

		jaxWsServerFactoryBean = new JaxWsServerFactoryBean();
		jaxWsServerFactoryBean.setServiceClass(jaxwsServiceBuilder.getServiceClass());
		jaxWsServerFactoryBean.setAddress("http://localhost:9000/Abarim");
		jaxWsServerFactoryBean.setServiceBean(new Abarim());
		
		 server = jaxWsServerFactoryBean.create();

	}
}
