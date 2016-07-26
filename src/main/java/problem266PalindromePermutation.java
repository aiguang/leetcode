import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 16-6-8.
 */
public class problem266PalindromePermutation {
  public boolean canPermutePalindrome(String s) {
    if(s == null || s.length() == 0) return true;
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for(int i = 0; i < s.length();i++){
      if(map.containsKey(s.charAt(i))){
        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
      }else {
        map.put(s.charAt(i), 1);
      }
    }
    int oddNum = 0;
    for(Map.Entry<Character, Integer> entry : map.entrySet()){
      if(entry.getValue() % 2 == 0) continue;
      oddNum++;
    }
    return oddNum <= 1;
  }
}
