package com.github.xdptdr.cxf;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
import org.apache.cxf.endpoint.ConduitSelector;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.endpoint.EndpointException;
import org.apache.cxf.endpoint.EndpointImpl;
import org.apache.cxf.endpoint.PreexistingConduitSelector;
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
import org.apache.cxf.service.model.Extensible;
import org.apache.cxf.service.model.FaultInfo;
import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.MessagePartInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.transport.Conduit;
import org.apache.cxf.transport.local.LocalConduit;
import org.apache.cxf.transport.local.LocalDestination;
import org.apache.cxf.transport.local.LocalTransportFactory;
import org.apache.cxf.ws.addressing.AddressingProperties;
import org.apache.cxf.ws.addressing.AttributedURIType;
import org.apache.cxf.ws.addressing.ContextUtils;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.apache.cxf.ws.addressing.JAXWSAConstants;
import org.apache.cxf.ws.addressing.MAPAggregator;
import org.apache.cxf.ws.addressing.Names;
import org.apache.cxf.ws.addressing.WSAContextUtils;
import org.apache.cxf.ws.addressing.impl.MAPAggregatorImpl;
import org.apache.cxf.ws.addressing.policy.MetadataConstants;
import org.apache.cxf.ws.policy.AssertionInfo;
import org.apache.cxf.ws.policy.AssertionInfoMap;
import org.apache.neethi.builders.PrimitiveAssertion;

import com.github.xdptdr.cxf.abdiel.AbdielFault;
import com.github.xdptdr.cxf.abdiel.AbdielWebFault;

public class Abdiel {

	private static final String CP_ENDPOINT_INFO_NAME_NOT_NULL = "endpointInfoNameNotNull";
	private static final String CP_MESSAGE_HAS_REPLY_TO_PROPERTY = "messageHasReplyToProperty";
	private static final String CP_HAS_REPLY_TO = "hasReplyTo";
	private static final String CP_REPLY_TO_ADDRESS = "replyToAddress";
	private static final String CP_MESSAGE_HAS_ENDPOINT_ADDRESS = "messageHasEndpointAddress";
	private static final String CP_HAS_CONDUIT = "hasConduit";
	private static final String CP_NULL_OP_INPUT_NAME = "nullOpInputName";
	private static final String CP_NULL_OP_OUTPUT_NAME = "nullOpOutputName";
	private static final String CP_BLP_VALUE = "blpValue";
	private static final String CP_OPERATION_HAS_INTERFACE = "operationHasInterface";
	private static final String CP_SYNTHETIC_BINDING_OPERATION_INFO = "syntheticBindingOperationInfo";
	private static final String CP_FAULT_INFO_HAS_OLD_ACTION_EXTENSION_ATTRIBUTE = "faultInfoHasOldActionExtensionAttribute";
	private static final String CP_FAULT_INFO_HAS_ACTION_EXTENSION_ATTRIBUTE = "faultInfoHasActionExtensionAttribute";
	private static final String CP_THROWABLE_IS_WEB_FAULT = "throwableIsWebFault";
	private static final String CP_MESSAGE_PART_INFO_CONCRETE_NAME_WEB_FAULT = "messagePartInfoConcreteNameWebFault";
	private static final String CP_MESSAGE_PART_INFO_TYPE_CLASS_IS_THROWABLE = "messagePartInfoTypeClassIsThrowable";
	private static final String CP_THROWABLE_NOT_NULL = "throwableNotNull";
	private static final String CP_FAULT_INFO_SIZE_NOT_ZERO = "faultInfoSizeNotZero";
	private static final String CP_HAS_FAULT_INFO = "hasFaultInfo";
	private static final String SOAP_EXTENSOR = "soapExtensor";
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
	private static final String CP_REQUESTOR = "requestor";
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

	private static void a() throws EndpointException, NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		CodePath cp = new CodePath();
		cp.set(CP_ADDRESSING_DISABLED, new Boolean[] { null, true, false }, 0);
		cp.set(CP_NULL_MESSAGE, new Boolean[] { false, true }, 0);
		cp.set(CP_NULL_EXCHANGE, new Boolean[] { false, true }, 0);
		cp.set(CP_MESSAGE_IN_FAULT, new Boolean[] { false, true }, 0);
		cp.set(CP_MESSAGE_OUT_FAULT, new Boolean[] { false, true }, 0);
		cp.set(CP_MESSAGE_OUT, new Boolean[] { false, true }, 1);
		cp.set(CP_REQUESTOR, new Boolean[] { false, true, null }, 1);
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
		cp.set(CP_MAPS_INBOUND, new Boolean[] { false, true }, 1);
		cp.set(CP_MAPS_OUTBOUND, new Boolean[] { false, true }, 0);
		cp.set(CP_MAPS_CLIENT, new Boolean[] { false, true }, 0);
		cp.set(CP_MESSAGE_CONTENT_IS_FAULT, new Boolean[] { false, true }, 1);
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
		cp.set(SOAP_EXTENSOR, new Boolean[] { false, true }, 0);
		cp.set(CP_HAS_FAULT_INFO, new Boolean[] { false, true }, 1);
		cp.set(CP_FAULT_INFO_SIZE_NOT_ZERO, new Boolean[] { false, true }, 1);
		cp.set(CP_THROWABLE_NOT_NULL, new Boolean[] { false, true }, 1);
		cp.set(CP_MESSAGE_PART_INFO_TYPE_CLASS_IS_THROWABLE, new Boolean[] { false, true }, 0);
		cp.set(CP_MESSAGE_PART_INFO_CONCRETE_NAME_WEB_FAULT, new Boolean[] { false, true }, 1);
		cp.set(CP_THROWABLE_IS_WEB_FAULT, new Boolean[] { false, true }, 0);
		cp.set(CP_FAULT_INFO_HAS_ACTION_EXTENSION_ATTRIBUTE, new Boolean[] { false, true }, 0);
		cp.set(CP_FAULT_INFO_HAS_OLD_ACTION_EXTENSION_ATTRIBUTE, new Boolean[] { false, true }, 0);
		cp.set(CP_SYNTHETIC_BINDING_OPERATION_INFO, new Boolean[] { false, true }, 0);
		cp.set(CP_OPERATION_HAS_INTERFACE, new Boolean[] { false, true }, 1);
		cp.set(CP_BLP_VALUE, new String[] { "bLP", "Throwable" }, 0);
		cp.set(CP_NULL_OP_INPUT_NAME, new Boolean[] { false, true }, 0);
		cp.set(CP_NULL_OP_OUTPUT_NAME, new Boolean[] { false, true }, 0);
		cp.set(CP_HAS_CONDUIT, new Boolean[] { false, true }, 0);
		cp.set(CP_MESSAGE_HAS_ENDPOINT_ADDRESS, new Boolean[] { false, true }, 1);
		cp.set(CP_HAS_REPLY_TO, new Boolean[] { false, true }, 0);
		cp.set(CP_REPLY_TO_ADDRESS, new Object[] { null, Names.WSA_ANONYMOUS_ADDRESS, Names.WSA_NONE_ADDRESS }, 0);
		cp.set(CP_MESSAGE_HAS_REPLY_TO_PROPERTY, new Boolean[] { false, true }, 1);
		cp.set(CP_ENDPOINT_INFO_NAME_NOT_NULL, new Boolean[] { false, true }, 1);

		Exchange exchange = null;
		if (!(boolean) cp.get(CP_NULL_EXCHANGE)) {
			exchange = new ExchangeImpl();

			if (!(boolean) cp.get(CP_NULL_BINDING_OPERATION_INFO)) {
				OperationInfo wrappedOperationInfo = null;
				if ((boolean) cp.get(CP_OPERATION_HAS_INTERFACE)) {
					ServiceInfo si = new ServiceInfo();
					InterfaceInfo intf = new InterfaceInfo(si, new QName("interfaceNS", "interfaceLP"));
					Constructor<OperationInfo> ctr = OperationInfo.class.getDeclaredConstructor(InterfaceInfo.class,
							QName.class);
					ctr.setAccessible(true);
					wrappedOperationInfo = ctr.newInstance(intf, new QName("operationNS", "operationLP"));
				} else {
					wrappedOperationInfo = new OperationInfo();
				}

				setSoapExtensor(wrappedOperationInfo, cp);

				if ((boolean) cp.get(CP_UNWRAPPED_CAPABLE)) {
					OperationInfo unwrappedOperationInfo = null;
					if ((boolean) cp.get(CP_OPERATION_HAS_INTERFACE)) {
						ServiceInfo si = new ServiceInfo();
						InterfaceInfo intf = new InterfaceInfo(si, new QName("interfaceNS", "interfaceLP"));
						Constructor<OperationInfo> ctr = OperationInfo.class.getDeclaredConstructor(InterfaceInfo.class,
								QName.class);
						ctr.setAccessible(true);
						unwrappedOperationInfo = ctr.newInstance(intf, new QName("operationNS", "operationLP"));
					} else {
						unwrappedOperationInfo = new OperationInfo();
					}
					addFault(unwrappedOperationInfo, cp);
					setSoapExtensor(unwrappedOperationInfo, cp);
					wrappedOperationInfo.setUnwrappedOperation(unwrappedOperationInfo);
				}

				if ((boolean) cp.get(CP_OPERATION_INFO_HAS_INPUT)) {
					MessageInfo messageInfo = getMessageInfo(cp, wrappedOperationInfo);
					if (wrappedOperationInfo.getUnwrappedOperation() != null) {
						MessageInfo messageInfo2 = getMessageInfo(cp, wrappedOperationInfo.getUnwrappedOperation());
						String inputName = null;
						if (!(boolean) cp.get(CP_NULL_OP_INPUT_NAME)) {
							inputName = "inputName";
						}
						wrappedOperationInfo.getUnwrappedOperation().setInput(inputName, messageInfo2);
					}
					String inputName = null;
					if (!(boolean) cp.get(CP_NULL_OP_INPUT_NAME)) {
						inputName = "inputName";
					}
					wrappedOperationInfo.setInput(inputName, messageInfo);
				}
				if ((boolean) cp.get(CP_OPERATION_INFO_HAS_OUTPUT)) {
					MessageInfo messageInfo = getMessageInfo(cp, wrappedOperationInfo);
					if (wrappedOperationInfo.getUnwrappedOperation() != null) {
						MessageInfo messageInfo2 = getMessageInfo(cp, wrappedOperationInfo.getUnwrappedOperation());
						String outputName = null;
						if (!(boolean) cp.get(CP_NULL_OP_OUTPUT_NAME)) {
							outputName = "outputName";
						}

						wrappedOperationInfo.getUnwrappedOperation().setOutput(outputName, messageInfo2);
					}
					String outputName = null;
					if (!(boolean) cp.get(CP_NULL_OP_OUTPUT_NAME)) {
						outputName = "outputName";
					}
					wrappedOperationInfo.setOutput(outputName, messageInfo);
				}

				addFault(wrappedOperationInfo, cp);
				BindingOperationInfo bindingOperationInfo = new BindingOperationInfo(null, wrappedOperationInfo);
				if ((boolean) cp.get(CP_SYNTHETIC_BINDING_OPERATION_INFO)) {
					bindingOperationInfo.setProperty("operation.is.synthetic", true);
				}
				setSoapExtensor(bindingOperationInfo, cp);
				if ((boolean) cp.get(CP_UNWRAPPED_CAPABLE)) {
					setSoapExtensor(bindingOperationInfo.getUnwrappedOperation(), cp);
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
			Boolean isRequestor = (Boolean) cp.get(CP_REQUESTOR);
			if (isRequestor != null) {
				message.put(Message.REQUESTOR_ROLE, isRequestor.booleanValue());
			}
			if ((boolean) cp.get(CP_HAS_CONTEXT_UTILS_ACTION)) {
				message.put(ContextUtils.ACTION, "actionName");
			}
			if ((boolean) cp.get(CP_HAS_SOAP_BINDING_CONSTANTS_ACTION)) {
				message.put(SoapBindingConstants.SOAP_ACTION, "actionName");
			}
			if ((boolean) cp.get(CP_MESSAGE_HAS_ENDPOINT_ADDRESS)) {
				message.put(Message.ENDPOINT_ADDRESS, "messageEndpointAddress");
			}
			if ((boolean) cp.get(CP_MESSAGE_HAS_REPLY_TO_PROPERTY)) {
				message.put(WSAContextUtils.REPLYTO_PROPERTY, "messageReplyTo");
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

		Endpoint endpoint = null;
		Bus bus = null;
		EndpointInfo endpointInfo = null;
		boolean nullEndpoint = (boolean) cp.get(CP_NULL_ENDPOINT);
		if (!nullEndpoint) {
			BindingInfo bindingInfo = new BindingInfo(null, "http://www.w3.org/2004/08/wsdl/http");
			endpointInfo = new EndpointInfo();
			if ((boolean) cp.get(CP_ENDPOINT_INFO_NAME_NOT_NULL)) {
				endpointInfo.setName(new QName("endpointInfoNS", "endpointInfoLP"));
			}
			endpointInfo.setBinding(bindingInfo);
			bus = BusFactory.getDefaultBus();
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

		if ((boolean) cp.get(CP_HAS_REPLY_TO)) {
			EndpointReferenceType replyToERT = new EndpointReferenceType();
			AttributedURIType replyToAURIT = new AttributedURIType();
			replyToAURIT.setValue((String) cp.get(CP_REPLY_TO_ADDRESS));
			replyToERT.setAddress(replyToAURIT);
			maps.setReplyTo(replyToERT);
		}

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

			Throwable t = null;
			if ((boolean) cp.get(CP_THROWABLE_NOT_NULL)) {
				if ((boolean) cp.get(CP_THROWABLE_IS_WEB_FAULT)) {
					t = new AbdielWebFault();
				} else {
					t = new Throwable();
				}
			}

			Fault fault = new Fault(t);
			if ((boolean) cp.get(CP_MESSAGE_CONTENT_IS_FAULT_WITH_FAULT_ACTION_ANNOTATION)) {
				fault = new AbdielFault(t);
			}

			if ((boolean) cp.get(CP_WSA_FAULT)) {
				fault.setFaultCode(new QName(Names.WSA_NAMESPACE_NAME, ""));
			}
			message.setContent(Exception.class, fault);
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

		if (exchange != null && message != null && (boolean) cp.get(CP_HAS_CONDUIT)) {
			LocalTransportFactory localTransportFactory = new LocalTransportFactory();
			EndpointReferenceType endpointReferenceType = new EndpointReferenceType();
			final AttributedURIType ertAURIT = new AttributedURIType();
			ertAURIT.setValue("");
			endpointReferenceType.setAddress(ertAURIT);
			LocalDestination localDestination = new LocalDestination(localTransportFactory, endpointReferenceType,
					endpointInfo, bus);
			LocalConduit localConduit = new LocalConduit(localTransportFactory, localDestination);
			PreexistingConduitSelector preexistingConduitSelector = new PreexistingConduitSelector(localConduit);
			exchange.put(ConduitSelector.class, preexistingConduitSelector);
		}

		if (exchange != null) {
			exchange.put(Bus.class, bus);
		}
		mapAggregatorImpl.handleMessage(message);

	}

	private static void addFault(OperationInfo operationInfo, CodePath cp) {

		if ((boolean) cp.get(CP_HAS_FAULT_INFO)) {

			QName aqn = new QName("aNS", "aLP");
			QName bqn = new QName("bNs", (String) cp.get(CP_BLP_VALUE));
			FaultInfo faultInfo = new FaultInfo(aqn, bqn, operationInfo);
			if ((boolean) cp.get(CP_FAULT_INFO_SIZE_NOT_ZERO)) {
				QName mpiQName = new QName("mpiNS", "mpiLP");
				MessagePartInfo messagePartInfo = new MessagePartInfo(mpiQName, faultInfo);
				if ((boolean) cp.get(CP_MESSAGE_PART_INFO_TYPE_CLASS_IS_THROWABLE)) {
					messagePartInfo.setTypeClass(Throwable.class);
				}

				if ((boolean) cp.get(CP_MESSAGE_PART_INFO_CONCRETE_NAME_WEB_FAULT)) {
					messagePartInfo.setConcreteName(new QName("webFaultNS", "webFaultLP"));
				}

				faultInfo.addMessagePart(messagePartInfo);
			}

			if ((boolean) cp.get(CP_FAULT_INFO_HAS_ACTION_EXTENSION_ATTRIBUTE)) {
				faultInfo.addExtensionAttribute(Names.WSAW_ACTION_QNAME, "actionName");
			}

			if ((boolean) cp.get(CP_FAULT_INFO_HAS_OLD_ACTION_EXTENSION_ATTRIBUTE)) {
				faultInfo.addExtensionAttribute(new QName(Names.WSA_NAMESPACE_WSDL_NAME_OLD, Names.WSAW_ACTION_NAME),
						"actionName");
			}

			operationInfo.addFault(faultInfo);

		}

	}

	private static void setSoapExtensor(Extensible extensible, CodePath cp) {
		if ((boolean) cp.get(SOAP_EXTENSOR)) {
			SoapOperationInfo soapOperationInfo = new SoapOperationInfo();
			soapOperationInfo.setAction("actionName");
			extensible.addExtensor(soapOperationInfo);
		}
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

	public static void main(String[] args) throws EndpointException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		a();
	}

}
