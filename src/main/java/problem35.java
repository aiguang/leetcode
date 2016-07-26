/**
 Given a sorted array and a target value, return the index if the target is found.
 If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
public class problem35 {
  public static void main(String[] args){
    int[] nums = {1,3};
    int target = 2;
    System.out.println(new problem35().searchInsert(nums, target));

  }
  public int searchInsert(int[] nums, int target) {
    if(nums == null || nums.length == 0) return 0;
    int left = 0;
    int right = nums.length - 1;
    int mid = 0;
    while (left <= right){
      mid = left + (right - left) / 2;
      if(nums[mid] == target){
        if(mid == 0) return 0;
        return mid;
      }else if(nums[mid] > target){
        if(mid == 0) return 0;
        else if (nums[mid - 1] < target) return mid;
        else{
          right = mid - 1;
        }
      }else{
        if(mid == nums.length - 1) return nums.length;
        else if(nums[mid + 1] > target) return mid + 1;
        else{
          left = mid + 1;
        }
      }
    }
    return mid + 1;
  }

}
