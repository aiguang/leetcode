/**
 You are given coins of different denominations and a total amount of money amount
 . Write a function to compute the fewest number of coins that you need to make up that amount.
 If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:
 coins = [1, 2, 5], amount = 11
 return 3 (11 = 5 + 5 + 1)

 Example 2:
 coins = [2], amount = 3
 return -1.

 Note:
 You may assume that you have an infinite number of each kind of coin.
 You are given coins of different denominations and a total amount of money amount.
 Write a function to compute the fewest number of coins that you need to make up that amount.
 If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:
 coins = [1, 2, 5], amount = 11
 return 3 (11 = 5 + 5 + 1)

 Example 2:
 coins = [2], amount = 3
 return -1.

 Note:
 You may assume that you have an infinite number of each kind of coin.
 */
public class problem322 {
  public static void main(String[] args){
    int[] coins = {1,2,5};
    System.out.println(new problem322().coinChange(coins, 11));
  }
  public int coinChange(int[] coins, int amount) {
    if(amount < 0) return -1;
    if(amount == 0) return 0;
    if(coins == null || coins.length == 0) return -1;
    int[] dp = new int[amount + 1];
    dp[0] = 0;
    for(int i = 0; i < dp.length;i++){
      dp[i] = -1;
    }
    for(int i = 0; i < coins.length;i++){
       if(coins[i] < dp.length){
         dp[coins[i]] = 1;
       }
    }
    for(int i = 0 ; i < dp.length;i++){
      if(dp[i] == -1) continue;
      for(int j = 0;j < coins.length;j++){
        if(i + coins[j] < dp.length){
          if(dp[i + coins[j]] == -1){
            dp[i + coins[j]] = dp[i] + 1;
          }else{
            dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
          }
        }
      }
    }
    return dp[amount];
  }
}
