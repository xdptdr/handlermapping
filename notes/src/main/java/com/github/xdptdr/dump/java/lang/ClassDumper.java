package com.github.xdptdr.dump.java.lang;

public class ClassDumper {
	public static void dump(String id, Object o) {
		System.out.println(id + " : " + ((Class<?>) o).getName());
	}
}
