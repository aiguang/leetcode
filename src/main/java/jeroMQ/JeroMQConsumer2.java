package jeroMQ;

import org.zeromq.ZMQ;

/**
 * Created by Administrator on 16-3-23.
 */
public class JeroMQConsumer2 {
  public static void main(String[] args){
    int port = 5560;
    ZMQ.Context context = ZMQ.context(ZMQ.REP);
    ZMQ.Socket socket = context.socket(ZMQ.REP);

    socket.connect("tcp://localhost:" +  port);
    while (true){
      String msg = socket.recvStr();
      System.out.println("server reveive msg, msg is  " + msg);
      socket.send("it is reply form server");
    }
  }
}
