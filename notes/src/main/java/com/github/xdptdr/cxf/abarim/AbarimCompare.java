package com.github.xdptdr.cxf.abarim;

import java.io.Closeable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.Binding;
import org.apache.cxf.databinding.DataBinding;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.WSDLGetInterceptor;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.MessageSenderInterceptor;
import org.apache.cxf.jaxws.interceptors.HolderInInterceptor;
import org.apache.cxf.jaxws.interceptors.HolderOutInterceptor;
import org.apache.cxf.jaxws.interceptors.SwAInInterceptor;
import org.apache.cxf.jaxws.interceptors.SwAOutInterceptor;
import org.apache.cxf.jaxws.interceptors.WrapperClassInInterceptor;
import org.apache.cxf.jaxws.interceptors.WrapperClassOutInterceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.invoker.Invoker;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.transport.MessageObserver;

public class AbarimCompare {

	public static void compare(Endpoint a, Endpoint b) {

		azzert(a.getActiveFeatures() == null);
		azzert(b.getActiveFeatures().size() == 0);

		Binding aBinding = a.getBinding();
		Binding bBinding = b.getBinding();
		azzert(aBinding != null);
		azzert(bBinding != null);
		azzert(aBinding != bBinding);
		compare(aBinding, bBinding);

		List<Closeable> aCleanupHooks = a.getCleanupHooks();
		azzert(aCleanupHooks.size() == 0);
		azzert(aCleanupHooks == b.getCleanupHooks());

		EndpointInfo endpointInfo = a.getEndpointInfo();
		azzert(endpointInfo != null);
		azzert(endpointInfo == b.getEndpointInfo());

		Executor executor = a.getExecutor();
		azzert(executor != null);
		azzert(executor == b.getExecutor());

		MessageObserver aInFaultObserver = a.getInFaultObserver();
		final MessageObserver bInFaultObserver = b.getInFaultObserver();
		azzert(aInFaultObserver != null);
		azzert(bInFaultObserver != null);
		azzert(aInFaultObserver != bInFaultObserver);

		MessageObserver aOutFaultObserver = a.getOutFaultObserver();
		MessageObserver bOutFaultObserver = b.getOutFaultObserver();
		azzert(aOutFaultObserver != null);
		azzert(bOutFaultObserver != null);
		azzert(aOutFaultObserver != bOutFaultObserver);

		List<Interceptor<? extends Message>> aInInterceptors = a.getInInterceptors();
		List<Interceptor<? extends Message>> bInInterceptors = b.getInInterceptors();
		azzert(aInInterceptors != null);
		azzert(bInInterceptors != null);
		azzert(aInInterceptors != bInInterceptors);
		compareInInterceptors(aInInterceptors, bInInterceptors);

		List<Interceptor<? extends Message>> aOutInterceptors = a.getOutInterceptors();
		List<Interceptor<? extends Message>> bOutInterceptors = b.getOutInterceptors();
		azzert(aOutInterceptors != null);
		azzert(bOutInterceptors != null);
		azzert(aOutInterceptors != bOutInterceptors);
		compareOutInterceptors(aOutInterceptors, bOutInterceptors);

		Service aService = a.getService();
		Service bService = b.getService();
		azzert(aService != null);
		azzert(bService != null);
		azzert(aService == bService);
		compare(aService, bService);

	}

	private static void compareInInterceptors(List<Interceptor<? extends Message>> a,
			List<Interceptor<? extends Message>> b) {
		azzert(a.size() == 3);
		azzert(b.size() == 4);

		for (Class<?> clazz : new Class<?>[] { WrapperClassInInterceptor.class, HolderInInterceptor.class,
				SwAInInterceptor.class }) {
			azzertContainsT(a, clazz);
			azzertContainsT(b, clazz);
		}

		azzertContainsT(b, WSDLGetInterceptor.class);

	}

	private static void compareOutInterceptors(List<Interceptor<? extends Message>> a,
			List<Interceptor<? extends Message>> b) {
		azzert(a.size() == 4);
		azzert(b.size() == 4);

		for (Class<?> clazz : new Class<?>[] { MessageSenderInterceptor.class, SwAOutInterceptor.class,
				WrapperClassOutInterceptor.class, HolderOutInterceptor.class }) {
			azzertContainsT(a, clazz);
			azzertContainsT(b, clazz);
		}

	}

	private static void azzertContainsT(List<?> list, Class<?> clazz) {
		for (Object o : list) {
			if (o.getClass() == clazz) {
				return;
			}
		}
		throw new RuntimeException("Assertion Error");

	}

	private static void compare(Service a, Service b) {
		DataBinding dataBinding = a.getDataBinding();
		azzert(dataBinding != null);
		azzert(dataBinding == b.getDataBinding());

		Map<QName, Endpoint> endpoints = a.getEndpoints();
		azzert(endpoints != null);
		azzert(endpoints == b.getEndpoints());

		Executor executor = a.getExecutor();
		azzert(executor != null);
		azzert(executor == b.getExecutor());

		Invoker invoker = a.getInvoker();
		azzert(invoker != null);
		azzert(invoker == b.getInvoker());

		QName name = a.getName();
		azzert(name != null);
		azzert(name == b.getName());

		List<ServiceInfo> serviceInfos = a.getServiceInfos();
		azzert(serviceInfos != null);
		azzert(serviceInfos == b.getServiceInfos());

	}

	private static void compare(Binding a, Binding b) {
		BindingInfo bindingInfo = a.getBindingInfo();
		azzert(bindingInfo != null);
		azzert(bindingInfo == b.getBindingInfo());
	}

	private static void azzert(boolean b) {
		if (!b) {
			throw new RuntimeException("Assertion Error");
		}
	}

}
