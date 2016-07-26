/**
 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class problem121 {
  public static void main(String[] args){
    int[] nums = {2,1,2,0,1};
    System.out.println(new problem121().maxProfit(nums));
  }
  public int maxProfit(int[] prices) {
    if(prices == null || prices.length == 0) return 0;
    int[] dp = new int[prices.length];
    dp[0] = 0;
    int min = prices[0];
    for(int i = 1 ; i < prices.length;i++){
      dp[i] = prices[i] - min;
      if(min > prices[i]){
        min = prices[i];
      }
    }
    int max = dp[0];
    for(int i = 1; i < dp.length;i++){
      if(max < dp[i]) max = dp[i];
    }
    return max;
  }
}
