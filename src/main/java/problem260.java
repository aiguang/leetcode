import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given an array of numbers nums, in which exactly two elements appear only once
 and all the other elements appear exactly twice. Find the two elements that appear only once.

 For example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 Note:
 The order of the result is not important. So in the above example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class problem260 {
  public static void main(String[] args){
    int[] a = {1,1,2,2,4,5};
    int[] result = new problem260().singleNumber(a);
    for(int i = 0 ;i < result.length;i++){
      System.out.print(result[i] + ",");
    }
  }
  public int[] singleNumber(int[] nums) {
    if(nums == null || nums.length == 0) return null;
    int result = nums[0];
    for(int i = 1 ; i < nums.length;i++){
      result = result ^ nums[i];
    }
    int firstIndex = 0;
    for(;firstIndex < 32; firstIndex++){
      if(((result >> firstIndex) & 1) == 1){
        break;
      }
    }
    int xorTwice = 0;
    for(int i = 0; i < nums.length;i++){
      if(((nums[i] >> firstIndex) & 1) == 1){
        xorTwice ^= nums[i];
      }
    }
   int[] r = {xorTwice, xorTwice ^ result};
    return r;
  }
}
