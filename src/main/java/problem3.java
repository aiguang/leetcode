import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 15-8-12.
 */
public class problem3 {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    String
        test =
        "aa";
    System.out.println(new problem3().lengthOfLongestSubstring(test));

    System.out.println(System.currentTimeMillis() - start);
  }

  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map= new HashMap<Character, Integer>();
    int max = 0;
    int length = 0;
    int preStart = 0;
    for(int i = 0;i < s.length();i++){
      char tmp = s.charAt(i);
      Integer value = map.get(tmp);
      if(value != null && preStart <= value){
        if(max < length){
          max = length;
        }
        length = i - value;
        preStart = value + 1;
      }else{
        length++;
      }
      map.put(tmp, i);
    }
    return max > length ? max : length;
  }
}
