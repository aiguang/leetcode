import java.util.HashMap;
import java.util.Map;

/**
 Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters.
 No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.
 */
public class problem205 {
  public static void main(String[] args){
    String s = "ab";
    String t = "aa";
    System.out.println(new problem205().isIsomorphic(s, t));
  }
  public boolean isIsomorphic(String s, String t) {
    if(s.length() != t.length()) return false;
    Map<Character, Character> s2t = new HashMap<Character, Character>();
    Map<Character, Character> t2s = new HashMap<Character, Character>();
    for(int i = 0; i < s.length();i++){
      Character s1 = s.charAt(i);
      Character t1 = t.charAt(i);

      Character value = s2t.get(s1);
      if(value == null){
        s2t.put(s1, t1);
      }else{
        if(value != t1) return false;
      }

      Character value2 = t2s.get(t1);
      if(value2 == null){
        t2s.put(t1, s1);
      }else{
        if(value2 != s1) return false;
      }
    }
    return true;
  }
}
