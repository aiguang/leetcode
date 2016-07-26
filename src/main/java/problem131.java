import java.util.ArrayList;
import java.util.List;

/**
 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
public class problem131 {
  public static void main(String[] args){
    String s = "abb";
    List<List<String>> result = new problem131().partition(s);
    for(List<String> list : result){
      for(String value : list){
        System.out.print(value + ",");
      }
      System.out.println();
    }
  }
  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<List<String>>();
    if(s == null || s.length() == 0) return result;
    helper(new ArrayList<String>(), result, 0, s);
    return result;
  }
  private void helper(List<String> tmp, List<List<String>> result,int curIndex, String s){
    if(curIndex > s.length() - 1){
      List<String> l = new ArrayList<String>();
      for(int i = 0 ; i < tmp.size();i++){
        l.add(tmp.get(i));
      }
      result.add(l);
      return;
    }
    for(int i = curIndex;i < s.length();i++){
      String value = s.substring(curIndex,i + 1);
      if(isPalindrome(value)){
        tmp.add(value);
        helper(tmp, result, i + 1, s);
        tmp.remove(tmp.size() - 1);
      }
    }
  }
  private boolean isPalindrome(String s){
    if(s == null) return false;
    int i = 0, j = s.length() - 1;
    while (i < j){
      if(s.charAt(i) == s.charAt(j)){
        i++;
        j--;
        continue;
      }
      return false;
    }
    return true;
  }

}
