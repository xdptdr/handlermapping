package com.github.xdptdr.mbjaxrs.basics.yze;

import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/yze")
public class YzeEndpoint {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response get(@QueryParam("len") int len) {
		return Response.ok(new StreamingOutput() {
			@Override
			public void write(OutputStream output) throws IOException, WebApplicationException {
				for (int i = 0; i < len; ++i) {
					output.write((Integer.toString(i) + " ").getBytes());
					output.flush();
				}
			}
		}).build();

	}
}
