/**
 A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

 click to show spoilers.

 Note:
 Your solution should be in logarithmic complexity.
 */
public class problem162 {
  public static void main(String[] args){
    int[] nums = {2,1};
    System.out.println(new problem162().findPeakElement(nums));
  }
  public int findPeakElement(int[] nums) {
    if(nums == null || nums.length == 0) return -1;
    int left = 0;
    int right = nums.length;
    int mid = 0;
    while (left <= right){
      mid = left + (right - left) / 2;
      if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])){
        return mid;
      }else if(mid > 0 && nums[mid] < nums[mid - 1]){
        right = mid - 1;
      }else {
        left = mid + 1;
      }
    }
    return mid;

  }
}
