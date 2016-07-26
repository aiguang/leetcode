/**
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class problem33 {
  public static void main(String[] args){
    int[] nums = {1,2,3,4,5,6};
    int target = 4;
    System.out.println(new problem33().search(nums, target));
  }

  public int search(int[] nums, int target) {
    if(nums == null || nums.length == 0) return -1;
    int start = 0;
    int right = nums.length - 1;
    while (start < right){
      int mid = (start + right) / 2;
      if(nums[mid] == target){
        return mid;
      }else if(nums[mid] < target){
        if(nums[start] > nums[mid]){
          if(nums[right] == target) return right;
          right--;
        }else{
          start = mid + 1;
        }
      }else{
        if(nums[right] > nums[mid]){
          right = mid - 1;
        }else{
          if(nums[right] == target) return right;
          right--;
        }
      }
    }
    int index = -1;
    if(start >= 0 && start < nums.length && target == nums[start]){
      index = start;
    }else if(right >= 0 && right < nums.length && target == nums[right]){
      index = right;
    }
    return index;
  }
}
