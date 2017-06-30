package com.github.xdptdr.notes;

import java.util.HashSet;
import java.util.Set;

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
		int total = 0;
		int coveredCount = 0;
		for (Class<?> clazz : todo) {
			if (!covered.contains(clazz)) {
				System.out.println("TODO : " + clazz.getName());
			} else {
				++coveredCount;
			}
			++total;
		}
		System.out.println("Progression : " + coveredCount + "/" + total);
	}

	public void setIgnoreDups(boolean ignoreDups) {
		this.ignoreDups = ignoreDups;

	}

}