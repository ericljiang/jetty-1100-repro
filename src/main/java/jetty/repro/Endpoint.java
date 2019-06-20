package jetty.repro;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/", decoders = MessageDecoder.class, encoders = MessageEncoder.class)
public class Endpoint {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Session opened.");
    }

    @OnMessage
    public void onMessage(Session session, Message message) throws IOException, EncodeException {
        System.out.println("Received message: " + message.message);
        session.getBasicRemote().sendObject(message);
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Session closed.");
    }

}
