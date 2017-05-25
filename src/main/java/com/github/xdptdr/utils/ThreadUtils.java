package com.github.xdptdr.utils;

public class ThreadUtils {

	public static void sleep() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
	}

}
