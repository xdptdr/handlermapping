package com.github.xdptdr.mbwar.jaxrs.vej;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
@VejLogged
public class VejFilter implements ContainerRequestFilter {

	@EJB
	private VejSingleton vejSingleton;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		vejSingleton.log(requestContext.getUriInfo().getAbsolutePath().toString());
	}

}
