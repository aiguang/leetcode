/**
 Follow up for "Find Minimum in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array may contain duplicates.
 */
public class problem154 {
  public static void  main(String[] args){
    int[] nums = {1,1,2,0,0,1};
    System.out.println(new problem154().findMin(nums));
  }
  public int findMin(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    int left = 0;
    int right = nums.length - 1;
    int min = nums[0];
    while (left < right - 1){
      int mid = (left + right) / 2;
      if(nums[mid] < nums[left]){
        min = Math.min(nums[mid], min);
        right = mid - 1;
      }else if (nums[mid] > nums[left]){
        min = Math.min(nums[left], min);
        left = mid + 1;
      }else{
        left++;
      }
    }
    min = Math.min(nums[left],min);
    min = Math.min(nums[right],min);
    return min;
  }
}
