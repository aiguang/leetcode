import java.util.Map;

/**
 Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once.
 You must make sure your result is the smallest in lexicographical order among all possible results.

 Example:
 Given "bcabc"
 Return "abc"

 Given "cbacdcbc"
 Return "acdb"
 */
public class problem316 {
  public static void main(String[] args){
    String s = "bcabc";
    System.out.println(new problem316().removeDuplicateLetters(s));
  }

  /**
   *
   * @param s
   * @return
   */
  public String removeDuplicateLetters(String s) {
    if(s == null || s.length() == 0) return s;
    int[] result = new int[26];
    for(int i = 0; i < s.length();i++){
      char tmp = s.charAt(i);
      result[tmp - 'a'] += 1;
    }
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < result.length;i++){
      if(result[i] >= 1){
        sb.append((char)('a' + i));
      }
    }
    return sb.toString();
  }
}
