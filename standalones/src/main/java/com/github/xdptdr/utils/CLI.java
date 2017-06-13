package com.github.xdptdr.utils;

public final class CLI {
	public static boolean match(String cmd, String[] args, int i) {
		return cmd.equals(getL(args, i));
	}

	public static String getL(String[] args, int i) {
		return get(args, i).toLowerCase();

	}

	public static String get(String[] args, int i) {
		if (i >= args.length) {
			return "";
		}
		return args[i].trim();
	}
}
