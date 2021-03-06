/**
 * Created by Administrator on 16-2-23.
 */
public class problem70_1 {
  public static void main(String[] args){

  }
  public int climbStairs(int n) {
    if(n < 2) return 1;
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i = 2; i < dp.length;i++){
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }
}
