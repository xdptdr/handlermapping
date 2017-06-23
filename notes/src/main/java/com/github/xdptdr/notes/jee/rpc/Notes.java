package com.github.xdptdr.notes.jee.rpc;

import javax.xml.rpc.Call;
import javax.xml.rpc.JAXRPCException;
import javax.xml.rpc.NamespaceConstants;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.ServiceFactory;
import javax.xml.rpc.Stub;
import javax.xml.rpc.encoding.DeserializationContext;
import javax.xml.rpc.encoding.Deserializer;
import javax.xml.rpc.encoding.DeserializerFactory;
import javax.xml.rpc.encoding.SerializationContext;
import javax.xml.rpc.encoding.Serializer;
import javax.xml.rpc.encoding.SerializerFactory;
import javax.xml.rpc.encoding.TypeMapping;
import javax.xml.rpc.encoding.TypeMappingRegistry;
import javax.xml.rpc.encoding.XMLType;
import javax.xml.rpc.handler.GenericHandler;
import javax.xml.rpc.handler.Handler;
import javax.xml.rpc.handler.HandlerChain;
import javax.xml.rpc.handler.HandlerInfo;
import javax.xml.rpc.handler.HandlerRegistry;
import javax.xml.rpc.handler.MessageContext;
import javax.xml.rpc.handler.soap.SOAPMessageContext;
import javax.xml.rpc.holders.BigDecimalHolder;
import javax.xml.rpc.holders.BigIntegerHolder;
import javax.xml.rpc.holders.BooleanHolder;
import javax.xml.rpc.holders.BooleanWrapperHolder;
import javax.xml.rpc.holders.ByteArrayHolder;
import javax.xml.rpc.holders.ByteHolder;
import javax.xml.rpc.holders.ByteWrapperHolder;
import javax.xml.rpc.holders.CalendarHolder;
import javax.xml.rpc.holders.DoubleHolder;
import javax.xml.rpc.holders.DoubleWrapperHolder;
import javax.xml.rpc.holders.FloatHolder;
import javax.xml.rpc.holders.FloatWrapperHolder;
import javax.xml.rpc.holders.Holder;
import javax.xml.rpc.holders.IntHolder;
import javax.xml.rpc.holders.IntegerWrapperHolder;
import javax.xml.rpc.holders.LongHolder;
import javax.xml.rpc.holders.LongWrapperHolder;
import javax.xml.rpc.holders.ObjectHolder;
import javax.xml.rpc.holders.QNameHolder;
import javax.xml.rpc.holders.ShortHolder;
import javax.xml.rpc.holders.ShortWrapperHolder;
import javax.xml.rpc.holders.StringHolder;
import javax.xml.rpc.server.ServiceLifecycle;
import javax.xml.rpc.server.ServletEndpointContext;
import javax.xml.rpc.soap.SOAPFaultException;

import com.github.xdptdr.notes.N;

public class Notes {

	private static void notes(N n) {
		n.todo(Call.class);
		n.todo(JAXRPCException.class);
		n.todo(NamespaceConstants.class);
		n.todo(ParameterMode.class);
		n.todo(Service.class);
		n.todo(ServiceException.class);
		n.todo(ServiceFactory.class);
		n.todo(Stub.class);

		n.todo(DeserializationContext.class);
		n.todo(Deserializer.class);
		n.todo(DeserializerFactory.class);
		n.todo(SerializationContext.class);
		n.todo(Serializer.class);
		n.todo(SerializerFactory.class);
		n.todo(TypeMapping.class);
		n.todo(TypeMappingRegistry.class);
		n.todo(XMLType.class);

		n.todo(GenericHandler.class);
		n.todo(Handler.class);
		n.todo(HandlerChain.class);
		n.todo(HandlerInfo.class);
		n.todo(HandlerRegistry.class);
		n.todo(MessageContext.class);

		n.todo(SOAPMessageContext.class);

		n.todo(BigDecimalHolder.class);
		n.todo(BigIntegerHolder.class);
		n.todo(BooleanHolder.class);
		n.todo(BooleanWrapperHolder.class);
		n.todo(ByteArrayHolder.class);
		n.todo(ByteHolder.class);
		n.todo(ByteWrapperHolder.class);
		n.todo(CalendarHolder.class);
		n.todo(DoubleHolder.class);
		n.todo(DoubleWrapperHolder.class);
		n.todo(FloatHolder.class);
		n.todo(FloatWrapperHolder.class);
		n.todo(Holder.class);
		n.todo(IntegerWrapperHolder.class);
		n.todo(IntHolder.class);
		n.todo(LongHolder.class);
		n.todo(LongWrapperHolder.class);
		n.todo(ObjectHolder.class);
		n.todo(QNameHolder.class);
		n.todo(ShortHolder.class);
		n.todo(ShortWrapperHolder.class);
		n.todo(StringHolder.class);

		n.todo(ServiceLifecycle.class);
		n.todo(ServletEndpointContext.class);

		n.todo(SOAPFaultException.class);
	}

	public static void main(String[] args) {
		N n = new N();
		notes(n);
		n.sumUp();
	}

}
