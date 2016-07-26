/**
 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.

 Note:
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class problem268 {
  public static void main(String[] args){
    int[] nums = {0};
    System.out.println(new problem268().missingNumber(nums));
  }
  public int missingNumber(int[] nums) {
    int real = 0, min = nums[0], max = nums[0];
    for(int i = 0; i < nums.length;i++){
      real += nums[i];
      if(nums[i] > max){
        max = nums[i];
      }
      if(nums[i] < min){
        min = nums[i];
      }
    }
    if(min != 0) return 0;
    int tmp =  (min + max) * (max - min + 1) / 2 - real;
    return tmp == 0 ? max + 1 : tmp;
  }
}
