/**
 Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Try to solve it in linear time/space.

 Return 0 if the array contains less than 2 elements.

 You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
public class problem164 {

  public static void main(String[] args){
    System.out.println("loop start");
    for(int i = 2; i <= 2;i++){
      System.out.println("current i is " + i);
    }
    System.out.println("loop end");
  }
  public int maximumGap(int[] nums) {
    if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
    int max = nums[0];
    for(int i = 1;i < nums.length;i++){
      max = Math.max(max, nums[i]);
    }
    int[] tmp = new int[max + 1];
    int first = -1;
    for(int i = 0; i < nums.length;i++){
      tmp[nums[i]] = 1;
      if(first != -1) first = nums[i];
    }
    int gap = Integer.MIN_VALUE;

    for(int i = first; i < tmp.length;i++){
      if(tmp[i] == 1){
        gap = Math.max(gap, i - first);
        first = i;
      }
    }
    return gap;
  }
}
