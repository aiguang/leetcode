/**
 Follow up for "Find Minimum in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array may contain duplicates.
 */
public class problem154_1 {

  /**
   * 思路：Find Minimum in Rotated Sorted Array I
   和Search in Rotated Sorted Array I这题换汤不换药。同样可以根据A[mid]和A[end]来判断右半数组是否sorted：
   原数组：0 1 2 4 5 6 7
   情况1：  6 7 0 1 2 4 5
   情况2：  2 4 5 6 7 0 1
   (1) A[mid] < A[end]：A[mid : end] sorted => min不在A[mid+1 : end]中
   搜索A[start : mid]
   (2) A[mid] > A[end]：A[start : mid] sorted且又因为该情况下A[end]<A[start] => min不在A[start : mid]中
   搜索A[mid+1 : end]
   (3) base case：
   a. start =  end，必然A[start]为min，为搜寻结束条件。
   b. start + 1 = end，此时A[mid] =  A[start]，而min = min(A[mid], A[end])。而这个条件可以合并到(1)和(2)中。
   * @param nums
   * @return
   */
  public int findMin(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    int start = 0, end = nums.length-1;
    while(start<end) {
      int mid = start + (end-start)/2;
      if(nums[mid]<nums[end])
        end = mid;
      else if(nums[mid]>nums[end])
        start = mid+1;
      else
        end--;
    }
    return nums[start];
  }
}
