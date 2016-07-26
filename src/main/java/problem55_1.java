/**
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.
 */
public class problem55_1 {
  public boolean canJump(int[] nums) {
    if(nums == null || nums.length == 0) return false;
    if(nums.length == 1) return true;
    int start = 0;
    int end = 0;
    while (end < nums.length - 1){
      int max = 0;
      for(int i = start; i <= end;i++){
        if(i + nums[i] >= nums.length - 1) return true;
        max = Math.max(max, i + nums[i]);
      }
      start = end + 1;
      end = max;
      if(end == 0) return false;
    }
    return false;
  }
}
