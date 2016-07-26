package jeroMQ.multiDealer;

import org.zeromq.ZMQ;

import zmq.SocketBase;

/**
 * Created by Administrator on 16-3-23.
 */
public class M_Router {
  private static int DEALER_NUM = 2;
  public static void main(String[] args){
    ZMQ.Context context = ZMQ.context(1);
    ZMQ.Socket client = context.socket(ZMQ.ROUTER);
    client.bind("tcp://*:5671");
//    zmq.ZMQ.setSocketOption(broker.base(), zmq.ZMQ.ZMQ_IDENTITY, "Q");

//    try {
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }

    for(int i = 0; i < 10;i++){
      if(i < 3){
        client.sendMore("a");
      }else {
        client.sendMore("b");
      }

      client.send("it is a msg, but the send more not the same");
    }

  }
}
