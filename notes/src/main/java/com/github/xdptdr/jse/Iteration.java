package com.github.xdptdr.jse;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Iteration {
	public static void main(String[] args) throws SQLException, IOException {

		// arrays

		int[] arrayOfPrimitiveIntegers = new int[] {};

		for (int idx = 0; idx < arrayOfPrimitiveIntegers.length; ++idx) {
			int integer = arrayOfPrimitiveIntegers[idx];
			foo(integer);
		}

		for (int integer : arrayOfPrimitiveIntegers) {
			foo(integer);
		}

		// lists

		List<Integer> listOfIntegers = new ArrayList<>();

		for (int idx = 0; idx < listOfIntegers.size(); ++idx) {
			Integer integer = listOfIntegers.get(idx);
			foo(integer);
		}

		for (Integer integer : listOfIntegers) {
			foo(integer);
		}

		Iterator<Integer> it = listOfIntegers.iterator();
		while (it.hasNext()) {
			Integer integer = it.next();
			foo(integer);
			it.remove(); // possibility
		}

		// Strings

		String string = "";
		for (int idx = 0; idx < string.length(); ++idx) {
			char character = string.charAt(idx);
			foo(character);
		}

		// resutl sets

		ResultSet rs = getResultSet();
		while (rs.next()) {
			int rowNumber = rs.getRow();
			foo(rowNumber);
		}

		// Input stream

		InputStream is = getInputStream();
		int bytee = 0;
		while ((bytee = is.read()) != -1) {
			foo(bytee);
		}

		// Map

		Map<String, String> map = new HashMap<>();

		for (Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			foo(key);
			foo(value);
		}

		Iterator<Entry<String, String>> mapEntriesIterator = map.entrySet().iterator();
		while (mapEntriesIterator.hasNext()) {
			Entry<String, String> entry = mapEntriesIterator.next();
			String key = entry.getKey();
			String value = entry.getValue();
			foo(value);
			foo(key);
			mapEntriesIterator.remove();
		}

	}

	private static InputStream getInputStream() {
		return null;
	}

	private static ResultSet getResultSet() {
		return null;
	}

	private static void foo(Object o) {

	}
}
