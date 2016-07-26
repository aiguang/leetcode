import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 1) Similar to Word Break I, use DP to check if given string can be split to a group of words. If answer is no, simply return an empty list.

 2) If answer is yes, then use backtracking to get all results. Basically, if we go to ith position,
 we need to iterate from 0 to i - 1. As long as the substring(0, i) can be split to words group,
 we need to recursively get the result.
 After that, concatenate each string in result with substring(i + 1, end). (Do not miss the space)
 */
public class problem140 {

  public static void main(String[] args) {
    String s = "catsanddog";
    Set<String> set = new HashSet<String>();
    set.add("cat");
    set.add("cats");
    set.add("and");
    set.add("sand");
    set.add("dog");
    List<String> result = new problem140().wordBreak(s, set);
    for (String value : result) {
      System.out.println(value);
    }
  }

  public List<String> wordBreak(String s, Set<String> wordDict) {
    if (s == null || "".equals(s)) {
      return new ArrayList<String>();
    }
    int[] dp = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      if (wordDict.contains(s.substring(0, i + 1))) {
        dp[i] = 1;
      } else {
        for (int j = 0; j < i; j++) {
          if (dp[j] == 1 && wordDict.contains(s.substring(j + 1, i + 1))) {
            dp[i] = 1;
            break;
          }
        }
      }
    }
    if (dp[s.length() - 1] == 0) {
      return new ArrayList<String>();
    }
    return wordBreak(s, dp, s.length() - 1, wordDict);
  }

  private List<String> wordBreak(String s, int[] dp, int end, Set<String> wordDict) {
    List<String> result = new ArrayList<String>();
    for (int i = 0; i < end; i++) {
      if (dp[i] == 1 && wordDict.contains(s.substring(i + 1, end + 1))) {
        List<String> temp = wordBreak(s, dp, i, wordDict);
        for (String str : temp) {
          result.add(str + " " + s.substring(i + 1, end + 1));
        }
      }
    }
    if (wordDict.contains(s.substring(0, end + 1))) {
      result.add(s.substring(0, end + 1));
    }
    return result;
  }

}
