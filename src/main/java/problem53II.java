/**
 * Created by Administrator on 15-8-31.
 */
public class problem53II {
  public static void main(String[] args){
    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(new problem53II().maxSubArray(nums));
  }
  public int maxSubArray(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    int max = nums[0];
    int curMax = max;
    for(int i = 1; i < nums.length;i++){
      curMax = Math.max(curMax + nums[i], nums[i]);
      max = Math.max(max, curMax);
    }
    return max;
  }
}
