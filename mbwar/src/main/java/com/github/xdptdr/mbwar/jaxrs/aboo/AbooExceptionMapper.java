package com.github.xdptdr.mbwar.jaxrs.aboo;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AbooExceptionMapper implements ExceptionMapper<AbooException> {

	@Override
	public Response toResponse(AbooException exception) {
		return Response.status(Status.FORBIDDEN).entity(exception.getMessage()).build();
	}

}
