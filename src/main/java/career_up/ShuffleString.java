package career_up;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 16-3-28.
 */
public class ShuffleString {

  public static void main(String[] args) {

  }

  public String shuffle(String value) {
    if (value == null || value.isEmpty()) {
      return null;
    }
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < value.length(); i++) {
      char c = value.charAt(i);
      int v = map.get(c);
      if (v == 0) {
        map.put(c, 1);
      } else {
        map.put(c, v++);
      }
      if (v == value.length() / 2 + 2) {
        return null;
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!map.isEmpty()){
      Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
      while (iterator.hasNext()) {
        Map.Entry<Character, Integer> entry = iterator.next();
        sb.append(entry.getValue());
        if(sb.length() >= 4 && sb.charAt(sb.length() - 1) == sb.charAt(sb.length() - 2)){
          char tmp = sb.charAt(sb.length() - 1);

        }
      }
    }
    return sb.toString();
  }

}
