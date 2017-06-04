package com.github.xdptdr.mbwar.websocket;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/helloWebSocket")
public class MyWebsocketEndpoint {

	@OnMessage
	public String handleMessage(String message) {
		return message.toUpperCase();
	}

}
