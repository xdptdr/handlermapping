package com.github.xdptdr.dump.org.apache.cxf.headers;

import org.apache.cxf.headers.Header.Direction;

public class Header {
	public static class DirectionDumper {
		public static void dump(Object o) {
			Direction d = (Direction) o;

		}
	}
}
