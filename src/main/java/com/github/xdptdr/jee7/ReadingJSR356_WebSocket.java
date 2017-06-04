package com.github.xdptdr.jee7;

import java.io.IOException;
import java.util.Map;

import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.OnError;
import javax.websocket.MessageHandler.Partial;
import javax.websocket.MessageHandler.Whole;
import javax.websocket.OnMessage;
import javax.websocket.PongMessage;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

public class ReadingJSR356_WebSocket extends Reading {

	private Map<String, Object> properties;

	@Override
	public void reading() throws Exception {
		/*
		 * The developer can only register at most one MessageHandler for
		 * incoming text messages, one MessageHandler for incoming binary
		 * messages, and one MessageHandler for incoming pong messages.
		 */

		dontRun(new NotRunnable() {

			class MyPartialMessageHandler implements Partial<String> {
				@Override
				public void onMessage(String partialMessage, boolean last) {

				}
			}

			class MyWholeMessageHandler implements Whole<String> {
				private Basic basic;

				public MyWholeMessageHandler(Basic basic) {
					this.basic = basic;
				}

				@Override
				public void onMessage(String message) {
					try {
						basic.sendText("Here's your message back : " + message);
					} catch (IOException e) {
					}
				}

			}

			class MyEndpoint extends Endpoint {

				@Override
				public void onOpen(Session session, EndpointConfig config) {

					properties = session.getUserProperties();
					session.addMessageHandler(new MyPartialMessageHandler());

					Basic basic = session.getBasicRemote();

					session.addMessageHandler(new MyWholeMessageHandler(basic));

				}

				@Override
				public void onClose(Session session, CloseReason closeReason) {
					super.onClose(session, closeReason);
				}
			}

			@ServerEndpoint("/hello")
			class MyHelloServer {
				@OnMessage
				public String handleMessage(String message) {
					return "Here's your message back : " + message;
				}

				@OnMessage
				public PongMessage handleMessage(PongMessage message) {
					return message;
				}
			}

			@Override
			public void dontRun() throws Exception {
				WebSocketContainer.class.getName();
				ContainerProvider.class.getName();
				ServerEndpoint.class.isAnnotation();
				ServerEndpoint.class.newInstance().encoders();
				ServerEndpoint.class.newInstance().decoders();
				OnError.class.isAnnotation();
				PongMessage.class.getName();
				ServerEndpointConfig.class.getName();
				Configurator.class.getName();
				
			}
		});

	}

}
