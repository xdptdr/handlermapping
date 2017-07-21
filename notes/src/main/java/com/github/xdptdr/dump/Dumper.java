package com.github.xdptdr.dump;

import java.lang.reflect.InvocationTargetException;

public class Dumper {

	public static void dump(Object o) {

		if (o == null) {
			System.out.println("null");
			return;
		}
		try {
			Class<?> dumper = Dumper.class.getClassLoader()
					.loadClass("com.github.xdptdr.dump." + o.getClass().getName() + "Dumper");
			dumper.getMethod("dump", Object.class).invoke(null, o);
		} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	public static void dump(String id, Object o) {

		if (o == null) {
			System.out.println("null");
			return;
		}
		try {
			Class<?> dumper = Dumper.class.getClassLoader()
					.loadClass("com.github.xdptdr.dump." + o.getClass().getName() + "Dumper");
			dumper.getMethod("dump", String.class, Object.class).invoke(null, id, o);
		} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
}
