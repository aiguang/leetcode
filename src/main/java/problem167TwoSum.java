import com.sun.org.apache.regexp.internal.recompile;

import java.util.ArrayList;
import java.util.List;

/**
 Two Sum II - Input array is sorted

 Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class problem167TwoSum {
  public List<Integer> twoSum(int[] nums, int target){
    List<Integer> list = new ArrayList<Integer>();
    int left = 0, right = nums.length - 1;
    while (left < right){
      while (left < nums.length - 1 && nums[left] + nums[right] < target) left++;
      while (right > 0 && nums[left] + nums[right] > target) right--;
      if(left < right && left > 0 && right < nums.length - 1 && nums[left] + nums[right] == target){
        list.add(nums[left]);
        list.add(nums[right]);
        return list;
      }
    }
    return  list;
  }
}
