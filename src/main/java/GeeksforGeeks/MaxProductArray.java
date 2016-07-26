package GeeksforGeeks;

/**
 * Created by Administrator on 16-3-28.
 */
public class MaxProductArray {
  public int maxProduct(int[] nums) {
    int max = nums[0];
    int curMax = nums[0];
    int curMin = nums[0];
    for(int i = 1; i < nums.length;i++){
      int tmp = curMax;
      curMax = Math.max(curMin * nums[i], Math.max(curMax * nums[i], nums[i]));
      curMin = Math.min(tmp * nums[i], Math.min(curMin * nums[i], nums[i]));
      max = Math.max(max, curMax);
    }
    return max;
  }
}
