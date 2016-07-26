package GeeksforGeeks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 16-3-28.
 */
public class JumpingNums {

  public List<Integer> allJump(int n) {
    if (n < 0) {
      return new ArrayList<Integer>();
    }
    List<Integer> result = new ArrayList<Integer>();
    if (n < 10) {
      for (int i = 0; i < n; i++) {
        result.add(i);
      }
      return result;
    } else {
      Queue<Integer> queue = new ArrayDeque<Integer>();
      for (int i = 0; i < 10; i++) {
        result.add(i);
        queue.add(i);
      }
      while (!queue.isEmpty()) {
        int current = queue.poll();
        if (current != 0) {
          int mod = current % 10;
          if (mod > 0) {
            queue.add(current * 10 + mod + 1);
            queue.add(current * 10 + mod - 1);
            result.add(current * 10 + mod + 1);
            result.add(current * 10 + mod - 1);
          } else {
            queue.add(current * 10 + mod + 1);
            result.add(current * 10 + mod + 1);
          }
        }
      }
    }
    return result;
  }
}
