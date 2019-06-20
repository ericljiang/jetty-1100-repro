package jetty.repro;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MessageDecoder implements Decoder.Text<Message> {

    public MessageDecoder() {
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
    public Message decode(String s) throws DecodeException {
        System.out.println(this + " decoding message");
        return new Message(s);
    }

    @Override
    public boolean willDecode(String s) {
        return s != null;
    }

}
