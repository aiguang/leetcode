import java.util.LinkedList;

/**
 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
public class problem31 {
  public void nextPermutation(int[] nums) {
    int pivot = indexOfLastPeak(nums) - 1;
    if(pivot != -1){
      int pivotSuccessor = lastIndexOfGreater(nums, nums[pivot]);
      int temp = nums[pivot];
      nums[pivot] = nums[pivotSuccessor];
      nums[pivotSuccessor] = temp;
    }
    int start = pivot + 1, end = nums.length - 1;
    while(start < end){
      int temp = nums[start];
      nums[start++] = nums[end];
      nums[end--] = temp;
    }
  }


  private int indexOfLastPeak(int [] nums){
    for(int i = nums.length - 1 ; i > 0; i--){
      if(nums[i] > nums[i - 1]) return i;
    }
    return 0; /** first index */
  }

  private int lastIndexOfGreater(int [] nums, int threshold){
    for(int i = nums.length - 1 ; i >= 0; i--){
      if(nums[i] > threshold) return i;
    }
    return -1; /** shouldn't be executed */
  }

}
