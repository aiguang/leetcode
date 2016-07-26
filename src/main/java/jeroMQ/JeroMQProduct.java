package jeroMQ;

import org.zeromq.ZMQ;

/**
 * Created by Administrator on 16-3-23.
 */
public class JeroMQProduct {
  public static void main(String[] args){
    int port = 5559;
    ZMQ.Context context = ZMQ.context(ZMQ.REQ);
    ZMQ.Socket socket = context.socket(ZMQ.REQ);

    socket.connect("tcp://localhost:" + port);
    long curTime = System.currentTimeMillis();
    for(int i = 1;i < 1000;i++){

//      System.out.println("it is a request, index " + i);
      if(i < 500){
        socket.send("hello world ,it is " + i + "times", 0);
      }else{
        socket.send("hello world ,it is " + i + "times", 1);
      }


      String receive = socket.recvStr();
      System.out.println("it is " +  i + " times receive form server ");
    }
    System.out.println((System.currentTimeMillis() - curTime) / 1000);
  }
}
