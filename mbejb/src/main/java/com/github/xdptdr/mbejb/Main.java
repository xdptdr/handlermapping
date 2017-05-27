package com.github.xdptdr.mbejb;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Local;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

import com.github.xdptdr.mbejb.api.MainI;

@Singleton
@Local(MainI.class)
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class Main implements MainI {

	Map<String, Integer> map = new HashMap<>();

	@Override
	@Lock(LockType.READ)
	public String mapToString() {
		StringBuffer buf = new StringBuffer();
		boolean sep = false;
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (sep) {
				buf.append("\n");
			}
			buf.append(entry.getKey());
			buf.append(":");
			buf.append(entry.getValue());
			sep = true;
		}
		return buf.toString();
	}

	@Override
	@Lock(LockType.WRITE)
	public void register(String name) {
		if (!map.containsKey(name)) {
			map.put(name, 1);
		} else {
			map.put(name, map.get(name) + 1);
		}
	}

	@Override
	@Lock(LockType.WRITE)
	public void unregister(String name) {
		if (map.containsKey(name)) {
			map.put(name, map.get(name) - 1);
		}
	}

}
