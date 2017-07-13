package com.github.xdptdr.cxf;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.cxf.Bus;
import org.apache.cxf.Bus.BusState;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.extension.ExtensionManagerBus;
import org.apache.cxf.feature.Feature;

public class Aaron {

	private static void foo() {

		Bus bus = BusFactory.getDefaultBus();
		bar(bus);

		if (t()) {
			return;
		}

		boolean createIfNeeded = false;
		String className = null;

		BusFactory.clearDefaultBusForAnyThread(bus);
		bus = BusFactory.getAndSetThreadDefaultBus(bus);
		bus = BusFactory.getDefaultBus(createIfNeeded);
		bus = BusFactory.getThreadDefaultBus();
		bus = BusFactory.getThreadDefaultBus(createIfNeeded);
		BusFactory busFactory = BusFactory.newInstance();
		busFactory = BusFactory.newInstance(className);
		@SuppressWarnings("unused")
		boolean possiblySetDefaultBusReturnValue = BusFactory.possiblySetDefaultBus(bus);
		BusFactory.setDefaultBus(bus);
		BusFactory.setThreadDefaultBus(bus);
		bus = busFactory.createBus();

	}

	private static void bar(Bus bus) {

		System.out.println(Bus.DEFAULT_BUS_ID);

		System.out.println(bus.getState());
		azzert(bus.getState() instanceof BusState);
		System.out.println(bus.getId());
		Collection<Feature> features = bus.getFeatures();
		for (Feature feature : features) {
			aze(feature);
		}
		Map<String, Object> properties = bus.getProperties();
		for (Entry<String, Object> entry : properties.entrySet()) {
			System.out.println(entry.getKey() + " : " + os(entry.getValue()));
		}
		azzert(bus.getProperty("bus") == bus.getProperty("cxf"));

		System.out.println(ExtensionManagerBus.BUS_PROPERTY_NAME);
		if (bus instanceof ExtensionManagerBus) {
			ExtensionManagerBus emb = (ExtensionManagerBus) bus;
			if (!t()) {
				emb.initialize();
				emb.shutdown();
			}
		}

		if (t()) {
			return;
		}

		Object extensionTypeO = null;
		String name = null;
		boolean wait = false;

		@SuppressWarnings("unused")
		Object extension = bus.getExtension(Object.class);
		@SuppressWarnings("unused")
		boolean hasExtension = bus.hasExtensionByName(name);
		bus.setExtension(extensionTypeO, Object.class);
		bus.shutdown(wait);

	}

	private static void azzert(boolean b) {
		if (!b) {
			throw new RuntimeException("Assertion Error");
		}

	}

	private static String os(Object value) {
		if (value == null) {
			return "n$";

		} else if (value instanceof String) {
			return "s$" + value;
		} else {
			return "c$" + value.getClass().getName();
		}
	}

	private static void aze(Feature feature) {
		System.out.println(feature.getClass().getName());
	}

	private static boolean t() {
		return true;
	}

	public static void main(String[] args) {
		foo();
	}

}
