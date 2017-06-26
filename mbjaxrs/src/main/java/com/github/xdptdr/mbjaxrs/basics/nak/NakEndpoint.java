package com.github.xdptdr.mbjaxrs.basics.nak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/nak")
public class NakEndpoint {

	@GET
	@Path("/get/{p1}/{p2}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> get(@PathParam("p1") PathSegment pathSegment1, @PathParam("p2") PathSegment pathSegment2) {

		Map<String, Object> content = new HashMap<>();
		content.put("pathSegment1", dump(pathSegment1));
		content.put("pathSegment2", dump(pathSegment2));

		return content;
	}

	private Map<String, Object> dump(PathSegment ps) {

		Map<String, List<String>> mp = new HashMap<>();
		for (Entry<String, List<String>> entry : ps.getMatrixParameters().entrySet()) {
			String key = entry.getKey();
			mp.put(key, new ArrayList<>());
			for (String value : entry.getValue()) {
				mp.get(key).add(value);
			}
		}

		Map<String, Object> i = new HashMap<>();
		i.put("path", ps.getPath());
		i.put("matrixParams", mp);
		return i;
	}
}
