/**
 * Created by Administrator on 16-7-7.
 */
public class problem238ProductofArrayExceptSelf {
  public static void main(String[] args){
    int[] nums = {9,0,-2};
    int[] result = new problem238ProductofArrayExceptSelf().productExceptSelf(nums);
    for(int v : result){
      System.out.print(v + ",");
    }
  }
  public int[] productExceptSelf(int[] nums) {
    if(nums == null || nums.length == 0) return null;
    if(nums.length == 1) return nums;
    int[] left = new int[nums.length];
    int[] right = new int[nums.length];
    left[0] = 1;
    for(int i = 1; i < nums.length;i++){
      left[i] = left[i - 1] * nums[i - 1];
    }
    right[nums.length - 1] = 1;

    for(int i = nums.length - 2;i >= 0;i--){
      right[i] = right[i + 1] * nums[i + 1];
    }
    int[] result = new int[nums.length];
    for(int i = 0; i < nums.length;i++){
      result[i] = left[i] * right[i];
    }
    return result;
  }

}
