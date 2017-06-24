package com.github.xdptdr.mbwar.jaxrs.tad;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.container.TimeoutHandler;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/tad")
public class TadEndpoint {

	@Resource
	ManagedExecutorService mes;

	@EJB
	private TadSingleton tadSingleton;

	@GET
	@Path("/{timeout}")
	@Produces(MediaType.TEXT_PLAIN)
	public void get(@Suspended AsyncResponse ar, @PathParam("timeout") int timeout) {
		setTimeout(ar);
		ar.register(new TadCallbacks(tadSingleton));
		mes.submit(getRunnable(ar, timeout));

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLog() {
		return Response.ok(tadSingleton.getLog()).build();

	}

	private void setTimeout(AsyncResponse ar) {
		ar.setTimeoutHandler(new TimeoutHandler() {
			@Override
			public void handleTimeout(AsyncResponse ar) {
				Response response = Response.status(Status.SERVICE_UNAVAILABLE).entity("Tad timed out").build();
				ar.resume(response);
			}
		});
		ar.setTimeout(1, TimeUnit.SECONDS);
	}

	private Runnable getRunnable(AsyncResponse ar, int timeout) {
		return new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(timeout);
					Response response = Response.ok("Hello from Tad").build();
					ar.resume(response);
				} catch (InterruptedException e) {
					Response response = Response.ok("Hello from Tad ; was interrupted").build();
					ar.resume(response);
				}
			}
		};
	}
}
