import java.util.Arrays;

/**
 Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s.
 If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.

 click to show more practice.

 More practice:
 If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class problem209 {
  public static void main(String[] args){
    int[] nums = {10,5,13,4,8,4,5,11,14,9,16,10,20,8};
    System.out.println(new problem209().minSubArrayLen(80, nums));
  }
  public int minSubArrayLen(int s, int[] nums) {
    int length = 0, p1 = 0, p2 = 0, sum = 0;
    if (nums == null || nums.length == 0) return length;
    while (p1 != nums.length) {
      while (p1 != nums.length && sum < s) sum += nums[p1++];
      while (sum >= s) sum -= nums[p2++];
      if (length == 0 || length > p1 - p2 + 1) length = p1 - p2 + 1;
    }
    return length > nums.length ? 0 : length;
  }
}
