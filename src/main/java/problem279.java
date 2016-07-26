import java.util.ArrayList;
import java.util.List;

/**
 Given a positive integer n,
 find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class problem279 {
  public static void main(String[] args){
    int n = 19;
    System.out.println(new problem279().numSquares(n));
  }
  public int numSquares(int n) {
    int dp[] = new int[n + 1];
    //仔细观察，不需要担心溢出
    for(int i = 0; i < dp.length;i++){
      dp[i] = Integer.MAX_VALUE;
    }
    for (int i = 1; i * i <= n; i++) {
      dp[i * i] = 1;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; i + j * j <= n; j++) {
        dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
      }
    }
    return dp[n];
  }
  private void generate(List<Integer> list, List<Integer> result, int sum, int target, int total){
    if(list.size() > result.get(0) || sum > target){
      return;
    }
    if(sum == target){
      int min = Math.min(list.size(), result.get(0));
      result.set(0, min);
      return;
    }
    for(int i = total; i >= 1; i--){
      sum += i * i;
      list.add(i);
      generate(list, result, sum, target, i);
      if(list.size() >= 1){
        int value = list.get(list.size() - 1);
        sum -= value * value;
        list.remove(list.size() - 1);
      }else {
        sum = 0;
      }
    }
  }
}
