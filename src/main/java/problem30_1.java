import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 16-2-14.
 *
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]

 You should return the indices: [0,9].
 */
public class problem30_1 {

  public List<Integer> findSubstring(String s, String[] words) {
    if(s == null || s.length() == 0 || words == null || words.length == 0) return new ArrayList<Integer>();
    Map<String, Integer> map = new HashMap<String, Integer>();
    Set<String> set = new HashSet<String>();
    for(String value : words){
      set.add(value);
    }
    List<Integer> list = new ArrayList<Integer>();
    int step = words[0].length();
    int index = -1;
    for(int i = 0 ;i < s.length();i += step){
      String curString = s.substring(i, i + step);
      if(set.contains(curString)){
        if(map.containsKey(curString)){
          index = map.get(curString) + step;
          continue;
        }else{
          map.put(curString, i);
          if(i - index == words[0].length() * words.length){
            list.add(index);
            //todo remove min value & key
          }
        }
      }else {
        index = i;
      }
    }
    return list;
  }
}
