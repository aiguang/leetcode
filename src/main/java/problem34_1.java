/**
 * Created by Administrator on 16-2-14.
 */
public class problem34_1 {
  public static void main(String[] args){
    int[] nums = {5,6,7,7,8,8,9,10};
    int[] result = new problem34_1().searchRange(nums, 8);
    System.out.println(result[0] + "    " + result[1]);

  }
  public int[] searchRange(int[] nums, int target) {
    if(nums == null || nums.length == 0) return new int[]{-1,-1};
    int[] result= {-1,-1};
    helper(result, nums, target, 0, nums.length - 1);
    return result;
  }
  private void helper(int[] result, int[] nums, int target, int low, int high){
    if(low <= high){
      int mid = low + (high - low) / 2;
      if(nums[mid] == target){
        if(result[0] == -1 || mid < result[0]) result[0] = mid;
        if(result[1] == -1 || mid > result[1]) result[1] = mid;
        helper(result, nums, target, low, mid - 1);
        helper(result, nums, target, mid + 1, high);
      }else if(nums[mid] > target){
        helper(result, nums, target, low, mid - 1);
      }else{
        helper(result, nums, target, mid + 1, high);
      }
    }
  }
}
