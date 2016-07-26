import java.util.HashSet;
import java.util.Set;

/**
 Given a string s and a dictionary of words dict, determine if s can be segmented
 into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 "goalspecial"
 ["go","goal","goals","special"]

 Return true because "leetcode" can be segmented as "leet code".
 */
public class problem139 {
  public static void main(String[] args){
    String s = "goalspecial";
    Set<String> dict = new HashSet<String>();
    dict.add("go");
    dict.add("goal");
    dict.add("goals");
    dict.add("special");
    System.out.println(new problem139().wordBreak(s, dict));
  }
  public boolean wordBreak(String text, Set<String> dictionary) {
    int n = text.length();
    if(n == 0){
      return true;
    }

    //dp[i] = true if there is a solution in prefix text[0..i]
    boolean[] dp = new boolean[n];

    //try all possible prefixes
    for(int i = 0; i< n; i++){
      //check from dp if current length prefix is a solution
      //if not then the prefix should be present in dictionary
      if(dp[i] == false && dictionary.contains(text.substring(0, i+1))){
        dp[i] = true;
      }

      //if this prefix contains in dictionary the try to extend the prefix up to end of the string
      if(dp[i] == true){
        for(int j = i+1; j < n; j++){
          //check id dp[j] already computed to a solution ,
          //other wise we need to check if text[i+1..i] contains in the dict.
          //so that we can create a longer prefix text[0..j]
          if(dp[j] == false){
            dp[j] = dictionary.contains(text.substring(i+1, j+1));
          }
        }
      }
    }


    return dp[n-1];
  }
  private boolean helper(String curString, Set<String> wordDict){
    if(wordDict.contains(curString)){
      return true;
    }
    for(int i = 0; i < curString.length();i++){
      String tmp = curString.substring(0, i + 1);
      if(wordDict.contains(tmp)){
        boolean result =  helper(curString.substring(i + 1, curString.length()), wordDict);
        if(result) return true;
      }
    }
    return false;
  }
}
