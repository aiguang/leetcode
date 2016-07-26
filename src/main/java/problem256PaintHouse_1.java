/**
 * Created by Administrator on 16-7-11.
 */
public class problem256PaintHouse_1 {
  public int minCost(int[][] costs) {
    if(costs == null || costs.length == 0)  return 0;
    int min = Integer.MAX_VALUE;
    int[][] dp = new int[costs.length][costs[0].length];
    dp[0][0] = costs[0][0];
    dp[0][1] = costs[0][1];
    dp[0][2] = costs[0][2];
    min = Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    for(int i = 1; i < costs.length;i++){
      dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
      dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
      dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
      min = Math.min(dp[i][0], Math.min(dp[i][1], dp[i][2]));
    }
    return min;
  }
}
