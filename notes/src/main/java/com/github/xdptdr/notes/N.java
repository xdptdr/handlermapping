package com.github.xdptdr.notes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.namespace.QName;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.extension.ExtensionManagerBus;

import com.github.xdptdr.cxf.Aaron;

public class N {

	Set<Class<?>> covered = new HashSet<>();
	Set<Class<?>> todo = new HashSet<>();
	private boolean ignoreDups;

	public N k(Class<?>... classes) {
		for (Class<?> clazz : classes) {
			covered.add(clazz);
		}
		return this;

	}

	public N s(String string) {
		return this;
	}

	public void todo(Class<?>... classes) {
		for (Class<?> clazz : classes) {

			if (!todo.contains(clazz)) {
				todo.add(clazz);
			} else if (!ignoreDups) {
				throw new RuntimeException("Duplicate class " + clazz.getName());
			}
		}
	}

	public void sumUp() {
		sumUp(false);
	}

	public void sumUp(boolean ignoreExceptions) {
		int total = 0;
		int coveredCount = 0;
		List<String> todos = new ArrayList<>();

		for (Class<?> clazz : todo) {
			if (ignoreExceptions && Exception.class.isAssignableFrom(clazz)) {
				continue;
			}
			if (!covered.contains(clazz)) {
				todos.add(clazz.getName());
			} else {
				++coveredCount;
			}
			++total;
		}

		Collections.sort(todos);
		for (String todo : todos) {
			System.out.println("TODO : " + todo);
		}

		System.out.println("Progression : " + coveredCount + "/" + total);
	}

	public void setIgnoreDups(boolean ignoreDups) {
		this.ignoreDups = ignoreDups;

	}

	public void o(Class<?>... classes) {

	}

	public static void azzert(boolean b) {
		if (!b) {
			throw new RuntimeException("Assertion Error");
		}

	}

	public static String qns(QName qn) {
		if (qn == null) {
			return "!null!";
		} else {
			return qn.getNamespaceURI() + " " + qn.getPrefix() + " " + qn.getLocalPart();

		}
	}

}