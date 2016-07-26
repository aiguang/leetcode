/**
 * Created by Administrator on 16-2-18.
 */
public class problem53_1 {
  public static void main(String[] args){
    int[] nums = {-1,0,-2};
    System.out.println(new problem53_1().maxSubArray(nums));
  }
  public int maxSubArray(int[] nums) {
    int max = nums[0];
    int current = nums[0];
    for(int i = 1; i < nums.length;i++){
      current = Math.max(current + nums[i], nums[i]);
      max = Math.max(max, current + nums[i]);
    }
    return max;
  }
}
