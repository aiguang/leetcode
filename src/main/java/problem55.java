/**
 * Created by Administrator on 15-8-31.
 */
public class problem55 {
  public static void main(String[] args){
//    3,2,1,0,4  2,3,1,1,4
    int[] nums = {3,2,1,0,4};
    System.out.println(new problem55().canJump(nums));
  }
  public boolean canJump(int[] nums) {
    int[] dp = new int[nums.length];

    dp[0] = 0;
    for(int i = 1; i < nums.length; i++){
      dp[i] = Math.max(dp[i - 1], nums[i - 1]) - 1;
      if(dp[i] < 0) return false;
    }
    return dp[nums.length - 1] >= 0;
  }
}
