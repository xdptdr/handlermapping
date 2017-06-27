package com.github.xdptdr.mbjaxrs.a.gok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/hej")
public class HejEndpoint {

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response hej(Form form) {

		Map<String, List<String>> map = new HashMap<>();

		for (Entry<String, List<String>> entry : form.asMap().entrySet()) {
			String key = entry.getKey();
			for (String value : entry.getValue()) {
				if (!map.containsKey(key)) {
					map.put(key, new ArrayList<>());
				}
				map.get(key).add(value);
			}
		}

		return Response.ok(map).build();

	}
}
