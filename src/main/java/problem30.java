import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 You are given a string, s, and a list of words, words, that are all of the same length.
 Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]

 "lingmindraboofooowingdingbarrwingmonkeypoundcake"
 ["fooo","barr","wing","ding","wing"]

 You should return the indices: [0,9].
 (order does not matter).

 Subscribe to see which companies asked this question
 */
public class problem30 {
  public static void main(String[] args){
    String[] words = {"a", "b"};
    String s = "aaa";
    List<Integer> result = new problem30().findSubstring(s, words);
    for(Integer value : result){
      System.out.print(value + ",");
    }
  }
  public List<Integer> findSubstring(String s, String[] words) {

    ArrayList<Integer> result = new ArrayList<Integer>();
    if (s == null || s.length() == 0 || words == null || words.length == 0)
      return result;
    int strLen = s.length();
    int wordLen = words[0].length();
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for (int i = 0; i < words.length; i++) {
      if (map.containsKey(words[i])) {
        map.put(words[i], map.get(words[i]) + 1);
      } else {
        map.put(words[i], 1);
      }
    }
    for (int i = 0; i < wordLen; i++) {
      HashMap<String, Integer> curMap = new HashMap<String, Integer>();
      int count = 0, left = i;
      for (int j = i; j <= strLen - wordLen; j += wordLen) {
        String curStr = s.substring(j, j + wordLen);
        if (map.containsKey(curStr)) {
          if (curMap.containsKey(curStr)) {
            curMap.put(curStr, curMap.get(curStr) + 1);
          } else {
            curMap.put(curStr, 1);
          }
          if (curMap.get(curStr) <= map.get(curStr)) {
            count++;
          } else {
            while (true) {
              String tmp = s.substring(left, left + wordLen);
              curMap.put(tmp, curMap.get(tmp) - 1);
              left += wordLen;
              if (curStr.equals(tmp)) {
                break;
              } else {
                count--;
              }
            }
          }
          if (count == words.length) {
            result.add(left);
            String tmp = s.substring(left, left + wordLen);
            curMap.put(tmp, curMap.get(tmp) - 1);
            left += wordLen;
            count--;
          }
        } else {
          curMap.clear();
          count = 0;
          left = j + wordLen;
        }
      }
    }
    return result;
  }
}
