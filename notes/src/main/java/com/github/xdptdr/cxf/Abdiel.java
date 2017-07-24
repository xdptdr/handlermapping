package com.github.xdptdr.cxf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.UnknownExtensibilityElement;
import javax.xml.namespace.QName;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.binding.soap.SoapBindingConstants;
import org.apache.cxf.binding.soap.model.SoapOperationInfo;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.endpoint.EndpointException;
import org.apache.cxf.endpoint.EndpointImpl;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.ExchangeImpl;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageImpl;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.ServiceImpl;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.cxf.ws.addressing.AddressingProperties;
import org.apache.cxf.ws.addressing.ContextUtils;
import org.apache.cxf.ws.addressing.JAXWSAConstants;
import org.apache.cxf.ws.addressing.MAPAggregator;
import org.apache.cxf.ws.addressing.Names;
import org.apache.cxf.ws.addressing.impl.MAPAggregatorImpl;
import org.apache.cxf.ws.addressing.policy.MetadataConstants;
import org.apache.cxf.ws.policy.AssertionInfo;
import org.apache.cxf.ws.policy.AssertionInfoMap;
import org.apache.neethi.builders.PrimitiveAssertion;

import com.github.xdptdr.cxf.abdiel.AbdielFault;

public class Abdiel {

	private static final String CP_UNWRAPPED_OPERATION_HAS_SOAP_EXTENSOR = "unwrappedOperationHasSoapExtensor";
	private static final String CP_MESSAGE_INFO_HAS_OLD_ACTION = "messageInfoHasOLDAction";
	private static final String CP_MESSAGE_INFO_HAS_NSWSA_ACTION = "messageInfoHasNSWSAAction";
	private static final String CP_MESSAGE_INFO_HAS_WSAW_WSDL_ACTION = "messageInfoHasWSAWWSDLAction";
	private static final String CP_MESSAGE_INFO_HAS_WSAW_ACTION = "messageInfoHasWSAWAction";
	private static final String CP_HAS_MESSAGE_INFO_CONTEXT_UTILS_ACTION = "hasMessageInfoContextUtilsAction";
	private static final String CP_OPERATION_INFO_HAS_OUTPUT = "operationInfoHasOutput";
	private static final String CP_OPERATION_INFO_HAS_INPUT = "operationInfoHasInput";
	private static final String CP_HAS_SOAP_BINDING_CONSTANTS_ACTION = "hasSoapBindingConstantsAction";
	private static final String CP_HAS_CONTEXT_UTILS_ACTION = "hasContextUtilsAction";
	private static final String CP_UNWRAPPED_CAPABLE = "unwrappedCapable";
	private static final String CP_NULL_BINDING_OPERATION_INFO = "nullBindingOperationInfo";
	private static final String CP_MESSAGE_CONTENT_IS_FAULT_WITH_FAULT_ACTION_ANNOTATION = "messageContentIsFaultWithFaultActionAnnotation";
	private static final String CP_WSA_FAULT = "wsaFault";
	private static final String CP_MESSAGE_CONTENT_IS_FAULT = "messageContentIsFault";
	private static final String CP_MAPS_INBOUND = "mapsInbound";
	private static final String CP_MAPS_OUTBOUND = "mapsOutbound";
	private static final String CP_MAPS_CLIENT = "mapsClient";
	private static final String CP_USING_PROPERTY = "usingProperty";
	private static final String CP_USING_ADRESSING_ADVISORY = "usingAdressingAdvisory";
	private static final String HAS_USING_ADDRESSING_2006_ASSERTION = "hasUsingAddressing2006Assertion";
	private static final String HAS_USING_ADDRESSING_2005_ASSERTION = "hasUsingAddressing2005Assertion";
	private static final String HAS_USING_ADDRESSING_2004_ASSERTION = "hasUsingAddressing2004Assertion";
	private static final String CP_HAS_ADDRESSING_ASSERTION = "hasAddressingAssertion";
	private static final String CP_HAS_ASSERTION_INFO_MAP = "hasAssertionInfoMap";
	private static final String CP_NULL_SERVICE = "nullService";
	private static final String CP_SERVICE_HAS_USING_ADDRESSING_EXTENSOR = "serviceHasUsingAddressingExtensor";
	private static final String CP_BINDING_HAS_USING_ADDRESSING_EXTENSOR = "bindingHasUsingAddressingExtensor";
	private static final String CP_ENDPOINT_INFO_HAS_USING_ADDRESSING_EXTENSOR = "endpointInfoHasUsingAddressingExtensor";
	private static final String CP_IS_ENDPOINT_USING_ADDRESSING = "isEndpointUsingAddressing";
	private static final String CP_NULL_ENDPOINT = "nullEndpoint";
	private static final String CP_IS_REQUESTOR = "isRequestor";
	private static final String CP_MESSAGE_OUT = "messageOut";
	private static final String CP_MESSAGE_OUT_FAULT = "messageOutFault";
	private static final String CP_MESSAGE_IN_FAULT = "messageInFault";
	private static final String CP_NULL_EXCHANGE = "nullExchange";
	private static final String CP_NULL_MESSAGE = "nullMessage";
	private static final String CP_ADDRESSING_DISABLED = "addressingDisabled";

	public static enum AdressGenericity {
		GENERIC_ANONYMOUS(Names.WSA_ANONYMOUS_ADDRESS), GENERIC_NONE(Names.WSA_NONE_ADDRESS), NOT_GENERIC("other");
		private final String address;

		AdressGenericity(String address) {
			this.address = address;
		}

		public String getAddress() {
			return address;
		}

	}

	public static class CodePath {

		private Map<String, Object> objects = new HashMap<>();

		public Object get(String key) {
			return objects.get(key);
		}

		public void set(String id, Object[] possibilities, int idx) {
			objects.put(id, possibilities[idx]);
		}

	}

	private static void addAssertion(AssertionInfoMap aim, QName qn) {
		aim.put(qn, Collections.singleton(new AssertionInfo(new PrimitiveAssertion())));

	}

	private static void a() throws EndpointException {

		CodePath cp = new CodePath();
		cp.set(CP_ADDRESSING_DISABLED, new Boolean[] { null, true, false }, 0);
		cp.set(CP_NULL_MESSAGE, new Boolean[] { false, true }, 0);
		cp.set(CP_NULL_EXCHANGE, new Boolean[] { false, true }, 0);
		cp.set(CP_MESSAGE_IN_FAULT, new Boolean[] { false, true }, 0);
		cp.set(CP_MESSAGE_OUT_FAULT, new Boolean[] { false, true }, 0);
		cp.set(CP_MESSAGE_OUT, new Boolean[] { false, true }, 1);
		cp.set(CP_IS_REQUESTOR, new Boolean[] { false, true, null }, 1);
		cp.set(CP_NULL_ENDPOINT, new Boolean[] { true, false }, 1);
		cp.set(CP_IS_ENDPOINT_USING_ADDRESSING, new Boolean[] { false, true, null }, 1);
		cp.set(CP_ENDPOINT_INFO_HAS_USING_ADDRESSING_EXTENSOR, new Boolean[] { false, true }, 0);
		cp.set(CP_BINDING_HAS_USING_ADDRESSING_EXTENSOR, new Boolean[] { false, true }, 0);
		cp.set(CP_SERVICE_HAS_USING_ADDRESSING_EXTENSOR, new Boolean[] { false, true }, 0);
		cp.set(CP_NULL_SERVICE, new Boolean[] { false, true }, 1);
		cp.set(CP_HAS_ASSERTION_INFO_MAP, new Boolean[] { false, true }, 1);
		cp.set(CP_HAS_ADDRESSING_ASSERTION, new Boolean[] { false, true }, 0);
		cp.set(HAS_USING_ADDRESSING_2004_ASSERTION, new Boolean[] { false, true }, 1);
		cp.set(HAS_USING_ADDRESSING_2005_ASSERTION, new Boolean[] { false, true }, 0);
		cp.set(HAS_USING_ADDRESSING_2006_ASSERTION, new Boolean[] { false, true }, 0);
		cp.set(CP_USING_ADRESSING_ADVISORY, new Boolean[] { false, true, null }, 1);
		cp.set(CP_USING_ADRESSING_ADVISORY, new Boolean[] { false, true, null }, 1);
		cp.set(CP_USING_PROPERTY, new Boolean[] { false, true, null }, 0);
		cp.set(CP_MAPS_INBOUND, new Boolean[] { false, true }, 0);
		cp.set(CP_MAPS_OUTBOUND, new Boolean[] { false, true }, 0);
		cp.set(CP_MAPS_CLIENT, new Boolean[] { false, true }, 0);
		cp.set(CP_MESSAGE_CONTENT_IS_FAULT, new Boolean[] { false, true }, 0);
		cp.set(CP_WSA_FAULT, new Boolean[] { false, true }, 0);
		cp.set(CP_MESSAGE_CONTENT_IS_FAULT_WITH_FAULT_ACTION_ANNOTATION, new Boolean[] { false, true }, 0);
		cp.set(CP_NULL_BINDING_OPERATION_INFO, new Boolean[] { false, true }, 0);
		cp.set(CP_UNWRAPPED_CAPABLE, new Boolean[] { false, true }, 1);
		cp.set(CP_HAS_CONTEXT_UTILS_ACTION, new Boolean[] { false, true }, 0);
		cp.set(CP_HAS_SOAP_BINDING_CONSTANTS_ACTION, new Boolean[] { false, true }, 0);
		cp.set(CP_OPERATION_INFO_HAS_INPUT, new Boolean[] { false, true }, 1);
		cp.set(CP_OPERATION_INFO_HAS_OUTPUT, new Boolean[] { false, true }, 1);
		cp.set(CP_HAS_MESSAGE_INFO_CONTEXT_UTILS_ACTION, new Boolean[] { false, true }, 0);
		cp.set(CP_MESSAGE_INFO_HAS_WSAW_ACTION, new Boolean[] { false, true }, 0);
		cp.set(CP_MESSAGE_INFO_HAS_WSAW_WSDL_ACTION, new Boolean[] { false, true }, 0);
		cp.set(CP_MESSAGE_INFO_HAS_NSWSA_ACTION, new Boolean[] { false, true }, 0);
		cp.set(CP_MESSAGE_INFO_HAS_OLD_ACTION, new Boolean[] { false, true }, 0);
		cp.set(CP_UNWRAPPED_OPERATION_HAS_SOAP_EXTENSOR, new Boolean[] { false, true }, 1);

		Exchange exchange = null;
		boolean nullExchange = (boolean) cp.get(CP_NULL_EXCHANGE);
		if (!nullExchange) {
			exchange = new ExchangeImpl();

			if (!(boolean) cp.get(CP_NULL_BINDING_OPERATION_INFO)) {
				OperationInfo operationInfo = new OperationInfo();
				if ((boolean) cp.get(CP_UNWRAPPED_OPERATION_HAS_SOAP_EXTENSOR)) {
					final SoapOperationInfo soapOperationInfo = new SoapOperationInfo();
					soapOperationInfo.setAction("actionName");
					operationInfo.addExtensor(soapOperationInfo);
				}
				if ((boolean) cp.get(CP_UNWRAPPED_CAPABLE)) {
					OperationInfo unwrappedOperationInfo = new OperationInfo();
					if ((boolean) cp.get(CP_UNWRAPPED_OPERATION_HAS_SOAP_EXTENSOR)) {
						final SoapOperationInfo soapOperationInfo = new SoapOperationInfo();
						soapOperationInfo.setAction("actionName");
						unwrappedOperationInfo.addExtensor(soapOperationInfo);
					}
					operationInfo.setUnwrappedOperation(unwrappedOperationInfo);
				}

				if ((boolean) cp.get(CP_OPERATION_INFO_HAS_INPUT)) {
					MessageInfo messageInfo = getMessageInfo(cp, operationInfo);
					if (operationInfo.getUnwrappedOperation() != null) {
						MessageInfo messageInfo2 = getMessageInfo(cp, operationInfo.getUnwrappedOperation());
						operationInfo.getUnwrappedOperation().setInput("", messageInfo2);
					}
					operationInfo.setInput("", messageInfo);
				}
				if ((boolean) cp.get(CP_OPERATION_INFO_HAS_OUTPUT)) {
					MessageInfo messageInfo = getMessageInfo(cp, operationInfo);
					if (operationInfo.getUnwrappedOperation() != null) {
						MessageInfo messageInfo2 = getMessageInfo(cp, operationInfo.getUnwrappedOperation());
						operationInfo.getUnwrappedOperation().setOutput("", messageInfo2);
					}
					operationInfo.setOutput("", messageInfo);
				}

				BindingOperationInfo bindingOperationInfo = new BindingOperationInfo(null, operationInfo);

				if ((boolean) cp.get(CP_UNWRAPPED_OPERATION_HAS_SOAP_EXTENSOR)) {
					final SoapOperationInfo soapOperationInfo = new SoapOperationInfo();
					soapOperationInfo.setAction("actionName");
					bindingOperationInfo.addExtensor(soapOperationInfo);
				}

				exchange.put(BindingOperationInfo.class, bindingOperationInfo);
			}
		}

		Message message = null;
		boolean nullMessage = (boolean) cp.get(CP_NULL_MESSAGE);
		if (!nullMessage) {
			message = new MessageImpl();
			message.setExchange(exchange);
			Boolean addressingDisabled = (Boolean) cp.get(CP_ADDRESSING_DISABLED);
			if (addressingDisabled != null) {
				message.put(MAPAggregator.ADDRESSING_DISABLED, addressingDisabled.booleanValue());
			}
		}

		boolean messageInFault = (boolean) cp.get(CP_MESSAGE_IN_FAULT);
		if (messageInFault && exchange != null) {
			exchange.setInFaultMessage(message);
		}

		boolean messageOutFault = (boolean) cp.get(CP_MESSAGE_OUT_FAULT);
		if (messageOutFault && exchange != null) {
			exchange.setOutFaultMessage(message);
		}

		boolean messageOut = (boolean) cp.get(CP_MESSAGE_OUT);
		if (messageOut && exchange != null) {
			exchange.setOutMessage(message);
		}

		Boolean isRequestor = (Boolean) cp.get(CP_IS_REQUESTOR);
		if (isRequestor != null) {
			message.put(Message.REQUESTOR_ROLE, isRequestor.booleanValue());
		}

		Endpoint endpoint = null;
		boolean nullEndpoint = (boolean) cp.get(CP_NULL_ENDPOINT);
		if (!nullEndpoint) {
			BindingInfo bindingInfo = new BindingInfo(null, "http://www.w3.org/2004/08/wsdl/http");
			EndpointInfo endpointInfo = new EndpointInfo();
			endpointInfo.setBinding(bindingInfo);
			Bus bus = BusFactory.getDefaultBus();
			Service service = null;
			if (!(boolean) cp.get(CP_NULL_SERVICE)) {
				service = new ServiceImpl();
			}
			endpoint = new EndpointImpl(bus, service, endpointInfo);
			if ((boolean) cp.get(CP_ENDPOINT_INFO_HAS_USING_ADDRESSING_EXTENSOR)) {
				ExtensibilityElement extensibilityElement = new UnknownExtensibilityElement();
				extensibilityElement.setElementType(Names.WSAW_USING_ADDRESSING_QNAME);
				endpointInfo.addExtensor(extensibilityElement);
			}
			if ((boolean) cp.get(CP_BINDING_HAS_USING_ADDRESSING_EXTENSOR)) {
				ExtensibilityElement extensibilityElement = new UnknownExtensibilityElement();
				extensibilityElement.setElementType(Names.WSAW_USING_ADDRESSING_QNAME);
				endpointInfo.getBinding().addExtensor(extensibilityElement);
			}
			if ((boolean) cp.get(CP_SERVICE_HAS_USING_ADDRESSING_EXTENSOR)) {
				if (endpointInfo.getService() != null) {
					ExtensibilityElement extensibilityElement = new UnknownExtensibilityElement();
					extensibilityElement.setElementType(Names.WSAW_USING_ADDRESSING_QNAME);
					endpointInfo.getService().addExtensor(extensibilityElement);
				}
			}

			endpoint.put(MAPAggregator.USING_ADDRESSING, cp.get(CP_IS_ENDPOINT_USING_ADDRESSING));

		}

		AssertionInfoMap aim = null;
		if ((boolean) cp.get(CP_HAS_ASSERTION_INFO_MAP)) {
			aim = new AssertionInfoMap(new ArrayList<>());
			message.put(AssertionInfoMap.class, aim);
		}

		if (aim != null) {
			if ((boolean) cp.get(CP_HAS_ADDRESSING_ASSERTION)) {
				addAssertion(aim, MetadataConstants.ADDRESSING_ASSERTION_QNAME);
			}
			if ((boolean) cp.get(HAS_USING_ADDRESSING_2004_ASSERTION)) {
				addAssertion(aim, MetadataConstants.USING_ADDRESSING_2004_QNAME);
			}
			if ((boolean) cp.get(HAS_USING_ADDRESSING_2005_ASSERTION)) {
				addAssertion(aim, MetadataConstants.USING_ADDRESSING_2005_QNAME);
			}
			if ((boolean) cp.get(HAS_USING_ADDRESSING_2006_ASSERTION)) {
				addAssertion(aim, MetadataConstants.USING_ADDRESSING_2005_QNAME);
			}
		}

		if (exchange != null) {
			exchange.put(Endpoint.class, endpoint);
		}

		AddressingProperties maps = new AddressingProperties();

		if ((boolean) cp.get(CP_MAPS_CLIENT)) {
			message.put(JAXWSAConstants.CLIENT_ADDRESSING_PROPERTIES, maps);
		}
		if ((boolean) cp.get(CP_MAPS_OUTBOUND)) {
			message.put(JAXWSAConstants.ADDRESSING_PROPERTIES_OUTBOUND, maps);
		}
		if ((boolean) cp.get(CP_MAPS_INBOUND)) {
			message.put(JAXWSAConstants.ADDRESSING_PROPERTIES_INBOUND, maps);
		}

		if ((boolean) cp.get(CP_MESSAGE_CONTENT_IS_FAULT)) {
			Fault fault = new Fault((Throwable) null);
			if ((boolean) cp.get(CP_MESSAGE_CONTENT_IS_FAULT_WITH_FAULT_ACTION_ANNOTATION)) {
				fault = new AbdielFault();
			}

			if ((boolean) cp.get(CP_WSA_FAULT)) {
				fault.setFaultCode(new QName(Names.WSA_NAMESPACE_NAME, ""));
			}
			message.setContent(Exception.class, fault);
		}

		if ((boolean) cp.get(CP_HAS_CONTEXT_UTILS_ACTION)) {
			message.put(ContextUtils.ACTION, "actionName");
		}
		if ((boolean) cp.get(CP_HAS_SOAP_BINDING_CONSTANTS_ACTION)) {
			message.put(SoapBindingConstants.SOAP_ACTION, "actionName");
		}
		MAPAggregatorImpl mapAggregatorImpl = new MAPAggregatorImpl();

		Boolean usingAdressingAdvisory = (Boolean) cp.get(CP_USING_ADRESSING_ADVISORY);
		if (usingAdressingAdvisory != null) {
			mapAggregatorImpl.setUsingAddressingAdvisory(usingAdressingAdvisory);
		}

		Boolean usingProperty = (Boolean) cp.get(CP_USING_PROPERTY);
		if (usingProperty != null) {
			message.put("org.apache.cxf.ws.addressing.using", usingProperty);
		}

		mapAggregatorImpl.handleMessage(message);

	}

	private static MessageInfo getMessageInfo(CodePath cp, OperationInfo operationInfo) {
		MessageInfo messageInfo = new MessageInfo(operationInfo, null, null);

		final QName qn = new QName("dummyNamespace", "dummyLocalPart");

		if ((boolean) cp.get(CP_HAS_MESSAGE_INFO_CONTEXT_UTILS_ACTION)) {
			messageInfo.setProperty(ContextUtils.ACTION, "actionName");
		}

		if ((boolean) cp.get(CP_MESSAGE_INFO_HAS_WSAW_ACTION)) {
			messageInfo.addExtensionAttribute(JAXWSAConstants.WSAW_ACTION_QNAME, qn);
		}
		if ((boolean) cp.get(CP_MESSAGE_INFO_HAS_WSAW_WSDL_ACTION)) {
			messageInfo.addExtensionAttribute(new QName(Names.WSA_NAMESPACE_WSDL_METADATA, Names.WSAW_ACTION_NAME), qn);
		}
		if ((boolean) cp.get(CP_MESSAGE_INFO_HAS_NSWSA_ACTION)) {
			messageInfo.addExtensionAttribute(new QName(JAXWSAConstants.NS_WSA, Names.WSAW_ACTION_NAME), qn);
		}
		if ((boolean) cp.get(CP_MESSAGE_INFO_HAS_OLD_ACTION)) {
			messageInfo.addExtensionAttribute(new QName(Names.WSA_NAMESPACE_WSDL_NAME_OLD, Names.WSAW_ACTION_NAME), qn);
		}

		return messageInfo;
	}

	public static void main(String[] args) throws EndpointException {
		a();
	}

}
