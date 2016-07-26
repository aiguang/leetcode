package jeroMQ;

import org.zeromq.ZMQ;

/**
 * Created by Administrator on 16-3-23.
 */
public class JeroMQProxy {
  public static void main (String[] args) {
    //  Prepare our context and sockets
    ZMQ.Context context = ZMQ.context(1);

    //  Socket facing clients
    ZMQ.Socket frontend = context.socket(ZMQ.ROUTER);
    frontend.bind("tcp://*:5559");

    //  Socket facing services
    ZMQ.Socket backend = context.socket(ZMQ.DEALER);
    backend.bind("tcp://*:5560");

    //  Start the proxy
    ZMQ.proxy (frontend, backend, null);

    //  We never get here but clean up anyhow
    frontend.close();
    backend.close();
    context.term();
  }
}
