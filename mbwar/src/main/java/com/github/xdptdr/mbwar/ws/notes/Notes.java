package com.github.xdptdr.mbwar.ws.notes;

import javax.xml.ws.Action;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.BindingType;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Endpoint;
import javax.xml.ws.EndpointContext;
import javax.xml.ws.EndpointReference;
import javax.xml.ws.FaultAction;
import javax.xml.ws.Holder;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.ProtocolException;
import javax.xml.ws.Provider;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.RespectBinding;
import javax.xml.ws.RespectBindingFeature;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;
import javax.xml.ws.Service;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebFault;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.WebServicePermission;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.WebServiceRefs;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.PortInfo;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.http.HTTPBinding;
import javax.xml.ws.http.HTTPException;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.soap.AddressingFeature;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.MTOMFeature;
import javax.xml.ws.soap.SOAPBinding;
import javax.xml.ws.soap.SOAPFaultException;
import javax.xml.ws.spi.Invoker;
import javax.xml.ws.spi.ServiceDelegate;
import javax.xml.ws.spi.WebServiceFeatureAnnotation;
import javax.xml.ws.spi.http.HttpContext;
import javax.xml.ws.spi.http.HttpExchange;
import javax.xml.ws.spi.http.HttpHandler;
import javax.xml.ws.wsaddressing.W3CEndpointReference;
import javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder;

import com.github.xdptdr.notes.N;

public class Notes {

	private static void notes(N n) {

		n.todo(Action.class);
		n.todo(AsyncHandler.class);
		n.todo(Binding.class);
		n.todo(BindingProvider.class);
		n.todo(BindingType.class);
		n.todo(Dispatch.class);
		n.todo(Endpoint.class);
		n.todo(EndpointContext.class);
		n.todo(EndpointReference.class);
		n.todo(FaultAction.class);
		n.todo(Holder.class);
		n.todo(LogicalMessage.class);
		n.todo(ProtocolException.class);
		n.todo(Provider.class);
		n.todo(RequestWrapper.class);
		n.todo(RespectBinding.class);
		n.todo(RespectBindingFeature.class);
		n.todo(Response.class);
		n.todo(ResponseWrapper.class);
		n.todo(Service.class);
		n.todo(ServiceMode.class);
		n.todo(WebEndpoint.class);
		n.todo(WebFault.class);
		n.todo(WebServiceClient.class);
		n.todo(WebServiceContext.class);
		n.todo(WebServiceException.class);
		n.todo(WebServiceFeature.class);
		n.todo(WebServicePermission.class);
		n.todo(WebServiceProvider.class);
		n.todo(WebServiceRef.class);
		n.todo(WebServiceRefs.class);

		n.todo(Handler.class);
		n.todo(HandlerResolver.class);
		n.todo(LogicalHandler.class);
		n.todo(LogicalMessageContext.class);
		n.todo(MessageContext.class);
		n.todo(PortInfo.class);

		n.todo(SOAPHandler.class);
		n.todo(SOAPMessageContext.class);

		n.todo(HTTPBinding.class);
		n.todo(HTTPException.class);

		n.todo(Addressing.class);
		n.todo(AddressingFeature.class);
		n.todo(MTOM.class);
		n.todo(MTOMFeature.class);
		n.todo(SOAPBinding.class);
		n.todo(SOAPFaultException.class);

		n.todo(Invoker.class);
		n.todo(javax.xml.ws.spi.Provider.class);
		n.todo(ServiceDelegate.class);
		n.todo(WebServiceFeatureAnnotation.class);

		n.todo(HttpContext.class);
		n.todo(HttpExchange.class);
		n.todo(HttpHandler.class);

		n.todo(W3CEndpointReference.class);
		n.todo(W3CEndpointReferenceBuilder.class);
	}

	public static void main(String[] args) {
		N n = new N();
		notes(n);
		n.sumUp();
	}

}
