import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 15-9-28.
 */
public class problem91 {
  public static void main(String[] args){
    String s = "12120";
    System.out.println(new problem91().numDecodings(s));
  }
  public int numDecodings(String s) {
    if(s == null || s.length() == 0) return  0;
    if(s.length() == 1){
      return checkOne(s.charAt(0)) ? 1 : 0;
    }
    int[] dp = new int[s.length()];
    dp[0] = checkOne(s.charAt(0)) ? 1 : 0;
    if(checkOne(s.charAt(1))){
      dp[1] += dp[0];
    }
    if(check(s.charAt(0), s.charAt(1))){
      dp[1] += 1;
    }


    for(int i = 2; i < s.length();i++){
      if(checkOne(s.charAt(i))){
        dp[i] += dp[i - 1];
      }
      if(check(s.charAt(i - 1), s.charAt(i))){
        dp[i] += dp[i - 2];
      }
    }
    return dp[dp.length - 1];
  }

  private boolean checkOne(char one){
    return one > '0' && one <= '9';
  }
  private boolean check(char one, char two){
    return one == '1' || (one == '2' && two >= '0' && two <= '6');
  }
}
