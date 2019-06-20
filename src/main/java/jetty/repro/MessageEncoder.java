package jetty.repro;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text<Message> {

    public MessageEncoder() {
        System.out.println("Constructing " + this);
    }

    @Override
    public void init(EndpointConfig config) {
        System.out.println("init() method called on " + this);
    }

    @Override
    public void destroy() {
    }

    @Override
    public String encode(Message message) throws EncodeException {
        System.out.println(this + " encoding message");
        return message.message;
    }

}
