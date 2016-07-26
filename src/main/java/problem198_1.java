/**
 * Created by Administrator on 16-3-10.
 */
public class problem198_1 {
  public static void main(String[] args){
    int[] a = {2,1,1,2};
    System.out.println(new problem198_1().rob(a));
  }
  public int rob(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    if(nums.length == 1) return nums[0];
    if(nums.length == 2) return Math.max(nums[0], nums[1]);
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = nums[1] > nums[0] ? nums[1] : nums[0];
    int max = Math.max(nums[0], nums[1]);
    for(int i = 2; i < nums.length;i++){
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    return dp[nums.length - 1];
  }
}
