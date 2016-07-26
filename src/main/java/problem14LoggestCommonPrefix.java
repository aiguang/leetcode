import java.util.Arrays;

/**
 * Created by Administrator on 16-6-26.
 */
public class problem14LoggestCommonPrefix {
  public static void main(String[] args){
    String[] s = {"a", "a", "a"};
    System.out.println(new problem14LoggestCommonPrefix().longestCommonPrefix(s));
  }
  public String longestCommonPrefix(String[] strs) {
    if(strs == null || strs.length == 0) return "";
    if(strs.length == 1) return strs[0];
    else if(strs.length == 2){
      return find(strs[0], strs[1]);
    }else{
      int left = 0;
      int right = strs.length ;
      int middle = (left + right) / 2;
      String s1 = longestCommonPrefix(Arrays.copyOfRange(strs, left, middle + 1));
      String s2 = longestCommonPrefix(Arrays.copyOfRange(strs, middle + 1, right));
      return find(s1, s2);
    }
  }
  public String find(String s1, String s2){
    int index1= 0;
    int index2= 0;
    while(index1 < s1.length() && index2 < s2.length()){
      if(s1.charAt(index1) == s2.charAt(index2)){
        index1++;
        index2++;
      }else break;
    }
    return s1.substring(0, index1);
  }
}
