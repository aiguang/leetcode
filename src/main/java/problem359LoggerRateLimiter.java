import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 Design a logger system that receive stream of messages along with its timestamps,
 each message should be printed if and only if it is not printed in the last 10 seconds.

 Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.

 It is possible that several messages arrive roughly at the same time.

 Example:

 Logger logger = new Logger();

 // logging string "foo" at timestamp 1
 logger.shouldPrintMessage(1, "foo"); returns true;

 // logging string "bar" at timestamp 2
 logger.shouldPrintMessage(2,"bar"); returns true;

 // logging string "foo" at timestamp 3
 logger.shouldPrintMessage(3,"foo"); returns false;

 // logging string "bar" at timestamp 8
 logger.shouldPrintMessage(8,"bar"); returns false;

 // logging string "foo" at timestamp 10
 logger.shouldPrintMessage(10,"foo"); returns false;

 // logging string "foo" at timestamp 11
 logger.shouldPrintMessage(11,"foo"); returns true;
 */
public class problem359LoggerRateLimiter {
  public static void main(String[] args){
    Logger logger = new Logger();
    System.out.println(logger.shouldPrintMessage(1, "foo"));
    System.out.println(logger.shouldPrintMessage(2, "bar"));
    System.out.println(logger.shouldPrintMessage(3, "foo"));
    System.out.println(logger.shouldPrintMessage(8, "bar"));
    System.out.println(logger.shouldPrintMessage(10, "foo"));
    System.out.println(logger.shouldPrintMessage(11, "foo"));
  }
}
class Logger {
  class Msg{
    int timestamp = -1;
    boolean hasMsg = false;
    String value;
  }

  int startTime = 0;
  /** Initialize your data structure here. */
  public Logger() {

  }
  List<Msg> list = new ArrayList<Msg>();
  Map<Integer, Msg> keyMap = new HashMap<Integer,Msg>();
  /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
   If this method returns false, the message will not be printed.
   The timestamp is in seconds granularity. */
  public boolean shouldPrintMessage(int timestamp, String message) {
    if(keyMap.containsKey(timestamp) && message.equals(keyMap.get(timestamp).value)) return false;

  }
}
