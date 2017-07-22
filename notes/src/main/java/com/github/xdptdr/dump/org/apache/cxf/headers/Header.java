package com.github.xdptdr.dump.org.apache.cxf.headers;

public class Header {
	public static class DirectionDumper {
		public static void dump(String id, Object o) {
			System.out.println(id+" : " + o.toString());

		}
	}
}
