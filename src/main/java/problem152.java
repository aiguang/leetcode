import org.omg.DynamicAny._DynArrayStub;

/**
 Find the contiguous subarray within an array
 (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.
 */
public class problem152 {
  public static void main(String[] args){
    int[] value = {2,3,-2,4};
    System.out.println(new problem152().maxProduct(value));
  }
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
