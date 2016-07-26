/**
 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit.
 You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class problem122 {
  public static void main(String[] args){

  }
  public int maxProfit(int[] prices) {
    if(prices == null || prices.length == 0) return 0;
    int[][] dp = new int[prices.length][prices.length];
    for(int i = 0; i < prices.length;i++){
      for(int j = 0; j < prices.length;j++){
        if(i == j){
          dp[i][j] = 0;
        }else if(j > i){
          dp[i][j] = prices[j] - prices[i];
        } else {
          dp[i][j] = -1;
        }
      }
    }
    int max = 0;
    int[] result = new int[prices.length];
    for(int i = 1 ; i < result.length;i++){
      result[i] = result[i - 1] + (dp[i - 1][i] > 0 ? dp[i][i - 1] : 0);
    }
    return result[prices.length - 1];

  }
}
