import java.util.Arrays;

/**
 Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

 For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */
public class problem280WiggleSort {
  public static void main(String[] args){
    int[] nums = {3,5,2,1,6,4,0};
    new problem280WiggleSort().wiggleSort(nums);
    for(int i = 0; i < nums.length;i++){
      System.out.print(nums[i] + ",");
    }
  }
  public void wiggleSort(int[] nums) {
    if(nums == null || nums.length == 0) return;
    Arrays.sort(nums);
    int i = 0;
    int j = (nums.length + 1) / 2;
    int[] array = new int[nums.length];
    int index = 0;
    while (j < nums.length && i < (nums.length + 1) / 2){
      array[index++] = nums[i++];
      array[index++] = nums[j++];
    }
    while (i < (nums.length + 1) / 2){
      array[index++] = nums[i++];
    }
    while (j < nums.length){
      array[index++] = nums[j++];
    }
    for(int k = 0; k< array.length;k++){
      nums[k] = array[k];
    }
  }
}
