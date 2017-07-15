package com.github.xdptdr.cxf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.Soap11;
import org.apache.cxf.binding.soap.Soap12;
import org.apache.cxf.binding.soap.SoapVersion;

public class Abana {
	public static void main(String[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Soap11 a = Soap11.getInstance();
		Soap12 b = Soap12.getInstance();

		for (Method method : SoapVersion.class.getMethods()) {
			if (method.getParameterTypes().length == 0) {
				if (method.getReturnType() == String.class) {
					System.out.println(method.getName());
					System.out.println(" - " + method.invoke(a));
					System.out.println(" - " + method.invoke(b));
				} else if (method.getReturnType() == QName.class) {
					System.out.println(method.getName());
					System.out.println(" - " + qns((QName) method.invoke(a)));
					System.out.println(" - " + qns((QName) method.invoke(b)));
				}
			}
		}
	}

	private static String qns(QName qn) {
		StringBuffer buf = new StringBuffer();
		if (qn != null) {
			buf.append(qn.getNamespaceURI());
			buf.append(" ");
			buf.append(qn.getPrefix());
			buf.append(" ");
			buf.append(qn.getLocalPart());
		}
		return buf.toString();
	}
}
