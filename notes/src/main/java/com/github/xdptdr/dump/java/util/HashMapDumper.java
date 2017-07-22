package com.github.xdptdr.dump.java.util;

import java.util.Map;
import java.util.Map.Entry;

import com.github.xdptdr.dump.Dumper;

public class HashMapDumper {
	public static void dump(String id, Object o) {
		Map<?, ?> m = (Map<?, ?>) o;
		for (Entry<?, ?> e : m.entrySet()) {
			Dumper.dump(id + ".key", e.getKey());
			Dumper.dump(id + ".value", e.getValue());
		}
	}
}
