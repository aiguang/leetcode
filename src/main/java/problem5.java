/**
 * Created by Administrator on 15-8-13.
 */
public class problem5 {
  public static void main(String[] args){
    String s = "ccc";
    System.out.println(new problem5().longestPalindrome(s));
  }
  public String longestPalindrome(String s) {
    boolean[][] d = new boolean[s.length()][s.length()];
    for(int i = 0;i < s.length();i++){
      d[i][i] = true;
      if(i >= 1){
        d[i][i-1] = true;
      }
    }
    int right = 0;
    int left = 0;
    for(int k = 2; k < s.length(); k++){
      for(int i = 0; i < s.length() - k;i++){
        if(s.charAt(i) == s.charAt(i + k - 1) && d[i+1][i+k-2]){
          d[i][i + k-1] = true;
          if(right - left + 1 > k){
            right = i +k - 1;
            left = i;
          }
        }
      }
    }
    return s.substring(left, right - left + 1);
  }
}
