package com.github.xdptdr.mbjaxrs.a.tad;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.CompletionCallback;
import javax.ws.rs.container.ConnectionCallback;

public class TadCallbacks implements ConnectionCallback, CompletionCallback {

	private TadSingleton tadSingleton;

	public TadCallbacks(TadSingleton tadSingleton) {
		this.tadSingleton = tadSingleton;
	}

	@Override
	public void onComplete(Throwable throwable) {
		tadSingleton.log("complete");
	}

	@Override
	public void onDisconnect(AsyncResponse disconnected) {
		tadSingleton.log("disconnect");
	}

}
