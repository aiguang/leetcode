package jeroMQ.multiDealer;

import org.zeromq.ZMQ;

/**
 * Created by Administrator on 16-3-23.
 */
public class M_DealerB extends Thread {
  public static void main(String[] args){
    ZMQ.Context context = ZMQ.context(1);
    ZMQ.Socket client = context.socket(ZMQ.DEALER);
    zmq.ZMQ.setSocketOption(client.base(), zmq.ZMQ.ZMQ_IDENTITY, "b");
    client.connect("tcp://*:5671");

    try {
      while(true){
        String receive = client.recvStr();
        System.out.println("M_Dealer receiveMsg " + receive + " , identity is b");
      }
    }finally {
      client.close();
      context.term();
    }
  }
}












