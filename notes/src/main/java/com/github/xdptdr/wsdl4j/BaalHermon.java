package com.github.xdptdr.wsdl4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.ibm.wsdl.util.IOUtils;
import com.ibm.wsdl.util.ObjectRegistry;
import com.ibm.wsdl.util.StringUtils;

public class BaalHermon {

	private static void foo() throws IOException {

		final String name = "name";
		Object object = new Object();
		Reader reader = new StringReader("hello");

		ObjectRegistry objectRegistry = new ObjectRegistry();
		objectRegistry.register(name, object);
		assert (objectRegistry.lookup(name) == object);
		objectRegistry.unregister(name);

		IOUtils.getStringFromReader(reader);

		String string = "\"hello\n";
		Class<?> clazz = Object.class;
		URL url = new URL("http://text.net");
		List<String> list = Arrays.asList(new String[] { "a", "b" });
		URL curl = new URL("http://text.net");
		String spec = "/toto";
		String tokenString = "a, b";

		String cleanedString = StringUtils.cleanString(string);
		String className = StringUtils.getClassName(clazz);
		InputStream inputStream = StringUtils.getContentAsInputStream(url);
		String newTokenString = StringUtils.getNMTokens(list);
		URL curls = StringUtils.getURL(curl, spec); // weird
		List newTokens = StringUtils.parseNMTokens(tokenString);

		System.out.println(cleanedString);
		System.out.println(className);
		System.out.println(newTokenString);
		for (Object newToken : newTokens) {
			System.out.println(newToken);
		}
		while (true) {
			int c = inputStream.read();
			if (c == -1) {
				break;
			}
			System.out.print((char) c);
		}
		System.out.println(curl);
	}

	public static void main(String[] args) throws IOException {
		foo();
	}

}
