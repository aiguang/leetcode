import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

 Example 1:
 Given nums = [1, -1, 5, -2, 3], k = 3,
 return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

 Example 2:
 Given nums = [-2, -1, 2, 1], k = 1,
 return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

 Follow Up:
 Can you do it in O(n) time?
 */
public class problem325MaximumSizeSubarraySumEqualsk {
  public static void main(String[] args){
    int[] nums = {1, 0,-1};
    int k = -1;
    System.out.println(new problem325MaximumSizeSubarraySumEqualsk().maxSubArrayLen(nums, k));
  }
  public  int maxSubArrayLen(int[] nums, int k) {
    if(nums == null || nums.length == 0) return 0;
    int length = 0;
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i = 0; i < nums.length;i++){
      sum += nums[i];
      if(sum == k){
        length = i + 1;
      }else{
        if(map.get(sum -k) != null){
          length = Math.max(length, i - map.get(sum - k));
        }
      }
      if (map.get(sum) == null)
        map.put(sum, i);
    }
    return length;
  }
}
