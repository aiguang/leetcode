/**
 Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character
 */
public class problem72 {
  public static void main(String[] args){
    String word1 = "a";
    String word2 = "a";
    System.out.println(new problem72().minDistance(word1, word2));
  }
  public int minDistance(String word1, String word2) {
    if((word1 == null || word1.length() == 0) && (word2 == null || word2.length() == 0)) return 0;
    if((word1 == null || word1.length() == 0) && word2 != null) return word2.length();
    if(word1 != null && (word2 == null || word2.length() == 0)) return word1.length();

    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for(int i = 0 ; i <= word1.length();i++){
      dp[i][0] = i;
    }
    for(int i = 0; i <= word2.length();i++){
      dp[0][i] = i;
    }
    for(int i = 1; i < dp.length; i++){
      for(int j = 1; j < dp[0].length; j++){
        int m = dp[i - 1][j] + 1;
        int k = dp[i][j - 1] + 1;
        int q = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
        dp[i][j] = Math.min(m, Math.min(k, q));
      }
    }
    return dp[word1.length()][word2.length()];
  }
}
