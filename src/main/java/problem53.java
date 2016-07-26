/**
 * Created by Administrator on 15-8-31.
 */
public class problem53 {
  public static void main(String[] args){
    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(new problem53().maxSubArray(nums));
  }
  public int maxSubArray(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    int[][] dp = new int[nums.length][nums.length];
    int max = nums[0];
    for(int i = 0; i < nums.length; i++){
      dp[i][i] = nums[i];
      if(nums[i] > max){
        max = nums[i];
      }
    }
    for(int i = 0;i < nums.length;i++){
      for(int j = i + 1;j < nums.length;j++){
        dp[i][j] = dp[i][j - 1] + nums[j];
        if(dp[i][j] > max){
          max = dp[i][j];
        }
      }
    }
    return max;
  }
}
