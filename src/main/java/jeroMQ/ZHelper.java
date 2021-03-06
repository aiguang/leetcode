package jeroMQ;

import org.zeromq.ZMQ;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 16-3-23.
 */
public class ZHelper {
  private static Random rand = new Random(System.currentTimeMillis ());

  /**
   * Receives all message parts from socket, prints neatly
   */
  public static void dump (ZMQ.Socket sock)
  {
    System.out.println("----------------------------------------");
    while(true) {
      byte [] msg = sock.recv (0);
      boolean isText = true;
      String data = "";
      for (int i = 0; i< msg.length; i++) {
        if (msg[i] < 32 || msg[i] > 127)
          isText = false;
        data += String.format ("%02X", msg[i]);
      }
      if (isText)
        data = new String (msg);

      System.out.println (String.format ("[%03d] %s", msg.length, data));
      if (!sock.hasReceiveMore ())
        break;
    }
  }

  public static void setId (ZMQ.Socket sock)
  {
    String identity = String.format ("%04X-%04X", rand.nextInt (), rand.nextInt ());

    sock.setIdentity (identity.getBytes ());
  }

  public static List<ZMQ.Socket> buildZPipe(ZMQ.Context ctx) {
    ZMQ.Socket socket1 = ctx.socket(ZMQ.PAIR);
    socket1.setLinger(0);
    socket1.setHWM(1);

    ZMQ.Socket socket2 = ctx.socket(ZMQ.PAIR);
    socket2.setLinger(0);
    socket2.setHWM(1);

    String iface = "inproc://" + new BigInteger(130, rand).toString(32);
    socket1.bind(iface);
    socket2.connect(iface);


    return Arrays.asList(socket1, socket2);
  }
}
